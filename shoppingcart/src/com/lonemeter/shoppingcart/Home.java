package com.lonemeter.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lonemeter.shoppingcart.good.*;
/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String i = request.getParameter("page");
		String serch = Optional.ofNullable(request.getParameter("serch")).orElse("");
		if(i==null){
			Items items = new Items();
			request.setAttribute("分類", "購物");
			Goods[] goods = items.goods;
			if(serch!=""){
				request.setAttribute("goods", Serch.GoodsSerch(goods,serch));
			}else{
				request.setAttribute("goods", goods);
			}
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}else if(!(i.equals("shoppingcart"))){
			Items items = new Items(i);
			request.setAttribute("分類", i);
			Goods[] goods = items.goods; 
			if(serch!=""){
				request.setAttribute("goods", Serch.GoodsSerch(goods,serch));
			}else{
				request.setAttribute("goods", goods);
			}
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}else if(i.equals("shoppingcart")){
			Items items = new Items();
			double sum = 0;
			List<Goods> goods = new ArrayList();
			for(Goods good: items.goods){
				if(request.getSession().getAttribute(good.getEngname())!=null){
					goods.add(good);
					sum += good.getPrice();
				}
			}
			request.setAttribute("goods", goods);
			request.getSession().setAttribute("sum", sum);
			request.getRequestDispatcher("WEB-INF/shoppingcart.jsp").forward(request, response);
		}
	}
}
