package com.example.androidproject.viewModel;

import android.content.Context;
import android.text.format.DateFormat;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.adapter.ScoreBoardRecyclerViewAdapter;
import com.example.androidproject.database.ScoreBoardEntity;
import com.example.androidproject.database.ScoreBoardRepository;
import com.example.androidproject.model.ScoreBoard;

import java.util.List;

public class ScoreBoardViewModel extends ViewModel {
	private Context context;
	public ScoreBoard scoreBoardViewModel = new ScoreBoard();

	public ScoreBoardViewModel(Context context) {
		this.context = context;
		System.out.println("On ViewModel");
	}
}
