package org.chinaarchitect.calculator.formula;
/**
 * 
 * @author Henry Hu
 *
 */
public class Variable implements Calculable {
	private double value;
	private String name;

	public Variable(String name, double value) {
		// TODO Auto-generated constructor stub
		this.setValue(value);
		this.setName(name);

	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
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
