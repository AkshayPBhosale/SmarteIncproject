package com.cardsequence.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckConstants {
   //This are the values for my cards. Here Ace is given 2 values
	public static final int CARD_A = 1;
	public static final int CARD_2 = 2;
	public static final int CARD_3 = 3;
	public static final int CARD_4 = 4;
	public static final int CARD_5 = 5;
	public static final int CARD_6 = 6;
	public static final int CARD_7 = 7;
	public static final int CARD_8 = 8;
	public static final int CARD_9 = 9;
	public static final int CARD_10 = 10;
	public static final int CARD_J = 11;
	public static final int CARD_Q = 12;
	public static final int CARD_K = 13;
	public static final int CARD_A_VALUE_2 = 14;
	//List to collect cards
	public static List<String> valueList = new ArrayList<String>();
	//List to collect Card values and then I arrange them in ascending order
	public static List<Integer> sequenceComputeList = new ArrayList<Integer>();
    //This are my valid suit list containing Spade,Heart,Club and Diamond represnted values
	public static List<String> validSuitsList = new ArrayList<String>(Arrays.asList("S", "H", "C", "D"));
}
