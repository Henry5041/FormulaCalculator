package org.chinaarchitect.calculator.formula;

public class Constant implements Expressible {
	private double value;

	public Constant(double value) {
		this.value = value;
	}

	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Double.toString(value);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Constant) {
			if (((Constant) o).getValue() == value) {
				return true;
			}
		}
		return false;
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
