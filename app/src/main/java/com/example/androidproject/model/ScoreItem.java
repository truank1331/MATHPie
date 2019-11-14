package com.example.androidproject.model;

import android.text.format.DateFormat;

public class ScoreItem {
	public int score;
	public long date;

	public ScoreItem(int score, long date) {
		this.score = score;
		this.date = date;
	}

	public String getDate(long timestamp) {
		String date = DateFormat.format("dd/MM/yyyy hh:mm:ss", timestamp).toString();
		return date;
	}

	public String getDateFormat(long timestamp) {
		String date = DateFormat.format("dd/MM/yyyy hh:mm:ss", timestamp).toString();
		return date;
	}
}
