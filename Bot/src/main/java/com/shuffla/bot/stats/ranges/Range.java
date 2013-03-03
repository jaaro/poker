package com.shuffla.bot.stats.ranges;

import java.util.Iterator;

import com.shuffla.poker.cards.Card;
import com.shuffla.poker.cards.ListOfCards;

public interface Range {
    void normalize();
    
    HandStats getHandStats(ListOfCards hand);
    
    void reduceChance(ListOfCards hand, double chance);
    
    void deleteAllHandsWithCard(Card card);
    
    Iterator<ListOfCards> getAllHands();    
}
