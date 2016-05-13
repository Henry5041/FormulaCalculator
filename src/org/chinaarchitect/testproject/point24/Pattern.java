package org.chinaarchitect.testproject.point24;

import java.util.HashSet;

public class Pattern<T> {
	private T[] pattern;

	public Pattern(T[] pattern) {
		setPattern(pattern);
	}

	public T[] getPattern() {
		return pattern;
	}

	public void setPattern(T[] pattern) {
		this.pattern = pattern;
	}

	public String toString() {
		String output = "";
		for (T element : pattern) {
			if (output == "")
				output = element.toString();
			else
				output = output + "\n" + element.toString();
		}
		return output;
	}

	public HashSet<T[]> Iterate() {
		// TODO finish this part
		HashSet<T[]> patterns = new HashSet<T[]>();
		int[] time = new int[pattern.length];
		// Make all elements in array time equal to pattern's length
		if (time != null) {

			for (int i = 0; i < time.length; i++) {

				time[i] = pattern.length;

			}

		}
		Circulation cir = new Circulation(time);
		cir.circulate(new Code() {
			public void body(int[] time) {
				T[] pat = pattern.clone(); // Create an array with the same
											// length of pattern
				for (int i : time) {
					// TODO finish this loop
				}
				if (pat != null) {
					// Give the pattern a new order
					for (int i = 0; i < pat.length; i++) {

						pat[i] = pattern[time[i]];

					}

				}
				patterns.add(pat);
			}
		});

		return patterns;
	}

}
