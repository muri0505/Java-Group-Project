/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import builders.DeptEmployeeBuilder;
import java.sql.ResultSet;
import java.util.Map;
import transferobjects.DeptEmployee;

/**
 *
 * @author Owner
 */
public class DeptEmployeeFactory extends AbstractFactory{
    DeptEmployeeBuilder db;
    
    public DeptEmployeeFactory(){
        db = new DeptEmployeeBuilder();
    }
    
    @Override
    public DeptEmployee createFromResultSet(ResultSet rs){
        db = new DeptEmployeeBuilder();
        db.setEmpNo(rs);
        db.setDeptNo(rs);
        db.setFromDate(rs);
        db.setToDate(rs);
        return db.getDeptEmployee();
    }
    
    @Override
    public DeptEmployee createFromMap(Map map) {
        db.build(map);
        return db.getDeptEmployee();
    }
}