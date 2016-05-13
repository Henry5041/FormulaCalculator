package org.chinaarchitect.testproject.test;

import org.chinaarchitect.testproject.point24.Circulation;
import org.chinaarchitect.testproject.point24.Code;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = { 1, 2, 3 };
		Circulation cir = new Circulation(c);
		new Code() {
			public void body(int[] time) {
				System.out.println("a");
			}
		}.body(c);
		cir.circulate(new Code() {
			public void body(int[] time) {
				System.out.print(time[2]);
			}
		});
	}

}
