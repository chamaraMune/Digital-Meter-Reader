/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.controller;

import com.dmr.project.dao.GetRedBill;
import com.dmr.project.model.RedBill;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author root
 */
public class NotificationPage extends HttpServlet {

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
            throws ServletException, IOException {
        GetRedBill billList = new GetRedBill();
        ArrayList<RedBill> rs;
        rs = billList.getbill();
        
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NotificationPage</title>");            
//            out.println("</head>");
//            out.println("<body>");
//           // out.println("<h1>Servlet NotificationPage at " + rs + "</h1>");
//            for(int i=0; i<rs.size();i++){
//                int meter_id = rs.get(i).getMeter_id();
//                double last_bill = rs.get(i).getLast_bill();
//                double current_bill = rs.get(i).getCurrent_bill();
//                Date date = rs.get(i).getDate();
//                Calendar c = Calendar.getInstance();
//                String date2 = "2017-08-04";
//                out.println("<h1>Servlet NotificationPage at " +meter_id+"  "+last_bill+"  "+current_bill+ "  " +date+"  "+ date2+"</h1>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//        }
    request.setAttribute("rs", rs);
    RequestDispatcher rd = request.getRequestDispatcher("/notifications.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
