package com.widiarifki.rental.connection;
 
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.sql.DataSource;
 
public class DBConnectionHandler {

    public static Connection getConnection() {
        Connection con = null;
        try {
            InitialContext ic = new InitialContext();
            Context initialContext = (Context) ic.lookup("java:comp/env");
            DataSource datasource = (DataSource) initialContext.lookup("jdbc/MySQLDS");
            //DataSource datasource = (DataSource) initialContext.lookup("jdbc/LocalMySQLDS");
            con = datasource.getConnection();
        } catch (Exception ex) {
            System.out.println("Exception db: " + ex + ex.getMessage());
        }
        return con;
    }
}