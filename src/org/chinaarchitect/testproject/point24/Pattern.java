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
		HashSet<T[]> patterns = new HashSet<T[]>();
		// TODO finish this part
		return patterns;
	}

}
