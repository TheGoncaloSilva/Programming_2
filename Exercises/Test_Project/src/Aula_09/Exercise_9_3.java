/* For information about the exercise, check the folder class_contents */
package Aula_09;

import static java.lang.System.*;
import java.util.Arrays;    // to use Java's array operations

public class Exercise_9_3 {
	public static void main(String[] args) {
		if (args.length < 1) {
	    	err.println("Test sorting algorithms for an array of size N.");
	    	err.println("Usage: java -ea TestSorting N ...");
	    	exit(1);
	    }
	    
	    // Labels for array data orders:
	    String[] arrayType = {"random", "sorted", "reverse"};

	    // Labels of algorithms to test:
	    String[] algorithm = {"Sequential", "Bubble", "Insertion", "Merge"};

	    // Table header:
	    out.printf("%-7s\t%-15s\t%7s\t%15s\t%15s\t%7s\t%-4s\n",
	    "Data", "Algorithm", "Size", 
	        "Comparisons", "Assignments", "Time/s", "OK?");
	    
	    int n = Integer.parseInt(args[0]);
	    // Create 3 arrays, each with n numbers, in 3 different orders:
	    int[][] arrays = new int[3][];
	    arrays[0] = randomArray(n, 2*n);  // n random numbers, in random order
	    arrays[1] = arrays[0].clone();
	    Arrays.sort(arrays[1]);           // same numbers, in increasing order
	    arrays[2] = reverseOf(arrays[1]); // same numbers, in decreasing order
	    
	    // For each data order, apply each algorithm:
	    for (int j = 0; j < 3; j++) {
	    	for (int k = 0; k < algorithm.length; k++) {
	    		int[] aCopy = arrays[j].clone();
	        
	    		Sorting.startMeasuring();

	    		if (k == 0)
	    			Sorting.sequentialSort(aCopy, 0, aCopy.length);
	    		else if (k == 1)
	    			Sorting.bubbleSort(aCopy, 0, aCopy.length);
	    		else if (k == 2)
	    			Sorting.insertionSort(aCopy, 0, aCopy.length);
	    		else if (k == 3)
	    			Sorting.mergeSort(aCopy, 0, aCopy.length);

	    		Sorting.stopMeasuring();

	    		// Check if sorting worked (by comparing with Java's sort result):
	    		String worked = Arrays.equals(aCopy, arrays[1])? "OK" : "FAIL";

	    		out.printf("%-7s\t%-15s\t%7d\t%15d\t%15d\t%7.3f\t%-4s\n",
	            arrayType[j], algorithm[k], n,
	            Sorting.comparisonCount, Sorting.assignmentCount, Sorting.elapsedTime, worked);
	    	}
	    }
	}

	/**
	* Creates an array filled with random integers in the interval [0; max].
	* @param len length of the array.
	* @param max maximum random value.
	* @return the array
	*/
	static int[] randomArray(int len, int max) {
		assert len >= 0;
	    assert max >= 0;
	    int[] result = new int[len];
	    for (int i = 0; i < len; i++)
	    	result[i] = (int)(Math.random()*(max+1));
	    return result;
	}

	/** Reverse copy of array.
	* @param a original array
	* @return an array with the elements of a, in reverse
	*/
	static int[] reverseOf(int[] a) {
		int len = a.length;
	    int[] result = new int[len];
	    for (int i = 0; i < len; i++)
	    	result[i] = a[len-1-i];
	    return result;
	}
}
