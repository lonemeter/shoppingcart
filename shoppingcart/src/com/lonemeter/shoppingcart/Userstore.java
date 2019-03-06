package com.lonemeter.shoppingcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userstore
 */
@WebServlet("/userstore")
public class Userstore extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = (Account) request.getSession().getAttribute("login");
		user.Store(Double.parseDouble(request.getParameter("storemoney")));
		response.sendRedirect("home?page=shoppingcart");
	}

}
