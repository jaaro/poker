package com.shuffla.poker.game.actions.bids;

import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.PlayerAction;

public class Call extends PlayerAction {
    public Call(String line) {
	super(line);
    }

    @Override
    public String getActionPrefix() {
	return "call";
    }

    @Override
    public void update(PokerTable table) {
	table.call(getPlayerName());
    }

}
