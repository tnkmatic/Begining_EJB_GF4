/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.soap.service;

import begining.gf4.soap.element.CreditCard453;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Eiichi Tanaka
 */
@Stateless
@WebService(name = "CardValidatorEJB453Service", portName = "Validator453Port")
public class CardValidatorEJB453 {

    @WebMethod(operationName = "validate")
    public boolean validate(CreditCard453 creditCard) {
        Character lastDigit =
                creditCard.getNumber().charAt(
                    creditCard.getNumber().length() - 1);

        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
