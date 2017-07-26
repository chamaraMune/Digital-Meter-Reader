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
public class TransformerDetails {

    private int transforerId;
    private String area;
    private String location;

    public TransformerDetails(int transforerId, String area, String location) {
        this.transforerId = transforerId;
        this.area = area;
        this.location = location;
    }

    public TransformerDetails(String location) {
    
        this.location = location;
        
    }

    public TransformerDetails() {
    
    }
    
    
    

    public String getArea() {
        return area;
    }

    public String getLocation() {
        return location;
    }

    public int getTransforerId() {
        return transforerId;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTransforerId(int transforerId) {
        this.transforerId = transforerId;
    }
    
    
    
}
