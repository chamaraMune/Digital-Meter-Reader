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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dmr.project.service.SendSmsServices;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author root
 */
public class Notificationpage extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
//        GetRedBill billList = new GetRedBill();
//        ArrayList<RedBill> rs;
//        rs = billList.getbill();
        
//             for(int i=0; i<rs.size();i++){
//                int meter_id = rs.get(i).getMeter_id();
//                double last_bill = rs.get(i).getLast_bill();
//                double current_bill = rs.get(i).getCurrent_bill();
//                double bill = last_bill - current_bill;
//                String date = "2017-08-04";
//                int temp = billList.getPhoneNo(meter_id);
//                String number = "94"+Integer.toString(temp);
//                String message = "Pay "+Double.toString(bill)+" befor 2017-08-04";
//                SendSmsServices service = new SendSmsServices();
//                //service.sendSms(message, number);
//                
//            }
                RequestDispatcher rd = request.getRequestDispatcher("/notifications2.jsp");
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
