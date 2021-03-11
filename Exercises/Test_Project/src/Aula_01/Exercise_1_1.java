/* For information about the exercise, check the folder class_contents*/
package Aula_01;

import static java.lang.System.*;
import java.util.Scanner;

public class Exercise_1_1 {
	
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		out.println("### BEM-VINDO - calculate all you need ###");
		String input = in.nextLine();
		String[] temp = input.split(" ");
		double n1 = Double.parseDouble(temp[0]);
		if(operator(temp[1])) {
			double n2 = Double.parseDouble(temp[2]);
			out.println("O resultado da operação é: " + operation(n1, n2, temp[1]));
		}else {
			err.println("Operator not supported");
		}
		in.close();
	}
	
	public static boolean operator(String op) {
		boolean decision = false;
		if(op.length() == 1) {
			if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
				decision = true;
			}
		}
		return decision;
	}
	
	public static double operation(double n1, double n2, String op) {
		if(op.equals("+")) {
			return n1 + n2;
		}else if(op.equals("-")) {
			return n1 - n2;
		}else if(op.equals("*")) {
			return n1 * n2;
		}else if(op.equals("/")) {
			return n1 / n2;
		}else{
			return 0.0;
		}
	}
}
