package net.poker.util;

import net.poker.data.Card;
import net.poker.data.PokerHand;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HandBuilderTest {

    @Test(expected = IllegalArgumentException.class)
    public void emptyHandTest() throws Exception {
        HandBuilder.makeHand("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullHandTest() throws Exception {
        HandBuilder.makeHand(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooManyCardsTest() throws Exception {
        HandBuilder.makeHand("2S KD TH 3H JH 4S");
    }

    @Test(expected = IllegalArgumentException.class)
    public void noSpacesTest() throws Exception {
        HandBuilder.makeHand("2SKDTH3HJH");
    }

    @Test
    public void simpleHandTest() throws Exception {
        List<Card> cards = HandBuilder.makeHand("2S KD TH 3H JH").getCards();

        assertEquals(5, cards.size());

        assertEquals(Card.Suit.SPADES, cards.get(0).getSuit());
        assertEquals(Card.Value.TWO, cards.get(0).getValue());

        assertEquals(Card.Suit.DIAMONDS, cards.get(4).getSuit());
        assertEquals(Card.Value.KING, cards.get(4).getValue());
    }

    @Test
    public void simpleHandSpacesTest() throws Exception {
        List<Card> cards = HandBuilder.makeHand("2S   KD   TH  3H    JH").getCards();

        assertEquals(5, cards.size());

        assertEquals(Card.Suit.SPADES, cards.get(0).getSuit());
        assertEquals(Card.Value.TWO, cards.get(0).getValue());

        assertEquals(Card.Suit.DIAMONDS, cards.get(4).getSuit());
        assertEquals(Card.Value.KING, cards.get(4).getValue());
    }
}