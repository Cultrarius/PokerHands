package net.poker.compare;

import com.google.common.collect.ImmutableList;
import net.poker.data.Card;
import net.poker.data.PokerHand;
import net.poker.util.HandBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
}