package com.lonemeter.shoppingcart.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.Account;
import com.lonemeter.shoppingcart.account.AccountH2Data;

public class ChangePasswordController implements Controller {
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Account user = (Account) request.getSession().getAttribute("loginUser");
		if(user.getPassword().equals(request.getParameter("oldpassword"))
				&& request.getParameter("newpassword1").equals(request.getParameter("newpassword2"))){
			try {
				user.changePassword(request.getParameter("newpassword1"));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			viewPage = "aleart-changepassword";
			return new ModelAndView(viewPage);
		}else{
			viewPage = "changepassword";
			return new ModelAndView(viewPage);
		}
		
	}

}
