package com.shuffla.poker.game.actions.blinds;

import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.ActionWithCash;

public class PostBigBlind extends ActionWithCash {

    public PostBigBlind(String line) {
	super(line);
    }

    @Override
    public String getActionPrefix() {
	return "PostBigBlind";
    }

    @Override
    public void update(PokerTable table) {
	table.raiseTo(getPlayerName(), getAmount());
	
    }

}
