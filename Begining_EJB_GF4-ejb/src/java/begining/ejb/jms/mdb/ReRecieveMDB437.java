/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.ejb.jms.mdb;

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
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QueueTest2")
        →この記述あやしい。Queueをすべて受信していそうな動作をしている。
})
public class ReRecieveMDB437 implements MessageListener {
    
    public ReRecieveMDB437() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            System.out.println("ReSend Message Recieved: " + msg.getText());
        } catch (JMSException e1) {
            
        }
    }
}
