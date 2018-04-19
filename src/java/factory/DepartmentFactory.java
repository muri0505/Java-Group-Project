/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import builders.DepartmentBuilder;
import java.sql.ResultSet;
import java.util.Map;
import transferobjects.Department;

/**
 *
 * @author shican
 */
public class DepartmentFactory extends AbstractFactory {

    DepartmentBuilder db;

    public DepartmentFactory() {
        db = new DepartmentBuilder();
    }
/**
 * creates a builder from resultset
 * @param rs
 * @return 
 */
    @Override
    public Department createFromResultSet(ResultSet rs) {
        db = new DepartmentBuilder();
        db.setDeptName(rs);
        db.setDeptNo(rs);
        return db.getDept();
    }
/**
 * calls builder to create an object
 * @param map
 * @return 
 */
    @Override
    public Department createFromMap(Map map) {
        db.build(map);
        return db.getDept();
    }

}
