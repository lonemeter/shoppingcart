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
 * Servlet implementation class Consumeservlet
 */
@WebServlet("/consumeservlet")
public class Consumeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account loginuser = (Account)request.getSession().getAttribute("login");
		try {
			loginuser.Consume((double)request.getSession().getAttribute("sum"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().invalidate();
		request.getSession().setAttribute("login", loginuser);
		response.sendRedirect("questionnaire");
	}

	

}
