package net.poker.compare.rule;

import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Three of the cards in the hand have the same value.
 * Hands which both contain three of a kind are ranked by the value of the 3 cards.
 */
public class ThreeOfAKind implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        int valueFirst = getValue(first);
        int valueSecond = getValue(second);
        return Integer.compare(valueFirst, valueSecond);
    }

    private int getValue(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Map<Card.Value, Integer> cardCount = new HashMap<>();
        cards.stream().map(Card::getValue).forEach(value -> {
            int count = cardCount.getOrDefault(value, 0);
            cardCount.put(value, count + 1);
        });
        return cardCount.entrySet().stream()
                .filter(e -> e.getValue() == 3)
                .findAny()
                .map(e -> e.getKey().ordinal())
                .orElse(-1);
    }
}
