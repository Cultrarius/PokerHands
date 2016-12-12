# PokerHands

A small project that compares two poker hands with each other to check which one is ranked higher.

To use it, you need to call it with the input file path as first parameter.
Either import the project into the IDE of your choice and run the Main class, or directly execute the jar file. 

The input file (see the example input.txt) encodes each card as two characters (value of the card and suit, e.g. 'KD' = king of diamonds) and each line is a hand.

The project depends on the following libs:
* Google guava
* Junit
* Hamcrest
