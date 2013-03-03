package com.shuffla.poker.comparators;

import com.shuffla.poker.cards.ListOfCards;
import com.shuffla.poker.types.GameType;

public interface HandComparator {
    public enum PokerHandName {
	    STRAIGHT_FLUSH, QUADS, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_A_KIND, PAIR_OR_PAIRS, NOTHING
    }
    
    public int compare(GameType gameType, ListOfCards table, ListOfCards player1, ListOfCards player2);
}
