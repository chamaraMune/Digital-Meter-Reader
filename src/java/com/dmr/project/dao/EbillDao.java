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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dmr.project.service.GetDoubleValue;

public class EbillDao {
    
    DBConnection connection = new DBConnection();
    Connection conn = null;
    
    public double returen_bill(int id,double bill){// get last bill and add new bill to it then update the bill
        int meter_id = id;
        double current_bill = bill;
        double last_bill=0;
        double new_bill =0;
        ResultSet rs =null;
        try{
           conn = connection.connect();
           String sql1 = "SELECT last_bill FROM dmr_bill WHERE meter_id =?";
           PreparedStatement statement = conn.prepareStatement(sql1);
           statement.setInt(1, meter_id);
           rs = statement.executeQuery();
           while(rs.next()){
           last_bill = rs.getDouble("last_bill");
           }
           new_bill = last_bill+current_bill; //call update bill function
           setBill(meter_id,new_bill,current_bill);
        }catch(Exception ex){
            System.out.println("Exception"+ex);
        }
        return new_bill;
    }
    public void setBill(int id, double new_bill,double current_bill2){// update bill  
            int meter_id = id;
            
            double last_bill = new GetDoubleValue().getValue(new_bill);
            double current_bill = new GetDoubleValue().getValue(current_bill2);
            try{
            String sql2 = "UPDATE dmr_bill SET last_bill=?, current_bill=? WHERE meter_id=?;";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setDouble(1, last_bill);
            statement2.setDouble(2, current_bill);
            statement2.setInt(3, meter_id);
            statement2.executeUpdate();
            }catch(Exception ex){
                System.out.println("Exception: "+ex);
            }
    }
}
