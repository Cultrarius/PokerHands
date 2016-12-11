package net.poker.compare;

import com.google.common.collect.ImmutableList;
import net.poker.compare.rule.Flush;
import net.poker.compare.rule.FourOfAKind;
import net.poker.compare.rule.FullHouse;
import net.poker.compare.rule.StraightFlush;
import net.poker.data.PokerHand;

import java.util.Comparator;
import java.util.List;

/**
 * Compares two poker hands with each other
 */
public class PokerHandComparator implements Comparator<PokerHand> {

    private List<IPokerRule> rules = ImmutableList.<IPokerRule>builder()
            .add(new StraightFlush())
            .add(new FourOfAKind())
            .add(new FullHouse())
            .add(new Flush())
            .build();

    @Override
    public int compare(PokerHand first, PokerHand second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Comparison with null is not possible");
        }
        for (IPokerRule rule : rules) {
            int result = rule.compareHands(first, second);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
