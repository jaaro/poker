package com.shuffla.poker.functionfinder.generator;

import java.util.Random;

import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Abs;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.commons.math3.analysis.function.Divide;
import org.apache.commons.math3.analysis.function.Gaussian;
import org.apache.commons.math3.analysis.function.Inverse;
import org.apache.commons.math3.analysis.function.Log;
import org.apache.commons.math3.analysis.function.Max;
import org.apache.commons.math3.analysis.function.Min;
import org.apache.commons.math3.analysis.function.Minus;
import org.apache.commons.math3.analysis.function.Multiply;
import org.apache.commons.math3.analysis.function.Sigmoid;
import org.apache.commons.math3.analysis.function.Subtract;

import com.shuffla.poker.functionfinder.functions.BivariateElement;
import com.shuffla.poker.functionfinder.functions.ConstantElement;
import com.shuffla.poker.functionfinder.functions.MathFunction;
import com.shuffla.poker.functionfinder.functions.UnivariateElement;
import com.shuffla.poker.functionfinder.functions.VariableElement;

public class FunctionGenerator {
	private static final BivariateFunction[] bivariateFunctions = new BivariateFunction[]{
		new Add(), new Multiply(), new Divide(), new Subtract(), new Min(), new Max()
	};
	
	private static final UnivariateFunction[] univariateFunctions = new UnivariateFunction[]{
		new Abs(), new Gaussian(), new Inverse(), new Log(), new Minus(), new Sigmoid()
	};
	
	private int dataSize;
	
	public FunctionGenerator(int dataSize) {
		this.dataSize = dataSize;
	}
	
	Random random = new Random(56);
	
	
	public MathFunction generate(int nodes) {
		if (nodes < 1) {
			throw new IllegalArgumentException("Trying to generate " + nodes + " number of nodes. This value must be >= 1");
		}
		
		if (nodes == 1) {
			if (random.nextBoolean()) return new ConstantElement(random.nextGaussian());
			else return new VariableElement(random.nextInt(dataSize));
		}
		
		nodes--;
		
		if (nodes >= 2 && random.nextDouble() < 0.5) {
			int leftSons = random.nextInt(nodes - 1) + 1;
			MathFunction leftSon = generate(leftSons);
			MathFunction rightSon = generate(nodes - leftSons);
			BivariateFunction function = createBivariateFunction();
			return new BivariateElement(leftSon, rightSon, function);
		}
		
		UnivariateFunction function = createUnivariateFunction();
		MathFunction son = generate(nodes);
		
		return new UnivariateElement(son, function);
		
	}


	private BivariateFunction createBivariateFunction() {
		return bivariateFunctions[random.nextInt(bivariateFunctions.length)];
	}
	
	private UnivariateFunction createUnivariateFunction() {
		return univariateFunctions[random.nextInt(univariateFunctions.length)];
	}
}
