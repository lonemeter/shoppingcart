package com.lonemeter.shoppingcart.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lonemeter.shoppingcart.other.Question;

@Controller
public class QuestionnaireController {
	@Value("WEB-INF/jsp/questionnaire.jsp")
	private String QUESTIONNAIRE_PATH;
	@Value("WEB-INF/jsp/questionnaireresult.jsp")
	private String QUESTIONNAIRE_RESULT_PATH;
	
	@GetMapping("questionnaire")
	public void questionnaireForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionNumber = 0;
		Question q = new Question();
		String[] question = q.getQuestion();
		request.getSession().setAttribute("questionNumber",questionNumber);
		request.setAttribute("quest",question[questionNumber]);
		request.getRequestDispatcher(QUESTIONNAIRE_PATH).forward(request, response);
	}
	
	@PostMapping("questionnaire")
	public void questionnaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Question q = new Question();
		String[] question = q.getQuestion();
		Integer questionNumber = Optional.ofNullable((Integer)request.getSession().getAttribute("questionNumber"))
				.map(attr -> (Integer) attr + 1)
				.orElse(0);
		request.getSession().setAttribute("questionNumber",questionNumber);
		String q1 = request.getParameter("question"+(questionNumber-1));
		request.getSession().setAttribute("question"+(questionNumber-1), q1);
		if(questionNumber>0 && questionNumber<question.length){
			request.setAttribute("quest",question[questionNumber]);
			request.getRequestDispatcher(QUESTIONNAIRE_PATH).forward(request, response);
		}
		if(questionNumber==question.length){
			request.getRequestDispatcher(QUESTIONNAIRE_RESULT_PATH).forward(request, response);
		}
	}
}
