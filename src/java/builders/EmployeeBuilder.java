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
import transferobjects.Employee;

/**
 *
 * @author shican
 */
public class EmployeeBuilder {

    private static String COL_EMPLOYEE_NO = "emp_no";
    private static String COL_EMPLOYEE_BIRTH_DATE = "birth_date";
    private static String COL_EMPLOYEE_FIRST_NAME = "first_name";
    private static String COL_EMPLOYEE_LAST_NAME = "last_name";
    private static String COL_EMPLOYEE_GENDER = "gender";
    private static String COL_EMPLOYEE_HIRE_DATE = "hire_date";

    private Employee employee;

    public EmployeeBuilder() {
        employee = new Employee();
    }

    /**
     * set values for the Employee object
     *
     * @param map
     */
    public void build(Map<String, String[]> map) {
        setEmployeeBirthDate(map);
        setEmployeeFirstName(map);
        setEmployeeLastName(map);
        setEmployeeGender(map);
        setEmployeeHireDate(map);
    }

    public void setEmployeeNo(ResultSet rs) {
        try {
            employee.setEmpNo(rs.getString(COL_EMPLOYEE_NO));
        } catch (SQLException ex) {
            employee.setEmpNo(null);
            Logger.getLogger(EmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeNo(Map<String, String[]> map) {
        employee.setEmpNo(map.get("emp_no")[0]);
    }

    public void setEmployeeBirthDate(ResultSet rs) {
        try {
            employee.setBirthDate(rs.getString(COL_EMPLOYEE_BIRTH_DATE));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeBirthDate(Map<String, String[]> map) {
        employee.setBirthDate(map.get("birth_date")[0]);
    }

    public void setEmployeeFirstName(ResultSet rs) {
        try {
            employee.setFirstName(rs.getString(COL_EMPLOYEE_FIRST_NAME));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeFirstName(Map<String, String[]> map) {
        employee.setFirstName(map.get("first_name")[0]);
    }

    public void setEmployeeLastName(ResultSet rs) {
        try {
            employee.setLastName(rs.getString(COL_EMPLOYEE_LAST_NAME));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeLastName(Map<String, String[]> map) {
        employee.setLastName(map.get("last_name")[0]);
    }

    public void setEmployeeGender(ResultSet rs) {
        try {
            employee.setGender(rs.getString(COL_EMPLOYEE_GENDER));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeGender(Map<String, String[]> map) {
        employee.setGender(map.get("gender")[0]);
    }

    public void setEmployeeHireDate(ResultSet rs) {
        try {
            employee.setHireDate(rs.getString(COL_EMPLOYEE_HIRE_DATE));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeHireDate(Map<String, String[]> map) {
        employee.setHireDate(map.get("hire_date")[0]);
    }

    public Employee getEmployee() {
        return employee;
    }
}
