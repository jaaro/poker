package com.shuffla.poker.functionfinder;

import com.shuffla.poker.functionfinder.functions.MathFunction;

public class FunctionData {
	private double[][] data;
	private double[] value;
	
	public FunctionData(double[][] data, double[] value) {
		super();
		this.data = data;
		this.value = value;
	}

	public double calculateEfficiency(MathFunction function) {
		double ret = 0;
		for(int i=0; i<data.length; i++) {
			double res = function.computeValue(data[i]);
			ret += Math.pow(value[i] - res, 2);
		}
		return ret;
	}
}
