/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.dao;

import com.dmr.project.connection.DBConnection;
import com.dmr.project.model.RedBill;
import com.dmr.project.model.TariffDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author root
 */
public class GetRedBill {

    DBConnection connection = new DBConnection();
    Connection conn = null;
    ResultSet result = null;
    int meter_id;
    double last_bill;
    double current_bill;
    Date date;
    int number;
    
    ArrayList<RedBill> redBillList = new ArrayList<RedBill>();
    
    public ArrayList<RedBill> getbill(){
       
       try{
        
           conn = connection.connect();
           String sql = "select meter_id,last_bill,current_bill,bill_date from dmr_bill where last_bill>=3000;";
           PreparedStatement statement = conn.prepareStatement(sql);
           result = statement.executeQuery();
           
           while(result.next()){
              meter_id = result.getInt("meter_id");
              
              last_bill = result.getDouble("last_bill");
              current_bill = result.getDouble("current_bill");
              date = result.getDate("bill_date");
              RedBill temp = new RedBill(meter_id,last_bill,current_bill,date);
              redBillList.add(temp);
           }
               
       }catch(Exception ex){
           System.out.println("Exception in get area ex: "+ex);
       }
       return redBillList;
    }
   
    
    public Integer getPhoneNo(int meterId){
        int num = 0;
        
        try{
        
         conn = connection.connect();
         String sql = "select mobileNumber from dmr_user where meterId=?";
         PreparedStatement statement = conn.prepareStatement(sql);
         statement.setInt(1, meterId);
         result = statement.executeQuery();
        
           while(result.next()){
              num = result.getInt("mobileNumber");
              
           }
         
        }catch(Exception ex){
            System.out.println("Exception in get area ex: "+ex);
        }
        
    return num;
    }
}
