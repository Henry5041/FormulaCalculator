package org.chinaarchitect.calculator.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * A class for pattern operations
 * 
 * @author Henry Hu
 *
 * @param <T>
 *            Type of the elements in the pattern
 */
public class Pattern<T> implements Cloneable {
	private T[] array;

	public Pattern(T[] array) {
		setArray(array);
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T[] pattern) {
		this.array = pattern;
	}

	@Override
	public String toString() {
		String output = "";
		for (T element : array) {
			if (output == "") // Judge if the element is the first one
				output = element.toString();
			else
				output += "\n" + element.toString();
		}
		return output;
	}

	/**
	 * 
	 * @param separator
	 * @return
	 */
	public String toString(String separator) {
		String output = "";
		for (T element : array) {
			if (output == "")
				output = element.toString();
			else
				output += separator + element.toString(); // Output with the
															// given separator
		}
		return output;
	}

	public HashSet<T[]> iterate() {
		// TODO finish this part
		HashSet<T[]> patterns = new HashSet<T[]>();
		int[] loop = new int[array.length];
		if (loop != null) {

			for (int i = 0; i < loop.length; i++) { // Make all elements in
													// array time equal to
													// array's length

				loop[i] = array.length;

			}

		}
		Circulation cir = new Circulation(loop);
		cir.circulate(new Code() {
			public void body(int[] time) {
				T[] pat = array.clone(); // Create an array with the same
											// length of array
				boolean repeat = false;

				// Judge if any two elements in the time array are the same
				Loop: for (int i = 0; i < time.length; i++) {
					for (int j = i + 1; j < time.length; j++) {
						if (time[i] == time[j]) {
							repeat = true;
							break Loop;
						}
					}
				}
				if (!repeat) {
					if (pat != null) {
						// Give the array a new order
						for (int i = 0; i < pat.length; i++) {

							pat[i] = array[time[i]];

						}
						patterns.add(pat);
					}
				}

			}
		});

		return patterns;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void disorganize() {
		ArrayList<T> list = new ArrayList<T>(array.length);
		for (T element : array) {
			list.add(element);
		}
		Collections.shuffle(list);

		array = list.toArray(array);

	}
}
