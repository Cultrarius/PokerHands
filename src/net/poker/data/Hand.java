package net.poker.data;

import net.poker.compare.HandComparator;

/**
 * Describes a single valid poker hand consisting of multiple cards
 */
public class Hand implements Comparable<Hand> {

    @Override
    public int compareTo(Hand other) {
        return new HandComparator().compare(this, other);
    }
}
