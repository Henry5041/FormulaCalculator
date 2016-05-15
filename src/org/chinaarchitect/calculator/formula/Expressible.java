package org.chinaarchitect.calculator.formula;

public interface Expressible {

	public double getValue(); // An expression must have a value

	public String toString(); // An expression can be expressed with a String
}
