/* For information about the exercise, check the folder class_contents */
package Aula_01;

import static java.lang.System.*;
import java.util.Scanner;

public class Exercise_1_6 {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		out.println("Bem vindo ao adivinha o n�mero");
		/*Random rand = new Random();
		int jackpot = rand.nextInt((100 - 0) + 1); Alternativa */
		int jackpot = (int)(Math.random() * (100 + 1));
		int number;
		do{
			out.println("Escolha o n�mero");
			number = in.nextInt();
			if(number != jackpot) {
				stats(number, jackpot);
			}
		}while(number != jackpot);
		out.println("Parab�ns, acabou o jogo");
		
		in.close();
	}
	
	public static void stats(int number, int jackpot) {
		
		if(number < jackpot) {
			out.println("O n�mero � superior");
		}else {
			out.println("O n�mero � inferior");
		}
		
	}

}
