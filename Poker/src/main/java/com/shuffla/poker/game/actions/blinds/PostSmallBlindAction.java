package com.shuffla.poker.game.actions.blinds;

import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.ActionWithCash;

public class PostSmallBlindAction extends ActionWithCash {

    public PostSmallBlindAction(String line) {
	super(line);
    }

    @Override
    public String getActionPrefix() {
	return "PostSmallBlind";
    }

    @Override
    public void update(PokerTable table) {
	table.setPlayerWhoPostedSmallBlind(getPlayerName());
	table.raiseTo(getPlayerName(), getAmount());
    }

}
