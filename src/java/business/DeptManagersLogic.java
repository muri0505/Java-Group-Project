/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.DeptManagerDAO;
import dataaccess.DeptManagerDAOImpl;
import java.util.List;
import transferobjects.DeptManager;

/**
 *
 * @author Owner
 */
public class DeptManagersLogic {
    private static final int DEPT_MANAGER_NO_MAX_LENGTH = 45;
    private static final int DEPT_MANAGER_NAME_MAX_LENGTH = 45;
    
    private DeptManagerDAO deptManagerDAO = null;
    
    public DeptManagersLogic(){
        deptManagerDAO = new DeptManagerDAOImpl();
    }
    
    public List<DeptManager> getAllDeptManagers() {
        return deptManagerDAO.getAllDeptManagers();
    }
    
    public void addDeptManager(DeptManager deptManager) {
        cleanDeptManager(deptManager);
        validateDeptManager(deptManager);
        deptManagerDAO.addDeptManager(deptManager);
    }
    
    private void cleanDeptManager(DeptManager deptManager) {
        if (deptManager.getEmpNo() != null) {
            deptManager.setEmpNo(deptManager.getEmpNo().trim());
        }

        if (deptManager.getDeptNo() != null) {
            deptManager.setDeptNo(deptManager.getDeptNo().trim());
        }

        if (deptManager.getFromDate() != null) {
            deptManager.setFromDate(deptManager.getFromDate().trim());
        }

        if (deptManager.getToDate() != null) {
            deptManager.setToDate(deptManager.getToDate().trim());
        }
    }
    
    private void validateDeptManager(DeptManager deptManager) {
        validateString(deptManager.getEmpNo(), "Employee Number", DEPT_MANAGER_NO_MAX_LENGTH, false);
        validateString(deptManager.getDeptNo(), "Department Number", DEPT_MANAGER_NO_MAX_LENGTH, false);
        validateString(deptManager.getFromDate(), "From Date", DEPT_MANAGER_NO_MAX_LENGTH, false);
        validateString(deptManager.getToDate(), "To Date", DEPT_MANAGER_NO_MAX_LENGTH, false);
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
