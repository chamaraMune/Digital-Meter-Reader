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
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.nio.charset.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PasswordHashingService {
    
    public static String getHashedPassword(char[] pwArr){
        String hashedpw = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            StringBuilder sb = new StringBuilder();
            String pwString = sb.append(pwArr).toString();
            md.update(pwString.getBytes("UTF-8"));
            byte[] digest = md.digest();
            hashedpw = String.format("%064x", new java.math.BigInteger(1, digest));
            System.out.println("Hashed pw : "+ hashedpw);
            System.out.println("Hashed pw length: "+ hashedpw.length());
        } 
        catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("getHashedPassword EXCEption : "+ ex);
        }
        
        return hashedpw;
    }
    
}
