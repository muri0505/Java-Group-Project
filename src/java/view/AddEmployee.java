package view;

import business.EmployeesLogic;
import factory.DTOFactoryCreator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Employee;

public class AddEmployee extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sample3Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"AddEmployee\" method=\"post\">");
            out.println("Birth Date:<br>");
            out.println("<input type=\"date\" name=\"birth_date\" min=\"1900-01-01\" max=\"2007-12-30\"><br><br>");
            out.println("First name:<br>");
            out.println("<input type=\"text\" name=\"first_name\" value=\"Mickey\"><br>");
            out.println("Last name:<br>");
            out.println("<input type=\"text\" name=\"last_name\" value=\"Mouse\"><br><br>");
            out.println("<input type=\"radio\" name=\"gender\" value=\"M\" checked> Male<br>");
            out.println("<input type=\"radio\" name=\"gender\" value=\"F\"> Female<br>");
            out.println("Hire Date:<br>");
            out.println("<input type=\"date\" name=\"hire_date\" min=\"1900-01-01\" max=\"2007-12-30\"><br><br>");
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            out.println("<pre>");
            out.println(toStringMap(request.getParameterMap()));
            out.println("</pre>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private String toStringMap(Map<String, String[]> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach((k, v) -> builder.append("Key=").append(k)
                .append(", ")
                .append("Value/s=").append(Arrays.toString(v))
                .append(System.lineSeparator()));
        return builder.toString();
    }

    private String getParameter(HttpServletRequest request, String ID) {
        String param = request.getParameter(ID);
        if (param != null) {
            return param.trim();
        }
        return null;
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
     * Handles the HTTP <code>POST</code> method. validates form input then adds
     * value to database
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList erros = new ArrayList();
        PrintWriter writer = response.getWriter();
        String birth_date = request.getParameter("birth_date");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String hire_date = request.getParameter("hire_date");
        if (birth_date == null || birth_date == "") {
            erros.add("Provide birth date...");
        }
        if (first_name == null || first_name == "") {
            erros.add("Provide first name...");
        }
        if (last_name == null || last_name == "") {
            erros.add("Provide last name...");
        }
        if (gender == null || gender == "") {
            erros.add("Provide gender...");
        }
        if (hire_date == null || hire_date == "") {
            erros.add("Provide hire date...");
        }
        if (erros.size() != 0) {
            writer.println(erros);
        } else {
            Employee employee = DTOFactoryCreator.createBuilder(Employee.class).createFromMap(request.getParameterMap());
            EmployeesLogic logic = new EmployeesLogic();
            logic.addEmployee(employee);
            String htmlResponse = "<html><h2>New employee added</h2></html>";
            writer.println(htmlResponse);
            //  processRequest(request, response); 
        }
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
