package org.chinaarchitect.calculator.formula;

public class Constant implements Calculable {
	private final double value;

	public Constant(double value) {
		this.value = value;
	}

	public double getValue() {
		// TODO Auto-generated method stub
		return value;
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
