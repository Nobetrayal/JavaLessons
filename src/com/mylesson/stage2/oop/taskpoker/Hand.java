package com.mylesson.stage2.oop.taskpoker;

import java.io.IOException;
import java.util.*;

public class Hand implements Comparable<Hand>{

	private final String name;
	private List<Card> cards;
	private String template;
	public HandValues value;

	@Override
	public String toString() {
		return "Hand " + name + "[" + template + "]," + value;
	}

	public static Hand fromString(String name, String template) throws IOException {

		Hand newHand = new Hand(name);
		newHand.cards = new ArrayList<>();
		newHand.template = template;
		fillCardsFromTemplate(newHand, template);
		newHand.calcHandValue();

		return newHand;

	}

	private void calcHandValue() {

		// Соответствие масти-количество.
		// Соответствие значения-количество.
		// Булево последовательные.

		Map<Character, Integer> suitMap = new HashMap<>();
		Map<Character, Integer> faceMap = new HashMap<>();
		Face maxFace = Face.Deuce;
		boolean inSequence;
		boolean haveFour = false;
		boolean haveThree = false;
		boolean haveTwo = false;
		boolean isFlush = false;
		int countOfPairs = 0;

		for (Card card : cards) {

			Suit suit = card.getSuit();
			char suitPresentation = suit.getSymbol();
			Face face = card.getFace();
			char facePresentation = face.getSymbol();
			Integer suitCount = suitMap.get(suitPresentation);
			if (suitCount == null) {
				suitMap.put(suitPresentation, 1);
			} else {
				suitMap.put(suitPresentation, suitCount + 1);
			}

			Integer faceCount = faceMap.get(facePresentation);
			if (faceCount == null) {
				faceMap.put(facePresentation, 1);
			} else {
				faceMap.put(facePresentation, faceCount + 1);
			}

			if (maxFace.compareTo(face) < 0) {
				maxFace = face;
			}

		}

		for (char face : faceMap.keySet()) {
			if (faceMap.get(face) == 4) {
				haveFour = true;
			}
			if (faceMap.get(face) == 3) {
				haveThree = true;
			}
			if (faceMap.get(face) == 2) {
				haveTwo = true;
				countOfPairs++;
			}

		}

		if (suitMap.size() == 1){ // all the same.
			isFlush = true;
		}

		inSequence = facesIsInSequence(faceMap);
		//System.out.println("is in sequence: " + inSequence);



		if (haveFour) {
			value = HandValues.FOUR_OF_A_KIND;
		} else if(haveThree && haveTwo){
			value = HandValues.FULL_HOUSE;
		} else if(isFlush) {

			if (inSequence){ // straight.

				if (maxFace == Face.Ace) {
					value = HandValues.ROYAL_FLUSH;
				} else {
					value = HandValues.STRAIGHT_FLUSH;
				}

			} else {
				value = HandValues.FLUSH;
			}
		} else if(inSequence) {
			value = HandValues.STRAIGHT;
		} else if(haveThree) {
			value = HandValues.THREE_OF_A_KIND;
		} else if(haveTwo) {

			if (countOfPairs == 1){
				value = HandValues.ONE_PAIR;
			} else if(countOfPairs == 2){
				value = HandValues.TWO_PAIR;
			} else {
				value = HandValues.HIGH_CARD;
			}
		} else {
			value = HandValues.HIGH_CARD;
		}

	}

	private boolean facesIsInSequence(Map<Character, Integer> faceMap) {

		if (!(faceMap.size() == 5)){
			return false;
		}

		LinkedList<Face> listOfFaces = Face.getEnumAsLinkedList();

		ListIterator<Face> listIter = listOfFaces.listIterator();
		boolean firstCoincidence = false;
		int matchCount = 0;
		while (listIter.hasNext()){

			Face nextFace = listIter.next();
			if (faceMap.get(nextFace.getSymbol()) == null){
				if (firstCoincidence){
					return matchCount == 5;
				}


			} else {
				firstCoincidence = true;
				matchCount++;
			}


		}

		return matchCount == 5;
	}

	private static void fillCardsFromTemplate(Hand newHand, String template) throws IOException {

		// check valid of templ, make array and create cards.
		if (template.length() == 14) {

			String[] cardTemplates = template.split(" ");

			for (String cardTemplate : cardTemplates) {
//				System.out.println(cardTemplate);
//				char firstChar = cardTemplate.charAt(0);
//				System.out.println(firstChar);
//				char secondChar = cardTemplate.charAt(1);
//				System.out.println(secondChar);
//				Face face = Face.getFaceFromCharacter(firstChar);
//				System.out.println(face);
//				Suit suit =  Suit.getSuitFromCharacter(secondChar);
//				System.out.println(suit);
//				Card card = new Card(face, suit);
//				System.out.println(card);

				newHand.cards.add(new Card(Face.getFaceFromCharacter(cardTemplate.charAt(0)), Suit.getSuitFromCharacter(cardTemplate.charAt(1))));

			}

		} else {

			throw new IOException("hand template is not valid");

		}

	}

	public Hand(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Hand hand = (Hand) o;
		return value == hand.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(Hand hand) {

		int handValue = hand.value.getValue();
		int thisHandValue = this.value.getValue();

		if (thisHandValue < handValue) {
			return -1;
		} else if (thisHandValue > handValue){
			return 1;
		}

		return 0;
	}


	//	public enum Suit {S, H, C, D}
//
//	public enum Face {A, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}

}
