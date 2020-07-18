package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.LoginDAO;
import com.DAO.LoginDAOImpl;
import com.entity.Login;



public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LoginDAO loginDAO = null;
	
	
    public LoginController() {
        loginDAO = new LoginDAOImpl();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Login login = new Login();
		
		login.setEmail(request.getParameter("email"));
		login.setPassword(request.getParameter("password"));
		
//		System.out.println("Email - "+email + " password - " +password);
		
		String status = loginDAO.authenticate(login);
		
		if(status.equals("right")){
			
			 session.setAttribute("email", login.getEmail());
			 
			 response.sendRedirect("Controller?action=LIST");  
		
		}else if(status.equals("wrong")){
		
			response.sendRedirect("index.jsp?status=wrong");  
		
		}else{
			response.sendRedirect("index.jsp?status=error");
			
		}
		
		
	}

	
}
