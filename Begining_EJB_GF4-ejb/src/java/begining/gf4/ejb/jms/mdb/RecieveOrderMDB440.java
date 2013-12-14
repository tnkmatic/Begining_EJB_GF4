/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.mdb;

import begining.gf4.ejb.dto.OrderDto440;
import java.util.logging.Level;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Eiichi Tanaka
 */
@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty(
            propertyName = "destinationType"
            ,propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(
            propertyName = "destinationLookup"
            ,propertyValue = "jms/OrderQueue440")
})
public class RecieveOrderMDB440 implements MessageListener {
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(RecieveOrderMDB440.class.getName());
    
    public RecieveOrderMDB440() {
    }
    
    @Override
    public void onMessage(Message message) {
        OrderDto440 dto;
        try {
            ObjectMessage obj = (ObjectMessage) message;
            dto = (OrderDto440) obj.getObject();            
            logger.log(Level.INFO
                ,"{0} : Order recieved : {1} {2} {3} {4}"
                ,new String[] {
                    RecieveOrderMDB440.class.getSimpleName()
                    ,dto.getOrderId().toString()
                    ,dto.getCustomerNmae()
                    ,dto.getTotalAmount().toString()
                    ,dto.getCreationDate().toString()
                });
        } catch (JMSException ex) {
            logger.log(Level.WARNING
                    ,"{0} : キュー受信エラー発生"
                    ,new String[] {
                        RecieveOrderMDB440.class.getSimpleName()
                    });
        }
    }
}
