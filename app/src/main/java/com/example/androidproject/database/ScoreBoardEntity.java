package com.example.androidproject.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@Entity(tableName = "scoreBoard")
public class ScoreBoardEntity {

	@PrimaryKey(autoGenerate = true)
	@SerializedName("id")
	public int id;

	@ColumnInfo(name = "score")
	@SerializedName("score")
	public int score;

	@ColumnInfo(name = "created_at")
	@SerializedName("created_at")
	public long createdAt = new Timestamp(System.currentTimeMillis()).getTime();

	public ScoreBoardEntity(int score) {
		this.score = score;
	}
}
