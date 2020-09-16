package com.mylesson.stage2.oop.taskpoker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerLauncher {

	public static void main(String[] args) {

		try {
			Hand hand1 = Hand.fromString("first", new String("4D 4C 4H 7H 7D"));
			//System.out.println(hand1);
			Hand hand2 = Hand.fromString("second", new String("2D 3C 4H 5H 6D"));
			//System.out.println(hand2);
			Hand hand3 = Hand.fromString("third", new String("6C 3C 4C 5C 2C"));
			Hand hand4 = Hand.fromString("fourth", new String("2C 3D 2C 5C 6C"));
			List<Hand> listOfHands = new ArrayList<>();

			listOfHands.add(hand1);
			listOfHands.add(hand2);
			listOfHands.add(hand3);
			listOfHands.add(hand4);
			Collections.sort(listOfHands);
			printOutput(listOfHands);



		}
		catch (IOException e){

		}

	}
	private static void printOutput(List<Hand> Hand) {
		for (int i = 0; i < Hand.size(); i++) {
			System.out.printf("%-20s %s", Hand.get(i), "\n");
		}
	}
}
