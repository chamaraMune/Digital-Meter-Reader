/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.dao;

/**
 *
 * @author chamara
 */

import com.dmr.project.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.dmr.project.model.RequestForm;
public class AdminHomeDao {
    
    public static int getCountRequests(){
        
        try{
            Connection connection = DBConnection.connect();
            
            String query = "SELECT COUNT(request_status) AS total FROM dmr_request "+
                    "WHERE request_status = 'false'";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            result.next();
            return result.getInt("total");
        }
        
        catch(SQLException ex){
            System.err.println("GetCountReqests method exception : "+ex);
            return 0;
        }
    }
    

    

    
    

    

//    public static boolean addMeterDMR(){}
    
}
