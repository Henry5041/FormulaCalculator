package org.chinaarchitect.testproject.formula;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		Expressible[] exp = new Expressible[5];
		for (int i = 0; i < 5 ; i++){
			Constant c = new Constant(in.nextInt());
			exp[i] = c;
		}
		System.out.println(new Function(exp));
		in.close();
	}

}
