package com.shuffla.bot.game;

import java.util.Map;

import com.shuffla.bot.settings.BotSettings;
import com.shuffla.bot.stats.ranges.Range;
import com.shuffla.bot.stats.ranges.RangeManager;
import com.shuffla.poker.game.Game;
import com.shuffla.poker.game.actions.AbstractAction;
import com.shuffla.poker.game.actions.others.NewPlayerAction;
import com.shuffla.poker.types.GameType;

public class EnhancedGame extends Game {
    
    public EnhancedGame(GameType gameType) {
	super(gameType);
    }

    protected Map<String, Range> representedRange;
    protected Map<String, Range> actualRange;

    public void postAction(BotSettings botSettings, AbstractAction action) {
	if (action instanceof NewPlayerAction) {
	    NewPlayerAction castedAction = (NewPlayerAction)action;
	    Range rRange = RangeManager.createRange(getGameType(), botSettings.getRangeSize());
	    Range aRange = RangeManager.createRange(getGameType(), botSettings.getRangeSize());
   	    representedRange.put(castedAction.getPlayerName(), rRange);
   	    actualRange.put(castedAction.getPlayerName(), aRange);
   	}
   	
   	super.postAction(action);
	
    }
}
