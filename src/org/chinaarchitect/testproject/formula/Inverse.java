package org.chinaarchitect.testproject.formula;

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
		return "-(" + expressions[0] + ")";
	}

}
