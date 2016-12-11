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

    @Test
    public void compareStraightFlushVsFourOfAKind() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS QS TS JS 9S");
        PokerHand hand2 = HandBuilder.makeHand("AS AD AH AC KH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareFullHouse() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("2S 2D 2H 3H 3D");
        PokerHand hand2 = HandBuilder.makeHand("AS AD KH QC JH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareFullHouses() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("2S 2D 2H AH AD");
        PokerHand hand2 = HandBuilder.makeHand("3S 3D 3H 2H 2D");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareFlush() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("3S KS 4S QS 6S");
        PokerHand hand2 = HandBuilder.makeHand("AS AD 2H AC KH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareFlushes() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("JS 7S 4S 5S 6S");
        PokerHand hand2 = HandBuilder.makeHand("KS 4S 2S JS 9S");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareStraight() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("3D 7S 4S 5H 6S");
        PokerHand hand2 = HandBuilder.makeHand("AS AD 2H AC KH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareStraights() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("3C 7S 4H 5S 6S");
        PokerHand hand2 = HandBuilder.makeHand("KS QC TD JS 9S");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareThreeOfAKind() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("2S KD TH 3H JH");
        PokerHand hand2 = HandBuilder.makeHand("4S 4D 4H 6C 5H");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareThreeOfAKinds() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD KH 6C 4H");
        PokerHand hand2 = HandBuilder.makeHand("4S 4D 4H 6C 5H");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareTwoPairs() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD QH QC 4H");
        PokerHand hand2 = HandBuilder.makeHand("2S KD TH 3H JH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareTwoPairsHighestPair() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD QH QC 4H");
        PokerHand hand2 = HandBuilder.makeHand("QS QD JH JC 4H");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareTwoPairsSecondPair() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD JH JC 4H");
        PokerHand hand2 = HandBuilder.makeHand("KS KD QH QC 4H");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareTwoPairsSingleCard() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD JH JC 3H");
        PokerHand hand2 = HandBuilder.makeHand("KS KC JS JH 4H");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void comparePair() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD QH JC 4H");
        PokerHand hand2 = HandBuilder.makeHand("2S KD TH 3H JH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void comparePairsHigh() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD QH JC 4H");
        PokerHand hand2 = HandBuilder.makeHand("2S TD TH 3H JH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void comparePairsLow() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD QH TC 4H");
        PokerHand hand2 = HandBuilder.makeHand("KS KD QH JC 4H");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void comparePairsLow2() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD AH TC 4H");
        PokerHand hand2 = HandBuilder.makeHand("KS KD QH JC 4H");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void comparePairsAllEqual() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS KD QH JC 4H");
        PokerHand hand2 = HandBuilder.makeHand("KC KD QS JC 4C");
        int result = hand1.compareTo(hand2);
        assertEquals(0, result);
    }

    @Test
    public void compareHighCard() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS 3D AH JC 4H");
        PokerHand hand2 = HandBuilder.makeHand("2S KD TH 3H JH");
        int result = hand1.compareTo(hand2);
        assertEquals(1, result);
    }

    @Test
    public void compareHighCardSomeEqual() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS 3D QH JC 4H");
        PokerHand hand2 = HandBuilder.makeHand("2S KD QH 5H JH");
        int result = hand1.compareTo(hand2);
        assertEquals(-1, result);
    }

    @Test
    public void compareHighCardAllEqual() throws Exception {
        PokerHand hand1 = HandBuilder.makeHand("KS 3D QH JC 4H");
        PokerHand hand2 = HandBuilder.makeHand("3S KD QH 4H JH");
        int result = hand1.compareTo(hand2);
        assertEquals(0, result);
    }
}