package main.java;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> hand = new ArrayList<>();

    public Hand() {}

    public void addCard(Card newCard) {
        hand.add(newCard);
    }

    public List<Card> getCards() {
        return this.hand;
    }

    public Card getCard(Card cardToFind) {
        for (int i=0;i<hand.size();i++) {
            if (hand.get(i).equals(cardToFind)) {
                return hand.remove(i);
            }
        }
        return null;
    }

    public int getSize() {
        return hand.size();
    }

    public Card getInput(Input input) {
        String cardString = input.getInputString();
        Card card = new Card(cardString.substring(0, 1), cardString.substring(1, 2));
        return getCard(card);
    }

    public String toString() {
        String delimiter = "";
        String output = "";
        for (Card card : hand) {
            output += delimiter + card;
            delimiter = ", ";
        }
        return output;
    }
}
