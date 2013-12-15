/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.servlet.soap.client;

import begining.gf4.ejb.soap.service.CardValidatorEJB453_Service;
import begining.gf4.ejb.soap.service.CreditCard453;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Eiichi Tanaka
 */
@WebServlet(name = "CardValidatorClientServlet453"
        , urlPatterns = {"/CardValidatorClient453"})
public class CardValidatorClientServlet453 extends HttpServlet {
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(
            CardValidatorClientServlet453.class.getName());
    
    @WebServiceRef(
        wsdlLocation = "WEB-INF/wsdl/localhost_8080/"
            + "CardValidatorEJB453/CardValidatorEJB453.wsdl")
    private CardValidatorEJB453_Service cardValidator_Service;

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
        Boolean validateResult = Boolean.valueOf(false);
        try {
            /**********************************************************************
             * CreditCard453の生成
             *********************************************************************/
            CreditCard453 creditCard = new CreditCard453();
            creditCard.setNumber("12341234");
            creditCard.setExpiryDate("10/10");
            creditCard.setType("VISA");
            creditCard.setControlNumber(1234);

            logger.log(Level.INFO, "CreditCard453を生成 : number = {0}"
                    ,new String[] {
                        creditCard.getNumber()
                    });

            /**********************************************************************
             * Webサービス呼び出し(validate)
             *********************************************************************/
            validateResult = this.validate(creditCard);

            logger.log(Level.INFO, "Webサービス呼び出し(validate) : result = {0}"
                    ,new String[] {
                        validateResult.toString()
                    });
        } catch (Exception e1) {
            logger.log(Level.SEVERE, "Webサービス実行エラー : {0}"
                    ,new String[]{e1.getMessage()});
            throw new ServletException(e1);
        }
        
        /**********************************************************************
         * 結果の出力
         *********************************************************************/       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CardValidatorClientServlet453</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CardValidatorClientServlet453 at " 
                    + request.getContextPath() + "</h1>");
            out.println(validateResult.toString());
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

    private Boolean validate(
            begining.gf4.ejb.soap.service.CreditCard453 creditCard) {
        begining.gf4.ejb.soap.service.CardValidatorEJB453 port = 
                cardValidator_Service.getCardValidatorEJB453Port();
        return port.validate(creditCard);
    }
}
