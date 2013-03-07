package com.shuffla.poker.functionfinder.functions;

import java.io.Serializable;

public interface MathFunction extends Serializable {
	double computeValue(double data[]);
	
	String getPrintableString();
}
