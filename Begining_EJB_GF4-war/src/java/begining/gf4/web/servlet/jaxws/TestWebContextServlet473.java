/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.servlet.jaxws;

import begining.ws.jaxws.test.webcontext.client.TestWebContextService473_Service;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "TestWebContextServlet473", urlPatterns = {"/TestWebContext473"})
public class TestWebContextServlet473 extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TestWebContextService473/TestWebContextService473.wsdl")
    private TestWebContextService473_Service service;
    
    private static final java.util.logging.Logger logger = 
            java.util.logging.Logger.getLogger(
            TestWebContextServlet473.class.getName());

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
        
        String resultMessage = null;
        try {
            resultMessage = convertMessage("test");
        } catch (Exception e1) {
            logger.log(java.util.logging.Level.SEVERE
                    ,"Webサービス呼び出しエラー {0}"
                    ,new String[]{e1.getMessage()}
                    );
            throw new ServletException(e1);
        }
        
        
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestWebContextServlet473</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Servlet TestWebContextServlet473 at " + request.getContextPath() + "</h3>");
            out.println(resultMessage);
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

    private String convertMessage(java.lang.String originalMessage) {
        begining.ws.jaxws.test.webcontext.client.TestWebContextService473 port 
                = service.getTestWebContextService473Port();
        return port.convertMessage(originalMessage);
    }
}
