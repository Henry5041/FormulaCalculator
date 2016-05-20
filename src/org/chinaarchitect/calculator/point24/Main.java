package org.chinaarchitect.calculator.point24;

import java.util.HashSet;
import java.util.Scanner;

import org.chinaarchitect.calculator.pattern.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Integer[] num = new Integer[4];
		do {
			System.out.println("Please enter the correct 4 numbers:");
			for (Integer i = 0; i < num.length; i++) {
				num[i] = in.nextInt();

			}
		} while (!judge(num)); // Judge if the numbers are in the correct range.
		in.close();
		for (Integer[] pattern : patternIterator(num)) {
			// System.out.println(getFormula(pattern));
			output(pattern);
			PointMatcher matcher = new PointMatcher(pattern, 24);

			for (String eachFormula : matcher.getSuccessive()) {
				System.out.println(eachFormula);

			}
		}

		// TODO Fix this part

	}

	public static boolean judge(Integer[] num) {
		if (num != null) {

			for (Integer i = 0; i < num.length; i++) {

				if (num[i] < 1 || num[i] > 13) // Make sure they're acceptable
												// numbers
					return false;
			}

		}

		return true;

	}

	public static HashSet<Integer[]> patternIterator(Integer[] num) {
		// Iterate every possible patterns with the same 4 numbers
		Pattern<Integer> pat = new Pattern<Integer>(num);
		return pat.Iterate();
	}

	public static String getFormula(Integer[] pattern) {
		String result = "";
		for (Integer i = 0; i < 6; i++) {
			for (Integer j = 0; j < 6; j++) {
				for (Integer k = 0; k < 6; k++) {
					double successiveResult = calculator(
							calculator(calculator(pattern[0], pattern[1], i), pattern[2], j), pattern[3], k);
					if (successiveResult > 23.99999 && successiveResult < 24.00001) { // Reduce
																						// the
						// accuracy
						String successiveFormula = formulaWriter(formulaWriter(
								formulaWriter(Integer.toString(pattern[0]), Integer.toString(pattern[1]), i),
								Integer.toString(pattern[2]), j), Integer.toString(pattern[3]), k);
						result = result + "\n" + successiveFormula + " = " + successiveResult;
					}

					double groupedResult = calculator(calculator(pattern[0], pattern[1], i),
							calculator(pattern[2], pattern[3], j), k);
					if (groupedResult > 23.99999 && groupedResult < 24.00001) {
						String groupedFormula = formulaWriter(
								formulaWriter(Integer.toString(pattern[0]), Integer.toString(pattern[1]), i),
								formulaWriter(Integer.toString(pattern[2]), Integer.toString(pattern[3]), j), k);
						result = result + "\n" + groupedFormula + " = " + groupedResult;
					}

				}
			}
		}
		return result;
	}

	// TODO Write way of group calculation
	public static double calculator(double firstNum, double secondNum, Integer operationCase) {
		double finalNum = firstNum; // Initialize the finalNum
		switch (operationCase) {
		case 0:
			finalNum = firstNum + secondNum;
			break;
		case 1:
			finalNum = firstNum - secondNum;
			break;
		case 2:
			finalNum = secondNum - firstNum;
			break;
		case 3:
			finalNum = firstNum * secondNum;
			break;
		case 4:
			finalNum = ((double) firstNum / (double) secondNum); // Change type
																	// to
																	// increase
																	// the
																	// accuracy
			break;
		case 5:
			try {
				finalNum = ((double) secondNum / (double) firstNum);
			} catch (java.lang.ArithmeticException e) {
				// TODO add codes to handle the zero exception
			}
			break;
		}
		return finalNum;

	}

	// TODO Write way of group calculation
	public static String formulaWriter(String firstFormula, String secondFormula, Integer operationCase) {
		String result = "";
		switch (operationCase) {
		case 0:
			result = firstFormula + " + " + secondFormula;
			break;
		case 1:
			result = firstFormula + " - " + secondFormula;
			break;
		case 2:
			result = secondFormula + " - (" + firstFormula + ")"; // Add
																	// brackets
																	// to avoid
			// changing operations
			break;
		case 3:
			result = "(" + firstFormula + ") * (" + secondFormula + ")";
			break;
		case 4:
			result = "(" + firstFormula + ") / (" + secondFormula + ")";
			break;
		case 5:
			result = "(" + secondFormula + ") / (" + firstFormula + ")";
			break;
		}
		return result;

	}

	// method of testing
	public static void output(Integer[] array) {

		if (array != null) {

			for (Integer i = 0; i < array.length; i++) {

				System.out.print(array[i] + " ");

			}

		}

		System.out.println();

	}

}
