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
import com.dmr.project.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditUserProfileDAO {
    
    public static User getUserDetails(String username){
        
        User  tempUser = new User();
        try{
           Connection con  = DBConnection.connect();
           String query = "SELECT * FROM dmr_user WHERE username =?";
           PreparedStatement statement = con.prepareStatement(query);
           statement.setString(1, username);
           
           ResultSet result = statement.executeQuery();
           
           
           if(result.last()){
               tempUser.setFirstname(result.getString("firstname"));
               tempUser.setLastname(result.getString("lastname"));
               tempUser.setAddress(result.getString("address"));
               tempUser.setEmail(result.getString("email"));
               tempUser.setUsername(result.getString("username"));
               tempUser.setMobileNo(result.getInt("mobileNumber"));
               return tempUser;
           }
           
           
        }
        catch(Exception ex){
            System.out.println("EDIT user profileDAO exception : "+ ex);
        }
        return tempUser;
    }
    
    public static String passwordChecking(String username){
        String hashpw = null;
        System.out.println("Here");
        try{
            Connection con = DBConnection.connect();
            String query = "SELECT password FROM dmr_user Where username = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if(result.first()){
                hashpw = result.getString("password");
            }
            
        }
        catch(Exception ex){
            System.out.println("Password Checking Exception: "+ex);
        }
        return hashpw;
    }
    
    // Update User Profile
    public static boolean updateProfile(User usr){
        boolean sucsess = true;
        int update = 0;
        System.out.println("Updating User profile");
        try{
            Connection con = DBConnection.connect();
            String sql = "UPDATE dmr_user SET firstname =?,lastname=?,email=?,mobileNumber=?,password=? WHERE username=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usr.getFirstname());
            ps.setString(2, usr.getLastname());
            ps.setString(3, usr.getEmail());
            ps.setInt(4, usr.getMobileNo());
            ps.setString(5, usr.getPassowrd());
            ps.setString(6, usr.getUsername());
            update = ps.executeUpdate();
            if(update == 0){
                System.out.println("Tring to Update:" + usr.getFirstname() + " " + usr.getLastname()+ " " + usr.getUsername());
                System.out.println("Update Failed at DAO");
                sucsess = false;
            }
            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        return sucsess;
    }
    
}
