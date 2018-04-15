/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import builders.SalaryBuilder;
import java.sql.ResultSet;
import java.util.Map;
import transferobjects.Salary;

/**
 *
 * @author Owner
 */
public class SalaryFactory extends AbstractFactory{
    SalaryBuilder db;
    
    public SalaryFactory(){
        db = new SalaryBuilder();
    }
    
    @Override
    public Salary createFromResultSet(ResultSet rs){
        db = new SalaryBuilder();
        db.setEmpNo(rs);
        db.setSalary(rs);
        db.setFromDate(rs);
        db.setToDate(rs);
        return db.getSalary();
    }
    
    @Override
    public Salary createFromMap(Map map) {
        db.build(map);
        return db.getSalary();
    }
}
