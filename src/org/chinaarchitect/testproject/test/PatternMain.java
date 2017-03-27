package org.chinaarchitect.testproject.test;

import java.util.HashSet;

import org.chinaarchitect.calculator.pattern.Pattern;

public class PatternMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = new Integer[25];
		for (int i = 0; i < 25; i++) {
			array[i] = i + 1;
		}

		Pattern<Integer> pat = new Pattern<Integer>(array);

		HashSet<Integer[]> set = pat.iterate();
		for (Integer[] eachArray : set) {
			for (int i = 0; i < 24; i++) {

			}
			System.out.println(new Pattern<Integer>(eachArray).toString(","));

		}
	}

	public boolean isPrime(int a, int b) {
		for (int i = 2; (i <= a) && (i <= b); i++) {
			if ((a % i == 0) && (b % i == 0)) {
				return false;
			}
		}
		return true;
	}
}
