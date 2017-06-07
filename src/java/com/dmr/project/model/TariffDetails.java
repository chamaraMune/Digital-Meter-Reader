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
public class TariffDetails {

    double consumption;
    double energy_charge;
    double fixed_charge;
    int dimand_charge;
    
    public TariffDetails() {
    }

    public TariffDetails(double consumption, double energy_charge, double fixed_charge, int dimand_charge) {
        this.consumption = consumption;
        this.energy_charge = energy_charge;
        this.fixed_charge = fixed_charge;
        this.dimand_charge = dimand_charge;
    }
      public TariffDetails(double consumption, double energy_charge, double fixed_charge) {
        this.consumption = consumption;
        this.energy_charge = energy_charge;
        this.fixed_charge = fixed_charge;
     
    }
      
      public TariffDetails(double energy_charge,double fixed_charge, int dimand_charge) {
        this.energy_charge = energy_charge;
        this.fixed_charge = fixed_charge;
        this.dimand_charge = dimand_charge;
    }  

    public double getConsumption() {
        return consumption;
    }

    public int getDimand_charge() {
        return dimand_charge;
    }

    public double getEnergy_charge() {
        return energy_charge;
    }

    public double getFixed_charge() {
        return fixed_charge;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public void setDimand_charge(int dimand_charge) {
        this.dimand_charge = dimand_charge;
    }

    public void setEnergy_charge(double energy_charge) {
        this.energy_charge = energy_charge;
    }

    public void setFixed_charge(double fixed_charge) {
        this.fixed_charge = fixed_charge;
    }
    
    
    
}
