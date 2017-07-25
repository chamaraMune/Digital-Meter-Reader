/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.dao;

import com.dmr.project.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.dmr.project.model.TransformerDetails;

/**
 *
 * @author root
 */
public class Transformers {
    
    ResultSet result = null;
   ArrayList<String> locationList = null;
    DBConnection connection = new DBConnection();
    
    public ResultSet getData(String area){
        try{
            Connection conn = connection.connect();
            String sql = "SELECT location FROM transformers WHERE area=?;";
            PreparedStatement statement =conn.prepareStatement(sql);
            statement.setString(1, area);
            result =  statement.executeQuery();
          
//            while(result.next()){
//            
//                String location = result.getString("location");
//                locationList.add(location);
//            }
            
            }catch(Exception ex){
            System.out.println("quert exception : "+ex);
        }
        return result;  
    }
    public ResultSet getTransformers(String[] area){
        ResultSet rs = null;
        String sql2 = null;
        String sql1 = null;
        PreparedStatement statement = null;
        try{
            Connection conn = connection.connect();
            sql2 = "SELECT location FROM transformers WHERE area=?";
            for(int i=1; i<area.length; i++){
                String temp = " or area=? ";
                sql2 += temp;
            }
             statement = conn.prepareStatement(sql2);
            for(int i=1; i<=area.length; i++){
                statement.setString(i, area[i-1]);
            }
            rs = statement.executeQuery();
            
            
        }catch(Exception ex){
            System.out.println("exception "+ex);
        }
    return rs;
    }
    
}
