package com.mylesson.stage2.oop.taskpoker;

public class Card {

	private Face face;
	private Suit suit;

	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	public Face getFace() {
		return face;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return face +
				" of " + suit;
	}
}
