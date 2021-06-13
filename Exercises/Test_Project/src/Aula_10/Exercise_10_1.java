/* For information about the exercise, check the folder class_contents */
package Aula_10;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.util.Scanner;

public class Exercise_10_1 {

	public static void main(String[] args) {
		requireEA();
		//assert args.length > 0 : "Arguments are needed to run the program";
		
		Scanner sc = new Scanner(System.in);
		
		out.println("Type the sentence/word ");
		out.print("-> ");
		String word = sc.nextLine();
		
		Stack pilha = new Stack();
		Queue fila = new Queue();
		int count = 0;
		while(word.length() > count) {
			char c = word.charAt(count);
			if(c != ' ') {
				pilha.push(Character.toLowerCase(c)); // Character.toLowerCase(c) para não haver problemas de maiúsculas e minúsculas
				fila.in(Character.toLowerCase(c)); // Character.toLowerCase(c) para não haver problemas de maiúsculas e minúsculas
			}
			count++;			
		}
		count = 0;
		while(count < (word.length() / 2)) {
			if(pilha.top() != fila.peek()) {
				out.println("The sentence is not a palindrome");
				exit(0);
			}else {
				pilha.pop();
				fila.out();
			}
			count++;
		}
		
		out.print("The sentence is a palindrome ");

		sc.close();
		
	}
	
	/** Check if program is being run with -ea, exit if not. */
	static void requireEA() {
		boolean ea = false;
	    assert ea = true; // assert with a side-effect, on purpose!
	    if (!ea) {
	      err.println("This program must be run with -ea!");
	      exit(1);
	    }
	}

}
