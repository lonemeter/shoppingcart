package com.lonemeter.shoppingcart.other;

import org.springframework.stereotype.Component;

@Component
public class Question {

	public String[] getQuestion(){
		return this.question;
	}
	private String[] question = {
		"外觀滿意度",
		"交易速度",
		"儲值速度"
	};
}
