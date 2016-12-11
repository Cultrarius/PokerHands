package net.poker.data;

import com.google.common.collect.ImmutableList;
import net.poker.compare.PokerHandComparator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Describes a single valid poker hand consisting of multiple cards.
 * The cards in the hand are always sorted in ascending order.
 */
public class PokerHand implements Comparable<PokerHand> {

    private List<Card> cards;

    public PokerHand(List<Card> cards) {
        checkValidity(cards);
        this.cards = ImmutableList.copyOf(cards.stream().sorted().collect(Collectors.toList()));
    }

    @Override
    public int compareTo(PokerHand other) {
        return new PokerHandComparator().compare(this, other);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    private static void checkValidity(List<Card> cards) {
    }
}
