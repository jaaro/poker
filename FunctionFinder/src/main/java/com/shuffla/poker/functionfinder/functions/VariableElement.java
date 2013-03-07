package com.shuffla.poker.functionfinder.functions;

public class VariableElement implements MathFunction {
	private static final long serialVersionUID = -8822777481002347925L;
	
	int index;
	
	public VariableElement(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double computeValue(double[] data) {
		return data[index];
	}

	public String getPrintableString() {
		return "DATA[" + index + "]";
	}

}
