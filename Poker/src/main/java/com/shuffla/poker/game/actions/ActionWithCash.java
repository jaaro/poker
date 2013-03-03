package com.shuffla.poker.game.actions;

public abstract class ActionWithCash extends PlayerAction {
    private double amount;

    public ActionWithCash(String line) {
	super(line);
	String[] splits = line.split(getDelimiter());
	if (splits.length < 3) {
	    throw new IllegalArgumentException("Not enough parts of command");
	}

	amount = Double.parseDouble(splits[2]);
    }

    public double getAmount() {
	return amount;
    }

    @Override
    public String toString() {
	return super.toString() + getDelimiter() + amount;
    }
}
