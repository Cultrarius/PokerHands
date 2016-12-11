package net.poker;

import net.poker.data.PokerHand;
import net.poker.util.HandBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Expected input file as argument");
        }
        File input = new File(args[0]);
        if (!input.exists()) {
            System.err.println("Input file <" + input.getAbsolutePath() + "> does not exist.");
            return;
        }

        try (Stream<String> stream = Files.lines(Paths.get(input.getAbsolutePath()))) {
            List<PokerHand> hands = stream.map(HandBuilder::makeHand).collect(Collectors.toList());
            if (hands.size() % 2 == 1) {
                System.err.println("Input file must contain even number of hands for comparison.");
                return;
            }
            for (int i = 0; i < hands.size(); i += 2) {
                PokerHand hand1 = hands.get(i);
                PokerHand hand2 = hands.get(i + 1);
                System.out.print(hand1);
                int result = hand1.compareTo(hand2);
                if (result == 1) {
                    System.out.print(" is ranked higher than ");
                } else if (result == -1) {
                    System.out.print(" is ranked lower than ");
                } else {
                    System.out.print(" is ranked the same as ");
                }
                System.out.println(hand2);
            }
        }
        System.out.println(Arrays.toString(args));
    }
}
