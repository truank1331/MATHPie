package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.androidproject.databinding.ActivityGameplayBinding;
import com.example.androidproject.helper.Problem;
import com.example.androidproject.model.IProblem;
import com.example.androidproject.viewModel.GameplayViewModel;

public class Gameplay extends AppCompatActivity {

	private ActivityGameplayBinding binding;
	private GameplayViewModel gameplayViewModel = new GameplayViewModel(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_gameplay);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_gameplay);
		binding.setGameplayViewModel(gameplayViewModel);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
}
