package com.lonemeter.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.AccountH2Data;

public class RegisterController implements Controller {
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AccountH2Data data = new AccountH2Data();
		if(request.getParameter("password1") != null
				&& request.getParameter("password1").equals(request.getParameter("password2"))
				&& data.register(request.getParameter("name"), request.getParameter("password1"))){
			viewPage = "aleart-register";
			return new ModelAndView(viewPage);
		}else{
			viewPage = "register";
			return new ModelAndView(viewPage);
		}
		
	}
	

}
