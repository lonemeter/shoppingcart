package com.lonemeter.shoppingcart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lonemeter.shoppingcart.other.QuestionDAO;

@Controller
public class QuestionnaireController {
	
	@Autowired
	QuestionDAO questions;
	
	@GetMapping("questionnaire")
	public String questionnaireForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int questionNumber = 0;
		List<String> question = questions.getQuestion();
		request.getSession().setAttribute("questionNumber",questionNumber);
		request.setAttribute("quest",question.get(questionNumber));
		return "questionnaire";
	}
	
	@PostMapping("questionnaire")
	public String questionnaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<String> question = questions.getQuestion();
		Integer questionNumber = Optional.ofNullable((Integer)request.getSession().getAttribute("questionNumber"))
				.map(attr -> (Integer) attr + 1)
				.orElse(0);
		request.getSession().setAttribute("questionNumber",questionNumber);
		
		//儲存作答過的題目到Session(questionsAns)
		String q1 = request.getParameter("question"+(questionNumber-1));
		List<String[]> questionsAns;
		if(request.getSession().getAttribute("questionsAns") == null) {
			questionsAns = new ArrayList<>();
		}else {
			questionsAns = (List<String[]>)request.getSession().getAttribute("questionsAns");
		}
		String[] ans = {String.valueOf(questionNumber),q1};
		questionsAns.add(ans);
		request.getSession().setAttribute("questionsAns", questionsAns);
		
		if(questionNumber>0 && questionNumber<question.size()){
			request.setAttribute("quest",question.get(questionNumber));
			return "questionnaire";
		}else{
			questions.savaQuestionnaireResult(questionsAns);
			request.setAttribute("questionsAns",questionsAns);
			request.getSession().removeAttribute("questionsAns");
			return "questionnaireresult";
		}
	}
	
	@GetMapping("questionnaireResult")
	public String questionnaireResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int OrderID = Integer.parseInt(request.getParameter("OrderID"));
		List<String[]> questionsAns = questions.getQuestionnaireResult(OrderID);
		request.setAttribute("questionsAns",questionsAns);
		return "queryquestionnaireresult";
	}
}
