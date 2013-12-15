/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.soap.service;

import begining.gf4.soap.element.CreditCard453;
import javax.ejb.Local;

/**
 *
 * @author Eiichi Tanaka
 */
@Local
public interface TestEJB453Local {
    public Boolean validate(CreditCard453 creditCard);
}
