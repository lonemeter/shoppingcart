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
public class sessiontest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String �[�J�ʪ��� = request.getParameter("ses");
		//String sell = request.getParameter("sell");
		//Optional<String> sell = Optional.ofNullable(request.getParameter("sell"));
		if(request.getParameter("sell")!=null){
			request.getSession().removeAttribute(�[�J�ʪ���);
			response.sendRedirect("shoppingcart.jsp");
		}else{
			request.getSession().setAttribute(�[�J�ʪ���, �[�J�ʪ���);
			response.sendRedirect("home.jsp");
		}
		
	}

}
