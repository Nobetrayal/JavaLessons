package com.mylesson.stage2.oop.taskpoker;

public enum HandValues {

	HIGH_CARD(0, "high card"), ONE_PAIR(1, "pair"), TWO_PAIR(2, "two pairs"), THREE_OF_A_KIND(3, "three of kind"),
		STRAIGHT(4, "straight"), FLUSH(5, "flush"), FULL_HOUSE(6, "full house"), FOUR_OF_A_KIND(7, "four of kind"),
	STRAIGHT_FLUSH(8, "straight flush"), ROYAL_FLUSH(9, "royal flush");

	private int value;
	private String presentation;

	public int getValue() {
		return value;
	}

	public String getPresentation() {
		return presentation;
	}

	HandValues(int value, String presentation) {
		this.value = value;
		this.presentation = presentation;
	}

	@Override
	public String toString() {
		return presentation;
	}
}
