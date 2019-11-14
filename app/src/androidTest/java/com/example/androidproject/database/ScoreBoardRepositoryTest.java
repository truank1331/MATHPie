package com.example.androidproject.database;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;

import static org.junit.Assert.*;

public class ScoreBoardRepositoryTest {
	Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
	private ScoreBoardRepository repo = new ScoreBoardRepository(appContext);

	@Test
	public void getScoreBoard() {
		repo.getScoreBoard(new ScoreBoardRepository.GetCallback() {
			@Override
			public void onSuccess(List<ScoreBoardEntity> itemList) {
				System.out.println(itemList.toString());
			}
		});
		System.out.println("END getScoreBoard");
	}

	@Test
	public void insertScoreBoard() {
		Random random = new Random();
		ScoreBoardEntity entity = new ScoreBoardEntity(random.nextInt(200));
		repo.insertScoreBoard(entity, new ScoreBoardRepository.InsertCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Insert Success.");
			}
		});

	}
}