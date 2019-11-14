package com.example.androidproject.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import com.example.androidproject.MainActivity;
import com.example.androidproject.database.ScoreBoardEntity;
import com.example.androidproject.database.ScoreBoardRepository;
import com.example.androidproject.helper.Problem;
import com.example.androidproject.model.Gameplay;
import com.example.androidproject.model.IProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GameplayViewModel extends ViewModel {
	public Gameplay gameplayModel;
	private Context context;
	public GameplayViewModel(Context context) {
		this.context = context;
		gameplayModel = new Gameplay();
		generateProblem();
		createTimer();
	}

	public void generateProblem() {
		Problem p = new Problem();
		IProblem question = p.generate();
		this.gameplayModel.setQuestion(question.getQuestion());
		this.gameplayModel.setAns(question.getAnswer());

		String ans = question.getAnswer();

		Random random = new Random();
		ArrayList<String> answerList = new ArrayList<>();
		answerList.add(ans);
		answerList.add(p.randomAnswer(ans));
		answerList.add(p.randomAnswer(ans));
		answerList.add(p.randomAnswer(ans));
		Collections.sort(answerList);
		this.gameplayModel.setAns1(answerList.get(0));
		this.gameplayModel.setAns2(answerList.get(1));
		this.gameplayModel.setAns3(answerList.get(2));
		this.gameplayModel.setAns4(answerList.get(3));
	}

	public void onClickAnswer(View view) {
		String answer = ((Button)view).getText().toString();
		if (answer.equalsIgnoreCase(gameplayModel.getAns())) {
			// Correct
			this.gameplayModel.setScore(+2);
		} else {
			// False
			this.gameplayModel.setScore(-1);
		}
		this.generateProblem();
		test();
	}

	public void test() {
		ScoreBoardRepository repo = new ScoreBoardRepository(context);
		System.out.println("TEST");
		repo.getScoreBoard(new ScoreBoardRepository.GetCallback() {
			@Override
			public void onSuccess(List<ScoreBoardEntity> itemList) {
				System.out.println("ITEM:");

				for (ScoreBoardEntity item : itemList) {
					String d = DateFormat.format("dd/MM/yyyy hh:mm:ss", item.createdAt).toString();
					System.out.println(item.id + " | " + d);
				}
			}
		});



/*
		Random random = new Random();
		ScoreBoardEntity entity = new ScoreBoardEntity(random.nextInt(200));
		repo.insertScoreBoard(entity, new ScoreBoardRepository.InsertCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Insert Success.");
			}
		});
*/

	}












	private void createTimer() {
		new CountDownTimer(30000, 100) {
			@Override
			public void onTick(long l) {
				String t = String.format("%.1f", (double)l / 1000);
				gameplayModel.setTimer(t);
			}

			@Override
			public void onFinish() {
				// Game Over
				gameplayModel.setTimer("0.0");

				if (((Activity) context).isFinishing()) {
					// NULL context (Activity destroyed)
					return;
				}

				saveScore();

				//
				AlertDialog.Builder builder = new AlertDialog.Builder(context);

				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
//						finish();
//						Intent intent = new Intent(context, MainActivity.class);
						System.out.println(context.getClass().toString());
						((Activity)context).finish();
//						context.startActivity(intent);
					}
				});

				builder.setCancelable(false);
				builder.setTitle("Game Over!");
				builder.setMessage("Your Score: " + gameplayModel.getScore());

				AlertDialog alertDialog = builder.create();
				alertDialog.show();

			}
		}.start();
	}

	private void saveScore() {
		ScoreBoardRepository repo = new ScoreBoardRepository(this.context);
		ScoreBoardEntity entity = new ScoreBoardEntity(this.gameplayModel.getScore());
		repo.insertScoreBoard(entity, new ScoreBoardRepository.InsertCallback() {
			@Override
			public void onSuccess() {

			}
		});
	}

}
