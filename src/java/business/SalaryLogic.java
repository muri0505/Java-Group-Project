/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.SalaryDAO;
import dataaccess.SalaryDAOImpl;
import java.util.List;
import transferobjects.Salary;

/**
 *
 * @author Owner
 */
public class SalaryLogic {
    private static final int SALARY_DATE = 10;
    
    private SalaryDAO salaryDAO = null;
    
    public SalaryLogic(){
        salaryDAO = new SalaryDAOImpl();
    }
    
    public List<Salary> getAllSalaries() {
        return salaryDAO.getAllSalaries();
    }
    
    public void addSalary(Salary salary) {
        cleanSalary(salary);
        validateSalary(salary);
        salaryDAO.addSalary(salary);
    }
    
    public List<Salary> getSalaryByEmpNo(Integer empNo){
        return salaryDAO.getSalaryByEmpNo(empNo);
    }
    
    private void cleanSalary(Salary salary) {
        if (salary.getEmpNo() != null) {
            salary.setEmpNo(salary.getEmpNo().trim());
        }

        if (salary.getSalary() != null) {
            salary.setSalary(salary.getSalary().trim());
        }

        if (salary.getFromDate() != null) {
            salary.setFromDate(salary.getFromDate().trim());
        }

        if (salary.getToDate() != null) {
            salary.setToDate(salary.getToDate().trim());
        }
    }
    
    private void validateSalary(Salary salary) {
        //validateString(salary.getEmpNo(), "Employee Number", SALARY_NO_MAX_LENGTH, false);
        //validateString(salary.getSalary(), "Salary", SALARY_NAME_MAX_LENGTH, false);
        validateString(salary.getFromDate(), "From Date", SALARY_DATE, false);
        validateString(salary.getToDate(), "To Date", SALARY_DATE, false);
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

