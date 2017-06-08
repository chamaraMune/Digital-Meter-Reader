/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author chamara
 */
public class MeterReading {
    private String date;
    private double amphere;
    private double voltage;
    private double unit;
    private int meterId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMeterId() {
        return meterId;
    }

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }

    public String getTimeStamp() {
        return date;
    }

    public void setTimeStamp(String timeStamp) {
        this.date = timeStamp;
    }

    public double getAmphere() {
        return amphere;
    }

    public void setAmphere(double amphere) {
        this.amphere = amphere;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }
    
    public void setUnit(double voltage, double amphere){
        
        
        DecimalFormat format = new DecimalFormat("#.####");
        format.setRoundingMode(RoundingMode.CEILING);
        double formula = (voltage * amphere) / 1000;
        unit = Double.valueOf(format.format(formula));
    }
    
    
    
}
