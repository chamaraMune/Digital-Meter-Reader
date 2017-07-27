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
import com.dmr.project.service.PasswordHashingService;
import javax.servlet.http.HttpSession;
import com.dmr.project.dao.EditUserProfileDAO;
import com.dmr.project.model.User;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author chamara
 */
public class UpdateUserProfile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        /* Access session attributes */
        HttpSession session = request.getSession();
        String loggedUsername = (String) session.getAttribute("loggedUsername");
//        System.out.println("Logged Username : "+ loggedUsername);
        
        /* Edit user profile values extracted */
        String firsname = request.getParameter("new_firstname");
        String lastname = request.getParameter("new_lastname");
        String email = request.getParameter("new_email");
        int mobilenumber = Integer.parseInt(request.getParameter("new_mobilenumber"));
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
//        System.out.println(firsname+" "+lastname+" "+email+" "+mobilenumber+" "+oldPassword+" "+newPassword);
        
        // to check whether old password is correctly inserted
        boolean flag = false;
        char[] oldPasswordArr = oldPassword.toCharArray();
        String hashedOldPassword = PasswordHashingService.getHashedPassword(oldPasswordArr);
        
        char[] newPasswordArr = newPassword.toCharArray();
        String hashedNewPassword = PasswordHashingService.getHashedPassword(newPasswordArr);
        
        String originalhasedpassword = EditUserProfileDAO.passwordChecking(loggedUsername);
//        System.out.println("Original hased password : "+ originalhasedpassword);

        if(originalhasedpassword.equalsIgnoreCase(hashedOldPassword)){
            System.err.println("Updating started");
            User usr = new User();
            usr.setUsername((String)session.getAttribute("loggedUsername"));
            System.out.println("Getting User name to update: " + (String)session.getAttribute("loggedUsername"));
            usr.setFirstname(firsname);
            usr.setLastname(lastname);
            usr.setEmail(email);
            usr.setMobileNo(mobilenumber);
            usr.setPassword(hashedNewPassword);
            // Calling DAO to update profile
            boolean isUpdated = EditUserProfileDAO.updateProfile(usr);
            if(isUpdated){
                System.out.println("Update Successful!");
                request.setAttribute("updateStatues", "sucess");
                RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
                rd.include(request, response);
            }
            else{
                System.out.println("Update Failed!");
                request.setAttribute("updateStatues", "fail");
            }
            
        }
        else{
            flag = true;
            request.setAttribute("pwdStautes", flag);
//            response.sendRedirect("EditProfileLoading");
            RequestDispatcher rd = request.getRequestDispatcher("EditProfileLoading");
            rd.include(request, response);
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
