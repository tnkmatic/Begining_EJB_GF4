/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.ejb.soap.service;

import java.security.Principal;
import java.util.Set;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author Eiichi Tanaka
 */
@WebService(serviceName = "TestWebContextService473")
@Stateless()
public class TestWebContextService473 {
    
    @Resource
    private WebServiceContext context;
    private String crlf = "<br>";
    
    /**
     * 受け取った文字列にWebContextから得られる文字列を付与
     */
    @WebMethod(operationName = "convertMessage")
    public String convertMessage(
            @WebParam(name = "originalMessage") String originalMessage) {
        StringBuilder sb = new StringBuilder();

        //認証関連
        final Principal principal = context.getUserPrincipal();
        sb.append("Principal.getName() = ").append(principal.getName());
        sb.append(crlf);
        
        //SOAPメッセージ関連
        final MessageContext msgContext = context.getMessageContext();
        final Set<String> keySet = msgContext.keySet();        
        sb.append("------ MessageContext KeySets ------").append(crlf);
        for (final String key : keySet) {
            Object obj = msgContext.get(key);
            if (obj != null) {
                sb.append(key).append("：").append(obj.toString()).append(crlf);
            } else {
                sb.append(key).append("：").append("null").append(crlf);
            }
        }
        sb.append("-----------------------------------").append(crlf);
        
        return sb.toString();
    }
}
