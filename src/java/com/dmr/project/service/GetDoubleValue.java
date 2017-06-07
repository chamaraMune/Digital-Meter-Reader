/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.service;

import java.text.DecimalFormat;

/**
 *
 * @author root
 */
public class GetDoubleValue {
    
   
    public double getValue(double value){
        DecimalFormat formatter = new DecimalFormat("#0.00");
        double value2 = value;
        String stringValue = formatter.format(value2);
        double double_value = Double.parseDouble(stringValue);
        return double_value;
    }
        
}
