package net.poker.compare.rule;

import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.
 */
public class StraightFlush implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        int flushValueFirst = getFlushValue(first);
        int flushValueSecond = getFlushValue(second);
        return Integer.compare(flushValueFirst, flushValueSecond);
    }

    private int getFlushValue(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Set<Card.Suit> suits = cards.stream().map(Card::getSuit).collect(Collectors.toSet());
        int highValue = cards.get(4).getValue().ordinal();
        boolean consecutive = 4 == highValue - cards.get(0).getValue().ordinal();
        return suits.size() == 1 && consecutive ? highValue : 0;
    }
}
