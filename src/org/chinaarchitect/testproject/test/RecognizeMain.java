package org.chinaarchitect.testproject.test;

import java.util.Scanner;

import org.chinaarchitect.calculator.exception.ImproperExpressionException;
import org.chinaarchitect.calculator.recognize.Recognizer;

public class RecognizeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String exp = in.next();
		try {
			Recognizer rec = new Recognizer(exp);
			System.out.println(rec.getExpression());
		} catch (ImproperExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
