package net.poker.compare.rule;

import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.List;

/**
 * Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.
 */
public class Straight implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        int flushValueFirst = getFlushValue(first);
        int flushValueSecond = getFlushValue(second);
        return Integer.compare(flushValueFirst, flushValueSecond);
    }

    private int getFlushValue(PokerHand hand) {
        List<Card> cards = hand.getCards();
        int highValue = hand.getHighCard().getValue().ordinal();
        boolean consecutive = 4 == highValue - cards.get(0).getValue().ordinal();
        return consecutive ? highValue : 0;
    }
}
