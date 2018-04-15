/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.DeptEmployeeDAO;
import dataaccess.DeptEmployeeDAOImpl;
import java.util.List;
import transferobjects.DeptEmployee;

/**
 *
 * @author Owner
 */
public class DeptEmployeesLogic {
    private static final int DEPT_EMPLOYEE_DEPTNO = 45;
    private static final int DEPT_EMPLOYEE_DATE = 10;
    
    private DeptEmployeeDAO deptEmployeeDAO = null;
    
    public DeptEmployeesLogic(){
        deptEmployeeDAO = new DeptEmployeeDAOImpl();
    }
    
    public List<DeptEmployee> getAllDeptEmployees() {
        return deptEmployeeDAO.getAllDeptEmployees();
    }
    
    public void addDeptEmployee(DeptEmployee deptEmployee) {
        cleanDeptEmployee(deptEmployee);
        validateDeptEmployee(deptEmployee);
        deptEmployeeDAO.addDeptEmployee(deptEmployee);
    }
    
    public DeptEmployee getDeptEmployeeByEmpNo(Integer EmpNo){
        return deptEmployeeDAO.getDeptEmployeeByEmpNo(EmpNo);
    }
    
    public List<DeptEmployee> getDeptEmployeeByDeptNo(String deptNo){
        return deptEmployeeDAO.getDeptEmployeeByDeptNo(deptNo);
    }
    
    private void cleanDeptEmployee(DeptEmployee deptEmployee) {
        if (deptEmployee.getEmpNo() != null) {
            deptEmployee.setEmpNo(deptEmployee.getEmpNo().trim());
        }

        if (deptEmployee.getDeptNo() != null) {
            deptEmployee.setDeptNo(deptEmployee.getDeptNo().trim());
        }

        if (deptEmployee.getFromDate() != null) {
            deptEmployee.setFromDate(deptEmployee.getFromDate().trim());
        }

        if (deptEmployee.getToDate() != null) {
            deptEmployee.setToDate(deptEmployee.getToDate().trim());
        }
    }
    
    private void validateDeptEmployee(DeptEmployee deptEmployee) {
        //validateString(deptEmployee.getEmpNo(), "Employee Number", DEPT_EMPLOYEE_NO_MAX_LENGTH, false);
        validateString(deptEmployee.getDeptNo(), "Department Number", DEPT_EMPLOYEE_DEPTNO, false);
        validateString(deptEmployee.getFromDate(), "From Date", DEPT_EMPLOYEE_DATE, false);
        validateString(deptEmployee.getToDate(), "To Date", DEPT_EMPLOYEE_DATE, false);
    }
    
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null) {
            if (!isNullAllowed) {
                throw new IllegalArgumentException(String.format("%s cannot be null", fieldName));
            }
        } else if (value.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new IllegalArgumentException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }
}
