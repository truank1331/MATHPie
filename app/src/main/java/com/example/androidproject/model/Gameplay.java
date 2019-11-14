package com.example.androidproject.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class Gameplay extends BaseObservable {
	private int score;
	private String timer, question, ans, ans1, ans2, ans3, ans4;

	@Bindable
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
		notifyPropertyChanged(BR.score);
	}

	@Bindable
	public String getTimer() {
		return timer;
	}

	public void setTimer(String timer) {
		this.timer = timer;
		notifyPropertyChanged(BR.timer);
	}
	@Bindable
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
		notifyPropertyChanged(BR.question);
	}

	@Bindable
	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
		notifyPropertyChanged(BR.ans);
	}

	@Bindable
	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
		notifyPropertyChanged(BR.ans1);
	}
	@Bindable
	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
		notifyPropertyChanged(BR.ans2);
	}
	@Bindable
	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
		notifyPropertyChanged(BR.ans3);
	}
	@Bindable
	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
		notifyPropertyChanged(BR.ans4);
	}
}
