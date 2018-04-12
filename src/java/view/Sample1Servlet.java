package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shariar
 */
public class Sample1Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sample1Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1 style=\"background-color:DodgerBlue;\">heading one</h1>");
            out.println("<h2 style=\"color:Tomato;\">heading two</h2>");
            out.println("<h3 style=\"border:2px solid Violet;\">heading three</h3>");
            
            out.println("<h4>heading four</h4>");
            out.println("<h5>heading five</h5>");
            out.println("<h6>heading six</h6>");
            
            out.println("<p>line 1. line 2.</p>");
            
            out.println("<p>line 1.<br>line 2.</p>");
            
            out.println("<pre>line 1.\nline 2.</pre>");
            
            out.println("<p><!-- Formatting -->");
            out.println("<b>Bold text</b><br>");
            out.println("<strong>Important text</strong><br>");
            out.println("<i>Italic text</i><br>");
            out.println("<em> Emphasized text</em><br>");
            out.println("<mark>Marked text</mark><br>");
            out.println("<small> Small text</small><br>");
            out.println("<del>Deleted text</del><br>");
            out.println("<ins>Inserted text</ins><br>");
            out.println("<sub>Subscript text</sub><br>");
            out.println("<sup>Superscript text</sup>");
            out.println("</p>");
            
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>Coffee</li>");
            out.println("<li>Tea</li>");
            out.println("<ul>");
            out.println("<li>Black Tea</li>");
            out.println("<li>Green Tea</li>");
            out.println("</ul>");
            out.println("<li>Milk</li>");
            out.println("</ul>");
            
            out.println("<ol type=\"1\">");
            out.println("<li>Coffee</li>");
            out.println("<li>Tea</li>");
            out.println("<li>Milk</li>");
            out.println("</ol>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
    }
}
