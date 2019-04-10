package com.lonemeter.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.good.Goods;
import com.lonemeter.shoppingcart.other.Items;
import com.lonemeter.shoppingcart.other.Serch;

public class HomeController implements Controller{
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page = request.getParameter("page");
		String serch = Optional.ofNullable(request.getParameter("serch")).orElse("");
		Items items = new Items(page);
		if(!("shoppingcart".equals(page))){
			request.setAttribute("¤ÀÃþ", page);
			List<Goods> goods = items.goods; 
			if(serch!=""){
				goods = Serch.goodsSerch(goods,serch);
			}
			viewPage = "home";
			return new ModelAndView(viewPage, "goods", goods);
		}else{
			double sum = 0;
			List<Goods> goods = new ArrayList<>();
			for(Goods good: items.goods){
				if(request.getSession().getAttribute(good.getEngname())!=null){
					goods.add(good);
					sum += good.getPrice();
				}
			}
			request.getSession().setAttribute("sum", sum);
			viewPage = "shoppingcart";
			return new ModelAndView(viewPage, "goods", goods);
		}
	}
	
	public void setViewPage(String viewPage) {
        this.viewPage = viewPage;
    }
}
