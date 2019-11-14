package com.example.androidproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ScoreBoardEntity.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
	private static String DB_NAME = "game.db";
	private static AppDatabase instance;

	public abstract ScoreBoardDao scoreBoardDao();




	public static synchronized AppDatabase getInstance(Context context) {
		if (instance == null) {
			instance = Room
					.databaseBuilder(
							context.getApplicationContext(),
							AppDatabase.class,
							DB_NAME
					).build();
		}
		return instance;
	}
}
