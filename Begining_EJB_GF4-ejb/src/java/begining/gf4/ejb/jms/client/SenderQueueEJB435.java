/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.client;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Eiichi Tanaka
 */
@Stateless
@LocalBean
public class SenderQueueEJB435 {
    @Resource(lookup = "jms/ConnectionTest1")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/Queue435")
    private Queue queue435;

    public void sendQueue() {
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        
        try {
            /*******************************************************************
            * キューの送信準備
            *******************************************************************/
            connection = connectionFactory.createConnection();
            session    = 
                    connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(queue435);
            
            /*******************************************************************
            * 送信メッセージ作成
            *******************************************************************/
            final StringBuilder sb = new StringBuilder();
            sb.append(SenderQueueEJB435.class.getSimpleName());
            sb.append("#");
            sb.append("This is a Queue text message sent at");
            sb.append(new Date());

            TextMessage message = session.createTextMessage();
            message.setText(sb.toString());
            
            /*******************************************************************
            * キューの送信
            *******************************************************************/
            producer.send(message);
        } catch (JMSException e1) { 
            
        } finally {
            try {
                if (producer != null) producer.close();
                if (session  != null) session.close();
                if (connection != null) connection.close();
            } catch (JMSException e2) {
                
            }
        }
    }
}
