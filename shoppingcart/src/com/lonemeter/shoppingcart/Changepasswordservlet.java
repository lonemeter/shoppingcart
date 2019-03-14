package com.lonemeter.shoppingcart;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lonemeter.shoppingcart.account.Account;

/**
 * Servlet implementation class changepassword
 */
@WebServlet("/changepasswordservlet")
public class Changepasswordservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/changepassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = (Account) request.getSession().getAttribute("login");
		if(request.getParameter("oldpassword").equals(user.getPassword()) 
				&& request.getParameter("newpassword1").equals(request.getParameter("newpassword2"))){
			try {
				user.Changepassword(request.getParameter("newpassword1"));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("WEB-INF/aleart-changepassword.jsp").forward(request, response);
			//response.sendRedirect("home");
		}else{
			request.getRequestDispatcher("WEB-INF/changepassword.jsp").forward(request, response);
		}
		
	}

}
