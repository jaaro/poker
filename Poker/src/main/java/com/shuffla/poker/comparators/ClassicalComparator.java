package com.shuffla.poker.comparators;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import com.shuffla.poker.cards.ListOfCards;
import com.shuffla.poker.types.GameType;

public class ClassicalComparator implements HandComparator {

    private static int NOT_FOUND = -7;

    @Override
    public int compare(GameType gameType, ListOfCards table,
	    ListOfCards player1, ListOfCards player2) {
	ListOfCards playerA = new ListOfCards(player1);
	ListOfCards playerB = new ListOfCards(player2);

	playerA.addAll(table);
	playerB.addAll(table);

	return compareListsOfCards(playerA, playerB);
    }

    public int compareListsOfCards(ListOfCards playerA, ListOfCards playerB) {
	byte[] cardsA = new byte[playerA.size()];
	byte[] cardsB = new byte[playerB.size()];

	for (int i = 0; i < playerA.size(); i++)
	    cardsA[i] = playerA.get(i).getRepresentation();
	for (int i = 0; i < playerB.size(); i++)
	    cardsB[i] = playerB.get(i).getRepresentation();

	return compareArraysOfCards(cardsA, cardsB);
    }

    private int compareArraysOfCards(byte[] cardsA, byte[] cardsB) {
	Arrays.sort(cardsA);
	Arrays.sort(cardsB);

	ArrayUtils.reverse(cardsA);
	ArrayUtils.reverse(cardsB);

	for (PokerHandName handName : PokerHandName.values()) {
	    int res = checkCriterium(handName, cardsA, cardsB);
	    if (res != NOT_FOUND)
		return res;
	}

	throw new IllegalArgumentException("Cannot determine hand value");

    }

    private int checkCriterium(PokerHandName handName, byte[] cardsA,
	    byte[] cardsB) {
	int valueA = getCriteriumValue(handName, cardsA);
	int valueB = getCriteriumValue(handName, cardsB);
	if (valueA == NOT_FOUND && valueB == NOT_FOUND)
	    return NOT_FOUND;

	return (valueA > valueB ? -1 : (valueA == valueB ? 0 : 1));
    }

    private int getCriteriumValue(PokerHandName handName, byte[] cards) {
	switch (handName) {
	case STRAIGHT_FLUSH:
	    return straightFlashValue(cards);
	case QUADS:
	    return quadsValue(cards);
	case FULL_HOUSE:
	    return fullHouseValue(cards);
	case FLUSH:
	    return flushValue(cards);
	case STRAIGHT:
	    return straightValue(cards);
	case THREE_OF_A_KIND:
	    return threeOfAKindValue(cards);
	case PAIR_OR_PAIRS:
	    return pairOrPairsValue(cards);
	case NOTHING:
	    return nothingValue(cards);
	default:
	    throw new IllegalAccessError();
	}
    }

    private int nothingValue(byte[] cards) {
	return 13
		* (13 * (13 * (13 * getCardValue(cards[0]) + getCardValue(cards[1])) + getCardValue(cards[2])) + getCardValue(cards[3]))
		+ getCardValue(cards[4]);
    }

    private int pairOrPairsValue(byte[] cards) {
	int count = 0, value = 0;
	boolean[] used = new boolean[7];
	for (int i = 1; i < cards.length; i++) {
	    if (getCardValue(cards[i]) == getCardValue(cards[i - 1])) {
		used[i - 1] = true;
		used[i] = true;
		value = value * 13 + getCardValue(cards[i]);
		count += 2;

		if (count == 4)
		    break;
	    }
	}

	if (count == 0)
	    return NOT_FOUND;
	return count * 333222111 + 54321 * value
		+ fillToFive(cards, used, count);
    }

    private int threeOfAKindValue(byte[] cards) {
	int count = 0, value = 0;
	boolean[] used = new boolean[7];
	for (int i = 2; i < cards.length; i++) {
	    if (getCardValue(cards[i]) == getCardValue(cards[i - 2])) {
		used[i - 2] = true;
		used[i - 1] = true;
		used[i] = true;
		count = 3;
		value = getCardValue(cards[i]);
		break;
	    }
	}

	if (count == 0)
	    return NOT_FOUND;
	else
	    return value * 111222 + fillToFive(cards, used, count);
    }

    private int fillToFive(byte[] cards, boolean[] used, int count) {
	int it = 0, value = 0;
	while (count < 5) {
	    if (!used[it]) {
		value = value * 13 + getCardValue(cards[it]);
		count++;
	    }
	    it++;
	}

	return value;
    }

    private int straightValue(byte[] cards) {
	boolean[] exists = new boolean[14];
	for (byte card : cards) {
	    int value = getCardValue(card);
	    exists[value + 1] = true;
	}
	exists[0] = exists[13];
	for (int i = 9; i >= 0; i--) {
	    if (exists[i] && exists[i + 1] && exists[i + 2] && exists[i + 3]
		    && exists[i + 4])
		return i + 5;
	}
	return NOT_FOUND;
    }

    private int flushValue(byte[] cards) {
	byte[] count = new byte[4];
	for (byte card : cards) {
	    count[getCardColor(card)]++;
	}

	if (count[0] >= 5 || count[1] >= 5 || count[2] >= 5 || count[3] >= 5) {
	    int color_idx = 0;
	    while (count[color_idx] < 5)
		color_idx++;

	    int res = 0;
	    int todo = 5;
	    int i = 0;
	    while (todo > 0) {
		if (getCardColor(cards[i]) == color_idx) {
		    todo--;
		    res = (res * 13) + getCardValue(cards[i]);
		}
		i++;
	    }
	    return res;
	}

	return NOT_FOUND;
    }

    private int fullHouseValue(byte[] cards) {
	int triple = -1;
	for (int i = 2; i < cards.length; i++) {
	    if (getCardValue(cards[i]) == getCardValue(cards[i - 2])) {
		triple = getCardValue(cards[i]);
		break;
	    }
	}

	if (triple == -1)
	    return NOT_FOUND;

	for (int i = 1; i < cards.length; i++) {
	    if (getCardValue(cards[i]) == getCardValue(cards[i - 1])
		    && getCardValue(cards[i]) != triple) {
		return triple * 13 + getCardValue(cards[i]);
	    }
	}

	return NOT_FOUND;
    }

    private int quadsValue(byte[] cards) {
	for (int i = 3; i < cards.length; i++) {
	    if (getCardValue(cards[i - 3]) == getCardValue(cards[i])) {
		return getCardValue(cards[i]) * 13
			+ getCardValue(cards[(i == 3 ? 4 : 0)]);
	    }
	}
	return NOT_FOUND;
    }

    private int getCardValue(byte b) {
	return b >> 2;
    }

    private int getCardColor(byte b) {
	return b & 3;
    }

    private int straightFlashValue(byte[] cards) {
	boolean[] exists = new boolean[56];
	for (byte value : cards) {
	    exists[value + 4] = true;
	    if (value >= 48) {
		exists[value - 48] = true;
	    }
	}

	for (int i = 55; i >= 16; i--) {
	    if (exists[i] && exists[i - 4] && exists[i - 8] && exists[i - 12]
		    && exists[i - 16]) {
		return i / 4 + 5;
	    }
	}

	return NOT_FOUND;
    }
}
