package net.poker.compare.rule;

import com.google.common.collect.ImmutableList;
import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The hand contains 2 different pairs.
 * Hands which both contain 2 pairs are ranked by the value of their highest pair.
 * Hands with the same highest pair are ranked by the value of their other pair.
 * If these values are the same the hands are ranked by the value of the remaining card.
 */
public class TwoPairs implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        List<Integer> valuesFirst = getPairValues(first);
        List<Integer> valuesSecond = getPairValues(second);
        for (int i = 0; i < 3; i++) {
            int result = Integer.compare(valuesFirst.get(i), valuesSecond.get(i));
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    private List<Integer> getPairValues(PokerHand hand) {
        List<Card> cards = hand.getCards();
        Map<Card.Value, Integer> cardCount = new HashMap<>();
        cards.stream().map(Card::getValue).forEach(value -> {
            int count = cardCount.getOrDefault(value, 0);
            cardCount.put(value, count + 1);
        });
        List<Integer> pairsValues = cardCount.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .map(e -> e.getKey().ordinal())
                .sorted()
                .collect(Collectors.toList());
        int singleValue = cardCount.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey().ordinal())
                .findFirst()
                .orElse(-1);

        // the value of the high pair, the low pair and the single card
        if (pairsValues.size() < 2) {
            return ImmutableList.of(-1, -1, -1);
        } else {
            return ImmutableList.of(pairsValues.get(0), pairsValues.get(1), singleValue);
        }
    }
}
