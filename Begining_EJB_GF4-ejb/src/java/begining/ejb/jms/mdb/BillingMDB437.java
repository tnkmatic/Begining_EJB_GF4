/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.ejb.jms.mdb;

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
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author Eiichi Tanaka
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QueueTest1")
})
public class BillingMDB437 implements MessageListener {
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
        /*
        try {
            TextMessage msg = (TextMessage) message;
            System.out.println("Message Recieved: " + msg.getText());
            sendPrintingMessage();
        } catch (JMSException e1) {
            
        }
        */
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
