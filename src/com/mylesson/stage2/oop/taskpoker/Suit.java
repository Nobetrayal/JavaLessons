package com.mylesson.stage2.oop.taskpoker;

public enum Suit {
	SPADES('C'), CLUBS('D'), DIAMONDS('H'), HEARTS('S');
	private char symbol;


	Suit(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}

	public static Suit getSuitFromCharacter(char character){

		Suit findingSuit = Suit.SPADES;
		for (Suit currentSuit: Suit.values()
		) {

			if (character == currentSuit.symbol){
				findingSuit = currentSuit;
				break;
			}

		}

		return findingSuit;

	}


}
