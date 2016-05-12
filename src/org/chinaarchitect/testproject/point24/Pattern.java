package org.chinaarchitect.testproject.point24;

import java.util.HashSet;

public class Pattern {
	private Object[] pattern;

	public Pattern(Object[] pattern) {
		setPattern(pattern);
	}

	public Object[] getPattern() {
		return pattern;
	}

	public void setPattern(Object[] pattern) {
		this.pattern = pattern;
	}

	public String toString() {
		String output = "";
		for (Object element : pattern) {
			if (output == "")
				output = element.toString();
			else
				output = output + "\n" + element.toString();
		}
		return output;
	}

	public HashSet<Object[]> Iterate() {
		HashSet<Object[]> patterns = new HashSet<Object[]>();
		// TODO finish this part
		return patterns;
	}
}
