package com.shuffla.poker.game.actions.cards;

import com.shuffla.poker.cards.Card;
import com.shuffla.poker.cards.ListOfCards;
import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.PlayerAction;

public class DealtToAction extends PlayerAction {
    protected ListOfCards cards;

    @Override
    public String getActionPrefix() {
	return "dealtTo";
    }
    
    public DealtToAction(String line) {
	super(line);
	
	String[] splits = line.split(getDelimiter());
	if (splits.length < 3) {
	    throw new IllegalArgumentException("No cards given?");
	}
	
	for(int i=2; i<splits.length; i++) {
	    cards.add(new Card(splits[i]));
	}
    }

    public ListOfCards getCards() {
        return cards;
    }

    @Override
    public String toString() {
	String res = super.toString();
	for(Card card : cards) {
	    res = res + getDelimiter() + card.toString();
	}
	return res;
    }

    @Override
    public void update(PokerTable table) {
	table.setPlayerCard(getPlayerName(), cards);	
    }

    
    
}
