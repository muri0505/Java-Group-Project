/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Employee;

/**
 *
 * @author Shawn
 */
public interface EmployeeDAO {

    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);

    //List<Employee> getEmployeeByFirstName(String firstName);
    Employee getEmployeeByEmployeeNo(Integer EmployeeNo);
    //void updateEmployee(Employee employee);
    //void deleteEmployee(Employee employee);
}
