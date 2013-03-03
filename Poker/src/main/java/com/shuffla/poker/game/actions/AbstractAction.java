package com.shuffla.poker.game.actions;

import com.shuffla.poker.game.PokerTable;

public abstract class AbstractAction {
    public abstract String getActionPrefix();
    public abstract void update(PokerTable table);
    
    public String getDelimiter() {
	return "|";
    }
    
    public boolean isActionMatching(String line) {
	return line.startsWith(getActionPrefix());
    }
    
    public String toString() {
	return getActionPrefix();
    }

}
