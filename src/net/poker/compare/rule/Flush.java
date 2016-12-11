package net.poker.compare.rule;

import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.
 */
public class Flush implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        int flushValueFirst = getFlushValue(first);
        int flushValueSecond = getFlushValue(second);
        return Integer.compare(flushValueFirst, flushValueSecond);
    }

    private int getFlushValue(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Set<Card.Suit> suits = cards.stream().map(Card::getSuit).collect(Collectors.toSet());
        int highValue = hand.getHighCard().getValue().ordinal();
        return suits.size() == 1 ? highValue : 0;
    }
}
