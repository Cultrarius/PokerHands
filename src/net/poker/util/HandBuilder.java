package net.poker.util;

import com.google.common.collect.ImmutableMap;
import com.sun.istack.internal.NotNull;
import net.poker.data.Card;
import net.poker.data.PokerHand;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HandBuilder {
    private static Map<Character, Card.Suit> suitMap = ImmutableMap.of('C', Card.Suit.CLUB, 'D', Card.Suit.DIAMONDS,
            'H', Card.Suit.HEARTS, 'S', Card.Suit.SPADES);

    private static Map<Character, Card.Value> valueMap = ImmutableMap.<Character, Card.Value>builder()
            .put('2', Card.Value.TWO)
            .put('3', Card.Value.THREE)
            .put('4', Card.Value.FOUR)
            .put('5', Card.Value.FIVE)
            .put('6', Card.Value.SIX)
            .put('7', Card.Value.SEVEN)
            .put('8', Card.Value.EIGHT)
            .put('9', Card.Value.NINE)
            .put('T', Card.Value.TEN)
            .put('J', Card.Value.JACK)
            .put('Q', Card.Value.QUEEN)
            .put('K', Card.Value.KING)
            .put('A', Card.Value.ACE)
            .build();

    public static PokerHand makeHand(@NotNull String s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("Invalid null input");
        }
        List<Card> cards = new ArrayList<>();
        String[] tokens = s.toUpperCase().split("\\s+");
        if (tokens.length != 5) {
            throw new IllegalArgumentException("Malformed input string <" + s + ">");
        }
        for (String token : tokens) {
            if (token.length() != 2) {
                throw new IllegalArgumentException("Malformed input token <" + token + ">");
            }
            Card.Value value = valueMap.get(token.charAt(0));
            Card.Suit suit = suitMap.get(token.charAt(1));

            if (value == null) {
                throw new IllegalArgumentException("Illegal card value in token <" + token + ">");
            }
            if (suit == null) {
                throw new IllegalArgumentException("Illegal card suit in token <" + token + ">");
            }
            cards.add(new Card(value, suit));
        }
        return new PokerHand(cards);
    }
}
