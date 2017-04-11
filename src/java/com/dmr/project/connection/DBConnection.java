/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.connection;

/**
 *
 * @author chamara
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    public static java.sql.Connection connect() {
//        initializing Connection variable.
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception in first try block: "+ex);
        }
        
//        Connection parameters
        String url = "jdbc:mysql://localhost:3306/dmr";
        String username = "root";
        String password = "root";
        
        try {
            
//            Establishing connection
            con = DriverManager.getConnection(url,username,password);
            return con;
            
            } 
        catch (SQLException ex) {
            System.out.println("EXception in second try block: "+ex);
        }
        
        return con;
    }
}
