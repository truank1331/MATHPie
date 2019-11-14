package com.example.androidproject.database;

import android.content.Context;
import android.os.AsyncTask;

import java.util.Collections;
import java.util.List;

public class ScoreBoardRepository {
	private Context context;
	private Context mContent;

	public ScoreBoardRepository(Context context) {
		this.context = context;
		this.mContent = context;
	}



	//region getScoreBoard
	public interface GetCallback {
		void onSuccess(List<ScoreBoardEntity> itemList);
	}


	public void getScoreBoard(GetCallback callback) {
		GetTask getTask = new GetTask(context, callback);
		getTask.execute();
	}

	private static class GetTask extends AsyncTask<Void, Void, List<ScoreBoardEntity>> {
		private Context context;
		private GetCallback callback;

		public GetTask(Context context, GetCallback callback) {
			this.context = context;
			this.callback = callback;
		}

		@Override
		protected List<ScoreBoardEntity> doInBackground(Void... voids) {
			AppDatabase db = AppDatabase.getInstance(context);
			List<ScoreBoardEntity> itemList = db.scoreBoardDao().getAll();
			return itemList;
		}

		@Override
		protected void onPostExecute(List<ScoreBoardEntity> scoreBoardEntities) {
			super.onPostExecute(scoreBoardEntities);
			callback.onSuccess(scoreBoardEntities);
		}
	}
	//endregion


	//region insertScoreBoard
	public interface InsertCallback {
		void onSuccess();
	}

	public void insertScoreBoard(ScoreBoardEntity entity, InsertCallback callback) {
		InsertTask insertTask = new InsertTask(mContent, callback);
		insertTask.execute(entity);
	}

	private static class InsertTask extends AsyncTask<ScoreBoardEntity, Void, Void> {
		private Context context;
		private InsertCallback callback;

		public InsertTask(Context context, InsertCallback callback) {
			this.context = context;
			this.callback = callback;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			callback.onSuccess();
		}

		@Override
		protected Void doInBackground(ScoreBoardEntity... scoreBoardEntities) {
			AppDatabase db = AppDatabase.getInstance(context);
			for (ScoreBoardEntity item : scoreBoardEntities) {
				db.scoreBoardDao().insert(item);
			}
			return null;
		}
	}
	//endregion
}
