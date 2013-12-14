/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.servlet.jms;

import begining.gf4.ejb.jms.client.SenderOrderQueueEJB440;
import begining.gf4.web.common.ConstantValueWeb;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eiichi Tanaka
 */
@WebServlet(name = "SenderOrderQueueServlet440", urlPatterns = {"/SenderOrderQueue440"})
public class SenderOrderQueueServlet440 extends HttpServlet {
    @EJB
    SenderOrderQueueEJB440 ejb;

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
        
        Long   orderId;
        String customerName;
        Float  totalAmount;
        
        /***********************************************************************
         * 注文情報の取得
         **********************************************************************/
        orderId = Long.valueOf(request.getParameter(
                ConstantValueWeb.PARAM_SENDER_ORDER_QUEUE_440_ORDER_ID));
        customerName = request.getParameter(
                ConstantValueWeb.PARAM_SENDER_ORDER_QUEUE_440_CUSTOMER_NAME);
        totalAmount = Float.valueOf(request.getParameter(
                ConstantValueWeb.PARAM_SENDER_ORDER_QUEUE_440_TOTAL_AMOUNT));
        
        /***********************************************************************
         * キュー送信
         **********************************************************************/
        ejb.sendOrderQueue(orderId, customerName, totalAmount);
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
}
