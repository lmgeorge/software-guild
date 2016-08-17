package com.swcguild.contactlistservlet.controller;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.swcguild.contactlistservlet.dao.ContactListDao;
import com.swcguild.contactlistservlet.dao.DaoFactory;
import com.swcguild.contactlistservlet.model.Contact;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
@WebServlet(name="AddServlet", urlPatterns={"/AddServlet"})

public class AddServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */ 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
			request
				.getRequestDispatcher("addForm.jsp")
				.forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

				
				//create strings to get all parameters
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String company = request.getParameter("company");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				
				// create new Contact object
				Contact contact = new Contact();
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setCompany(company);
				contact.setPhone(phone);
				contact.setEmail(email);
				
				
				ContactListDao dao = DaoFactory.getDao();
				dao.addContact(contact);
				
				
				
				
				response.sendRedirect("DisplayServlet");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
