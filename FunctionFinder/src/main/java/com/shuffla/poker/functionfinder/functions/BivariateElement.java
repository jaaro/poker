package com.shuffla.poker.functionfinder.functions;

import org.apache.commons.math3.analysis.BivariateFunction;

public class BivariateElement implements MathFunction{
	
	private static final long serialVersionUID = 1847886431589740552L;
	
	private MathFunction leftSon = null;
	private MathFunction rightSon = null;
	private BivariateFunction function = null;
	
	public BivariateElement(MathFunction leftSon, MathFunction rightSon,
			BivariateFunction function) {
		super();
		this.leftSon = leftSon;
		this.rightSon = rightSon;
		this.function = function;
	}


	public double computeValue(double[] data) {
		double left = leftSon.computeValue(data);
		double right = rightSon.computeValue(data);
		return function.value(left, right);
	}


	public String getPrintableString() {
		return function.getClass().getSimpleName() + "(" + leftSon.getPrintableString() + ", " + rightSon.getPrintableString() + ")";
	}

}
