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
import java.util.ArrayList;

import com.dmr.project.service.DataProcessingService;
import com.dmr.project.model.MeterReading;
import com.dmr.project.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class DummydataDao {
    
    public static  ArrayList<MeterReading> meterReadingDummyData(int meterID){
        System.out.println("In meter reading dummy data");
        
        ArrayList<String> dateList = DataProcessingService.getDateList("2017-04-01", "2017-06-08");
        
        ArrayList<MeterReading> readingList = new ArrayList();
        
        
        for(int i=0; i < dateList.size(); i++){
           MeterReading temp = new MeterReading();
           
           
           double v = DataProcessingService.getRandomVoltage();
           double a = DataProcessingService.getRandomAmphere();
           
           temp.setTimeStamp(dateList.get(i));
           temp.setAmphere(a);
           temp.setVoltage(v);
           temp.setUnit(v, a);
           temp.setMeterId(meterID);
           
           readingList.add(temp);
        }
        
        
        return readingList;
    }
    
    public static void meterReadingDummyDataWriting(int meterId){
        
        ArrayList<MeterReading> list = meterReadingDummyData(1001);
        
        
        try{
            Connection con  = DBConnection.connect();
            
            String Query = "INSERT INTO dmr_reading2(time,voltage,amphere,consumption_unit,meterID)"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(Query);
            
            for(int i=0; i< list.size(); i++){
                
                MeterReading obj = list.get(i);
                statement.setString(1, obj.getDate());
                statement.setDouble(2, obj.getVoltage());
                statement.setDouble(3, obj.getAmphere());
                statement.setDouble(4, obj.getUnit());
                statement.setInt(5, obj.getMeterId());
                statement.execute();
                System.out.println("Here");
            }
            
        }
        
        catch(Exception ex){
            System.out.println("Meter Reading dummy Date Writing ex: "+ ex);
        }
        
        

    }
    
}
