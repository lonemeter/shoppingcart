package com.lonemeter.shoppingcart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lonemeter.shoppingcart.good.Goods;
import com.lonemeter.shoppingcart.other.Order;
import com.lonemeter.shoppingcart.other.OrderDAO;
import com.lonemeter.shoppingcart.other.Serch;

@Controller
public class HomeController {
	
	@Autowired
	List<Goods> goods;
	
	@GetMapping("home")
	public String home(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) throws ServletException, IOException{
		String page = request.getParameter("page");
		String serch = Optional.ofNullable(request.getParameter("serch")).orElse("");
		if(!("shoppingcart".equals(page))){
			request.setAttribute("¤ÀÃþ", page);
			List<Goods> goodsCategory = goods;
			if(page!=null) {
				goodsCategory = Serch.goodsCategory(goods, page);
			}
			if(serch!=""){
				//request.setAttribute("goods", Serch.goodsSerch(goodsCategory,serch));
				map.put("goods", Serch.goodsSerch(goodsCategory,serch));
			}else{
				//request.setAttribute("goods", goodsCategory);
				map.put("goods", goodsCategory);
			}
			return "home";
		}else{
			double sum = 0;
			List<Goods> goodsOfShoppingcart = new ArrayList<>();
			for(Goods good: goods){
				if(request.getSession().getAttribute(good.getEngname())!=null){
					goodsOfShoppingcart.add(good);
					sum += good.getPrice();
				}
			}
			//request.setAttribute("goods", goodsOfShoppingcart);
			map.put("goods", goodsOfShoppingcart);
			request.getSession().setAttribute("sum", sum);
			return "shoppingcart";
		}
	}
	
	@GetMapping("shoppingCartManagement")
	public void shoppingCartManagement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String product = request.getParameter("product");
		if(request.getParameter("remove")!=null){
			request.getSession().removeAttribute(product);
			response.sendRedirect("home?page=shoppingcart");
		}else{
			request.getSession().setAttribute(product, product);
			response.sendRedirect("home?page=shoppingcart");
		}	
	}
	
	@GetMapping("orders")
	public String orders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		List<Order> orders = OrderDAO.getOrders();
		request.getSession().setAttribute("orders", orders);
		return "orders";
	}
	
	@GetMapping("orderInfo")
	public String orderInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		int orderID = Integer.parseInt(request.getParameter("orderID"));
		request.setAttribute("orderID", orderID);
		List<Goods> orderInfo = OrderDAO.getOrderInfo(orderID);
		request.getSession().setAttribute("orderInfo", orderInfo);
		return "orderInfo";
	}
}
