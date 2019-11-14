package com.example.androidproject.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class ScoreBoard extends BaseObservable {
	private boolean hasScore;

	@Bindable
	public boolean isHasScore() {
		return hasScore;
	}

	public void setHasScore(boolean hasScore) {
		this.hasScore = hasScore;
		notifyPropertyChanged(BR.hasScore);
	}
}
