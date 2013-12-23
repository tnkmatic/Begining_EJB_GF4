/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.soap.service;

import begining.gf4.soap.element.CreditCard453;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Eiichi Tanaka
 */
@WebService(serviceName = "CardValidatorWS453")
@Stateless()
public class CardValidator453 {

    /**
     * クレジットカード番号の最終桁チェック
     */
    @WebMethod(operationName = "validate")
    public boolean validate(
            @WebParam(name = "creditCard") CreditCard453 creditCard) {
        Character lastDigit = creditCard.getNumber().charAt(
                                    creditCard.getNumber().length() - 1);
        
        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
