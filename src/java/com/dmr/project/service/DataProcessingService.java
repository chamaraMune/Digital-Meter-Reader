/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.service;

/**
 *
 * @author chamara
 */
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class DataProcessingService {
    
    /*This method is used to generate dummy dates when given range*/
    public static ArrayList<String> getDateList(String fromDate,String toDate){
        
        ArrayList<String> list = new ArrayList();
        list.add(fromDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        
        try{
            
            while(!fromDate.equals(toDate)){
                
                calendar.setTime(dateFormat.parse(fromDate));
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                fromDate = dateFormat.format(calendar.getTime());
                list.add(fromDate);
            }
        }
        
        catch(Exception ex){
            System.err.println("getDateList() exception : "+ ex);
        }
        
        return list;
    }
    
    /*This method is used to generate dummy voltage Value*/
    public static double getRandomVoltage(){
        
        double min = 220.0;
        double max = 240.0;
        
        Random random = new Random();
        DecimalFormat format = new DecimalFormat("#.####");
        format.setRoundingMode(RoundingMode.CEILING);
        double temp = min + random.nextDouble()* (max - min);
        temp = Double.valueOf(format.format(temp));
        
        return temp;
        
    }
    
    /*This method is used to generate dummy amphre value */
    public static double getRandomAmphere(){
        
        double min = 5;
        double max = 50;
        Random random = new Random();
        DecimalFormat format = new DecimalFormat("#.####");
        format.setRoundingMode(RoundingMode.CEILING);
        double temp = min + random.nextDouble()* (max - min);
        temp = Double.valueOf(format.format(temp));
//        System.out.println("temp : "+temp);
        return temp;
        
    }
}
