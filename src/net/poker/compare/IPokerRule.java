package net.poker.compare;

import net.poker.data.PokerHand;

/**
 * Describes a rule to compare two poker hands
 */
public interface IPokerRule {

    int compareHands(PokerHand first, PokerHand second);
}
