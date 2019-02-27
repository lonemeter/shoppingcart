package shoppingcart;

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
		if(i==null){
			request.setAttribute("分類", "購物");
			Goods[] goods = Items.all;
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}
		if(i.equals("1")){
			request.setAttribute("分類", "補品");
			Goods[] goods = Items.food; 
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}
		
		
		if(i.equals("2")){
			request.setAttribute("分類", "防具");
			Goods[] goods = Items.armor;
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}
		
		
		if(i.equals("3")){
			request.setAttribute("分類", "武器");
			Goods[] goods = Items.arms; 
			request.setAttribute("goods", goods);
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
		}
		
		
		if(i.equals("4")){
			double sum = 0;
			List<Goods> goods = new ArrayList();
			for(Goods good: Items.all){
				if(request.getSession().getAttribute(good.engname)!=null){
					goods.add(good);
					sum += good.price;
				}
			}
			request.setAttribute("goods", goods);
			request.setAttribute("sum", sum);
			request.getRequestDispatcher("WEB-INF/shoppingcart.jsp").forward(request, response);
		}
	
	}
}
