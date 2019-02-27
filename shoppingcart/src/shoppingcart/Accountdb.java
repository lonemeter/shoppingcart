package shoppingcart;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accountdb
 */
@WebServlet("/accountdb")
public class Accountdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set accountdb = new HashSet();
		Enumeration set = request.getSession().getAttributeNames();
		while(set.hasMoreElements()){
			accountdb.add(set.nextElement().toString());
		}
		if(request.getParameter("name")==null){
			request.setAttribute("帳號不允許", "帳號不允許");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
			if (accountdb.contains(request.getParameter("name"))){
				request.setAttribute("帳號不允許", "帳號不允許");
				request.getRequestDispatcher("register").forward(request, response);
			}else{
				accountdb.add(request.getParameter("name"));
				request.setAttribute("註冊成功", "帳號不允許");
			}
		}	
	}

}
