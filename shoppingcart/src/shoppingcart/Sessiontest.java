package shoppingcart;


import java.io.IOException;
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
		String �[�J�ʪ��� = request.getParameter("ses");

		if(request.getParameter("clc")!=null){
			request.getSession().invalidate();
			response.sendRedirect("home?page=4");
		}else{
			if(request.getParameter("sell")!=null){
				request.getSession().removeAttribute(�[�J�ʪ���);
				response.sendRedirect("home?page=4");
			}else{
				request.getSession().setAttribute(�[�J�ʪ���, �[�J�ʪ���);
				response.sendRedirect("home");
			}
		}
	}
}
