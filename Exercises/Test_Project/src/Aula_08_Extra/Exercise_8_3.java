/* For information about the exercise, check the folder class_contents */
package Aula_08_Extra;

import static java.lang.System.*;

public class Exercise_8_3 {
	// Apresenta
	// * os n�meros dados na linha de comando por ordem crescente;
	// * os restantes argumentos por ordem lexicogr�fica.  (FALTA FAZER!)
	// Utiliza duas listas ordenadas para fazer isto.

	public static void main(String[] args) {
		requireEA();
		assert args.length > 1 : "Arguments need to be provided <Number/Text>";
		// Uma lista para os n�meros:
	    SortedList<Double> numbers = new SortedList<Double>();
	    // Outra lista para as restantes strings:
	    SortedList<String> words = new SortedList<String>();

	    for (int i=0; i<args.length; i++) {
	    	try {
	    		// Converte args[i] para n�mero e guarda na lista:
	    		numbers.insert(Double.valueOf(args[i]));
	    	}catch  (NumberFormatException e) {
	    		// Caso n�o seja n�mero, guardar args[i] noutra lista:
	    		words.insert(args[i]);
	    	}
	    }

	    // Escrever a lista dos n�meros (destruindo-a):
	    out.printf("Numbers (%b):\n", numbers.isSorted());
	    while (!numbers.isEmpty()) {
	      out.println(numbers.first());
	      numbers.removeFirst();
	    }
	    out.println();
	    
	    // Escrever a lista do resto:
	    out.printf("Text (%b):\n", words.isSorted());
	    while (!words.isEmpty()) {
	      out.println(words.first());
	      words.removeFirst();
	    }
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

