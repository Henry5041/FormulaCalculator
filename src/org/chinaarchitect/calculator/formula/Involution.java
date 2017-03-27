package org.chinaarchitect.calculator.formula;

/**
 * 
 * @author Henry Hu
 *
 */
public class Involution extends Function {

	public Involution(Calculable base, Calculable index) {
		super(new Calculable[] { base, index });
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getValue() {
		return Math.pow(expressions[0].getValue(), expressions[1].getValue());
	}

	@Override
	public String toString() {
		String str = "";
		// Add brackets for expressions except constants
		if (expressions[0] instanceof Constant) {
			str = expressions[0].toString();
		} else
			str = "(" + expressions[0].toString() + ")";

		if (expressions[1] instanceof Constant) {
			str += "^" + expressions[0].toString();
		} else
			str += "^(" + expressions[0].toString() + ")";
		return str;
	}
}
