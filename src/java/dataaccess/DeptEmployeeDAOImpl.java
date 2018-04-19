/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import factory.DTOFactoryCreator;
import factory.DeptEmployeeFactory;
import factory.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.DeptEmployee;

/**
 *
 * @author Owner
 */
public class DeptEmployeeDAOImpl implements DeptEmployeeDAO {

    private static final String GET_ALL_DEPT_EMPLOYEE = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp ORDER BY emp_no LIMIT 100";
    private static final String INSERT_DEPT_EMPLOYEE = "INSERT INTO dept_emp (emp_no, dept_no, from_date, to_date) VALUES(?,?,?,?)";
    private static final String SEARCH_DEPT_EMPLOYEE_EMPNO = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp WHERE emp_no = ";
    private static final String SEARCH_DEPT_EMPLOYEE_DEPTNO = "SELECT emp_no, dept_no, from_date, to_date FROM dept_emp WHERE dept_no = ";

    /**
     * returns all records
     *
     * @return
     */
    @Override
    public List<DeptEmployee> getAllDeptEmployees() {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<DeptEmployee> deptEmployees = Collections.EMPTY_LIST;
        Factory deptEmployee = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_DEPT_EMPLOYEE);
            rs = pstmt.executeQuery();

            //while (rs.next()) {}
            deptEmployee = (DeptEmployeeFactory) DTOFactoryCreator.createBuilder(DeptEmployee.class);
            deptEmployees = deptEmployee.createListFromResultSet(rs);

        } catch (SQLException ex) {
            Logger.getLogger(DeptEmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return deptEmployees;
    }

    @Override
    public void addDeptEmployee(DeptEmployee deptEmployee) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_DEPT_EMPLOYEE);) {
            pstmt.setString(1, deptEmployee.getEmpNo());
            pstmt.setString(2, deptEmployee.getDeptNo());
            pstmt.setString(3, deptEmployee.getFromDate());
            pstmt.setString(4, deptEmployee.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeptEmployeeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DeptEmployee getDeptEmployeeByEmpNo(Integer empNo) {
        DeptEmployeeFactory deptEmployeeFactory = null;
        DeptEmployee deptEmployee = null;
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SEARCH_DEPT_EMPLOYEE_EMPNO + "'" + empNo + "'");
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                deptEmployeeFactory = (DeptEmployeeFactory) DTOFactoryCreator.createBuilder(DeptEmployee.class);
                if (deptEmployeeFactory.createFromResultSet(rs).getDeptNo() == null) {
                    deptEmployee = null;
                } else {
                    deptEmployee = deptEmployeeFactory.createFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deptEmployee;
    }

    /**
     * find a record based or id number, then creates an object using factory
     *
     * @param deptNo
     * @return
     */
    @Override
    public List<DeptEmployee> getDeptEmployeeByDeptNo(String deptNo) {
        DeptEmployeeFactory deptEmployeeFactory = null;
        List<DeptEmployee> deptEmployees = Collections.EMPTY_LIST;

        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SEARCH_DEPT_EMPLOYEE_DEPTNO + "'" + deptNo + "' LIMIT 100");
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                deptEmployeeFactory = (DeptEmployeeFactory) DTOFactoryCreator.createBuilder(DeptEmployee.class);
                if (deptEmployeeFactory.createFromResultSet(rs).getDeptNo() == null) {
                    deptEmployees = null;
                } else {
                    rs.beforeFirst();
                    deptEmployees = deptEmployeeFactory.createListFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deptEmployees;
    }
}
