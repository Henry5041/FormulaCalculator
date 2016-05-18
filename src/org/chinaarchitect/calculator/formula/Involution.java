package org.chinaarchitect.calculator.formula;

public class Involution extends Function {

	public Involution(Expressible base, Expressible index) {
		super(new Expressible[] { base, index });
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
