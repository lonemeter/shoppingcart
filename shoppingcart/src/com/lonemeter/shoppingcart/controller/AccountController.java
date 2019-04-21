package com.lonemeter.shoppingcart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lonemeter.shoppingcart.account.AccountDAO;
import com.lonemeter.shoppingcart.account.AccountInfo;
import com.lonemeter.shoppingcart.good.Goods;
import com.lonemeter.shoppingcart.other.Order;

@Controller
public class AccountController {
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	List<Goods> goods;
	private List<Order> orders;
	
	@GetMapping("login")
	public String loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "login";
	}
	
	@PostMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(accountDAO.check(name,password)){
			request.changeSessionId();
			AccountInfo loginUser = new AccountInfo(name, password, accountDAO.getLoginUserMoney(name, password));
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:home";
		}
		else{
			return "login";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		return "redirect:home";
	}
	
	@GetMapping("register")
	public String registerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "register";
	}
	
	@PostMapping("register")
	public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("password1").equals(request.getParameter("password2"))
				&& accountDAO.register(request.getParameter("name"), request.getParameter("password1"))){
			return "aleart-register";
		}else{
			return "register";
		}
	}
	
	@GetMapping("changePassword")
	public String changepasswordForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "changepassword";
	}
	
	@PostMapping("changePassword")
	public String changepassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountInfo loginUser = (AccountInfo) request.getSession().getAttribute("loginUser");
		if(request.getParameter("oldPassword").equals(loginUser.getPassword()) 
				&& request.getParameter("newPassword1").equals(request.getParameter("newPassword2"))){
			try {
				accountDAO.changePassword(loginUser.getName(), loginUser.getPassword(), request.getParameter("newPassword1"));
				loginUser.changePassword(request.getParameter("newPassword1"));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			return "aleart-changepassword";
		}else{
			return "changepassword";
		}
	}
	
	@GetMapping("store")
	public String storeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "store";
	}
	
	@PostMapping("store")
	public String store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountInfo loginUser = (AccountInfo) request.getSession().getAttribute("loginUser");
		try {
			accountDAO.store(loginUser.getName(), loginUser.getMoney(), Double.parseDouble(request.getParameter("storemoney")));
			loginUser.store(Double.parseDouble(request.getParameter("storemoney")));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:home?page=shoppingcart";
	}
	
	@GetMapping("consume")
	public String Consume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountInfo loginUser = (AccountInfo) request.getSession().getAttribute("loginUser");
		try {
			accountDAO.consume(loginUser.getName(), loginUser.getMoney(), (double) request.getSession().getAttribute("sum"));
			loginUser.consum((double) request.getSession().getAttribute("sum"));
			
			//新增orders
			accountDAO.addOrders(loginUser.getName());
			//加入oders資料
			for(Goods good: goods){
				if(request.getSession().getAttribute(good.getEngname())!=null){
					accountDAO.addOrdersINFO(loginUser.getName(), good);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().invalidate();
		request.getSession().setAttribute("loginUser", loginUser);
		return "redirect:questionnaire";
	}
}
