package net.poker.compare.rule;

import net.poker.compare.IPokerRule;
import net.poker.data.Card;
import net.poker.data.PokerHand;

/**
 * Hands which do not fit any higher category are ranked by the value of their highest card.
 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
 */
public class HighCard implements IPokerRule {
    @Override
    public int compareHands(PokerHand first, PokerHand second) {
        for (int i = 4; i >= 0; i--) {
            Card firstCard = first.getCards().get(i);
            Card secondCard = second.getCards().get(i);
            int result = Integer.compare(firstCard.getValue().ordinal(), secondCard.getValue().ordinal());
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
