package com.shuffla.poker.game.actions.cards;

import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.ActionWithCard;

public class NewTableCardAction extends ActionWithCard {

    public NewTableCardAction(String line) {
	super(line);
    }

    @Override
    public String getActionPrefix() {
	return "newTableCard";
    }

    @Override
    public void update(PokerTable table) {
	table.addTableCard(getCard());
    }

}
