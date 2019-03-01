package shoppingcart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class questionnaire
 */
@WebServlet("/questionnaire")
public class questionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i = 0;
		Question q = new Question();
		String[] question = q.getQuestion();
		request.getSession().setAttribute("i",i);
		request.setAttribute("quest",question[i]);
		request.getRequestDispatcher("WEB-INF/questionnaire.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Question q = new Question();
		String[] question = q.getQuestion();
		Integer i = Optional.ofNullable((Integer)request.getSession().getAttribute("i"))
				.map(attr -> (Integer) attr + 1)
				.orElse(0);
		request.getSession().setAttribute("i",i);
		String q1 = request.getParameter("question"+(i-1));
		request.getSession().setAttribute("question"+(i-1), q1);
		if(i>0 && i<question.length){
			request.setAttribute("quest",question[i]);
			request.getRequestDispatcher("WEB-INF/questionnaire.jsp").forward(request, response);
		}
		if(i==question.length){
			request.getRequestDispatcher("WEB-INF/questionnaireresult.jsp").forward(request, response);
		}
		
	}

}
