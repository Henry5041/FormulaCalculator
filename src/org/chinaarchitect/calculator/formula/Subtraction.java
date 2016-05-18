package org.chinaarchitect.calculator.formula;

public class Subtraction extends Function {

	public Subtraction(Expressible[] expressions) {
		super(expressions);
		// TODO Auto-generated constructor stub
	}

	public Subtraction(double[] array) {
		super(array);
	}

	public Subtraction(Expressible minuend, Expressible subtractor) {
		super(new Expressible[] { minuend, subtractor });
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
	public Expressible minus(Expressible subtractor) {
		Expressible[] difference = new Expressible[expressions.length + 1];
		for (int i = 0; i < expressions.length; i++) {
			difference[i] = expressions[i];
		}
		difference[expressions.length + 1] = subtractor;
		return new Addition(difference);
	}
}
