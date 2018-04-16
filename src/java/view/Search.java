/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.DepartmentsLogic;
import business.DeptEmployeesLogic;
import business.DeptManagersLogic;
import business.EmployeesLogic;
import business.SalaryLogic;
import business.TitlesLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Department;
import transferobjects.DeptEmployee;
import transferobjects.DeptManager;
import transferobjects.Employee;
import transferobjects.Salary;
import transferobjects.Title;

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
                    + "<option value=\"DeptManager\">DeptManager</option>"
                    + "<option value=\"DeptEmployee\">DeptEmployee</option>"
                    + "<option value=\"Title\">Title</option>"
                    + "<option value=\"Salary\">Salary</option>"
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
                if("DeptManager".equals(request.getParameter("table"))){
                    searchDeptManager(inputSearch,response);
                }
                if("DeptEmployee".equals(request.getParameter("table"))){
                    searchDeptEmployee(inputSearch,response);
                }
                if("Title".equals(request.getParameter("table"))){
                    searchTitle(inputSearch,response);
                }
                if("Salary".equals(request.getParameter("table"))){
                    searchSalary(inputSearch,response);
            }
               
            out.println("</body>");
            out.println("</html>");
            }
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
    public Integer checkInteger(String inputSearch){
        Integer number = null;
        try{
            number = Integer.parseInt(inputSearch);
        }catch(NumberFormatException e){
            number = null;
        }
        return number;
    }
    
    public boolean isInteger(Integer number){
        return (number != null) ? true:false; 
    }
    
    public void searchEmployee(String inputSearch, HttpServletResponse response ) throws IOException{        
        try (PrintWriter out = response.getWriter()) {
            EmployeesLogic elogic = new EmployeesLogic();
            Employee employee = elogic.getEmployeeByEmployeeNo(checkInteger(inputSearch));
            
            if(employee == null){
                out.println(inputSearch +" Not Found in Employee ");
            }else{
                out.println("Search " + inputSearch + " in Employee <br>");
                out.println("<table border=\"1\">");
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
    }
    
    public void searchDepartment(String inputSearch, HttpServletResponse response ) throws IOException{
        try (PrintWriter out = response.getWriter()) {
            DepartmentsLogic dlogic = new DepartmentsLogic();
            Department department = dlogic.getDepartmentByDepartmentNo(inputSearch);
            
            if(department == null){
                out.println(inputSearch +" Not Found in Department ");
            }else{
                out.println("Search " + inputSearch + " in Department <br>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>dept_no</th>");
                out.println("<th>dept_name</th>");
                out.println("</tr>");
                out.printf("<tr> <td>%s</td> <td>%s</td></tr>",department.getDeptNo(), department.getDeptName());
            }
        }
    }
        
    public void searchDeptEmployee(String inputSearch, HttpServletResponse response)throws IOException{
        try (PrintWriter out = response.getWriter()) {
            DeptEmployeesLogic logic = new DeptEmployeesLogic();
            
            if (isInteger(checkInteger(inputSearch))){
                DeptEmployee deptEmployee = logic.getDeptEmployeeByEmpNo(checkInteger(inputSearch));
                if(deptEmployee == null){
                    out.println(inputSearch+ " Not Found in DeptEmployee ");
                }else{
                    out.println("Search " + inputSearch + " in DeptEmployee <br>");
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>emp_no</th>");
                    out.println("<th>detp_no</th>");
                    out.println("<th>from_date</th>");
                    out.println("<th>to_date</th>");
                    out.println("</tr>");
                    out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
                        deptEmployee.getEmpNo(), deptEmployee.getDeptNo(),
                        deptEmployee.getFromDate(), deptEmployee.getToDate());
            
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }else{
                List<DeptEmployee> deptEmployees = logic.getDeptEmployeeByDeptNo(inputSearch);
                
                if(deptEmployees.isEmpty()){
                    out.println(inputSearch+" Not Found in DeptEmployee ");
                }else{
                    out.println("Search " + inputSearch + " in DeptEmployee <br>");
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>emp_no</th>");
                    out.println("<th>detp_no</th>");
                    out.println("<th>from_date</th>");
                    out.println("<th>to_date</th>");
                    out.println("</tr>");
                    for (DeptEmployee deptEmployee : deptEmployees) {
                        out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
                        deptEmployee.getEmpNo(), deptEmployee.getDeptNo(),
                        deptEmployee.getFromDate(), deptEmployee.getToDate());
                    }
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
    }
    
    public void  searchDeptManager(String inputSearch, HttpServletResponse response)throws IOException{
        try (PrintWriter out = response.getWriter()) {
            DeptManagersLogic logic = new DeptManagersLogic();
            
            if (isInteger(checkInteger(inputSearch))){
                DeptManager deptManager = logic.getDeptManagerByEmpNo(checkInteger(inputSearch));
                if(deptManager == null){
                    out.println(inputSearch+" Not Found in DeptManager");
                }else{
                    out.println("Search " + inputSearch + " in DeptManager <br>");
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>emp_no</th>");
                    out.println("<th>detp_no</th>");
                    out.println("<th>from_date</th>");
                    out.println("<th>to_date</th>");
                    out.println("</tr>");
                    out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
                        deptManager.getEmpNo(), deptManager.getDeptNo(),
                        deptManager.getFromDate(), deptManager.getToDate());
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }else{
                List<DeptManager> deptManagers = logic.getDeptManagerByDeptNo(inputSearch);
                
                if(deptManagers.isEmpty()){
                    out.println(inputSearch+" Not Found in DeptManager");
                }else{
                    out.println("Search " + inputSearch + " in DeptManager <br>");
                    out.println("<table border=\"1\">");
                    out.println("<tr>");
                    out.println("<th>emp_no</th>");
                    out.println("<th>detp_no</th>");
                    out.println("<th>from_date</th>");
                    out.println("<th>to_date</th>");
                    out.println("</tr>");
                    for (DeptManager deptManager: deptManagers) {
                        out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
                        deptManager.getEmpNo(), deptManager.getDeptNo(),
                        deptManager.getFromDate(), deptManager.getToDate());
                    }
                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
    }
    
    public void searchTitle(String inputSearch, HttpServletResponse response ) throws IOException{        
        try (PrintWriter out = response.getWriter()) {
            TitlesLogic logic = new TitlesLogic();
            List<Title> titles = logic.getTitleByEmployeeNo(checkInteger(inputSearch));
            
            if(titles == null){
                out.println(inputSearch+" Not Found in Title");
            }else{
                out.println("Search " + inputSearch + " in Title <br>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>emp_no</th>");
                out.println("<th>title</th>");
                out.println("<th>from_date</th>");
                out.println("<th>to_date</th>");
                out.println("</tr>");
                
                for(Title title: titles)
                out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
                        title.getEmpNo(), title.getTitle(),
                        title.getFromDate(), title.getToDate());
            }
        }
    }
    
    public void searchSalary(String inputSearch, HttpServletResponse response ) throws IOException{        
        try (PrintWriter out = response.getWriter()) {
            SalaryLogic logic = new SalaryLogic();
            List<Salary> salaries = logic.getSalaryByEmpNo(checkInteger(inputSearch));
            
            if(salaries == null){
                out.println(inputSearch+" Not Found in Salary");
            }else{
                out.println("Search " + inputSearch + " in Salary <br>");
                out.println("<table border=\"1\">");
                out.println("<tr>");
                out.println("<th>emp_no</th>");
                out.println("<th>title</th>");
                out.println("<th>from_date</th>");
                out.println("<th>to_date</th>");
                out.println("</tr>");
                
                for(Salary salary: salaries)
                out.printf("<tr> <td>%s</td> <td>%s</td> <td>%s</td> <td>%s</td> </tr>",
                        salary.getEmpNo(), salary.getSalary(),
                        salary.getFromDate(), salary.getToDate());
            }
        }
    }
    
    
}
