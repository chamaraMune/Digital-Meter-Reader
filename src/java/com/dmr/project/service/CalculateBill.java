/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.service;
import com.dmr.project.model.TariffDetails;
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class CalculateBill {
    double bill = 0;
    double units;
    double fixed_charge1;
    double fixed_charge2;
    double dimand_charge;
    double charge1;
    double charge2;
    double consumption1;
    double temp;
    double last;
    
    String category;
    ArrayList<TariffDetails> table;

    
    public double domestic1Bill(double units, ArrayList<TariffDetails> table){
        temp = 0;
        last = 0;
        this.units = units;
        this.table = table;
        
        if(units <= table.get(0).getConsumption()){
        
             charge1 = table.get(0).getEnergy_charge();
             fixed_charge1 = table.get(0).getFixed_charge();
             temp = charge1*units + fixed_charge1 + dimand_charge;
        
        }else{
            consumption1 = table.get(0).getConsumption();
            charge1 = table.get(0).getEnergy_charge();
            charge2 = table.get(1).getEnergy_charge();
            fixed_charge1 = table.get(0).getFixed_charge();
            fixed_charge2 = table.get(1).getFixed_charge();
            temp =fixed_charge1 + fixed_charge2 + charge1*consumption1 + charge2*(units-consumption1);
        
        }
        
        return temp;
    }
    
    public double domestic2Bill(double units, ArrayList<TariffDetails> table){
        temp = 0;
        last = 0;
        this.units = units;
        this.table = table;
        int j = 0;
        double range = 0;
        for(double i=units; i>0; i-=range){
            consumption1 = table.get(j).getConsumption();
            range = consumption1 - last;
            if((i>=(range)) && (consumption1 <= 180)){
                temp += (range)*table.get(j).getEnergy_charge() + table.get(j).getFixed_charge();
                last = consumption1;
            }else if((i< (range)) || (consumption1 > 180)){
                temp += (i*table.get(j).getEnergy_charge() + table.get(j).getFixed_charge());
                range = i;
            }
            j++;
        }
        return temp;
    }
    
    public double hotelBill(double units, ArrayList<TariffDetails> table){
        
        this.table = table;
        this.units = units;
        
        bill = (units*table.get(0).getEnergy_charge()) + table.get(0).getFixed_charge() + table.get(0).getDimand_charge();
        
        return bill;
    }
    
    public double industrialBill(double units, ArrayList<TariffDetails> table){
        
        this.table = table;
        this.units = units;
        
        if(units <= table.get(0).getConsumption()){
        
            bill = (units*table.get(0).getEnergy_charge()) + table.get(0).getFixed_charge();
        
        }else{
        
            bill =(table.get(0).getConsumption()*table.get(0).getEnergy_charge()) +((units - table.get(0).getConsumption()) * table.get(1).getEnergy_charge())+table.get(1).getFixed_charge();
        
        }
        
        return bill;
    }
    
    
}
