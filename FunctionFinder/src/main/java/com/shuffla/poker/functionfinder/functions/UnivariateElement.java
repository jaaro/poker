package com.shuffla.poker.functionfinder.functions;

import org.apache.commons.math3.analysis.UnivariateFunction;

public class UnivariateElement implements MathFunction {
	private static final long serialVersionUID = -4570391461157785872L;
	
	private MathFunction son = null;
	private UnivariateFunction function = null;
	
	public UnivariateElement(MathFunction son, UnivariateFunction function) {
		super();
		this.son = son;
		this.function = function;
	}

	public MathFunction getSon() {
		return son;
	}

	public void setSon(MathFunction son) {
		this.son = son;
	}

	public UnivariateFunction getFunction() {
		return function;
	}
	
	public void setFunction(UnivariateFunction function) {
		this.function = function;
	}

	public double computeValue(double[] data) {
		return function.value(son.computeValue(data));
	}

	public String getPrintableString() {
		return function.getClass().getSimpleName() + "(" + son.getPrintableString() + ")";
	}
	 
}
