package com.lonemeter.shoppingcart.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.Account;

public class ShoppingCartManagementController implements Controller{
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String product = request.getParameter("product");
		
		if(request.getParameter("remove")!=null){
			request.getSession().removeAttribute(product);
			response.sendRedirect("Home?page=shoppingcart");
			
		}else{
			request.getSession().setAttribute(product, product);
			response.sendRedirect("Home");
		}
		
		return new ModelAndView(viewPage);		
	}
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
}