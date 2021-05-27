/* For information about the exercise, check the folder class_contents */
package Aula_10;

import static java.lang.System.*;

public class Exercise_10_1 {

	public static void main(String[] args) {
		requireEA();
		assert args.length > 0 : "Arguments are needed to run the program";
		
		Stack pilha = new Stack();
		Queue fila = new Queue();
		
		/* while(tamanho palavra) ou for
		 *  c = charat
		 *  pilha.push(c)
		 *  pilha.in(c)
		 * 
		 * while()
		 * 	pilha.top(0) == fila.peek() Não?? => Terminar, not Palindromo
		 * 	pilha.pop()
		 * 	fila.out()
		 * **** palindromo ****
		 */
		
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
