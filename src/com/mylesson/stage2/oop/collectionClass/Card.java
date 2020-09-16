package com.mylesson.stage2.oop.collectionClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                face == card.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }

    public enum Suit {SPADES, HEARTS, CLUBS, DIAMONDS}

    public enum Face {Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}

    private final Suit suit;
    private final Face face;

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    @Override
    public int compareTo(Card card) {

        Face[] values = Face.values();
        List<Face> faces = Arrays.asList(values);

        if (faces.indexOf(this.getFace()) < faces.indexOf(card.getFace())) {
            return -1;
        } else if (faces.indexOf(this.getFace()) > faces.indexOf(card.getFace())) {
            return 1;
        } else if (faces.indexOf(this.getFace()) == faces.indexOf(card.getFace())) {
            return String.valueOf(this.getSuit()).compareTo(String.valueOf(card.getSuit()));
        }

        return 0;
    }

    public Suit getSuit() {
        return suit;
    }

    public Face getFace() {
        return face;
    }
}
