package com.lonemeter.shoppingcart;


import java.io.IOException;
import java.io.PrintWriter;
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
		String �[�J�ʪ��� = request.getParameter("ses");
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("login")==null){
			//out.println("alert('�еn�J')");
			response.sendRedirect("login");
		}else{
			if(request.getParameter("clc")!=null){
				Account loginuser = (Account)request.getSession().getAttribute("login");
				loginuser.Consume((double)request.getSession().getAttribute("sum"));
				request.getSession().invalidate();
				request.getSession().setAttribute("login", loginuser);
				response.sendRedirect("questionnaire");
			}else{
				if(request.getParameter("sell")!=null){
					request.getSession().removeAttribute(�[�J�ʪ���);
					response.sendRedirect("home?page=shoppingcart");
				}else{
					request.getSession().setAttribute(�[�J�ʪ���, �[�J�ʪ���);
					response.sendRedirect("home");
				}
			}
		}
	}
}
