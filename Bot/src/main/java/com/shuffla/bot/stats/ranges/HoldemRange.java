package com.shuffla.bot.stats.ranges;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shuffla.poker.cards.Card;
import com.shuffla.poker.cards.ListOfCards;

public class HoldemRange implements Range {

    final Logger LOGGER = LoggerFactory.getLogger(HoldemRange.class);
    
    Map<ListOfCards, Double> percent = new HashMap<ListOfCards, Double>();
    List<Pair<ListOfCards, Double> > sortedList;
    
    public HoldemRange() {
	initializeHands();
	normalize();
    }
    
    private void initializeHands() {
	for(int i=0; i<52; i++) {
	    for(int j=i+1; j<52; j++) {
		percent.put(ListOfCards.create(new Card(i), new Card(j)), 1.0);
	    }
	}
    }

    public void normalize() {
	double sum = 0.0;
	for (ListOfCards hand : percent.keySet()) {
	    sum += percent.get(hand);
	}
	
	if (sum < 1e-9) {
	    LOGGER.error("Sum of probabilities equal to zero");
	    throw new IllegalStateException("Sum of probabilities equal to zero");
	}
	
	for (ListOfCards hand : percent.keySet()) {
	    double value = percent.get(hand) / sum;
	    percent.put(hand, value);
	}
    }

    public HandStats getHandStats(ListOfCards hand) {
	// TODO Auto-generated method stub
	return null;
    }

    public void reduceChance(ListOfCards hand, double chance) {
	// TODO Auto-generated method stub
	
    }

    public void deleteAllHandsWithCard(Card card) {
	// TODO Auto-generated method stub
	
    }

    public Iterator<ListOfCards> getAllHands() {
	// TODO Auto-generated method stub
	return null;
    }
    
}
