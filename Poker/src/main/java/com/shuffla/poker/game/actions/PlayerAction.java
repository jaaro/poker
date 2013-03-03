package com.shuffla.poker.game.actions;

public abstract class PlayerAction extends AbstractAction {
    protected String playerName;

    public PlayerAction(String line) {
	super();

	String[] splits = line.split(getDelimiter());
	
	if (splits.length < 2) {
	    throw new IllegalArgumentException("Too small splits.");
	}
	
	if (!isActionMatching(line)) {
	    throw new IllegalArgumentException("Wrong action = " + line);
	}
	
	this.playerName = splits[1];
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    @Override
    public String toString() {
	return getActionPrefix() + getDelimiter() + getPlayerName();
    }
    
}
