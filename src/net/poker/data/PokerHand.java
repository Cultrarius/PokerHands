package net.poker.data;

import net.poker.compare.PokerHandComparator;

/**
 * Describes a single valid poker hand consisting of multiple cards
 */
public class PokerHand implements Comparable<PokerHand> {

    @Override
    public int compareTo(PokerHand other) {
        return new PokerHandComparator().compare(this, other);
    }
}
