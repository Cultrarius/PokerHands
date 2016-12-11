package net.poker.compare.rule;

import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2 of the 5 cards in the hand have the same value.
 * Hands which both contain a pair are ranked by the value of the cards forming the pair.
 * If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
 */
public class Pair implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        int valueFirst = getPairValue(first);
        int valueSecond = getPairValue(second);
        int result = Integer.compare(valueFirst, valueSecond);
        if (result != 0 || valueFirst == -1 && valueSecond == -1) {
            return result;
        }
        for (int i = 4; i >= 0; i--) {
            Card firstCard = first.getCards().get(i);
            Card secondCard = second.getCards().get(i);
            result = Integer.compare(firstCard.getValue().ordinal(), secondCard.getValue().ordinal());
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    private int getPairValue(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Map<Card.Value, Integer> cardCount = new HashMap<>();
        cards.stream().map(Card::getValue).forEach(value -> {
            int count = cardCount.getOrDefault(value, 0);
            cardCount.put(value, count + 1);
        });
        return cardCount.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(e -> e.getKey().ordinal())
                .findFirst()
                .orElse(-1);
    }
}
