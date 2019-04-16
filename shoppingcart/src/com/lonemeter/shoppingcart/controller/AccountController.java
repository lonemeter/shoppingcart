package com.lonemeter.shoppingcart.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lonemeter.shoppingcart.account.Account;
import com.lonemeter.shoppingcart.account.AccountH2Data;

@Controller
public class AccountController {
	@Value("home")
	private String REDIRECT_HOME_PATH;
	@Value("home?page=shoppingcart")
	private String REDIRECT_HOME_SHOPPINGCART_PATH;
	@Value("WEB-INF/jsp/login.jsp")
	private String LOGIN_PATH;
	@Value("WEB-INF/jsp/register.jsp")
	private String REGISTER_PATH;
	@Value("WEB-INF/jsp/aleart-register.jsp")
	private String ALEART_REGISTER_PATH;
	@Value("WEB-INF/jsp/changepassword.jsp")
	private String CHANGEPASSWORD_PATH;
	@Value("WEB-INF/jsp/aleart-changepassword.jsp")
	private String ALEART_CHANGEPASSWORD_PATH;
	@Value("WEB-INF/jsp/store.jsp")
	private String STORE_PATH;
	@Value("questionnaire")
	private String REDIRECT_QUESTIONNAIRE_PATH;
	
	@GetMapping("login")
	public void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
	}
	
	@PostMapping("login")
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountH2Data user = new AccountH2Data();
		if(user.check(request.getParameter("name"),request.getParameter("password"))){
			request.getSession().setAttribute("loginUser", user.getLoginUser());
			response.sendRedirect(REDIRECT_HOME_PATH);
		}
		else{
			request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
		}
	}
	
	@GetMapping("logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(REDIRECT_HOME_PATH);
	}
	
	@GetMapping("register")
	public void registerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(REGISTER_PATH).forward(request, response);
	}
	
	@PostMapping("register")
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountH2Data data = new AccountH2Data();
		if(request.getParameter("password1").equals(request.getParameter("password2"))
				&& data.register(request.getParameter("name"), request.getParameter("password1"))){
			request.getRequestDispatcher(ALEART_REGISTER_PATH).forward(request, response);
		}else{
			request.getRequestDispatcher(REGISTER_PATH).forward(request, response);
		}
	}
	
	@GetMapping("changePassword")
	public void changepasswordForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(CHANGEPASSWORD_PATH).forward(request, response);
	}
	
	@PostMapping("changePassword")
	public void changepassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = (Account) request.getSession().getAttribute("loginUser");
		if(request.getParameter("oldPassword").equals(user.getPassword()) 
				&& request.getParameter("newPassword1").equals(request.getParameter("newPassword2"))){
			try {
				user.changePassword(request.getParameter("newPassword1"));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher(ALEART_CHANGEPASSWORD_PATH).forward(request, response);
		}else{
			request.getRequestDispatcher(CHANGEPASSWORD_PATH).forward(request, response);
		}
	}
	
	@GetMapping("store")
	public void storeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(STORE_PATH).forward(request, response);
	}
	
	@PostMapping("store")
	public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account user = (Account) request.getSession().getAttribute("loginUser");
		try {
			user.store(Double.parseDouble(request.getParameter("storemoney")));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(REDIRECT_HOME_SHOPPINGCART_PATH);
	}
	
	@GetMapping("consume")
	public void Consume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account loginUser = (Account) request.getSession().getAttribute("loginUser");
		try {
			loginUser.consume((double) request.getSession().getAttribute("sum"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().invalidate();
		request.getSession().setAttribute("loginUser", loginUser);
		response.sendRedirect(REDIRECT_QUESTIONNAIRE_PATH);
	}
}
