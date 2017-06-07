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

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class EmailService {
    
//    Create and set up Session for email sending
    public static Session getEmailSession(){
        
        final String senderEmail = "digitalmeterreader.project@gmail.com";
        final String password = "digitalmeterreader";
        
        Properties properties =  new Properties();
        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getDefaultInstance(properties, 
                new javax.mail.Authenticator() { 
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(senderEmail, password);
                }
        });
        
        return session;
    }
    
//    method for sending username and password to consumers
    public static void SendUsernamePassword(String userEmail, String username, char[] password){
        
        Session session = getEmailSession();
        final String sender = "digitalmeterreader.project@gmail.com";
        
        String pwStr = new String(password);
        
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            String subject = "DMR Registration";
            message.setSubject(subject);
            
            String msgBody ="<div style='text-align:left'>\n" +
                            "<h1 style='text-align:center'>Welcome to Digital meter reader</h1>\n" +
                            "<p style='font-size:20px;'>Thank you requesting digital meter reader\n" +
                            "Now you can use features and services.</p>\n" +
                            "<p style='font-size:20px;'>Following username and password are your login creditionals for DMR web site :-<br><br><b>"
                            +"Username :</b>"+username
                            +"<br><b>Password :</b>"+pwStr+"</p>\n" +
                            "<p style='font-size:18px;color:red'>*Please change your password as your prefered one</p>\n" +
                            "</div>";
            message.setContent(msgBody,"text/html");
            
            Transport.send(message);
            System.out.println("Email Sending Succesfully");
        }
                    
        catch(MessagingException ex)
        {
            System.out.println("EMAIL EXCEPTION : "+ ex);
        }
    }
}
