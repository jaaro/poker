package com.shuffla.poker.game.actions.others;

import com.shuffla.poker.game.PlayerInfo;
import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.ActionWithCash;

public class NewPlayerAction extends ActionWithCash {

    public NewPlayerAction(String line) {
	super(line);
    }

    @Override
    public String getActionPrefix() {
	return "newPlayer";
    }

    @Override
    public void update(PokerTable table) {
	table.addPlayer(new PlayerInfo(getPlayerName(), getAmount()));
    }

}
