package com.cardsequence.starter;

import com.cardsequence.logic.ComputatonLogic;

public class AppStarter {
	public static void main(String[] args) {
		//Here I am passing my input String
		String inputString = "C#A,C#2";

		//Here I am calling checkSequence method from my logic class
		ComputatonLogic logic = new ComputatonLogic();
		System.out.println("Are the given cards in sequence ?: The Answer is "+logic.checkSequence(inputString));

	}
}
