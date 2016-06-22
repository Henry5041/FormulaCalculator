package org.chinaarchitect.calculator.formula;
/**
 * 
 * @author Henry Hu
 *
 */
public class Multiplication extends Function {

	public Multiplication(Calculable[] expressions) {
		super(expressions);
		// TODO Auto-generated constructor stub
	}

	public Multiplication(double[] array) {
		super(array);
	}

	public Multiplication(Calculable multiplier1, Calculable multiplier2) {
		super(new Calculable[] { multiplier1, multiplier2 });
	}

	@Override
	public double getValue() {
		if (expressions != null) {
			double value = 1;

			for (int i = 0; i < expressions.length; i++) {

				value = value * expressions[i].getValue();

			}
			return value;
		}

		return 0;
	}

	@Override
	public String toString() {
		// TODO Edit this part
		String str = "";
		if (expressions != null) {
			// Judge the priority of the operation in the expression
			if (expressions[0] instanceof Addition || expressions[0] instanceof Subtraction) {
				str = "(" + expressions[0].toString() + ")";

			} else
				str = expressions[0].toString();

			for (int i = 1; i < expressions.length; i++) {
				// Judge the priority of the operation in the expression
				if (expressions[i].toString().startsWith("-") || expressions[i] instanceof Addition
						|| expressions[i] instanceof Subtraction) {
					str += "*(" + expressions[i] + ")";
				} else
					str += "*" + expressions[i];

			}
			return str;
		}

		return "";

	}

	@Override
	public Calculable multiply(Calculable multiplier) {
		Calculable[] product = new Calculable[expressions.length + 1];
		for (int i = 0; i < expressions.length; i++) {
			// Copy the expressions in the front
			product[i] = expressions[i];
		}
		// Add the input to the last place
		product[expressions.length] = multiplier;
		return new Multiplication(product);
	}
}
