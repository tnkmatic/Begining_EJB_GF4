/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.soap.service;

import begining.gf4.soap.element.CreditCard453;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Eiichi Tanaka
 */
@WebService(serviceName = "TestWS453")
@Stateless()
public class TestWS453 {
    @EJB
    private TestEJB453Local ejbRef;
    
    /***************************************************************************
     * CreditCard Numberバリデーション
     **************************************************************************/
    @WebMethod(operationName = "testValidate")
    public Boolean validate(
            @WebParam(name = "creditCard") CreditCard453 creditCard) {
        return ejbRef.validate(creditCard);
    }
    
}
