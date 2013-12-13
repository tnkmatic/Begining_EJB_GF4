/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.client;

import begining.gf4.ejb.common.ConstantValueEJB;
import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Eiichi Tanaka
 */
@Stateless
@LocalBean
public class SenderTopicEJB431 {

    public void senderTopicTest1() {
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        
        try {
            //JNDIコンテキストの取得
            Context jndiContext = new InitialContext();

            ConnectionFactory connectionFactory =
                    lookupConnectionFactory(jndiContext, ConstantValueEJB.JMS_CONNECTION_NAME);
            Topic topic = lookupTopic(jndiContext, ConstantValueEJB.JMS_TOPIC_TEST1_NAME);
            
            //トピックへの接続に必要なオブジェクトを作成
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(topic);
            
            TextMessage message = session.createTextMessage();
            
            //テキストメッセージをトピックに送信
            message.setText("This is a Topic text message sent at " + new Date());
            producer.send(message);
            
            //プライオリティ付与のメッセージを送信
            message.setText("This is a Topic text message with JMSPriority = 5");
            producer.setPriority(5);
            producer.send(message);

           //終了メッセージの送信(プライオリティを元に戻す)
           message.setText("bye");
           producer.setPriority(0);
           producer.send(message);
        } catch (NamingException | JMSException e1) { 
            
        } finally {
            try {
                if (producer != null) producer.close();
                if (session  != null) session.close();
                if (connection != null) connection.close();
            } catch (JMSException e2) {
                
            }
        }
    }
    
    private ConnectionFactory lookupConnectionFactory(
            final Context jndiContext, final String jndiName) {
        ConnectionFactory connectionFactory = null;
        
        try {
            //管理対象オブジェクトルックアップ
            connectionFactory = (ConnectionFactory) jndiContext.lookup(jndiName);
        } catch (NamingException e1) { }
        
        return connectionFactory;
    }    
        
    private Topic lookupTopic(
            final Context jndiContext, final String jndiName) {
        Topic topic = null;
        
        try {
            //管理対象オブジェクトルックアップ
            topic = (Topic) jndiContext.lookup(jndiName);
        } catch (NamingException e1) { }
        
        return topic;
    }

}
