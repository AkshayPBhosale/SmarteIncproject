package com.cardsequence.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cardsequence.constants.DeckConstants;

public class ComputatonLogic {

	public boolean isSuitSimilarAndCardsSequenced(String inputString) {
		Set<String> suitSet = new HashSet<String>();
		List<String> valueList = new ArrayList<String>();
		String[] arrSplit = inputString.split(",");
		for (int i = 0; i < arrSplit.length; i++) {
			// I am maintaining a list to store my card values
			// later I iterate this list to obtain actual values of cards
			valueList.add(arrSplit[i].substring(arrSplit[i].lastIndexOf("#") + 1));
			String[] arrSplit2 = arrSplit[i].split("#");
			for (int j = 0; j < arrSplit2.length; j++) {
				if (j == 0)

					// I am checking if the card suit inserted is valid or not then I am adding it
					// to my set
					if (!DeckConstants.validSuitsList.contains(arrSplit2[0])) {
						System.out.println("The suit of card with suit value " + arrSplit2[0] + " is invalid");
						System.out.println("Invalid card is ignored");
					}
				suitSet.add(arrSplit2[0]);
			}
		}
		// I am checking whether i got suits with multiple values
		if (suitSet.size() > 1) {
			return false;
		} else {
			return isValuesOfCardsSequenced(valueList);
			
		}
	}

	public boolean checkSequence(String inputString) {

		// Here I am checking if suits are valid and of same value
		// If not then I am returning fale.
		return isSuitSimilarAndCardsSequenced(inputString);
		
		// Here I am calculating difference between my values which are sorted in
		// ascending order
		// If my difference is not equal to 1 then I return false
	}

	public boolean isValuesOfCardsSequenced(List<String> inputCardsValues) {
		List<Integer> sequenceComputeList = new ArrayList<Integer>();
		for (String everyValue : inputCardsValues) {
			switch (everyValue) {
			case "A":

				// I have handled value of A
				// If King is present in my cards then Ace will have value 14
				// If king isn't present then i am giving Ace value as 1
				if (inputCardsValues.contains("K")) {
					sequenceComputeList.add(DeckConstants.CARD_A_VALUE_2);
				} else {
					sequenceComputeList.add(DeckConstants.CARD_A);
				}
				break;
			case "2":
				sequenceComputeList.add(DeckConstants.CARD_2);
				break;
			case "3":
				sequenceComputeList.add(DeckConstants.CARD_3);
				break;
			case "4":
				sequenceComputeList.add(DeckConstants.CARD_4);
				break;
			case "5":
				sequenceComputeList.add(DeckConstants.CARD_5);
				break;
			case "6":
				sequenceComputeList.add(DeckConstants.CARD_6);
				break;
			case "7":
				sequenceComputeList.add(DeckConstants.CARD_7);
				break;
			case "8":
				sequenceComputeList.add(DeckConstants.CARD_8);
				break;
			case "9":
				sequenceComputeList.add(DeckConstants.CARD_9);
				break;
			case "10":
				sequenceComputeList.add(DeckConstants.CARD_10);
				break;
			case "J":
				sequenceComputeList.add(DeckConstants.CARD_J);
				break;
			case "Q":
				sequenceComputeList.add(DeckConstants.CARD_Q);
				break;
			case "K":
				sequenceComputeList.add(DeckConstants.CARD_K);
				break;
			default:
				System.out.println("card with value " + everyValue + " was invalid");
				System.out.println("Invalid card is ignored");
			}
		}
		// sorting the values in order
		Collections.sort(sequenceComputeList);
		for (int i = 0; i < sequenceComputeList.size() - 1; i++) {
			int result = sequenceComputeList.get(i + 1) - sequenceComputeList.get(i);
			if (result == 1)
				continue;
			else
				return false;
		}
		return true;

	}

}
