package org.chinaarchitect.calculator.formula;

public class Function implements Expressible {
	protected Expressible[] expressions;

	public Function(Expressible[] expressions) {
		this.setExpressions(expressions);
	}

	public Function(double[] array) {
		Expressible[] exps = new Expressible[array.length];
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

	public Expressible[] getExpressions() {
		return expressions;
	}

	public void setExpressions(Expressible[] expressions) {
		this.expressions = expressions;
	}

	// Four Operations
	public Expressible plus(Expressible addend) {
		return new Addition(this, addend);
	}

	public Expressible plus(double addend) {
		return new Addition(this, new Constant(addend));
	}

	public Expressible minus(Expressible subtractor) {
		return new Subtraction(this, subtractor);
	}

	public Expressible minus(double subtractor) {
		return new Subtraction(this, new Constant(subtractor));
	}

	public Expressible multiply(Expressible multiplier) {
		return new Multiplication(this, multiplier);
	}

	public Expressible multiply(double multiplier) {
		return new Multiplication(this, new Constant(multiplier));
	}

	public Expressible divide(Expressible divisor) {
		return new Division(this, divisor);
	}

	public Expressible divide(double divisor) {
		return new Division(this, new Constant(divisor));
	}
}
