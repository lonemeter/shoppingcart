package com.lonemeter.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.AccountH2Data;

public class LoginController implements Controller {
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountH2Data user = new AccountH2Data();

		if(user.check(request.getParameter("name"),request.getParameter("password"))){
			request.getSession().setAttribute("loginUser", user.getLoginUser());
			response.sendRedirect("Home");
		}
		return new ModelAndView(viewPage);
	}
	
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}

}
