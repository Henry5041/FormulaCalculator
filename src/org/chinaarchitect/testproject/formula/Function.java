package org.chinaarchitect.testproject.formula;

public class Function implements Expressible {
	protected Expressible[] expressions;

	public Function(Expressible[] expressions) {
		this.setExpressions(expressions);
	}

	@Override
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

}
