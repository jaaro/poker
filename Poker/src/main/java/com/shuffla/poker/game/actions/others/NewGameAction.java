package com.shuffla.poker.game.actions.others;

import com.shuffla.poker.game.PokerTable;
import com.shuffla.poker.game.actions.AbstractAction;

public class NewGameAction extends AbstractAction {

    @Override
    public String getActionPrefix() {
	return "newGame";
    }

    @Override
    public void update(PokerTable table) {
	//Intentionally nothing
    }

}
