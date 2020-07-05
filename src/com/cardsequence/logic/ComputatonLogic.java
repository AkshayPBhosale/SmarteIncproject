package com.cardsequence.logic;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cardsequence.constants.DeckConstants;

public class ComputatonLogic {

	public boolean isSuitSimilar(String inputString) {
		Set<String> suitSet = new HashSet<String>();
		String[] arrSplit = inputString.split(",");
		for (int i = 0; i < arrSplit.length; i++) {
			//I am maintaining a list to store my card values
			//later I iterate this list to obtain actual values of cards
			DeckConstants.valueList.add(arrSplit[i].substring(arrSplit[i].lastIndexOf("#") + 1));
			String[] arrSplit2 = arrSplit[i].split("#");
			for (int j = 0; j < arrSplit2.length; j++) {
				if (j == 0)
					
					//I am checking if the card suit inserted is valid or not then I am adding it to my set
					if(!DeckConstants.validSuitsList.contains(arrSplit2[0])) {
					System.out.println("The suit of card with suit value "+arrSplit2[0]+" is invalid");
					System.out.println("Invalid card is ignored");
					suitSet.add(arrSplit2[0]);
					}
			}
		}
		//I am checking whether i got suits with multiple values
		if (suitSet.size() > 1)
			return false;
		else
			return true;
	}

	public boolean checkSequence(String inputString) {
		
		//Here I am checking if suits are valid and of same value
		//If not then I am returning fale.
		if (!isSuitSimilar(inputString))
			return false;
		
		//Here I am calculating difference between my values  which are sorted in ascending order
		//If my difference is not equal to 1 then I return false
		decideValuesOfCards(DeckConstants.valueList);
		for (int i = 0; i < DeckConstants.sequenceComputeList.size() - 1; i++) {
			int result = DeckConstants.sequenceComputeList.get(i + 1) - DeckConstants.sequenceComputeList.get(i);
			if (result == 1)
				continue;
			else
				return false;
		}
		return true;
	}

	public void decideValuesOfCards(List<String> inputCardsValues) {

		for (String everyValue : inputCardsValues) {
			switch (everyValue) {
			case "A":
				
				// I have handled value of A 
				//If King is present in my cards then Ace will have value 14
				//If king isn't present then i am giving Ace value as 1
				if (inputCardsValues.contains("K")) {
					DeckConstants.sequenceComputeList.add(DeckConstants.CARD_A_VALUE_2);
				} else {
					DeckConstants.sequenceComputeList.add(DeckConstants.CARD_A);
				}
				break;
			case "2":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_2);
				break;
			case "3":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_3);
				break;
			case "4":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_4);
				break;
			case "5":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_5);
				break;
			case "6":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_6);
				break;
			case "7":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_7);
				break;
			case "8":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_8);
				break;
			case "9":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_9);
				break;
			case "10":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_10);
				break;
			case "J":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_J);
				break;
			case "Q":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_Q);
				break;
			case "K":
				DeckConstants.sequenceComputeList.add(DeckConstants.CARD_K);
				break;
			default:
				System.out.println("card with value " + everyValue + " was invalid");
				System.out.println("Invalid card is ignored");
			}
		}
		//sorting the values in order
		Collections.sort(DeckConstants.sequenceComputeList);

	}

}
