package main.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    Hand hand = new Hand();

    @Test
    public void addCard() {
        hand.addCard(new Card("H", "A"));
        assertEquals(1,hand.getCards().size());
    }

    @Test
    public void getCardFromHand() {
        Card card = new Card("H", "A");
        hand.addCard(card);
        assertEquals(card, hand.getCard(new Card("H", "A")));
    }

    @Test
    public void dontUnderAnyCircumstancesGetNonExistentCardFromHand() {
        Card card = new Card("H","A");
        hand.addCard(card);
        assertEquals(null,hand.getCard(new Card("S","A")));
    }
}
