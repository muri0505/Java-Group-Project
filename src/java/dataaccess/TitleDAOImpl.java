/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import factory.DTOFactoryCreator;
import factory.TitleFactory;
import factory.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Title;

/**
 *
 * @author Owner
 */
public class TitleDAOImpl implements TitleDAO {

    private static final String GET_ALL_TITLES = "SELECT emp_no, title, from_date, to_date FROM titles ORDER BY emp_no LIMIT 100";
    private static final String INSERT_TITLES = "INSERT INTO titles (emp_no, title, from_date, to_date) VALUES(?,?,?,?)";
    private static final String SEARCH_TITLE_BY_EMPNO = "SELECT emp_no, title, from_date, to_date FROM titles WHERE emp_no = ";

    /**
     * returns all records
     *
     * @return
     */
    @Override
    public List<Title> getAllTitles() {
        @SuppressWarnings("unchecked")
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Title> titles = Collections.EMPTY_LIST;
        Factory title = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(GET_ALL_TITLES);
            rs = pstmt.executeQuery();

            //while (rs.next()) {}
            title = (TitleFactory) DTOFactoryCreator.createBuilder(Title.class);
            titles = title.createListFromResultSet(rs);

        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return titles;
    }

    @Override
    public void addTitle(Title title) {
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_TITLES);) {
            pstmt.setString(1, title.getEmpNo());
            pstmt.setString(2, title.getTitle());
            pstmt.setString(3, title.getFromDate());
            pstmt.setString(4, title.getToDate());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * find a record based or id number, then creates an object using factory
     *
     * @param empNo
     * @return
     */
    @Override
    public List<Title> getTitleByEmployeeNo(Integer empNo) {
        TitleFactory titleFactory = null;
        List<Title> title = null;
        try (Connection con = DataSource.getConnection();
                PreparedStatement pstmt = con.prepareStatement(SEARCH_TITLE_BY_EMPNO + "'" + empNo + "'");
                ResultSet rs = pstmt.executeQuery();) {

            while (rs.next()) {
                titleFactory = (TitleFactory) DTOFactoryCreator.createBuilder(Title.class);
                if (titleFactory.createFromResultSet(rs).getEmpNo() == null) {
                    title = null;
                } else {
                    rs.beforeFirst();
                    title = titleFactory.createListFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TitleDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return title;
    }
}
