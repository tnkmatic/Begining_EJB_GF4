/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.servlet.jaxws;

import begining.ws.jaxws.creditcard.client.CardValidatorWS453;
import begining.ws.jaxws.creditcard.client.CreditCard453;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.jboss.logging.Logger.Level;

/**
 *
 * @author Eiichi Tanaka
 */
@WebServlet(name = "CreditCardValidatorServlet453", urlPatterns = {"/CreditCardValidator453"})
public class CreditCardValidatorServlet453 extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CardValidatorWS453/CardValidator453.wsdl")
    private CardValidatorWS453 service;
    
    private static final java.util.logging.Logger logger = 
            java.util.logging.Logger.getLogger(
            CreditCardValidatorServlet453.class.getName());

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        CreditCard453 creditCard = new CreditCard453();
        
        creditCard.setControlNumber(1234);
        creditCard.setType("VISA");
        creditCard.setExpiryDate("10/10");
        creditCard.setNumber("12341235");

        boolean isResult;
        try {
            isResult = validate(creditCard);
        } catch (Exception e1) {
            logger.log(java.util.logging.Level.SEVERE
                    ,"Webサービス呼び出しエラー {0}"
                    ,new String[]{e1.getMessage()}
                    );
            throw new ServletException(e1);
        }
        
        response.setHeader("test", "impression-Key");
        
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreditCardValidatorServlet453</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreditCardValidatorServlet453 at " + request.getContextPath() + "</h1>");
            out.println("Validation Result = " + isResult);
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean validate(begining.ws.jaxws.creditcard.client.CreditCard453 creditCard) {
        begining.ws.jaxws.creditcard.client.CardValidator453 port = service.getCardValidator453Port();
        return port.validate(creditCard);
    }
}
