/* For information about the exercise, check the folder class_contents */
package Aula_06;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

public class Exercise_6_3 {
	public static void main(String[] args) {
		if(args.length == 0) {
			err.println("Arguments need to be provided");
			exit(1);
		}
		printArray(args, args.length);
	}

	/** Imprime as N primeiras strings do array, uma por linha. */
	public static void printArray(String[] array, int N) {		
		if(N > 0) {
			out.println(array[N-1]);
			printArray(array, N-1);
		}
		
		
	}
	
}

