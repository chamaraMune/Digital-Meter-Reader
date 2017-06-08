/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.controller;

import com.dmr.project.dao.TariffMethod;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dmr.project.dao.Units;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.dmr.project.service.GetDoubleValue;
import java.util.Date;

/**
 *
 * @author chamara
 */
public class CurrentUsageServlet extends HttpServlet {

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
            int meterId = 0;
            double units = 0;
            double bill = 0;
            Date date = null;
            String category = null;
            String sessionId = null;
            HttpSession session = request.getSession(true);
            sessionId = (String)session.getAttribute("loggedUsername");// create session and get session atribute
            Units unitObject = new Units();// create units object and using getMeter method get meterId for loged user 
            meterId = unitObject.getMeter(sessionId);
            ResultSet rs = unitObject.getUserUnits(meterId);// using meter id get category and current consumption
            
            while(rs.next()){// get current consumption units and category and calculate bill 
                units = rs.getDouble("consumption_unit");
                category = rs.getString("category");
                date = rs.getDate("time");
                double bill1 = new TariffMethod().selectMethod(units, category);
                bill = new GetDoubleValue().getValue(bill1);
            }
            
            response.setContentType("text/html;charset=UTF-8");//get attribute and dispatch to the jsp
            request.setAttribute("units", units);
            request.setAttribute("bill", bill);
            request.setAttribute("date", date);
            RequestDispatcher rd = request.getRequestDispatcher("/userCurrentUsage.jsp");
            rd.include(request, response);
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
            Logger.getLogger(CurrentUsageServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CurrentUsageServlet.class.getName()).log(Level.SEVERE, null, ex);
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
