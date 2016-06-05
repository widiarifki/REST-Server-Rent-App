package com.widiarifki.rental.connection;
 
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.sql.DataSource;
 
public class DBConnectionHandler {
    

    /*Connection con = null;*/
 
    public static Connection getConnection() {
        Connection con = null;
        /*try {

            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.setProperty("com.mysql.jdbc.Driver","");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://127.13.157.130:3306/adminrental","admincCenqaa","7JaWj_Si5wLC");

        } catch (Exception ex) {
            System.out.println("Exception: " + ex + ex.getMessage());
        }
        return con;*/
        /*Connection con = null;
        //String USERNAME = "admincCenqaa";
        String USERNAME = "root";
        //String PASSWORD = "7JaWj_Si5wLC";
        String PASSWORD = "";
        String DB_NAME = "adminrental";
        String FORNAME_URL = "com.mysql.jdbc.Driver";
        String URL = "mysql://127.13.157.130:3306/";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();//Mysql Connection
        /*} catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {*/
            //con = (Connection) DriverManager.getConnection("jdbc:"+URL+DB_NAME, USERNAME, PASSWORD);
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rental", "root", "");//mysql database
            //con = DriverManager.getConnection("jdbc:mysql://127.13.157.130:3306/adminrental", "admincCenqaa", "7JaWj_Si5wLC");
        //} catch (SQLException ex) {
        /*} catch (Exception ex) {

            System.out.println("Exception: " + ex + ex.getMessage());
            //Logger.getLogger(DBConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            InitialContext ic = new InitialContext();
            Context initialContext = (Context) ic.lookup("java:comp/env");
            DataSource datasource = (DataSource) initialContext.lookup("jdbc/MySQLDS");

            con = datasource.getConnection();
        } catch (Exception ex) {
            System.out.println("Exception db: " + ex + ex.getMessage());
        }
        return con;
        /*Connection result = null;
        try {
            InitialContext ic = new InitialContext();
            Context initialContext = (Context) ic.lookup("java:comp/env");
            DataSource datasource = (DataSource) initialContext.lookup("jdbc/MySQLDS");
            result = datasource.getConnection();
            Statement stmt = result.createStatement() ;
            String query = "select * from names;" ;
            ResultSet rs = stmt.executeQuery(query) ;
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + "<br />");
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex + ex.getMessage());
        }
        return result;*/
    }
}