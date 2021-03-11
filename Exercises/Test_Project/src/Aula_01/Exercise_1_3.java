/* For information about the exercise, check the folder class_contents*/
/* Um número primo só pode ter dois divisores, 1 e ele próprio, sendo assim, o maior divisor
 * de um número primo é ele próprio
 */
package Aula_01;

import static java.lang.System.*;
import java.util.Scanner;


public class Exercise_1_3 {
	 public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
	    while (true) {
	      out.print("N? ");
	      n = in.nextInt();
	      if (n > 0) break;
	      err.println("ERROR: invalid number!");
	    }

	    String verb = isPrime(n)? "is" : "is not";
	    out.printf("Number %d %s prime\n", n, verb);
	    
	    in.close();
	  }

	  public static boolean isPrime(int n) {
	    // Complete a função para verificar se é primo...
		boolean decision = false;
		int aux = 0;
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				aux++;
			}
		}
		if(aux == 2) {
			decision = true;
		}
		return decision;
	  }
	}

