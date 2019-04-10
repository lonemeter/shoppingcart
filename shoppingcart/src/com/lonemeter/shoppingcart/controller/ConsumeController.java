package com.lonemeter.shoppingcart.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.Account;
import com.lonemeter.shoppingcart.account.AccountH2Data;

public class ConsumeController implements Controller {
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Account loginUser = (Account)request.getSession().getAttribute("loginUser");
		try {
			loginUser.consume((double)request.getSession().getAttribute("sum"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().invalidate();
		request.getSession().setAttribute("loginUser", loginUser);
		response.sendRedirect("Questionnaire");
		
		viewPage = "home";
		return new ModelAndView(viewPage);		
	}
}