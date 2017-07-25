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
import java.sql.ResultSet;
import com.dmr.project.model.MeterReading;
import java.util.ArrayList;
import java.util.List;
public class AnalyticalDAO {
    
    public static int getMeterId(String loggedUser){
        
        int meterId =0;
        try{
            
            Connection con = DBConnection.connect();
            String query = "SELECT meterId FROM dmr_meter WHERE userId = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, loggedUser);
            ResultSet result = statement.executeQuery();
            boolean hasResult = result.next();
            meterId = result.getInt("meterId");
            
            return meterId;
            
        }
        
        catch(Exception ex){
            System.out.println("AnalyticalDAO getMeter Id EX : "+ ex);
        }
        return meterId;
    }
    
    public static List<MeterReading> getMeterReading(int meterId){
        
        List<MeterReading> list = new ArrayList();
        
        try{
            Connection con = DBConnection.connect();
            
            String query = "SELECT * FROM dmr_reading2 WHERE meterID = ? "
                    + "ORDER BY time DESC";
                   
                    
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, meterId);
//            ps.setString(2, time);
            ResultSet result = ps.executeQuery();
            
            while(result.next()){
                MeterReading temp = new MeterReading();
                temp.setDate(result.getString("time"));
                temp.setVoltage(result.getDouble("voltage"));
                temp.setAmphere(result.getDouble("amphere"));
                temp.setUnit(result.getDouble("consumption_unit"));
                list.add(temp);
                
            }
            return list;
            
        }
        
        catch(Exception ex){
            System.out.println("AnalyticalDAO getMeterReading() EX: "+ ex);
        }
        return list;
        
    }
}
