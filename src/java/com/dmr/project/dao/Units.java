/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.dao;

/**
 *
 * @author root
 */
import com.dmr.project.connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.dmr.project.model.UnitsDetails;
import java.util.ArrayList;
import java.util.List;

public class Units {
    
    DBConnection  connection = new DBConnection();
    Connection conn = null;
    Connection conn2 = null;
    ResultSet result = null;
    ArrayList<UnitsDetails> list =  new ArrayList<UnitsDetails>();// creat array list using units details beans class
    //int meterId;
   // ArrayList 
    public ArrayList<UnitsDetails> getUnits(){
        
        try{
            conn = connection.connect();
            String sql = " select dmr_meter.meterId,dmr_meter.category,dmr_readings.current_units from dmr_meter left join dmr_readings on dmr_meter.meterId = dmr_readings.meterId;";
            PreparedStatement statement = conn.prepareStatement(sql);
            result = statement.executeQuery();
            
           
            while(result.next()){// add all reading and current units to arraylist
                int meterId = result.getInt("meterId");
                double units = result.getDouble("current_units");
                String category = result.getString("category");
                UnitsDetails temp = new UnitsDetails(meterId,units,category);                
                list.add(temp);
                resetUnits(conn,meterId);
            }
            
        }catch(Exception ex){
            System.out.println("Exception:"+ex);
        }
     
        return list;
    }
    
    
    public void resetUnits(Connection conn,int id){// set current units to zero function
        Connection conn2 = conn;
        int meterId = id;
        try{
            String sql2 = "UPDATE dmr_readings SET current_units=0 WHERE meterId=?";
            PreparedStatement statement2 = conn2.prepareStatement(sql2);
            statement2.setInt(1, meterId);
            statement2.executeUpdate();
        }catch(Exception ex){
            System.out.println("Exception "+ex);
        }
    }
    
    
    public void setUnits(int id, double units){
        try{
            Connection conn3 = connection.connect();
            String sql = "UPDATE dmr_readings SET current_units=? WHERE readingId=?";
            PreparedStatement statement = conn3.prepareStatement(sql);
            statement.setDouble(1, units);
            statement.setInt(2, id);
            statement.executeUpdate();
        }catch(Exception ex){
            System.out.println("Exception"+ex);
        }
        
    }
}
