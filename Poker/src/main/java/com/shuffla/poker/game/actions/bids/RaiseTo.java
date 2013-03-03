package com.shuffla.poker.game.actions.bids;

import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.ActionWithCash;

public class RaiseTo extends ActionWithCash {

    public RaiseTo(String line) {
	super(line);
    }

    @Override
    public String getActionPrefix() {
	return "raiseTo";
    }

    @Override
    public void update(PokerTable table) {
	table.raiseTo(getPlayerName(), getAmount());	
    }

}
