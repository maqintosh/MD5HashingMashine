package com.hash.doHash;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateusz Cieśliński
 */
@WebServlet(name = "Hashing", urlPatterns = {"/DoHash.do"})
public class DoHash extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.security.NoSuchAlgorithmException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
           String data = request.getParameter("dataForHash");
           String hash = this.hash(data);
           request.setAttribute("md5hash", hash);
           request.getRequestDispatcher("/result.jsp").forward(request, response);
           
           
        }
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DoHash.class.getName()).log(Level.SEVERE, null, ex);
        }            finally{out.close();}

    }

  private String hash(String data) throws NoSuchAlgorithmException, ServletException{
           try{
           MessageDigest message = MessageDigest.getInstance("MD5");
           byte[] bufor = data.getBytes();
           message.update(bufor,0,bufor.length);
           BigInteger hash = new BigInteger(1,message.digest());
           return String.format("%1$032X", hash);
           } 
           
           catch(NoSuchAlgorithmException n){
           throw new ServletException("Algorithm is available :X");
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
