package org.chinaarchitect.testproject.test;

import java.util.Scanner;

import org.chinaarchitect.calculator.formula.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Integer[] c = { 1, 2, 3, 4 };
		// Pattern<Integer> pat = new Pattern<Integer>(c);
		// HashSet<Integer[]> patterns = pat.Iterate();
		// for (Integer[] eachGroup : patterns) {
		// System.out.println(new Pattern<Integer>(eachGroup).toString(","));
		// }
		//
		// System.out.println("End");
		Scanner in = new Scanner(System.in);

		System.out.print("a=");
		double a = in.nextDouble();
		System.out.print("b=");
		double b = in.nextDouble();
		System.out.print("c=");
		double c = in.nextDouble();
		System.out.print("d=");
		double d = in.nextDouble();

		System.out.print("x=");
		double x = in.nextDouble();
		System.out.print("y=");
		double y = in.nextDouble();
		System.out.print("z=");
		double z = in.nextDouble();
		System.out.print("w=");
		double w = in.nextDouble();

		Calculable f = new Multiplication(new Addition(new double[] { a, b, c }),
				new Subtraction(new double[] { x, y, z }));
		System.out.println("f=" + f);
		System.out.println(f.getValue());
		System.out.println(new Inverse(f).getValue());

		Calculable g = new Division(new Addition(new double[] { d, c, b }), new Subtraction(new double[] { w, z, y }));
		System.out.println("g=" + g);
		System.out.println(g.getValue());
		System.out.println(new Inverse(g).getValue());

		System.out.println(new Addition(f, g));
		System.out.println(new Subtraction(f, g));
		System.out.println(new Multiplication(f, g));
		System.out.println(new Division(f, g));
		in.close();
	}

}
