package org.chinaarchitect.calculator.point24;

import java.util.HashSet;

import org.chinaarchitect.calculator.formula.Calculable;
import org.chinaarchitect.calculator.formula.Constant;
import org.chinaarchitect.calculator.pattern.Circulation;
import org.chinaarchitect.calculator.pattern.Code;

/**
 * @author Henry Hu
 *
 */
public class PointMatcher {
	public Integer[] array;
	Integer target;

	/**
	 * @param array
	 *            array of numbers inputed
	 * @param target
	 *            the number want to achieve through calculation
	 */
	public PointMatcher(Integer[] array, Integer target) {
		this.array = array;
		this.target = target;

	}

	/**
	 * 
	 * @return the set of formulas from successive calculation which satisfies
	 *         the target
	 */
	public HashSet<String> getSuccessive() {
		HashSet<String> formulas = new HashSet<String>();
		double faultTolerance = 0.000001;
		int[] loop = new int[array.length - 1];

		// Set all cycle numbers of all looping layers to the number of
		// operation kinds
		for (int i = 0; i < loop.length; i++) {
			loop[i] = 6;
		}
		Circulation operationCir = new Circulation(loop);
		operationCir.circulate(new Code() {
			public void body(int[] time) {

				Calculable finalFormula = new Constant(array[0]);
				// Generate the formula
				for (int i = 1; i <= loop.length; i++) { // TODO Fix the problem
					finalFormula = operationSwitch(finalFormula, new Constant(array[i]), new Integer(time[i - 1]));
				}
				// Test this formula
				if ((finalFormula.getValue() >= target - faultTolerance)
						&& (finalFormula.getValue() <= target + faultTolerance)) {
					formulas.add(finalFormula.toString());
				}
			}
		});
		return formulas;
	}

	/**
	 * 
	 * @param firstFormula
	 * @param secondFormula
	 * @param operationCase
	 *            the ID of the operation you want to use through this method
	 * @return a new formula combined with the two inputed formulae
	 */
	public Calculable operationSwitch(Calculable firstFormula, Calculable secondFormula, Integer operationCase) {
		Calculable finalFormula = null;
		switch (operationCase) {
		case 0:
			finalFormula = firstFormula.plus(secondFormula);
			break;
		case 1:
			finalFormula = firstFormula.minus(secondFormula);
			break;
		case 2:
			finalFormula = secondFormula.minus(firstFormula);
			break;
		case 3:
			finalFormula = firstFormula.multiply(secondFormula);
			break;
		case 4:
			finalFormula = firstFormula.divide(secondFormula);
			break;
		case 5:
			finalFormula = secondFormula.divide(firstFormula);
			break;
		default:

		}
		return finalFormula;

	}

}
