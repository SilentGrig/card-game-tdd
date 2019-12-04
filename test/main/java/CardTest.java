package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card card = new Card("C","A");

    @Test
    public void canCreateACard() {
        assertNotNull(card);
    }

    @Test
    public void canCreateAClubCard() {
        assertEquals("C", card.getSuit());
    }

    @Test
    public void canCreateFaceCard() {
        assertEquals("A", card.getFace());
    }

    @Test
    public void throwExceptionWhenInvalidSuitProvided() {
        assertThrows(IllegalArgumentException.class, () -> new Card("G", "A"));
    }

    @Test
    public void throwExceptionWhenInvalidFaceProvided() {
        assertThrows(IllegalArgumentException.class, () -> new Card("C", "B"));
    }

    @Test
    public void canGetCardValue() {
        assertEquals(1, card.getValue());
    }

    @Test
    public void canGetKingCardValue() {
        Card kingCard = new Card("C", "K");
        assertEquals(13, kingCard.getValue());
    }

    @Test
    public void compareIfTwoCardsAreTheSame() {
        Card firstCard = new Card("C", "A");
        Card secondCard = new Card("C", "A");
        assertTrue(firstCard.equals(secondCard));
    }

}