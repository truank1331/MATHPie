package com.example.androidproject.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ScoreBoardDao {

	@Query("SELECT * FROM scoreBoard")
	List<ScoreBoardEntity> getAll();

	@Insert
	long insert(ScoreBoardEntity entity);

}
