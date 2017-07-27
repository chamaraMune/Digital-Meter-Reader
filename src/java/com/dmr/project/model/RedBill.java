/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.model;

import java.util.Date;

/**
 *
 * @author root
 */
public class RedBill {
    private int meter_id;
    private double last_bill;
    private double current_bill;
    private Date date;
    private int number;

    public RedBill(int meter_id, double last_bill, double current_bill, Date date) {
        this.meter_id = meter_id;
        this.last_bill = last_bill;
        this.current_bill = current_bill;
        this.date = date;
    }

    public RedBill(int meter_id, double last_bill, double current_bill, Date date, int number) {
        this.meter_id = meter_id;
        this.last_bill = last_bill;
        this.current_bill = current_bill;
        this.date = date;
        this.number = number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
    
    

    public double getCurrent_bill() {
        return current_bill;
    }

    public Date getDate() {
        return date;
    }

    public double getLast_bill() {
        return last_bill;
    }

    public int getMeter_id() {
        return meter_id;
    }

    public void setCurrent_bill(double current_bill) {
        this.current_bill = current_bill;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLast_bill(double last_bill) {
        this.last_bill = last_bill;
    }

    public void setMeter_id(int meter_id) {
        this.meter_id = meter_id;
    }
    
    
}
