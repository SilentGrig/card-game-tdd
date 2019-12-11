package main.java;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    protected List<Hand> hands = new ArrayList<>();
    protected Deck deck;
    protected Input player1Input;
    protected Input player2Input;

    public CardGame() {
        deck = Deck.generateDeck();
        player1Input = new playerInput();
        player2Input = new playerInput();
    }

    public void generateHands(int numberOfHands, int numberOfCards) {
        for(int i = 0; i < numberOfHands; i++) {
            Hand hand = new Hand();
            for(int j = 0; j < numberOfCards; j++) {
                hand.addCard(deck.dealCard());
            }
            hands.add(hand);
        }
    }

    public Hand getHand(int index) {
        return hands.get(index);
    }

    public void run() {
        generateHands(2, 5);
        Card card = getHand(0).getInput(player1Input);
        Card card2 = getHand(1).getInput(player2Input);
        System.out.println("player card: " + card);
        System.out.println("computer card: " + card2);
        System.out.println(true);
        System.out.println(card.equals(card2));
    }
}
