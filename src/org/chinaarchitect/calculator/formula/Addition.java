package org.chinaarchitect.calculator.formula;

public class Addition extends Function {

	public Addition(Expressible[] expressions) {
		super(expressions);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getValue() {
		if (expressions != null) {
			double value = 0;

			for (int i = 0; i < expressions.length; i++) {

				value = value + expressions[i].getValue();

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
				if (expressions[i].toString().startsWith("-")) {
					str = str + expressions[i];
				} else {
					str = str + "+" + expressions[i];
				}

			}
			return str;
		}

		return "";

	}
}
