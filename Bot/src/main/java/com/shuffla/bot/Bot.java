package com.shuffla.bot;

import com.google.inject.Inject;
import com.shuffla.bot.game.EnhancedGame;
import com.shuffla.bot.resources.AISettings;
import com.shuffla.bot.resources.MyName;
import com.shuffla.bot.settings.BotSettings;
import com.shuffla.poker.game.PlayerInfo;
import com.shuffla.poker.game.actions.AbstractAction;
import com.shuffla.poker.game.actions.ActionCreator;
import com.shuffla.poker.game.actions.bids.Fold;

public class Bot {
    @MyName
    protected String myName;
    
    @AISettings
    protected BotSettings botSettings;

    @Inject
    public Bot(@MyName String myName, @AISettings BotSettings botSettings) {
	super();
	this.myName = myName;
	this.botSettings = botSettings;
    }
    
    public AbstractAction play(EnhancedGame game) {
	//PlayerInfo info = game.getPlayerStats(myName);
	//ListOfCards cards = info.getCards();
	
	
	return ActionCreator.create(Fold.class, myName);
    }

    public void update(EnhancedGame game, AbstractAction action) {
	game.postAction(botSettings, action);
    }
}
