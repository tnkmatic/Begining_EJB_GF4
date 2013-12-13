/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.mdb;

import begining.gf4.com.ConstantValue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Eiichi Tanaka
 */
@MessageDriven(
    mappedName = "jms/QueueTest1"
    ,activationConfig = {
        @ActivationConfigProperty(
            propertyName   = "acknowledgeMode"
            ,propertyValue = "Auto-acknowledge")
        ,@ActivationConfigProperty(
            propertyName = "destinationType"
            ,propertyValue = "javax.jms.Queue")
        ,@ActivationConfigProperty(
            propertyName = "destinationLookup"
            ,propertyValue = "jms/QueueTest1")
})
public class BillingMDB437 implements MessageListener {
    private static final Logger logger =
            Logger.getLogger(BillingMDB437.class.getName());
    
    @Resource(lookup = "jms/QueueTest2")
    private Destination printingQueue;
    
    @Resource(lookup = "jms/ConnectionTest1")
    private ConnectionFactory connectionFactory;
    private Connection connection;
    
    public BillingMDB437() {
    }

    @PostConstruct
    private void initConnection() {
        try {
            connection = connectionFactory.createConnection();
        } catch (JMSException e1) {
            
        }
    }
    
    @PreDestroy
    private void closeConnection() {
        try {
            if (connection != null) connection.close();
        } catch (JMSException e1) {
            
        }
    }
    
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            
            logger.log(
                    Level.INFO
                    ,"{0} {1} : Message Received : {2}"
                    ,new String[]{
                        BillingMDB437.class.getSimpleName()
                        ,ConstantValue.JMS_QUEUE_TEST1_NAME
                        ,msg.getText()
                    });
            
            //sendPrintingMessage();
        } catch (JMSException e1) {
            logger.log(
                    Level.SEVERE, "{0} {1}"
                    , new Object[]{
                        e1.getErrorCode(), e1.getMessage()});
        }
    }
    
    private void sendPrintingMessage() throws JMSException {
        /*
        try {
            try (Session session = 
                    connection.createSession(true, Session.AUTO_ACKNOWLEDGE)) {
                MessageProducer producer = session.createProducer(printingQueue);
                TextMessage message = session.createTextMessage();
                message.setText("This message has been recieved and sent again.");
                producer.send(message);
            }
        } catch (JMSException e1) {
            
        }
        */
    }
}
