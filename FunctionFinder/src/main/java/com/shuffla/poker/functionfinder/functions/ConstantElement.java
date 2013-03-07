package com.shuffla.poker.functionfinder.functions;

public class ConstantElement implements MathFunction {
	private static final long serialVersionUID = -8047182300081841206L;
	
	private double value;

	public ConstantElement(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double computeValue(double[] data) {
		return value;
	}

	public String getPrintableString() {
		return Double.toString(value);
	}
}
