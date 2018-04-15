/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Salary;

/**
 *
 * @author Owner
 */
public interface SalaryDAO {
    List<Salary> getAllSalaries();

    void addSalary(Salary salary);
    List<Salary> getSalaryByEmpNo(Integer empNo);
    //Title getEmployeByEmployeeNo(Integer EmployeeNo);
    //void updateEmployee(Employee employee);
    //void deleteEmployee(Employee employee);
}
