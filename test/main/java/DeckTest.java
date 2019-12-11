package main.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    Deck deck = Deck.generateDeck();

    @Test
    public void testDeck() {
        assertEquals("C", deck.getCard(0).getSuit());
        assertEquals("A", deck.getCard(0).getFace());
        assertEquals("D", deck.getCard(13).getSuit());
        assertEquals("H", deck.getCard(26).getSuit());
        assertEquals("S", deck.getCard(39).getSuit());
    }
    // test 0, 13, 26, 39

    @Test
    public void shuffleDeck() {
        String face1 = deck.getCard(0).getFace();
        String suit1 = deck.getCard(0).getSuit();
        deck.shuffleDeck();
        String face2 = deck.getCard(0).getFace();
        String suit2 = deck.getCard(0).getSuit();
        assertNotEquals(face1, face2);
        assertNotEquals(suit1, suit2);
    }

    @Test
    public void dealTheLastCardInTheDeck() {
        Card lastCard = deck.getCard(51);
        Card card = deck.dealCard();
        assertEquals(lastCard, card);
    }

    @Test
    public void cantGeneratedASecondDeck() {
        Deck secondDeck = Deck.generateDeck();
        assertSame(deck, secondDeck);
    }
}
