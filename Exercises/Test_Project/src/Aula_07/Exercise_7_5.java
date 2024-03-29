/* For information about the exercise, check the folder class_contents */
package Aula_07;

import static java.lang.System.*;
import java.util.Scanner;

public class Exercise_7_5 {
	
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		requireEA();
	    out.println("Type some words, terminated by end-of-file (Ctrl+D).");
	    DynamicArray<String> words = new DynamicArray<>();
	    int n = 0;
	    while (input.hasNext()) {
	      String word = input.next();
	      words.set(n, word);
	      n++;
	    }

	    out.printf("Final words.length() = %d\n", words.length());
	    for (int p = words.length()-1; p > 0; p = p/2) {
	      out.printf("words.get(%d) = %s\n", p, words.get(p));
	    }
	    
	    DynamicArray<Boolean> numbers = new DynamicArray<>();
	    numbers.set(23, true);
	    numbers.set(12, true);
	    numbers.set(30, true);
	    numbers.set(2, true);
	    numbers.set(11, true);
	    out.println("Loto numbers:");
	    for (int i = 1; i <= 49; i++) {
	      if (numbers.get(i, false))
	        out.printf("%2s", "X");
	      else
	        out.printf("%2d", i);
	      if (i % 7 == 0)
	        out.println();
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
