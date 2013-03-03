package com.shuffla.poker.game.actions.bids;

import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.PlayerAction;

public class Fold extends PlayerAction {

    public Fold(String line) {
	super(line);
    }

    @Override
    public String getActionPrefix() {
	return "fold";
    }

    @Override
    public void update(PokerTable table) {
	table.fold(getPlayerName());
    }

}
