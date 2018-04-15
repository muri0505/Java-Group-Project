/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Title;


/**
 *
 * @author Owner
 */
public interface TitleDAO {
    List<Title> getAllTitles();

    void addTitle(Title title);
    //List<Employee> getEmployeeByFirstName(String firstName);
    //Title getEmployeByEmployeeNo(Integer EmployeeNo);
    //void updateEmployee(Employee employee);
    //void deleteEmployee(Employee employee);
}
