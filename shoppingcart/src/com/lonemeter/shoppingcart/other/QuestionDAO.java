package com.lonemeter.shoppingcart.other;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class QuestionDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<String> getQuestion() throws SQLException{
		List<String> questions = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM QUESTION");
		Iterator<Map<String, Object>>  it = rows.iterator();
		while(it.hasNext()) {
			Map<String, Object> userMap = (Map<String, Object>)it.next();
			questions.add(userMap.get("QUESTION").toString());
		}
		return questions;
	}
	
	public void savaQuestionnaireResult(List<String[]> questionsAns) throws SQLException{
		int i = 0;
		String[] ans = new String[questionsAns.size()];
		for(String[] Ans : questionsAns) {
			ans[i] = Ans[1];
			i++;
		}
		jdbcTemplate.update("INSERT INTO QUESTIONNAIRERESULT(Q1,Q2,Q3) VALUES ('"+ans[0]+"','"+ans[1]+"','"+ans[2]+"')");
	}
	
	public List<String[]> getQuestionnaireResult(int OrderID) throws SQLException{
		List<String[]> questionsAns = new ArrayList<>();
		List<Map<String, Object>>  rows = jdbcTemplate.queryForList("SELECT * FROM QUESTIONNAIRERESULT WHERE OrderID="+OrderID);
		Iterator<Map<String, Object>>  it = rows.iterator();
		Map<String, Object> userMap = (Map<String, Object>)it.next();
		for(int i=0;i<userMap.size()-1;i++) {
			String q1 = userMap.get("Q"+(i+1)).toString();
			String[] ans = {String.valueOf(i),q1};
			questionsAns.add(ans);
		}
		return questionsAns;
	}
}
