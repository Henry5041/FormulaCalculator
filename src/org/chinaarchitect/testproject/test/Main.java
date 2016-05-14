package org.chinaarchitect.testproject.test;

import java.util.HashSet;

import org.chinaarchitect.testproject.pattern.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] c = { 1, 2, 3, 4 };
		Pattern<Integer> pat = new Pattern<Integer>(c);
		HashSet<Integer[]> patterns = pat.Iterate();
		for (Integer[] eachGroup : patterns) {
			System.out.println(new Pattern<Integer>(eachGroup).toString(","));
		}

		System.out.println("End");
	}

}
