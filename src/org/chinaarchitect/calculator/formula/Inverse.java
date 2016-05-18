package org.chinaarchitect.calculator.formula;

public class Inverse extends Function {

	public Inverse(Expressible exp) {
		super(new Expressible[] { exp });
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getValue() {
		return -expressions[0].getValue();
	}

	@Override
	public String toString() {
		if (expressions[0].toString().startsWith("-") || expressions[0] instanceof Addition
				|| expressions[0] instanceof Subtraction) {
			return "-(" + expressions[0] + ")";
		} else
			return "-" + expressions[0];

	}

}
