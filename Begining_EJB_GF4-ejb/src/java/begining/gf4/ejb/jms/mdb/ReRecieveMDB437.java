/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.mdb;

import java.util.logging.Level;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Logger;

/**
 *
 * @author Eiichi Tanaka
 */
@MessageDriven(
    mappedName = "jms/QueueTest2",
    activationConfig = {
        @ActivationConfigProperty(
            propertyName   = "acknowledgeMode"
            ,propertyValue = "Auto-acknowledge")
        ,@ActivationConfigProperty(
            propertyName = "destinationType"
            ,propertyValue = "javax.jms.Queue")
        ,@ActivationConfigProperty(
            propertyName = "destinationLookup"
            ,propertyValue = "jms/QueueTest2")
    }
)

public class ReRecieveMDB437 implements MessageListener {
    
    private static final Logger logger = 
            Logger.getLogger(ReRecieveMDB437.class.getName());
    
    public ReRecieveMDB437() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            logger.log(
                    Level.INFO
                    ,"{0} : Resend Message Recieved : {1}"
                    ,new String[]{
                        ReRecieveMDB437.class.getSimpleName()
                        ,msg.getText()
                    });
        } catch (JMSException e1) {
            
        }
    }
}
