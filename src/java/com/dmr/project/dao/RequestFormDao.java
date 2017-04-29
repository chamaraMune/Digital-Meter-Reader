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
import com.dmr.project.model.RequestForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.dmr.project.model.User;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dmr.project.service.GetLocalTimeDate;

public class RequestFormDao {
    
    public static boolean requestFormAddData(User user){
        
        try
        {
           Connection con = DBConnection.connect();
           
           String query = "INSERT INTO dmr_request(first_name,last_name,address,national_id,email,"
                   + "mobile_number,ceb_account,area_office,request_dateTime) VALUES(?,?,?,?,?,?,?,?,?)";
           
           PreparedStatement statement = con.prepareStatement(query);
           statement.setString(1,user.getFirstname());
           statement.setString(2,user.getLastname());
           statement.setString(3,user.getAddress());
           statement.setString(4,user.getNationalId());
           statement.setString(5,user.getEmail());
           statement.setInt(6,user.getMobileNo());
           statement.setInt(7,user.getCebAccountNo());
           statement.setString(8,user.getAreaOffice());
           statement.setString(9,user.getRequestDate());
           boolean isExecuted = statement.execute();
            System.out.println("request form boolean : "+isExecuted);
        }
        catch(Exception ex)
        {
            System.out.println("Exception form RequestFormDao");
            return false;
        }
        
        return true;
    }
    
        public static List<RequestForm> getRequestList(){
        
        List<RequestForm> requestList = new ArrayList();
        
        try{
            
            Connection connection = DBConnection.connect();
            
            String query = "SELECT * from dmr_request WHERE request_status = 'false' ";
            
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            
            while(result.next()){
                
                RequestForm temp = new RequestForm();
                temp.setRequestId(result.getInt("requestId"));
                temp.setFirstName(result.getString("first_name"));
                temp.setLastName(result.getString("last_name"));
                temp.setAddress(result.getString("address"));
                temp.setNationalId(result.getString("national_id"));
                temp.setEmail(result.getString("email"));
                temp.setMobilenumber(result.getInt("mobile_number"));
                temp.setCebAccount(result.getInt("ceb_account"));
                temp.setAreaOffice(result.getString("area_office"));
                temp.setRequestDateTime(result.getString("request_dateTime"));
                temp.setRequestStatus(result.getString("request_status"));
                requestList.add(temp);
                
            }
            
        }
        catch(SQLException ex){
            System.out.println("GetRequestList method :"+ex);
        }
        return requestList;
    }
        
        public static RequestForm getRequestFormDetails(int requestId){
        
        
        RequestForm temp = new RequestForm();
        
        try{
            Connection connection = DBConnection.connect();
            
            String query = "SELECT * FROM dmr_request WHERE requestId = ?";
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, requestId);
            ResultSet result = statement.executeQuery();
            boolean hasResult = result.next();
            
            /*
                ResultSet may have one result so that resulted row is binded to temp
                 form object.
            */
            temp.setRequestId(result.getInt("requestId"));
            temp.setFirstName(result.getString("first_name"));
            temp.setLastName(result.getString("last_name"));
            temp.setAddress(result.getString("address"));
            temp.setNationalId(result.getString("national_id"));
            temp.setEmail(result.getString("email"));
            temp.setMobilenumber(result.getInt("mobile_number"));
            temp.setCebAccount(result.getInt("ceb_account"));
            temp.setAreaOffice(result.getString("area_office"));
            temp.setRequestDateTime(result.getString("request_dateTime"));
            temp.setRequestStatus(result.getString("request_status"));
            
        }
        catch(SQLException ex){
            System.out.println("Exception from getRequestFormDetails : "+ex);
        }
        return temp;
        
    }
        
    /*
    updateRequestFomrmStatus(requestId) is a method that changed dmr_request table's requestStatus value
    from false to true in corresponding user row where requested user is registered to the system. 
    requestStatus is indicated requests that are not registered or new requests.
 */
    public static boolean updateRequestFormStatus(int requestId){
        
        boolean flag = false;
        
        try{
            Connection connection = DBConnection.connect();
            String sql = "UPDATE dmr_request SET request_status = ? WHERE requestId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "true");
            statement.setInt(2, requestId);
            flag = statement.execute();
            
        }
        catch(SQLException ex){
            System.out.println("Exception from updateRequestFormStatus : "+ ex);
        }
        return flag;
    }
    
    public static boolean  addUserDMR(RequestForm form,String hashpw,int requestId){
        
        boolean isadd = false;
        
        try{
            Connection connection = DBConnection.connect();
            String sql = "INSERT INTO dmr_user(username,firstname,lastname,password,email,"
                    + "mobileNumber,address) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, form.getNationalId());
            statement.setString(2,form.getFirstName());
            statement.setString(3, form.getLastName());
            statement.setString(4,hashpw);
            statement.setString(5, form.getEmail());
            statement.setInt(6, form.getMobilenumber());
            statement.setString(7,form.getAddress());
            
            isadd = statement.execute();
            System.out.println("ISADDED : "+isadd);
            updateRequestFormStatus(requestId);
            addMeterDMR(form);
            
        }
        catch(SQLException ex){
            System.out.println("AddUserDMR exception :"+ex);
        }
        
        return isadd;
        
    }
    
    public static void addMeterDMR(RequestForm form){
        
        String issuedDateTime = GetLocalTimeDate.GetTimeDate();
        try{
            
            Connection connection = DBConnection.connect();
            String sql = "INSERT INTO dmr_meter(userId,requestDate,IssueDate) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,form.getNationalId());
            statement.setString(2,form.getRequestDateTime());
            statement.setString(3, issuedDateTime);
            statement.execute();
        }
        catch(SQLException ex){
            System.out.println("AddMeterDMR exception :"+ex);
        }
    }
        
}
