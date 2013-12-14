/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.jms.client;

import begining.gf4.ejb.common.ConstantValueEJB;
import begining.gf4.ejb.dto.OrderDto440;
import java.util.Date;
import java.util.logging.Level;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author Eiichi Tanaka
 */
@Stateless
@LocalBean
public class SenderOrderQueueEJB440 {
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(SenderOrderQueueEJB440.class.getName());

    @Resource(lookup = "jms/ConnectionTest1")
    private ConnectionFactory connectionFactory;
    
    @Resource(lookup = "jms/OrderQueue440")
    private Queue queue;
    
    public void sendOrderQueue(
            final Long orderId, final String customerName
            ,final Float totalAmount) {
        String curMethodName = 
                Thread.currentThread().getStackTrace()[0].getMethodName();
        
        /***********************************************************************
         * 注文情報のDTOを作成
         **********************************************************************/
        OrderDto440 dto = new OrderDto440();
        dto.setOrderId(orderId);
        dto.setCustomerNmae(customerName);
        dto.setCreationDate(new Date());
        dto.setTotalAmount(totalAmount);
        
        logger.log(Level.INFO
                ,"{0}#{1} : 注文情報のDTO作成 OrderId = {3}"
                ,new String[] {
                    SenderOrderQueueEJB440.class.getSimpleName()
                    ,curMethodName
                    ,orderId.toString()
                });
        
        try {
            /*******************************************************************
            * キュー送信準備
            *******************************************************************/
            Connection connection = connectionFactory.createConnection();
            Session session = 
                    connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            
            /*******************************************************************
            * 送信オブジェクトの作成
            *******************************************************************/
            ObjectMessage message = session.createObjectMessage();
            message.setObject(dto);
            producer.send(message);
        } catch (JMSException e1) {
            logger.log(Level.WARNING
                    ,"{0}#{1} : {2} 送信エラー"
                    ,new String[] {
                        SenderOrderQueueEJB440.class.getSimpleName()
                        ,curMethodName
                        , ConstantValueEJB.JMS_QUEUE_440_NAME
                    });
        }
        
    }

}
