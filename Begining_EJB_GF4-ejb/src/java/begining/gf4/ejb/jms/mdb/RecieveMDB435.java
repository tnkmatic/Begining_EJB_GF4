/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.mdb;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Eiichi Tanaka
 */
@MessageDriven(
    mappedName = "jms/Queue435"
    ,activationConfig = {
        @ActivationConfigProperty(
            propertyName   = "acknowledgeMode"
            ,propertyValue = "Auto-acknowledge")
        ,@ActivationConfigProperty(
            propertyName   = "destinationType"
            ,propertyValue = "javax.jms.Queue")
        ,@ActivationConfigProperty(
            propertyName = "destinationLookup"
            ,propertyValue = "jms/Queue435")
})
//@RunAs("admin_role")
public class RecieveMDB435 implements MessageListener {
    private static final java.util.logging.Logger logger = 
            Logger.getLogger(RecieveMDB435.class.getName());
            
    @Resource
    private MessageDrivenContext context;
    
    public RecieveMDB435() {
    }
    
    @Override
    public void onMessage(Message message) {
        final Principal princial = context.getCallerPrincipal();
        
        logger.log(Level.INFO
                , "Principal#getName() = {0}"
                , princial.getName());

        try {
            TextMessage msg = (TextMessage) message;
            logger.logp(
                    Level.INFO
                    , Thread.currentThread().getStackTrace()[0].getClassName()
                    , Thread.currentThread().getStackTrace()[0].getMethodName()
                    , "MDB Message recieved : {0}"
                    , msg.getText());
        } catch (JMSException e1) {
            logger.log(Level.SEVERE, e1.getMessage());
        }
    }
}
