package dataaccess;

import factory.DTOFactoryCreator;
import factory.EmployeeFactory;
import factory.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Employee;

/**
 *
 * @author Can Shi
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String GET_ALL_EMPLOYEES = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees ORDER BY emp_no DESC LIMIT 100";
    private static final String INSERT_EMPLOYEES = "INSERT INTO employees (emp_no, birth_date, first_name, last_name, gender, hire_date) VALUES(?,?,?,?,?,?)";
    private static final String LAST_EMP_NO = "SELECT emp_no FROM employees ORDER BY emp_no DESC LIMIT 1";
    private static final String SEARCH_EMPLOYEE_ID = "SELECT emp_no, birth_date, first_name, last_name, gender, hire_date FROM employees WHERE emp_no = ";
    //private static final String DELETE_COURSES = "DELETE FROM Courses WHERE course_num = ?";
    //private static final String UPDATE_COURSES = "UPDATE Courses SET name = ? WHERE course_num = ?";
    //private static final String GET_BY_CODE_COURSES = "SELECT course_num, name FROM Courses WHERE name = ?";

    /**
     * returns all records
     *
     * @return
     */
    @Override
    public List<Employee> getAllEmployees() {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Employee> employees = Collections.EMPTY_LIST;
        Factory employee = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_EMPLOYEES);
            rs = pstmt.executeQuery();

            //while (rs.next()) {}
            employee = (EmployeeFactory) DTOFactoryCreator.createBuilder(Employee.class);
            employees = employee.createListFromResultSet(rs);

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

    public String newEmpNo() {
        String new_id = null;
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(LAST_EMP_NO);) {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String last_id = rs.getString("emp_no");
            new_id = String.valueOf(Integer.parseInt(last_id) + 1);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new_id;
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_EMPLOYEES);) {
            pstmt.setString(1, newEmpNo());
            pstmt.setString(2, employee.getBirthDate());
            pstmt.setString(3, employee.getFirstName());
            pstmt.setString(4, employee.getLastName());
            pstmt.setString(5, employee.getGender());
            pstmt.setString(6, employee.getHireDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * find a record based or id number, then creates an object using factory
     *
     * @param EmployeeNo
     * @return
     */
    @Override
    public Employee getEmployeeByEmployeeNo(Integer EmployeeNo) {

        EmployeeFactory employeeFactory = null;
        Employee employee = null;
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SEARCH_EMPLOYEE_ID + "'" + EmployeeNo + "'");
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                employeeFactory = (EmployeeFactory) DTOFactoryCreator.createBuilder(Employee.class);
                if (employeeFactory.createFromResultSet(rs).getEmpNo() == null) {
                    employee = null;
                } else {
                    employee = employeeFactory.createFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

}
