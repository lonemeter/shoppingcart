package com.lonemeter.shoppingcart.controller;

import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.lonemeter.shoppingcart.account.Account;
import com.lonemeter.shoppingcart.account.AccountH2Data;
import com.lonemeter.shoppingcart.other.Question;

public class QuestionnaireController implements Controller {
	private String viewPage;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Question q = new Question();
		String[] question = q.getQuestion();
		Integer questionNumber = Optional.ofNullable((Integer)request.getSession().getAttribute("questionNumber"))
				.map(attr -> (Integer) attr + 1)
				.orElse(0);
		request.getSession().setAttribute("questionNumber",questionNumber);
		String q1 = request.getParameter("question"+(questionNumber-1));
		request.getSession().setAttribute("question"+(questionNumber-1), q1);
		
		
		if(questionNumber<question.length){
			request.setAttribute("quest",question[questionNumber]);
			viewPage = "questionnaire";
			return new ModelAndView(viewPage);	
		}else{
			viewPage = "questionnaireresult";
			return new ModelAndView(viewPage);	
		}	
	}
	
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
}
