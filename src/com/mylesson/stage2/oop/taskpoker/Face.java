package com.mylesson.stage2.oop.taskpoker;

import java.util.LinkedList;

public enum Face{

	Ace('A'), Deuce('2'), Three('3'), Four('4'), Five('5'), Six('6'),
		Seven('7'), Eight('8'), Nine('9'), Ten('T'), Jack('J'), Queen('Q'), King('K');

	private char simbol;

	Face(char simbol) {
		this.simbol = simbol;
	}

	public char getSymbol() {
		return simbol;
	}

	public static Face getFaceFromCharacter(char character){

		Face findingFace = Face.Ace;
		for (Face currentFace: Face.values()
		     ) {

			if (character == currentFace.simbol){
				findingFace = currentFace;
				break;
			}

		}

		return findingFace;

	}

	public static LinkedList<Face> getEnumAsLinkedList(){

		LinkedList<Face> list = new LinkedList<>();
		for (Face value: Face.values()) {
			list.add(value);
		}
		return list;
	}
}
