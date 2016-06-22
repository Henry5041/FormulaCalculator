package org.chinaarchitect.calculator.formula;

/**
 * 
 * @author Henry Hu
 *
 */
public interface Expressible {
	/**
	 * 
	 * @return value of the expression
	 */
	public double getValue(); // An expression must have a value

	/**
	 * 
	 * @return Written form of the expression
	 */
	public String toString(); // An expression can be expressed with a String

}
