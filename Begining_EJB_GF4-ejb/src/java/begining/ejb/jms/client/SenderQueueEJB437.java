/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.ejb.jms.client;

import begining.com.ConstantValue;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 *
 * @author Eiichi Tanaka
 */
@Stateless
@LocalBean
public class SenderQueueEJB437 {
    //@Resource(lookup = ConstantValue.)
    ConnectionFactory connectionFactory;
    
    //@Resource(lookup = )
    Queue queue;
    
    public void sendQueueMessage() {
        //ここから。
    }

}
