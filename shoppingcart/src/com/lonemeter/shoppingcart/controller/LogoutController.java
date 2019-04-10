package com.lonemeter.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.AccountH2Data;

public class LogoutController implements Controller {
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		request.getSession();
		response.sendRedirect("Home");
		return new ModelAndView(viewPage);
	}
	
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}

}
