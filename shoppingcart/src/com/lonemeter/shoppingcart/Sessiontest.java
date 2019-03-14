package com.lonemeter.shoppingcart;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lonemeter.shoppingcart.account.Account;

/**
 * Servlet implementation class sessiontest
 */
@WebServlet("/sessiontest")
public class Sessiontest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String 加入購物單 = request.getParameter("ses");
		if(request.getParameter("clc")!=null){
			//request.getRequestDispatcher("consumeservlet").forward(request, response);
			response.sendRedirect("consumeservlet");
		}else{
			if(request.getParameter("sell")!=null){
				request.getSession().removeAttribute(加入購物單);
				response.sendRedirect("home?page=shoppingcart");
			}else{
				request.getSession().setAttribute(加入購物單, 加入購物單);
				response.sendRedirect("home");
			}
		}
	}
}
