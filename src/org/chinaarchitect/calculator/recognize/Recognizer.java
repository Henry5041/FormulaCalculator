/**
 * 
 */
package org.chinaarchitect.calculator.recognize;

import org.chinaarchitect.calculator.exception.ImproperExpressionException;

/**
 * @author Henry Hu
 *
 */
public class Recognizer {
	private String expression;

	/**
	 * @throws ImproperExpressionException
	 * 
	 */
	public Recognizer(String expression) throws ImproperExpressionException {
		// TODO Auto-generated constructor stub
		expression.replace(" ", "");
		if (!check(expression))
			throw new ImproperExpressionException("Inputed expression is incorrect");
		this.setExpression(expression);

	}

	public static boolean check(String expression) {
		int[] array = expression.chars().toArray();
		int leftBracket = 0, rightBracket = 0;
		boolean bracketFirst = false, bracketLast = false;
		for (int i = 0; i < array.length; i++) {
			int charID = array[i];

			char character = (char) charID;
			if (character == '(') {
				leftBracket++;
				continue;
			} else if (character == ')') {
				rightBracket++;
			}
		}
		if (leftBracket == rightBracket) {
			for (int i = 0; i < array.length; i++) {
				char character = (char) array[i];
				if (character == '(') {
					bracketFirst = true;
					break;
				} else if (character == ')') {
					bracketFirst = false;
					break;
				}
			}

			for (int i = 0; i < array.length; i++) {
				char character = (char) array[array.length - i - 1];
				if (character == ')') {
					bracketLast = true;
					break;
				} else if (character == '(') {
					bracketLast = false;
					break;
				}
			}
			return bracketFirst && bracketLast;
		}
		return false;
	}

	public double getValue() {
		int[] array = expression.chars().toArray();

		int beginIndex = 0;
		int endIndex = array.length;
		boolean bracket = false;
		for (int i = 0; i < array.length; i++) {
			int charID = array[i];

			char character = (char) charID;
			if (character == '(') {
				bracket = true;
				beginIndex = i + 1;
				continue;
			} else if (character == ')') {
				endIndex = i;
				break;
			}
		}
		String subStr = expression.substring(beginIndex, endIndex);
		// TODO Finish this part

		double output = 0;
		return output;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

}
