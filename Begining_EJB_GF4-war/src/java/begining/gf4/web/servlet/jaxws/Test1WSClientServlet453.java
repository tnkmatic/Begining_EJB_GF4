/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package begining.gf4.web.servlet.jaxws;

import begining.ws.jaxws.test.client.Test1WS453_Service;
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
@WebServlet(name = "Test1WSClientServlet453", urlPatterns = {"/Test1WSClient453"})
public class Test1WSClientServlet453 extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Test1WS453/Test1WS453.wsdl")
    private Test1WS453_Service service;

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test1WSClientServlet453</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test1WSClientServlet453 at " + request.getContextPath() + "</h1>");
            out.println(hello("abcdefg"));
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

    /***************************************************************************
     * Helloウェブサービスの呼び出し
     * ※注意
     * 　「Webサービスクライアント」を新規作成する際、
     * 　クライアントJavaアーティファクトを生成するパッケージ名をデフォルト
     * 　にしてしまうと、Webサービスを利用するサーブレットで呼び出し時に例外
     * 　が発生してしまう。(IllegalException - not interface)
     * 　必ずアーティファクトを生成するパッケージ名を指定すること
     * @param name
     * @return 
     **************************************************************************/
    private String hello(java.lang.String name) {
        begining.ws.jaxws.test.client.Test1WS453 port = service.getTest1WS453Port();
        return port.hello(name);
    }
}
