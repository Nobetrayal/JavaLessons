package com.mylesson.stage2.oop.collectionClass;

import java.util.*;

public class CollectionRunner {

    public static void main(String[] args) {
//        List<String> colors = new ArrayList<>();
//        colors.add("blue");
//        colors.add("green");
//        colors.add("black");
//        colors.add("red");
//        colors.add("yellow");
//
//        System.out.println("list before sorting " + colors);
//        Collections.sort(colors); // естественная сортировка. через compareTo()
//        System.out.println("list after sorting " + colors);

        List<Card> deckOfCards = new ArrayList<>();
        for (Card.Face face : Card.Face.values()) {

            for (Card.Suit suit : Card.Suit.values()) {

                deckOfCards.add(new Card(suit, face));

            }

        }

//        System.out.println("original deck of cards");
//        for (int i = 0; i <deckOfCards.size(); i++){
//            System.out.printf("%-20s %s", deckOfCards.get(i), (i+1)%4 == 0 ? "\n":" ");
//        }

        Collections.shuffle(deckOfCards);
        Collections.sort(deckOfCards); // Бинарный поиск только по отсортированным коллекциям.
        Card card = new Card(Card.Suit.SPADES, Card.Face.Queen);
        int i = Collections.binarySearch(deckOfCards, card);
        if (i > 0) {
            System.out.println("Card was found at position " + i);

        } else {
            System.out.println("Card was not found");
        }
        Collections.reverse(deckOfCards);

        List<Card> cardList = new ArrayList<>(deckOfCards);
        Collections.fill(cardList, card);

        System.out.println("\n\n shuffled deck of cards");
//        printOutpet((List<Card>) deckOfCards);

        Collections.sort(deckOfCards, new CardComparator());
        System.out.println("\n\n sorted deck of cards");
//        printOutpet(deckOfCards);
    }

    private static void printOutpet(List<Card> deckOfCards) {
        for (int i = 0; i < deckOfCards.size(); i++) {
            System.out.printf("%-20s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " ");
        }
    }

}
