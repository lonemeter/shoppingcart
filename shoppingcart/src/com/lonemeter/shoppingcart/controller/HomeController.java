package com.lonemeter.shoppingcart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lonemeter.shoppingcart.good.Goods;
import com.lonemeter.shoppingcart.other.Items;
import com.lonemeter.shoppingcart.other.Serch;

@Controller
public class HomeController {
	@Value("/WEB-INF/jsp/home.jsp")
	private String HOME_PATH;
	@Value("/WEB-INF/jsp/shoppingcart.jsp")
	private String SHOPPINGCART_PATH;
	@Value("home")
	private String REDIRECT_HOME_PATH;
	@Value("home?page=shoppingcart")
	private String REDIRECT_HOME_SHOPPINGCART_PATH;
	
	@GetMapping("home")
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String page = request.getParameter("page");
		String serch = Optional.ofNullable(request.getParameter("serch")).orElse("");
		Items items = new Items(page);
		if(!("shoppingcart".equals(page))){
			request.setAttribute("¤ÀÃþ", page);
			List<Goods> goods = items.goods; 
			if(serch!=""){
				request.setAttribute("goods", Serch.goodsSerch(goods,serch));
			}else{
				request.setAttribute("goods", goods);
			}
			request.getRequestDispatcher(HOME_PATH).forward(request, response);
		}else{
			double sum = 0;
			List<Goods> goods = new ArrayList<>();
			for(Goods good: items.goods){
				if(request.getSession().getAttribute(good.getEngname())!=null){
					goods.add(good);
					sum += good.getPrice();
				}
			}
			request.setAttribute("goods", goods);
			request.getSession().setAttribute("sum", sum);
			request.getRequestDispatcher(SHOPPINGCART_PATH).forward(request, response);
		}
	}
	
	@GetMapping("shoppingCartManagement")
	public void shoppingCartManagement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String product = request.getParameter("product");
		if(request.getParameter("remove")!=null){
			request.getSession().removeAttribute(product);
			response.sendRedirect(REDIRECT_HOME_SHOPPINGCART_PATH);
		}else{
			request.getSession().setAttribute(product, product);
			response.sendRedirect(REDIRECT_HOME_PATH);
		}	
	}
}
