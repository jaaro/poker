package com.shuffla.poker.cards;

import java.util.ArrayList;

public class ListOfCards extends ArrayList<Card> {
    private static final long serialVersionUID = 4617204607010201988L;

    public ListOfCards(ListOfCards list) {
	super(list);
    }

    public ListOfCards() {
	super();
    }

    public static ListOfCards create(Card card1, Card card2) {
	ListOfCards cards = new ListOfCards();
	cards.add(card1);
	cards.add(card2);
	return cards;
    }
}
