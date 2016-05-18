package org.chinaarchitect.calculator.formula;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		Calculable[] exp = new Calculable[5];

		for (int i = 0; i < 5; i++) {
			Constant c = new Constant(in.nextDouble());
			exp[i] = c;
		}
		System.out.println(new Function(exp));
		System.out.println(new Addition(exp));
		System.out.println(new Addition(exp).getValue());
		in.close();
	}

}
