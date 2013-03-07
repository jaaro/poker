package com.shuffla.poker.functionfinder;

import com.shuffla.poker.functionfinder.functions.MathFunction;
import com.shuffla.poker.functionfinder.generator.FunctionGenerator;

public class FunctionFinder {
	public MathFunction find(double[][] data1, double[] value1) {
		FunctionData data = new FunctionData(data1, value1);
		FunctionGenerator generator = new FunctionGenerator(data1[0].length);
		
		double ret = 1e10;
		
		for(int i=0; i<1000000; i++) {
			MathFunction fun = generator.generate(12);
			double eff = data.calculateEfficiency(fun);
			if (eff < ret) {
				ret = eff;
				System.out.println("[" + eff + "] " + fun.getPrintableString());
			}
		}
		
		return null;
	}
}
