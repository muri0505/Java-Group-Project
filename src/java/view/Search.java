/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.DepartmentsLogic;
import business.EmployeesLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Department;
import transferobjects.Employee;

/**
 *
 * @author Owner
 */
public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<title>Servlet Search</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"Search\" method=\"post\">");
            out.println("Search by ID:<br>");
            out.println("<input type=\"text\" name=\"search\" value=\"\"><br>");
            out.println("Table Name:<br>");
            out.println("<select name=\"table\" id=\"table\" size=\"1\"> "
                    + "<option value=\"Table\">Select a Table</option>"
                    + "<option value=\"Employee\">Employee</option>"
                    + "<option value=\"Department\">Department</option>"
                    + "</select>");
            out.println("<input type=\"submit\" value=\"Submit\"><br><br>");
            
            String inputSearch = request.getParameter("search");
            if(inputSearch.isEmpty()){
                out.println("please enter id");
            }else if ("Table".equals(request.getParameter("table"))){
                out.println("please select table");
            }else{
                if("Employee".equals(request.getParameter("table"))){
                    searchEmployee(inputSearch,response);
                }
                if("Department".equals(request.getParameter("table"))){
                    searchDepartment(inputSearch,response);
                }
            }
            
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

    
    public void searchEmployee(String inputSearch, HttpServletResponse response ) throws IOException{
        try (PrintWriter out = response.getWriter()) {
            EmployeesLogic elogic = new EmployeesLogic();
            Employee employee = elogic.getEmployeByEmployeeNo(Integer.parseInt(inputSearch));
            
            out.println("<table border=\"1\">");
            out.println("<caption>Employees</caption>");
            out.println("<tr>");
            out.println("<th>emp_no</th>");
            out.println("<th>birth_date</th>");
            out.println("<th>first_name</th>");
            out.println("<th>last_name</th>");
            out.println("<th>gender</th>");
            out.println("<th>hire_date</th>");
            out.println("</tr>");
            out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
                    employee.getEmpNo(), employee.getBirthDate(),employee.getFirstName(), employee.getLastName(),
                    employee.getGender(), employee.getHireDate());
        }
    }
    
    public void searchDepartment(String inputSearch, HttpServletResponse response ) throws IOException{
        try (PrintWriter out = response.getWriter()) {
            DepartmentsLogic dlogic = new DepartmentsLogic();
                Department department = dlogic.getDepartmentByDepartmentNo(inputSearch);
                out.println("<table border=\"1\">");
                out.println("<caption>Departments</caption>");
                out.println("<tr>");
                out.println("<th>dept_no</th>");
                out.println("<th>dept_name</th>");
                out.println("</tr>");
                out.printf("<tr> <td>%s</td> <td>%s</td></tr>",department.getDeptNo(), department.getDeptName());
        }
    }
}
