package com.shuffla.poker.game.actions;

import com.shuffla.poker.game.actions.bids.Call;
import com.shuffla.poker.game.actions.bids.Fold;
import com.shuffla.poker.game.actions.bids.RaiseTo;

public class ActionCreator {

    public static AbstractAction create(Class<? extends AbstractAction> clazz, String playerName) {
	if (clazz.equals(Fold.class)) {
	    return new Fold("fold|" + playerName);
	}
	
	if (clazz.equals(Call.class)) {
	    return new Fold("call|" + playerName);
	}
	
	throw new IllegalArgumentException("Invalid class name. Class = " + clazz);
    }
    
    public static AbstractAction create(Class<? extends AbstractAction> clazz, String playerName, double amount) {
	if (clazz.equals(RaiseTo.class)) {
	    return new RaiseTo("raiseTo|" + playerName + "|" + amount);
	}
	
	throw new IllegalArgumentException("Invalid class name. Class = " + clazz);
    }

}
