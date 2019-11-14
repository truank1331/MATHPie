package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}



	public void onClickGameStart(View view) {
		Intent intent = new Intent(this, Gameplay.class);
		startActivity(intent);
	}

	public void onClickScoreBoard(View view) {
		Intent intent = new Intent(this, ScoreBoard.class);
		startActivity(intent);
	}










}
