/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.dao;

import com.dmr.project.connection.DBConnection;
import com.dmr.project.model.TariffDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.dmr.project.service.CalculateBill;

/**
 *
 * @author root
 */
public class TariffMethod {
    double units;
    double current_bill;
    DBConnection connection = new DBConnection();
    CalculateBill billObject = new CalculateBill();
    Connection conn = null;
    ResultSet result = null;
    ArrayList<TariffDetails> tariffList1 = new ArrayList<TariffDetails>();
    ArrayList<TariffDetails> tariffList2 = new ArrayList<TariffDetails>(); 
    
       public double selectMethod(double units,String category){
      //  return category;
        this.units = units;
        if(category.equals("domestic")){
            
            if(units <= 60){
                
               tariffList2 = getTariffMethod1("domestic1");
              current_bill = new CalculateBill().domestic1Bill(units, tariffList2);
               
                
            }else{
            
              tariffList2 =  getTariffMethod1("domestic2");
                current_bill = new CalculateBill().domestic2Bill(units, tariffList2);
            
            } 
        
        }else if(category.equals("general") ){
        
           tariffList2 = getTariffMethod1("general1");
           current_bill = new CalculateBill().industrialBill(units, tariffList2);

           
            
        }else if(category.equals("government1")){
        
           tariffList2 = getTariffMethod2("government1");
           current_bill = new CalculateBill().hotelBill(units, tariffList2);
           
        }else if(category.equals("government2")){
        
           tariffList2 = getTariffMethod2("government2");
           current_bill = new CalculateBill().hotelBill(units, tariffList2);

           
        }else if(category.equals("government3")){
        
           tariffList2 = getTariffMethod2("government3");
           current_bill = new CalculateBill().hotelBill(units, tariffList2);
 
           
        }else if(category.equals("hotel")){
        
           tariffList2 = getTariffMethod2("hotel1");
           current_bill = new CalculateBill().hotelBill(units, tariffList2);

            
        }else if(category.equals("industrial")){
        
           tariffList2 = getTariffMethod1("industrial1");
           current_bill = new CalculateBill().industrialBill(units, tariffList2);

        }else if(category.equals("religious")){
        
           tariffList2 = getTariffMethod1("religious");
           current_bill = new CalculateBill().domestic2Bill(units, tariffList2);

        
        }
          return current_bill;  
    }
       
           public ArrayList<TariffDetails> getTariffMethod1(String table){// methord for normal tariff category with consumption rangers
        String Table = table;
        try{
            conn = connection.connect();
            String sql1 = "SELECT * FROM @tableName;";
            String sql2 = sql1.replace("@tableName", Table);
            PreparedStatement statement = conn.prepareStatement(sql2);
            
            result = statement.executeQuery();
            
            while(result.next()){
            
                double consumption = result.getDouble("consumption");
                double energy_charge = result.getDouble("energy_charge");
                double fixed_charge = result.getDouble("fixed_charge");
                //int dimand_charge = result.getInt("dimand_charge");
                
                TariffDetails temp = new TariffDetails(consumption, energy_charge, fixed_charge);
                tariffList1.add(temp);
                
            }
            
            
        }catch(Exception ex){
        
            System.out.println("sql exception " + ex);
        
        }
    return tariffList1;
    }
           
           
        public ArrayList<TariffDetails> getTariffMethod2(String table){// method2 for without consumption range 
        String Table = table;
        try{
            conn = connection.connect();
            String sql1 = "SELECT * FROM @tableName";
            String sql2 = sql1.replace("@tableName", Table);
            PreparedStatement statement = conn.prepareStatement(sql2);
            result = statement.executeQuery();
            
            while(result.next()){
           
                double energy_charge = result.getDouble("energy_charge");
                double fixed_charge = result.getDouble("fixed_charge");
                int dimand_charge = result.getInt("dimand_charge");
                
                TariffDetails temp = new TariffDetails(energy_charge, fixed_charge, dimand_charge);
                tariffList1.add(temp);
            }
            
            
        }catch(Exception ex){
        
            System.out.println("sql exception " + ex);
        
        }
    return tariffList1;
    }
       
       
}
