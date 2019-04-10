package com.lonemeter.shoppingcart.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.Account;
import com.lonemeter.shoppingcart.account.AccountH2Data;

public class StoreController implements Controller {
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getParameter("storemoney")!=null) {
			Account user = (Account) request.getSession().getAttribute("loginUser");
			try {
				user.store(Double.parseDouble(request.getParameter("storemoney")));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Home?page=shoppingcart");
		}
		
		return new ModelAndView(viewPage);		
	}
	
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
}
