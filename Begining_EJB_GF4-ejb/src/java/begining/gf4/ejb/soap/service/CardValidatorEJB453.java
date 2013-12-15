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
@WebService(serviceName = "CardValidatorEJB453")
@Stateless()
public class CardValidatorEJB453 {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * CreditCard453のバリデーション処理
     */
    @WebMethod(operationName = "validate")
    public Boolean validate(
            @WebParam(name = "creditCard") CreditCard453 creditCard) {
        
        Character lastDigit = creditCard.getNumber()
                .charAt(creditCard.getNumber().length() - 1);
        
        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
