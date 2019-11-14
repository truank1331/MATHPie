package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidproject.adapter.ScoreBoardRecyclerViewAdapter;
import com.example.androidproject.database.ScoreBoardEntity;
import com.example.androidproject.database.ScoreBoardRepository;
import com.example.androidproject.databinding.ActivityScoreBoardBinding;
import com.example.androidproject.model.ScoreItem;
import com.example.androidproject.viewModel.ScoreBoardViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard extends AppCompatActivity {

	private ScoreBoardViewModel gameplayViewModel = new ScoreBoardViewModel(this);
	private ActivityScoreBoardBinding binding;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_score_board);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_score_board);
		binding.setScoreboardViewModel(gameplayViewModel);

		createRecyclerView();
		System.out.println("On Create");
	}


	private void createRecyclerView() {
		final RecyclerView recyclerView = binding.recyclerView;
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setHasFixedSize(true);

		final List<ScoreItem> itemList = new ArrayList<>();

		ScoreBoardRepository repo = new ScoreBoardRepository(this);
		repo.getScoreBoard(new ScoreBoardRepository.GetCallback() {
			@Override
			public void onSuccess(List<ScoreBoardEntity> entitys) {

				if (entitys.size() > 0)
					gameplayViewModel.scoreBoardViewModel.setHasScore(true);
				else
					gameplayViewModel.scoreBoardViewModel.setHasScore(false);

				for (ScoreBoardEntity entity : entitys) {
					itemList.add(new ScoreItem(entity.score, entity.createdAt));
				}
				Collections.reverse(itemList);
				ScoreBoardRecyclerViewAdapter adapter = new ScoreBoardRecyclerViewAdapter(itemList);
				recyclerView.setAdapter(adapter);
			}
		});

	}




}
