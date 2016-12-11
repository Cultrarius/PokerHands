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
        PokerHand hand = HandBuilder.makeHand("2S KD TH 3H JH");
        System.out.println(hand);
    }

}