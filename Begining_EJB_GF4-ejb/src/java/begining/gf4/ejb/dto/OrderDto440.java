/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Eiichi Tanaka
 */
public class OrderDto440 implements Serializable {
    private Long orderId;
    private Date creationDate;
    private String customerNmae;
    private Float totalAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCustomerNmae() {
        return customerNmae;
    }

    public void setCustomerNmae(String customerNmae) {
        this.customerNmae = customerNmae;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
