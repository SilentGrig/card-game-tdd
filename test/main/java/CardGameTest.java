package main.java;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {
    @Test
    public void generateHandFromDeck() {
        CardGame game = new CardGame();
        game.generateHands(2, 1);
        assertEquals(1, game.getHand(0).getSize());
    }

    @Test
    public void checkEntireGameLogicthisisIntegrationTesting() throws NoSuchMethodException {
        BlackJack game = new BlackJack();

        Card card1 = new Card("S","3");
        Card card2 = new Card("H","A");
        Card card3 = new Card("D","A");
        Card card4 = new Card("C","10");

        game.generateHands(2,0);
        game.getHand(0).addCard(card1);
        game.getHand(0).addCard(card2);
        game.getHand(1).addCard(card3);
        game.getHand(1).addCard(card4);

        int winningHand = game.getWinningHand();
        assertEquals(1,winningHand);
    }


    @Test
    public void checkEntireGameLogicthisisIntegrationTestingnumbertwo()  {
        BlackJack game = new BlackJack();

        Card card1 = new Card("S","10");
        Card card2 = new Card("H","A");
        Card card3 = new Card("D","A");
        Card card4 = new Card("C","10");
        Card card5 = new Card("S","A");
        Card card6 = new Card("H","4");

        game.generateHands(2,0);
        game.getHand(0).addCard(card1);
        game.getHand(0).addCard(card2);
        game.getHand(1).addCard(card3);
        game.getHand(1).addCard(card4);
        game.getHand(1).addCard(card5);
        game.getHand(1).addCard(card6);

        int winningHand = game.getWinningHand();
        assertEquals(1,winningHand);
    }
}