package org.chinaarchitect.testproject.test;

import java.util.HashSet;
import java.util.Scanner;

import org.chinaarchitect.calculator.pattern.Pattern;
import org.chinaarchitect.calculator.point24.PointMatcher;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer[] firstPattern = new Integer[4];
		System.out.println("Please enter the correct 4 numbers:");
		for (Integer i = 0; i < firstPattern.length; i++) {
			firstPattern[i] = in.nextInt();
		}
		in.close();
		HashSet<String> formulas = new HashSet<String>();
		for (Integer[] pattern : new Pattern<Integer>(firstPattern).iterate()) {
			// System.out.println(getFormula(pattern));
			PointMatcher matcher = new PointMatcher(pattern, 24);

			formulas.addAll(matcher.getSuccessive());
		}
		for (String str : formulas) {
			System.out.println(str);

		}

	}

}
