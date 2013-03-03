package com.shuffla.poker.types;

public enum GameType {
	HOLDEM_NL, PLO;
	
	public int getNumberOfHoleCards(GameType type) {
		switch(type) {
		case HOLDEM_NL: return 2;
		case PLO: return 4;
		default:
			throw new IllegalArgumentException("Unknown game type");
		}
	}
	
	public int getMinimumNumberOfHoleCardsUsedInAHand(GameType type) {
		switch(type) {
		case HOLDEM_NL: return 0;
		case PLO: return 2;
		default:
			throw new IllegalArgumentException("Unknown game type");
		}
	}
	
	public int getMaximumNumberOfHoleCardsUsedInAHand(GameType type) {
		switch(type) {
		case HOLDEM_NL: return 2;
		case PLO: return 2;
		default:
			throw new IllegalArgumentException("Unknown game type");
		}
	}
}
