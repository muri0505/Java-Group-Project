/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import builders.DeptManagerBuilder;
import java.sql.ResultSet;
import java.util.Map;
import transferobjects.DeptManager;
/**
 *
 * @author Owner
 */
public class DeptManagerFactory extends AbstractFactory{
    DeptManagerBuilder db;
    
    public DeptManagerFactory(){
        db = new DeptManagerBuilder();
    }
    
    @Override
    public DeptManager createFromResultSet(ResultSet rs){
        db = new DeptManagerBuilder();
        db.setEmpNo(rs);
        db.setDeptNo(rs);
        db.setFromDate(rs);
        db.setToDate(rs);
        return db.getDeptManager();
    }
    
    @Override
    public DeptManager createFromMap(Map map) {
        db.build(map);
        return db.getDeptManager();
    }
}