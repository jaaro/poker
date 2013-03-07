package com.shuffla.poker.comparators;

import com.google.inject.Inject;
import com.shuffla.poker.cards.ListOfCards;
import com.shuffla.poker.types.GameType;

public class MainComparator implements HandComparator {
	
	private final ClassicalComparator classicalComparator;
	
	@Inject
	public MainComparator(ClassicalComparator classicalComparator) {
		super();
		this.classicalComparator = classicalComparator;
	}

	public int compare(GameType gameType, ListOfCards table,
			ListOfCards player1, ListOfCards player2) {
		
		if (gameType == GameType.HOLDEM_NL)
			return classicalComparator.compare(gameType, table, player1, player2);
		
		throw new IllegalArgumentException("Right now only HOLDEM_NL is supported");			
	}

}
