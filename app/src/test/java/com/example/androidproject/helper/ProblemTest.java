package com.example.androidproject.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemTest {

	private Problem p = new Problem();

	@Test
	public void randomNumberRange() {
		System.out.println(p.randomNumberRange(10,100));
	}


	@Test
	public void generate() {
		p.generate();
	}
}