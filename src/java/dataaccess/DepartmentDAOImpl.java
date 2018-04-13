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
import transferobjects.Department;
/**
 *
 * @author Can Shi
 */
public class DepartmentDAOImpl implements DepartmentDAO{

    private static final String GET_ALL_DEPARTMENTS = "SELECT dept_no, dept_name FROM departments ORDER BY dept_no";
    private static final String INSERT_DEPARTMENTS = "INSERT INTO departments (dept_name) VALUES(?)";
    //private static final String DELETE_COURSES = "DELETE FROM Courses WHERE course_num = ?";
    //private static final String UPDATE_COURSES = "UPDATE Courses SET name = ? WHERE course_num = ?";
    //private static final String GET_BY_CODE_COURSES = "SELECT course_num, name FROM Courses WHERE name = ?";
    
    @Override
    public List<Department> getAllDepartments() {
        @SuppressWarnings("unchecked")
        List<Department> departments = Collections.EMPTY_LIST;
        Department department;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = DataSource.getConnection();
            pstmt = con.prepareStatement( GET_ALL_DEPARTMENTS);
            rs = pstmt.executeQuery();
            departments = new ArrayList<>(100);
            while( rs.next()){
                department = new Department.Builder().setDeptNo(rs.getString("dept_no")).setDeptName(rs.getString("dept_name")).build();
                departments.add(department);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return departments;
    }

    @Override
    public void addDepartment(Department department) {
        try( Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_DEPARTMENTS);){
            pstmt.setString(1, department.getDeptName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
