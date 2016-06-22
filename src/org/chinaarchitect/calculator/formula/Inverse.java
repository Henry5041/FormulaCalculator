package org.chinaarchitect.calculator.formula;
/**
 * 
 * @author Henry Hu
 *
 */
public class Inverse extends Function {

	public Inverse(Calculable exp) {
		super(new Calculable[] { exp });
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
