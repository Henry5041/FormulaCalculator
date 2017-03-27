package org.chinaarchitect.testproject.test;

import java.util.Scanner;

import org.chinaarchitect.calculator.formula.Addition;
import org.chinaarchitect.calculator.formula.Calculable;
import org.chinaarchitect.calculator.formula.Constant;
import org.chinaarchitect.calculator.formula.Function;

public class FormulaMain {

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
