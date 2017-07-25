/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmr.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dmr.project.service.SendSmsServices;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;
import com.dmr.project.dao.SendSMS;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


/**
 *
 * @author root
 */
public class SMSHandler extends HttpServlet {

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
        
        SendSmsServices service = new SendSmsServices();
        
        
       
        
        
       String[] area_list =null;
       String[] location_list = null;
       String message = null;
        area_list = request.getParameterValues("area_list[]");
       // location_list = request.getParameterValues("transformer_list[]");
        message = request.getParameter("message");
         //service.sendSms(area_list, "94702122494");
        
//        try{
//        
//             area = request.getParameter("area");
//             location = request.getParameter("location");
//             message = request.getParameter("message");
//             String sms = area+location+message;
//             
//             service.sendSms(area,"94702122494");
//            
//        }
       
        //SendSMS send = new SendSMS();// get numbers list from database
       //ArrayList<Integer> numbers = send.getNumbers(area,location);
//       
//         try (PrintWriter out = response.getWriter()) {
//           
//            int count = 0;
//             for(int i=0; i<numbers.size();i++){//numbers convert to string and call sendSms funtion for send message
//                int temp = numbers.get(i);
//                String num = "94"+Integer.toString(temp);
//                sendsms.sendSms(message, num);
//                count++;
//                }
//             if(count==0){// if there are no numbers to send then display message
//                 JOptionPane.showMessageDialog(null, "not sended");
//                 response.setContentType("text/html;charset=UTF-8");
//                 RequestDispatcher rd = request.getRequestDispatcher("/SendNewsPage");
//                 rd.include(request, response);
//                 
//             }else{//after send the message redirect to same page
//                 JOptionPane.showMessageDialog(null, "Message send successfuly");
//                 response.setContentType("text/html;charset=UTF-8");
//                 RequestDispatcher rd = request.getRequestDispatcher("/SendNewsPage");
//                 rd.include(request, response);
//            }
//                         
//        }
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SMSHandler</title>");            
            out.println("</head>");
            out.println("<body>");
            for(int i=0; i<area_list.length; i++){
            out.println("<h1>Servlet SMSHandler at qqq"+area_list[i]+"</h1>");
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
