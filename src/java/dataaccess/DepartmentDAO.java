/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Department;

/**
 *
 * @author shican
 */
public interface DepartmentDAO {

    List<Department> getAllDepartments();

    void addDepartment(Department department);
    //List<Employee> getEmployeeByFirstName(String firstName);
    Department getDepartmentByDepartmentNo(String DepartmentNo);
    //void updateEmployee(Employee employee);
    //void deleteEmployee(Employee employee);
}
