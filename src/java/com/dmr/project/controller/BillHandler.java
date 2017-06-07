/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.controller;

import com.dmr.project.dao.Units;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dmr.project.model.UnitsDetails;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.dmr.project.service.GetLocalTimeDate;
import com.dmr.project.dao.TariffMethod;
import com.dmr.project.model.TariffDetails;
import com.dmr.project.service.CalculateBill;
import com.dmr.project.dao.EbillDao;
import java.text.DecimalFormat;
import com.dmr.project.service.GetDoubleValue;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author root
 */
public class BillHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        GetLocalTimeDate date = new GetLocalTimeDate();
        String dateTime = date.GetTimeDate();
        String category; 
        int id;
        double unit;
        double bill;
        ArrayList<TariffDetails> table;
        ArrayList<Double> billList = null;
        Units unitsObject = new Units();
        TariffMethod methodObject = new TariffMethod();
        CalculateBill billObject = new CalculateBill();
           
        ArrayList<UnitsDetails> unitList = unitsObject.getUnits();// get meter list with units and category
        
//        for(int i=0; i<unitList.size(); i++){// get category and current units and call bill calculate function
//            category = unitList.get(i).getCategory();
//            unit = unitList.get(i).getUnits();
//            id = unitList.get(i).getMeterId();
//            double billvalue = new TariffMethod().selectMethod(unit,category);
//            double allbill = new  EbillDao().returen_bill(id, billvalue);
//        }
       
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BillHandler</title>");            
            out.println("</head>");
            out.println("<body>");            
            out.println("<h1>date and time "+dateTime+"  "+"</h1>");
            Timer timer = new Timer();
           // timer.schedule(tt, date);
            for(int i=0; i<unitList.size(); i++){// get category and current units and call bill calculate function
                category = unitList.get(i).getCategory();
                unit = unitList.get(i).getUnits();
                id = unitList.get(i).getMeterId();
                double billvalue = new TariffMethod().selectMethod(unit,category);
                double billValue = new GetDoubleValue().getValue(billvalue);
                double allbill = new  EbillDao().returen_bill(id, billValue);
                double allbillValue = new GetDoubleValue().getValue(allbill);
                out.println("<h1>bill category "+category+" units  "+unit+" id  "+id+"</h1>");
                out.println("<h1>bill values "+billValue+"  "+allbillValue+"</h1>");
            }            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BillHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
