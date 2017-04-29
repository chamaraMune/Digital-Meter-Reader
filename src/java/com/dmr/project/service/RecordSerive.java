/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chamara
 */
public class RecordSerive {
    
        public static void passwordBackup(String name,String passwd, String hashedpw){
        
        FileWriter fw= null ;
        BufferedWriter buffWriter = null;
        try{
            
            File file = new File("E://password.txt");
            System.out.println("File exist :"+file.exists());
            fw = new FileWriter(file,true);
            buffWriter = new BufferedWriter(fw);
            String str = String.format("{Name %s,password :%s ,hashedpassword :%s}",name,passwd,hashedpw);
            buffWriter.append(str);
            buffWriter.newLine();
            
        }
        catch(IOException ex){
            System.out.println("Exception : "+ ex);
        }
        finally{
            if(buffWriter != null){
                try {
                    buffWriter.close();
                } catch (IOException ex) {
                    System.out.println("Password backup Exception : "+ ex);
                }
            }
        }
    }
}
