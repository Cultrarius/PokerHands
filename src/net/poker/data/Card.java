package net.poker.data;

/**
 * Defines a single poker card
 */
public class Card {

    private Value value;
    private Suit suit;

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public enum Suit {
        HEARTS, DIAMONDS, SPADE, CLUB
    }
}
