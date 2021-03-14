/* For information about the exercise, check the folder class_contents*/
package Aula_01;

import static java.lang.System.*;
import java.util.Scanner;

public class Exercise_1_5 {
	public static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) {
		double number, sum = 0.0;
		int times = 0;
		do {
			out.println("Introduza um número");
			number = in.nextInt();
			sum += number;
			times++;
		}while(number != 0);
		times--; // retirar a contagem do 0
		stats(sum, times);

	}
	
	public static void stats(double sum, int times) {
		out.println("Soma: " + sum);
		if(sum != 0) {
			out.println("Média: " + (sum / times));
		}

	}

}
