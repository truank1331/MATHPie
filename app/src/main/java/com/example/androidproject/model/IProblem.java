package com.example.androidproject.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class IProblem {
	private String question, answer;

	public IProblem() {
	}

	public IProblem(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}


	public String getQuestion() {
		return question;
	}

//	public void setQuestion(String question) {
//		this.question = question;
//	}

	public String getAnswer() {
		return answer;
	}

//	public void setAnswer(String answer) {
//		this.answer = answer;
//	}
}
