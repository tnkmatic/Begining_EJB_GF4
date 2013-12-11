/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.ejb.jms.mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Eiichi Tanaka
 */
@MessageDriven(mappedName = "jms/TopicTest1", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/TopicTest1")
})
public class BillingMDB431 implements MessageListener {    
    private static final java.util.logging.Logger logger = 
            Logger.getLogger(RecieveMDB435.class.getName());
    
    public BillingMDB431() {
        
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            logger.logp(
                    Level.INFO
                    , Thread.currentThread().getStackTrace()[0].getClassName()
                    , Thread.currentThread().getStackTrace()[0].getMethodName()
                    , "MDB Message recieved : {0}"
                    , msg.getText());
        } catch (JMSException e1) {
            
        }
    }
}
