package com.lonemeter.shoppingcart.other;

import org.springframework.stereotype.Component;

@Component
public class Question {

	public String[] getQuestion(){
		return this.question;
	}
	private String[] question = {
		"�~�[���N��",
		"����t��",
		"�x�ȳt��"
	};
}
