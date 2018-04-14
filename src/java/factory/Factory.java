/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author shican
 * @param <T>
 */
public interface Factory<T> {

    public T createFromResultSet(ResultSet rs);

    public List<T> createListFromResultSet(ResultSet rs);

    public T createFromMap(Map<String, String[]> map);
}
