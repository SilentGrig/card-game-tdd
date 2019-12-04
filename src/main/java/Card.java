package main.java;

import java.util.*;

public class Card {
    private final String suit;
    private final String face;

    public final static Set<String> suits = new LinkedHashSet<>(Arrays.asList("C", "D", "H", "S"));
    public final static Set<String> faces = new LinkedHashSet<>(Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
    private final Map<String, Integer> valueMap = new HashMap<>() {
        {
            put("A", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
        }
    };

    public Card(String suit, String face) {
        if (!suits.contains(suit)) {
            throw new IllegalArgumentException(suit + " is not a valid suit");
        }
        if (!faces.contains(face)) {
            throw new IllegalArgumentException(face + " is not a valid face");
        }
        this.suit = suit;
        this.face = face;
    }

    public String getSuit() {
        return this.suit;
    }

    public String getFace() {
        return this.face;
    }

    public int getValue() {
        return valueMap.get(this.face);
    }

    public boolean equals(Card other) {
        if (!this.face.equals(other.face)) {
            return false;
        }
        if (!this.suit.equals(other.suit)) {
            return false;
        }
        return true;
    }
}
