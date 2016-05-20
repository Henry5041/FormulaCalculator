package org.chinaarchitect.calculator.formula;

public interface Calculable extends Expressible {

	public Calculable plus(Calculable addend);

	public Calculable minus(Calculable subtractor);

	public Calculable multiply(Calculable multiplier);

	public Calculable divide(Calculable divisor);
}
