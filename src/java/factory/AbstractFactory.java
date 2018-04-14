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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public List<T> createListFromResultSet(ResultSet rs) {
        try {
            List<T> collections = Collections.EMPTY_LIST;
            collections = new ArrayList<>(100);
            while (rs.next()) {
               //collections.add()
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
