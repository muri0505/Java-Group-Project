/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import builders.TitleBuilder;
import java.sql.ResultSet;
import java.util.Map;
import transferobjects.Title;

/**
 *
 * @author Owner
 */
public class TitleFactory extends AbstractFactory {

    TitleBuilder db;

    public TitleFactory() {
        db = new TitleBuilder();
    }

    /**
     * create a builder from resultset
     *
     * @param rs
     * @return
     */
    @Override
    public Title createFromResultSet(ResultSet rs) {
        db = new TitleBuilder();
        db.setEmpNo(rs);
        db.setTitle(rs);
        db.setFromDate(rs);
        db.setToDate(rs);
        return db.getTitle();
    }

    /**
     * calls builder to create an object
     *
     * @param map
     * @return
     */
    @Override
    public Title createFromMap(Map map) {
        db.build(map);
        return db.getTitle();
    }
}
