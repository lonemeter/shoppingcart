package com.lonemeter.shoppingcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Accounth2date user = new Accounth2date();
		if(user.check(request.getParameter("name"),request.getParameter("password"))){
			request.getSession().setAttribute("login", user.getLoginuser());
			response.sendRedirect("home");
		}
		/*if(request.getParameter("name").equals("meter")&&request.getParameter("password").equals("123456")){
			request.getSession().setAttribute("login", request.getParameter("name"));
			response.sendRedirect("home");
		}*/else{
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
	}

}
