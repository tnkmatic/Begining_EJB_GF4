/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.soap.service;

import begining.gf4.soap.element.CreditCard453;
import javax.ejb.Stateless;

/**
 *
 * @author Eiichi Tanaka
 */
@Stateless
public class TestEJB453 implements TestEJB453Local {

    @Override
    public Boolean validate(CreditCard453 creditCard) {
        Character lastDigit = creditCard.getNumber().charAt(
                creditCard.getNumber().length() - 1);
        
        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}
