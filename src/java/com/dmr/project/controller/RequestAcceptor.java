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
import com.dmr.project.service.RandomPassowrd;
import com.dmr.project.model.RequestForm;
import com.dmr.project.model.User;
import com.dmr.project.dao.AdminHomeDao;
import javax.servlet.RequestDispatcher;
import com.dmr.project.service.PasswordHashingService;
import com.dmr.project.dao.RequestFormDao;
import com.dmr.project.service.EmailService;


/**
 *
 * @author chamara
 */
public class RequestAcceptor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        
        /* Requested object data binded as correspoing request id*/
        RequestForm form = RequestFormDao.getRequestFormDetails(requestId);
        
        /*
            Password sholud be randomly generated. so RandomPasswordGenerator
            class method is used for that. The generated password and username
            send to requested user via email.
        */
        String username = form.getNationalId();
        char[] pwArr = RandomPassowrd.getPassword();
        /*
            Generated password encrpted as SHA-256 hash function
        */
        String hashedpw = PasswordHashingService.getHashedPassword(pwArr);
        
        /*This is only until login is completed */
//        com.dmr.project.service.RecordSerive.passwordBackup(form.getFirstName(), new String(pwArr), hashedpw);
        
        /* After the request was accepted user will added to system. */
        boolean isadd = RequestFormDao.addUserDMR(form, hashedpw,requestId);
        
        // userEmail variable are stored requested user's email for sending password and username.
        String userEmail = form.getEmail();
        int userMobile = form.getMobilenumber();
//        System.out.println("IS ADD VARIABLE :"+isadd);
        
        /* Email sending method is called here */
        EmailService.SendUsernamePassword(userEmail, username, pwArr);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("AdminDMRRequest");
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
