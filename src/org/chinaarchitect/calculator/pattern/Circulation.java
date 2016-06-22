package org.chinaarchitect.calculator.pattern;

/**
 * 
 * @author Henry Hu
 *
 */
public class Circulation {
	private int[] loop;
	private int[] time;
	private int depth;

	/**
	 * 
	 * @param loop
	 *            An array that decides how many times each depth of circulation
	 *            runs. loop[0] for the outer layer, loop[1] for the second
	 *            layer, etc.
	 */
	public Circulation(int[] loop) {
		setLoop(loop);
		time = new int[loop.length];
		depth = 0;
	}

	public int[] getLoop() {
		return loop;
	}

	public void setLoop(int[] loop) {
		this.loop = loop;
	}

	/**
	 * 
	 * @param code
	 *            The code you want to execute in the circulation. Must
	 *            implements interface Code.
	 */
	public <T extends Code> void circulate(T code) {

		for (; time[depth] < loop[depth]; time[depth]++) {
			depth++; // Depth added one for entering a new inner loop
			if (depth < loop.length) { // Detects if it's the deepest depth

				circulate(code);
				time[depth] = 0;
			} else {
				code.body(time);
			}
			depth--; // Depth minus one for quitting a inner loop

		}

	}

}
