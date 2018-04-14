/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import builders.EmployeeBuilder;
import java.sql.ResultSet;
import java.util.Map;
import transferobjects.Employee;

/**
 *
 * @author shican
 */
public class EmployeeFactory extends AbstractFactory{
    EmployeeBuilder db = new EmployeeBuilder();

    @Override
    public Employee createFromResultSet(ResultSet rs) {
        db.setEmployeeNo(rs);
        db.setEmployeeBirthDate(rs);
        db.setEmployeeFirstName(rs);
        db.setEmployeeLastName(rs);
        db.setEmployeeGender(rs);
        db.setEmployeeHireDate(rs);
        return db.getEmployee();
    }

    @Override
    public Employee createFromMap(Map map) {
        db.build(map);
        return db.getEmployee();
    }
}
