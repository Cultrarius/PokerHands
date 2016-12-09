package net.poker.data;

/**
 * Defines a single poker card
 */
public class Card {

    private Value value;
    private Suit suit;

    public Card(Value value, Suit suit) {
        if (value == null || suit == null) {
            throw new IllegalArgumentException();
        }
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public enum Suit {
        HEARTS, DIAMONDS, SPADE, CLUB
    }
}
