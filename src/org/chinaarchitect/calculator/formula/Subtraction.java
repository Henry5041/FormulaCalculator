package org.chinaarchitect.calculator.formula;

/**
 * 
 * @author Henry Hu
 *
 */
public class Subtraction extends Function {

	public Subtraction(Calculable[] expressions) {
		super(expressions);
		// TODO Auto-generated constructor stub
	}

	public Subtraction(double[] array) {
		super(array);
	}

	public Subtraction(Calculable minuend, Calculable subtractor) {
		super(new Calculable[] { minuend, subtractor });
	}

	@Override
	public double getValue() {
		if (expressions != null) {
			double value = expressions[0].getValue();
			for (int i = 1; i < expressions.length; i++) {

				value = value - expressions[i].getValue();

			}
			return value;
		}

		return 0;
	}

	@Override
	public String toString() {
		if (expressions != null) {
			String str = expressions[0].toString();

			for (int i = 1; i < expressions.length; i++) {
				// Judge the priority of the operation
				if (expressions[i].toString().startsWith("-") || expressions[i] instanceof Addition
						|| expressions[i] instanceof Subtraction) {
					str += "-(" + expressions[i] + ")";
				} else
					str += "-" + expressions[i];

			}
			return str;
		}

		return "";

	}

	@Override
	public Calculable minus(Calculable subtractor) {
		Calculable[] difference = new Calculable[expressions.length + 1];
		for (int i = 0; i < expressions.length; i++) {
			difference[i] = expressions[i];
		}
		difference[expressions.length] = subtractor;
		return new Subtraction(difference);
	}
}
