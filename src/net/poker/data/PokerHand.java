package net.poker.data;

import com.google.common.collect.ImmutableList;
import net.poker.compare.PokerHandComparator;

import java.util.List;

/**
 * Describes a single valid poker hand consisting of multiple cards
 */
public class PokerHand implements Comparable<PokerHand> {

    private List<Card> cards = ImmutableList.of();

    @Override
    public int compareTo(PokerHand other) {
        return new PokerHandComparator().compare(this, other);
    }

    public List<Card> getCards() {
        return cards;
    }
}
