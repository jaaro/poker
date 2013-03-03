package com.shuffla.poker.game;

import com.shuffla.poker.game.actions.AbstractAction;
import com.shuffla.poker.game.actions.others.NewPlayerAction;
import com.shuffla.poker.types.GameType;

public class Game {
    
    protected PokerTable table;
    
    public Game(GameType gameType) {
	table = new PokerTable(gameType);
    }
    
    public void postAction(AbstractAction action) {
	if (action instanceof NewPlayerAction) {
	    NewPlayerAction castedAction = (NewPlayerAction)action;
	    table.addPlayer(new PlayerInfo(castedAction.getPlayerName(), castedAction.getAmount()));
	    return ;
	}
	
	action.update(table);
    }
    
    public GameType getGameType() {
	return table.getGameType();
    }
}
