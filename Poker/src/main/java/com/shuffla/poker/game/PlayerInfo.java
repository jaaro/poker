package com.shuffla.poker.game;

import com.shuffla.poker.cards.ListOfCards;

public class PlayerInfo {
    private String name;
    
    private double originalStack;
    private double currentStack;
    private double amountInCurrentBid;
    private boolean isInGame;
    
    private ListOfCards cards = new ListOfCards();

    public PlayerInfo(String name, double originalStack) {
	this.name = name;
	this.originalStack = originalStack;
	
	isInGame = true;
	currentStack = originalStack;
	amountInCurrentBid = 0;
    }
    
    public boolean isInGame() {
	return isInGame;
    }
    
    public String getName() {
        return name;
    }

    public double getOriginalStack() {
        return originalStack;
    }

    public double getCurrentStack() {
        return currentStack;
    }

    public double getAmountInCurrentBid() {
        return amountInCurrentBid;
    }

    public ListOfCards getCards() {
        return cards;
    }

    public void resetBid() {
	amountInCurrentBid = 0;
    }
    
    public void fold() {
	isInGame = false;
    }
    
    public void raiseTo(double amount) {
	amount -= amountInCurrentBid;
	if (amount < 0) {
	    throw new IllegalArgumentException("Raise to is smaller than prevoius raise by this player");
	}
	
	if (amount > currentStack) amount = currentStack;
	
	currentStack -= amount;
	amountInCurrentBid += amount;
    }
    
    public double getAmountInWholeHand() {
	return originalStack - currentStack;
    }

    public void addCards(ListOfCards moreCards) {
	cards.addAll(moreCards);
    }


}
