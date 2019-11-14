package com.example.androidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.database.ScoreBoardEntity;
import com.example.androidproject.database.ScoreBoardRepository;
import com.example.androidproject.databinding.ScoreItemBinding;
import com.example.androidproject.model.ScoreItem;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoardRecyclerViewAdapter extends RecyclerView.Adapter<ScoreBoardRecyclerViewAdapter.ScoreViewHolder>{


	//region ViewHolder
	class ScoreViewHolder extends RecyclerView.ViewHolder {
		private ScoreItemBinding scoreItemBinding;

		public ScoreViewHolder(@NonNull ScoreItemBinding scoreItemBinding) {
			super(scoreItemBinding.getRoot());
			this.scoreItemBinding = scoreItemBinding;
		}
	}
	//endregion

	private List<ScoreItem> scoreItemList = new ArrayList<>();
	public ScoreBoardRecyclerViewAdapter(final List<ScoreItem> scoreItemList) {
		this.scoreItemList = scoreItemList;
	}

	@NonNull
	@Override
	public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		ScoreItemBinding scoreItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.score_item, parent, false);
		return new ScoreViewHolder(scoreItemBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
		ScoreItem currentScore = scoreItemList.get(position);
		holder.scoreItemBinding.setScoreItemViewModel(currentScore);
	}

	@Override
	public int getItemCount() {
		return scoreItemList.size();
	}
}
