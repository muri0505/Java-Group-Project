/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Salary;

/**
 *
 * @author Owner
 */
public class SalaryBuilder {

    private static String COL_EMP_NO = "emp_no";
    private static String COL_SALARY = "salary";
    private static String COL_FROM_DATE = "from_date";
    private static String COL_TO_DATE = "to_date";

    private Salary salary;

    public SalaryBuilder() {
        salary = new Salary();
    }

    /**
     * set values for the Salary object
     *
     * @param map
     */
    public void build(Map<String, String[]> map) {
        setEmpNo(map);
        setSalary(map);
        setFromDate(map);
        setToDate(map);
    }

    public void setEmpNo(Map<String, String[]> map) {
        salary.setEmpNo(map.get(COL_EMP_NO)[0]);
    }

    public void setSalary(Map<String, String[]> map) {
        salary.setSalary(map.get(COL_SALARY)[0]);
    }

    public void setFromDate(Map<String, String[]> map) {
        salary.setFromDate(map.get(COL_FROM_DATE)[0]);
    }

    public void setToDate(Map<String, String[]> map) {
        salary.setToDate(map.get(COL_TO_DATE)[0]);
    }

    public void setEmpNo(ResultSet rs) {
        try {
            salary.setEmpNo(rs.getString(COL_EMP_NO));
        } catch (SQLException ex) {
            salary.setEmpNo(null);
            Logger.getLogger(SalaryBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSalary(ResultSet rs) {
        try {
            salary.setSalary(rs.getString(COL_SALARY));
        } catch (SQLException ex) {
            Logger.getLogger(SalaryBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setFromDate(ResultSet rs) {
        try {
            salary.setFromDate(rs.getString(COL_FROM_DATE));
        } catch (SQLException ex) {
            Logger.getLogger(SalaryBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setToDate(ResultSet rs) {
        try {
            salary.setToDate(rs.getString(COL_TO_DATE));
        } catch (SQLException ex) {
            Logger.getLogger(SalaryBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Salary getSalary() {
        return salary;
    }
}
