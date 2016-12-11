package net.poker.compare;

import net.poker.data.PokerHand;
import net.poker.util.HandBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandComparatorTest {
    @Test
    public void compareSameHand() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("2S KD TH 3H JH");
        PokerHand hand2 = HandBuilder.makeHand("2S KD TH 3H JH");
        int result = hand1.compareTo(hand2);
        assertEquals(0, result);
    }

    @Test
    public void compareStraightFlush() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("3S 7S 4S 5S 6S");
        PokerHand hand2 = HandBuilder.makeHand("AS AD AH AC KH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareStraightFlushes() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("3S 7S 4S 5S 6S");
        PokerHand hand2 = HandBuilder.makeHand("KS QS TS JS 9S");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareFourOfAKind() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("2S KD TH 3H JH");
        PokerHand hand2 = HandBuilder.makeHand("4S 4D 4H 4C 5H");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareFourOfAKinds() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD KH KC 4H");
        PokerHand hand2 = HandBuilder.makeHand("4S 4D 4H 4C 5H");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }
}