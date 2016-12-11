package net.poker.data;

/**
 * Defines a single poker card
 */
public class Card implements Comparable<Card> {

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

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return value == card.value && suit == card.suit;
    }

    @Override
    public final int hashCode() {
        return value.hashCode() + suit.hashCode();
    }

    @Override
    public int compareTo(Card card) {
        int valueComparison = Integer.compare(value.ordinal(), card.value.ordinal());
        int suitComparison = Integer.compare(suit.ordinal(), card.suit.ordinal());
        return valueComparison == 0 ? suitComparison : valueComparison;
    }

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    public enum Suit {
        HEARTS, DIAMONDS, SPADES, CLUB
    }
}
