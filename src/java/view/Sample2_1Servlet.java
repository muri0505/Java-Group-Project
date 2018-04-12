/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.EmployeesLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Employee;

/**
 *
 * @author Shariar
 */
public class Sample2_1Servlet extends HttpServlet {

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
            out.println("<title>Servlet Sample2Servlet</title>");
            //https://www.w3schools.com/css/css_table.asp
            out.println("<style>");
            out.println("table {border-collapse: collapse;width: auto;}");
            out.println("th, td {text-align: left;padding: 8px;}");
            out.println("tr:nth-child(even) {background-color: #f2f2f2;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            //https://www.w3schools.com/css/css_table.asp
            EmployeesLogic logic = new EmployeesLogic();
            List<Employee> employees = logic.getAllEmployees();
            out.println("<table border=\"1\">");
            out.println("<caption>Courses</caption>");
            out.println("<tr>");
            out.println("<th>Course Code</th>");
            out.println("<th>Course Name</th>");
            out.println("</tr>");
           /* for (Employee course : courses) {
                out.printf("<tr><td>%s</td><td>%s</td></tr>", course.getCode(), course.getName());
            }*/

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
    }// </editor-fold>

}
