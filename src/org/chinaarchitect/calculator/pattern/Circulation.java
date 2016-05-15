package org.chinaarchitect.calculator.pattern;

public class Circulation {
	private int[] loop;
	private int[] time;
	private int depth;

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
