package main.java;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>(52);

    private volatile static Deck uniqueInstance;

    private Deck() {
        for (String suit : Card.suits) {
            for (String face : Card.faces) {
                deck.add(new Card(suit, face));
            }
        }
    }

    public static Deck generateDeck() {
        if (uniqueInstance == null) {
            synchronized (Deck.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Deck();
                }
            }
        }
        return uniqueInstance;
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public int getSize() {
        return deck.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        int index = deck.size() - 1;
        return deck.remove(index);
    }
}
