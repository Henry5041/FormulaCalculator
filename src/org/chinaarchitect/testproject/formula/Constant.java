package org.chinaarchitect.testproject.formula;

public class Constant implements Expressible {
	private double value;

	public Constant(double value) {
		this.value = value;
	}

	@Override
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

}
