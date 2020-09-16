package com.mylesson.stage2.oop.stackQueue;

import com.mylesson.stage2.oop.collectionClass.Card;
import com.mylesson.stage2.oop.collectionClass.CardComparator;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class StackQueueLauncher {
    public static void main(String[] args) {
//        passengerProcessing();

//        Queue<Integer> q = new PriorityQueue<>();
////        q.offer(4);
////        q.offer(5);
////        q.offer(23);
////        q.offer(1);
////
////        System.out.println(q.poll());
////        System.out.println(q.poll());

        Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator());
        for (Card.Face face : Card.Face.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
                cardDeck.offer(new Card(suit, face));
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(cardDeck.poll());
        }
        System.out.println("Deck size is " + cardDeck.size());

    }

    private static void passengerProcessing() {
        Stack<Passenger> bus = new Stack<>();

        Passenger passenger = new Passenger("Katerina", "Ivanova");
        bus.push(new Passenger("Alex", "Vasko"));
        bus.push(new Passenger("Viktor", "Mikhailov"));
        bus.push(new Passenger("Dmitrii", "Petrov"));
        bus.push(passenger);
        bus.push(new Passenger("Ivan", "Ivanov"));

        System.out.println("Passenger found at position " + bus.search(passenger));

        System.out.println("Last entered passenger is: " + bus.peek());
        while (!bus.empty()) {
            System.out.println("Passenger :" + bus.pop());
        }

    }

    private static class Passenger {

        private static int number = 1;
        private String name;
        private String surname;

        public static int getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return "Passenger{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }

        public static void setNumber(int number) {
            Passenger.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public Passenger(String name, String surname) {
            number++;
            this.name = name;
            this.surname = surname;
        }
    }
}
