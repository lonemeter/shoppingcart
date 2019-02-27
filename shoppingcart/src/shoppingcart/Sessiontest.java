package shoppingcart;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sessiontest
 */
@WebServlet("/sessiontest")
public class Sessiontest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String 加入購物單 = request.getParameter("ses");
		PrintWriter out = response.getWriter();
		if(request.getSession().getAttribute("login")==null){
			//out.println("alert('請登入')");
			response.sendRedirect("login");
		}else{
			if(request.getParameter("clc")!=null){
				String name = (String)request.getSession().getAttribute("login");
				request.getSession().invalidate();
				request.getSession().setAttribute("login", name);
				response.sendRedirect("home?page=4");
			}else{
				if(request.getParameter("sell")!=null){
					request.getSession().removeAttribute(加入購物單);
					response.sendRedirect("home?page=4");
				}else{
					request.getSession().setAttribute(加入購物單, 加入購物單);
					response.sendRedirect("home");
				}
			}
		}
	}
}
