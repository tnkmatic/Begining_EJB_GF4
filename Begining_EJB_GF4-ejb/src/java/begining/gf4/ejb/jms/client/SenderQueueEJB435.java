/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.client;

import begining.gf4.ejb.common.ConstantValueEJB;
import java.util.logging.Logger;
import java.util.Date;
import java.util.logging.Level;
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
    
    @Resource(lookup = "jms/QueueTest1")
    private Queue queueTest1;
    
    private static final Logger logger =
            Logger.getLogger(SenderQueueEJB435.class.getName());

    public void sendQueue(final String queueName) {
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
            
            logger.log(
                Level.INFO, "{0}#{1} : 送信キュー = {2}"
                ,new String[] {
                    SenderQueueEJB435.class.getSimpleName()
                    ,"sendQueue"
                    ,queueName
                });
            
            if (ConstantValueEJB.JMS_QUQUE_435_NAME.equals(queueName)) {
                producer = session.createProducer(queue435);
            } else if (ConstantValueEJB.JMS_QUEUE_TEST1_NAME.equals(queueName)) {
                producer = session.createProducer(queueTest1);
            } else {
                logger.log(
                    Level.WARNING
                    ,"{0}#{1} : パラメータが不正です。"
                    ,new String[] {
                        SenderQueueEJB435.class.getSimpleName()
                        ,"sendQueue"
                    });
                return;
            }
            
            /*******************************************************************
            * 送信メッセージ作成
            *******************************************************************/
            final StringBuilder sb = new StringBuilder();
            sb.append(SenderQueueEJB435.class.getSimpleName());
            sb.append("#");
            sb.append(queueName);
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
