package org.chinaarchitect.calculator.formula;
/**
 * 
 * @author Henry Hu
 *
 */
public class Function implements Calculable {
	protected Calculable[] expressions;

	public Function(Calculable[] expressions) {
		this.setExpressions(expressions);
	}

	public Function(double[] array) {
		Calculable[] exps = new Calculable[array.length];
		for (int i = 0; i < array.length; i++) {
			exps[i] = new Constant(array[i]);
		}
		this.setExpressions(exps);
	}

	public double getValue() {
		// TODO Auto-generated method stub
		return expressions[0].getValue();
	}

	@Override
	public String toString() {
		if (expressions != null) {
			String str = "(" + expressions[0].toString();

			for (int i = 1; i < expressions.length; i++) {

				str = str + "," + expressions[i];

			}
			str = str + ")";
			return str;
		}

		return "";

	}

	public Calculable[] getExpressions() {
		return expressions;
	}

	public void setExpressions(Calculable[] expressions) {
		this.expressions = expressions;
	}

	// Four Operations
	public Calculable plus(Calculable addend) {
		return new Addition(this, addend);
	}

	public Calculable plus(double addend) {
		return new Addition(this, new Constant(addend));
	}

	public Calculable minus(Calculable subtractor) {
		return new Subtraction(this, subtractor);
	}

	public Calculable minus(double subtractor) {
		return new Subtraction(this, new Constant(subtractor));
	}

	public Calculable multiply(Calculable multiplier) {
		return new Multiplication(this, multiplier);
	}

	public Calculable multiply(double multiplier) {
		return new Multiplication(this, new Constant(multiplier));
	}

	public Calculable divide(Calculable divisor) {
		return new Division(this, divisor);
	}

	public Calculable divide(double divisor) {
		return new Division(this, new Constant(divisor));
	}
}
