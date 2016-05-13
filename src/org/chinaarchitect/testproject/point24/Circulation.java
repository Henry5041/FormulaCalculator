package org.chinaarchitect.testproject.point24;

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
			depth++;
			if (depth < loop.length) {

				circulate(code);
				time[depth] = 0;
			} else {
				code.body(time);
			}
			depth--;

		}

	}

}
