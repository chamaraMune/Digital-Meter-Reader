/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author root
 */
public class SendSmsServices {
        
            public String sendSms(String massage, String no) {
		try {
			// Construct data
			String user = "username=" + "sudesh.kapugamage25@gmail.com";
			String hash = "&hash=" + "25b47ed8a0641aaad9ff8bdc33e9078c56a5e362425d7bb52d463ce1cc6df8cb ";
			String message = "&message=" + massage;
			String sender = "&sender=" + "dmr";
			String numbers = "&numbers=" + no;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.txtlocal.com/send/?").openConnection();
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
    
}
