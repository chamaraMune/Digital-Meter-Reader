/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.model;

/**
 *
 * @author root
 */
public class UnitsDetails {
    
    public int meterId;
    public double units;
    public double reading;
    public int readingId;
    public String category;

    public UnitsDetails(int meterId, double units,String category) {
        this.meterId = meterId;
        this.units = units;
        this.category = category;
    }

    public int getMeterId() {
        return meterId;
    }

    public double getUnits() {
        return units;
    }

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
}
