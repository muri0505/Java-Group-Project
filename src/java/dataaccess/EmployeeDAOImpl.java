package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Employee;

/**
 *
 * @author Can Shi
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    private static final String GET_ALL_EMPLOYEES = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY emp_no LIMIT 100";
    private static final String INSERT_EMPLOYEES = "INSERT INTO employees (birth_date, first_name, last_name, gender, hire_date) VALUES(?, ?, ?, ?, ?)";
    //private static final String DELETE_COURSES = "DELETE FROM Courses WHERE course_num = ?";
    //private static final String UPDATE_COURSES = "UPDATE Courses SET name = ? WHERE course_num = ?";
    //private static final String GET_BY_CODE_COURSES = "SELECT course_num, name FROM Courses WHERE name = ?";
    
    @Override
    public List<Employee> getAllEmployees() {
        @SuppressWarnings("unchecked")
        List<Employee> employees = Collections.EMPTY_LIST;
        Employee employee;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_EMPLOYEES);
            rs = pstmt.executeQuery();
            employees = new ArrayList<>(100);
            while( rs.next()){
                employee = new Employee();
                employee.setEmpNo( rs.getString("emp_no"));
                employee.setBirthDate( rs.getString("birth_date"));
                employee.setFirstName( rs.getString("first_name"));
                employee.setLastName( rs.getString("last_name"));
                employee.setGender( rs.getString("gender"));
                employee.setHireDate( rs.getString("hire_date"));
                employees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_EMPLOYEES);){
            pstmt.setString(1, employee.getBirthDate());
            pstmt.setString(2, employee.getFirstName());
            pstmt.setString(3, employee.getLastName());
            pstmt.setString(4, employee.getGender());
            pstmt.setString(5, employee.getHireDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}