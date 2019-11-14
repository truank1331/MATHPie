package com.example.androidproject.helper;

import android.renderscript.Script;

import androidx.annotation.NonNull;

import com.example.androidproject.model.IProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Problem {
	private String answer;
	private ScriptEngine engine;
	private int level = 5;

	public int randomNumberRange(int min, int max) {
		double r = Math.random() * (max - min) + min;
		return (int)Math.round(r);
	}

	public Problem() {
		try {
			engine = new ScriptEngineManager().getEngineByName("rhino");
			String TreeNode = "var TreeNode = function(left, right, operator) {\n" +
					"    this.left = left;\n" +
					"    this.right = right;\n" +
					"    this.operator = operator;\n" +
					"\n" +
					"    this.toString = function() {\n" +
					"        return '(' + left + ' ' + operator + ' ' + right + ')';\n" +
					"    }\n" +
					"}";

			String randomNumberRange = "function randomNumberRange(min, max) {" +
					"	return Math.floor(Math.random() *  (max - min) + min);" +
					"}";

//			String operator = "let x = ['/','*','-','+'];";
			String operator = "let x = ['*','-','+'];";

			String buildTree = "function buildTree(numNodes) {\n" +
					"    if (numNodes === 1)\n" +
					"        return randomNumberRange(1, 100);\n" +
					"\n" +
					"    var numLeft = Math.floor(numNodes / 2);\n" +
					"    var leftSubTree = buildTree(numLeft);\n" +
					"    var numRight = Math.ceil(numNodes / 2);\n" +
					"    var rightSubTree = buildTree(numRight);\n" +
					"\n" +
					"    var m = randomNumberRange(0, x.length);\n" +
					"    var str = x[m];\n" +
					"    return new TreeNode(leftSubTree, rightSubTree, str);\n" +
					"}";


			engine.eval(TreeNode);
			engine.eval(randomNumberRange);
			engine.eval(operator);
			engine.eval(buildTree);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public IProblem generate() {
		IProblem problem = new IProblem();
		try {
			String question = engine.eval("buildTree(3).toString()").toString();
			String answer = engine.eval(question).toString();
			answer = String.valueOf(new Double(answer).intValue());
			problem =  new IProblem(question, answer);
//			System.out.println(question.toString());
//			System.out.println(answer.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		return problem;
	}

	public String randomAnswer(String answer) {
		int ans = new Double(answer).intValue();
		return String.valueOf(ans + this.randomNumberRange(-100, 100));
	}
}
