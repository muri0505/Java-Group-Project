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
    
    DepartmentBuilder db = new DepartmentBuilder();

    @Override
    public Department createFromResultSet(ResultSet rs) {
        db.setDeptName(rs);
        db.setDeptNo(rs);
        return db.getDept();
    }

    @Override
    public Department createFromMap(Map map) {
        db.build(map);
        return db.getDept();
    }

}
