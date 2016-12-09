package net.poker.compare.rule;

import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.List;

/**
 * 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.
 */
public class StraightFlush implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        int flushValueFirst = getFlushValue(first);
        int flushValueSecond = getFlushValue(first);
        return Integer.compare(flushValueFirst, flushValueSecond);
    }

    private int getFlushValue(PokerHand hand) {
        List<Card> cards = hand.getCards();
        return 0;
    }
}
