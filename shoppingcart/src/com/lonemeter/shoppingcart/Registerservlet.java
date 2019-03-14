package com.lonemeter.shoppingcart;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lonemeter.shoppingcart.account.Account;
import com.lonemeter.shoppingcart.account.Accounth2data;

/**
 * Servlet implementation class Register
 */
@WebServlet("/registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Accounth2data data = new Accounth2data();
		if(request.getParameter("password1").equals(request.getParameter("password2"))
				&& data.register(request.getParameter("name"), request.getParameter("password1"))){
			request.getRequestDispatcher("WEB-INF/aleart-register.jsp").forward(request, response);
			//response.sendRedirect("WEB-INF/login");
		}else{
			request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
		}
		
	}

}
