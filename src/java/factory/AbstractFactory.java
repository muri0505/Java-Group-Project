/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Department;

/**
 *
 * @author shican
 * @param <T>
 */
public abstract class AbstractFactory<T> implements Factory<T> {

    @Override
    public abstract T createFromResultSet(ResultSet rs);

    @Override
    public abstract T createFromMap(Map<String, String[]> map);

    /**
     * creates a list of type T
     *
     * @param rs
     * @return
     */
    @Override
    public List<T> createListFromResultSet(ResultSet rs) {
        List<T> collections = Collections.EMPTY_LIST;
        try {
            collections = new LinkedList<>();
            //rs.beforeFirst();
            while (rs.next()) {
                collections.add(createFromResultSet(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return collections;
    }
}
