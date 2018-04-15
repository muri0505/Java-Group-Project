/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import factory.DTOFactoryCreator;
import factory.DeptManagerFactory;
import factory.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.DeptManager;
/**
 *
 * @author Owner
 */
public class DeptManagerDAOImpl implements DeptManagerDAO{
    private static final String GET_ALL_DEPT_MANGER = "SELECT emp_no, dept_no, from_date, to_date FROM dept_manager ORDER BY emp_no LIMIT 100";
    private static final String INSERT_DEPT_MANGER = "INSERT INTO dept_manager (emp_no, dept_no, from_date, to_date) VALUES(?,?,?,?)";
    
    @Override
    public List<DeptManager> getAllDeptManagers() {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<DeptManager> deptManagers = Collections.EMPTY_LIST;
        Factory deptManager = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_DEPT_MANGER);
            rs = pstmt.executeQuery();

            //while (rs.next()) {}
            deptManager = (DeptManagerFactory) DTOFactoryCreator.createBuilder(DeptManager.class);
            deptManagers = deptManager.createListFromResultSet(rs);

        } catch (SQLException ex) {
            Logger.getLogger(DeptManagerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return deptManagers;
    }
    
    @Override
    public void addDeptManager(DeptManager deptManager) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_DEPT_MANGER);) {
            pstmt.setString(1, deptManager.getEmpNo());
            pstmt.setString(2, deptManager.getDeptNo());
            pstmt.setString(3, deptManager.getFromDate());
            pstmt.setString(4, deptManager.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeptManagerDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
