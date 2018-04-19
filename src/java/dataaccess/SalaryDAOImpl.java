/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import factory.DTOFactoryCreator;
import factory.SalaryFactory;
import factory.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Salary;

/**
 *
 * @author Owner
 */
public class SalaryDAOImpl implements SalaryDAO {

    private static final String GET_ALL_SALARY = "SELECT emp_no, salary, from_date, to_date FROM salaries ORDER BY emp_no LIMIT 100";
    private static final String INSERT_SALARY = "INSERT INTO salaries (emp_no, salary, from_date, to_date) VALUES(?,?,?,?)";
    private static final String SEARCH_SALARY_BY_EMPNO = "SELECT emp_no, salary, from_date, to_date FROM salaries WHERE emp_no = ";

    /**
     * returns all records
     *
     * @return
     */
    @Override
    public List<Salary> getAllSalaries() {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Salary> salaries = Collections.EMPTY_LIST;
        Factory salary = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_SALARY);
            rs = pstmt.executeQuery();

            //while (rs.next()) {}
            salary = (SalaryFactory) DTOFactoryCreator.createBuilder(Salary.class);
            salaries = salary.createListFromResultSet(rs);

        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return salaries;
    }

    @Override
    public void addSalary(Salary salary) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_SALARY);) {
            pstmt.setString(1, salary.getEmpNo());
            pstmt.setString(2, salary.getSalary());
            pstmt.setString(3, salary.getFromDate());
            pstmt.setString(4, salary.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * find a record based or id number, then creates an object using factory
     *
     * @param empNo
     * @return
     */
    @Override
    public List<Salary> getSalaryByEmpNo(Integer empNo) {
        SalaryFactory salaryFactory = null;
        List<Salary> salary = null;
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SEARCH_SALARY_BY_EMPNO + "'" + empNo + "'");
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                salaryFactory = (SalaryFactory) DTOFactoryCreator.createBuilder(Salary.class);
                if (salaryFactory.createFromResultSet(rs).getEmpNo() == null) {
                    salary = null;
                } else {
                    rs.beforeFirst();
                    salary = salaryFactory.createListFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salary;
    }
}
