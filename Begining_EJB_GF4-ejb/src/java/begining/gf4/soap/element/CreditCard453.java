/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.soap.element;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eiichi Tanaka
 */
@XmlRootElement
public class CreditCard453 implements Serializable {
    private String  number;
    private String  expiryDate;
    private Integer controlNumber;
    private String  type;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
