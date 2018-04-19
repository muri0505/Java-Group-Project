/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Shariar
 */
public class DataSource {

    private static DataSource singleton;

    private javax.sql.DataSource ds;

    private DataSource() {
        ds = getDataSource();
    }

    private javax.sql.DataSource getDataSource() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup("jdbc/employees");
            return ds;
        } catch (NamingException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Only use one connection for this application, prevent memory leaks.
     *
     * @return Connection
     */
    public static Connection getConnection() {
        if (singleton == null) {
            singleton = new DataSource();
        }
        return singleton.createConnection();
    }

    private Connection createConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
