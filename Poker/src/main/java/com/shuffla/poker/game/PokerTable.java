package com.shuffla.poker.game;

import java.util.ArrayList;
import java.util.List;

import com.shuffla.poker.cards.Card;
import com.shuffla.poker.cards.ListOfCards;
import com.shuffla.poker.types.GameType;

public class PokerTable {

    protected List<PlayerInfo> players = new ArrayList<PlayerInfo>();
    protected String playerWhoPostedSmallBlind;
    protected ListOfCards tableCards = new ListOfCards();
    protected GameType gameType = null;
    
    public PokerTable(GameType gameType) {
	this.gameType = gameType;
    }
    
    public void addPlayer(PlayerInfo playerInfo) {
	players.add(playerInfo);
    }

    public void setPlayerWhoPostedSmallBlind(String playerName) {
	playerWhoPostedSmallBlind = playerName;
    }
    
    public PlayerInfo find(String playerName) {
	for(PlayerInfo player : players) {
	    if (player.getName().equals(playerName)) {
		return player;
	    }
	}
	
	throw new IllegalArgumentException("No such player");
    }

    public void setPlayerCard(String playerName, ListOfCards cards) {
	find(playerName).addCards(cards);
	
    }

    public void addTableCard(Card card) {
	tableCards.add(card);
    }

    public void raiseTo(String playerName, double amount) {
	find(playerName).raiseTo(amount);
	
    }

    public void fold(String playerName) {
	find(playerName).fold();
    }

    public void call(String playerName) {
	double amountToCall = 0;
	
	for(PlayerInfo player : players) {
	    amountToCall = Math.max(amountToCall, player.getAmountInCurrentBid());
	}
	
	find(playerName).raiseTo(amountToCall);
    }

    public GameType getGameType() {
	return gameType;
    }

    
}
