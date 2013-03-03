package com.shuffla.poker.cards;

public class Card {
    private byte value;

    public Card(String line) {
	if (line.length() != 4) {
	    throw new IllegalArgumentException("Argument is not a valid card");
	}

	if (line.charAt(0) != '[' || line.charAt(3) != ']') {
	    throw new IllegalArgumentException(
		    "Argument is not a valid card, example of correct value [4d]");
	}

	value = 0;
	for (byte i = 0; i < 13; i++)
	    if (getLetterForValue(i) == line.charAt(1))
		value += i * 4;
	for (byte i = 0; i < 4; i++)
	    if (getLetterForColor(i) == line.charAt(2))
		value += i;
    }

    public Card(int value) {
	this.value = (byte) value;
    }

    public byte getColor() {
	return (byte) (value & 3);
    }

    public byte getValue() {
	return (byte) (value / 4);
    }

    public String toString() {
	return "[" + getLetterForValue(getValue())
		+ getLetterForColor(getColor()) + "]";
    }

    public char getLetterForColor(byte a) {
	if (a == 0)
	    return 'h';
	if (a == 1)
	    return 'd';
	if (a == 2)
	    return 's';
	if (a == 3)
	    return 'c';

	throw new IllegalArgumentException("Incorrect card color");
    }

    public char getLetterForValue(byte a) {
	if (a == 12)
	    return 'A';
	if (a == 11)
	    return 'K';
	if (a == 10)
	    return 'Q';
	if (a == 9)
	    return 'J';
	if (a == 8)
	    return 'T';
	if (a >= 0 && a <= 7)
	    return (char) ('2' + a);

	throw new IllegalArgumentException("Incorrect card value");
    }

    public byte getRepresentation() {
	return value;
    }
}
