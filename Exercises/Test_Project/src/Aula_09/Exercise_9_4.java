/* For information about the exercise, check the folder class_contents */
package Aula_09;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.util.Arrays;

public class Exercise_9_4 {
	public static void main(String[] args) {
		requireEA();
		assert args.length >= 1 : "TestGenericSort uses multiple values to order, please include one or more arguments";
		
		String[] array = args;
		
		// Sort the first n elements in the array with our algorithm:
		Sorting.mergeSort(array, 0, array.length);
    
		// Print the result:
		out.println(Arrays.toString(array));
		
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
