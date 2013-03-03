package com.shuffla.poker.game.actions;

import com.shuffla.poker.cards.Card;

public abstract class ActionWithCard extends AbstractAction {

    private Card card;

    public Card getCard() {
        return card;
    }
    
    public ActionWithCard(Card card) {
	this.card = card;
    }
    
    public ActionWithCard(String line) {
	String[] splits = line.split(getDelimiter());
	if (splits.length != 2) {
	    throw new IllegalArgumentException("Line doesn't match command");
	}
	
	if (!splits[0].equals(getActionPrefix())) {
	    throw new IllegalArgumentException("Action doesn't match command");
	}
	
	card = new Card(splits[1]);
    }   
    
    @Override
    public String toString() {
	return getActionPrefix() + getDelimiter() + card.toString();
    }
}
