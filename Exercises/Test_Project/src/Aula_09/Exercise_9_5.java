/* For information about the exercise, check the folder class_contents */
package Aula_09;

import static java.lang.System.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Exercise_9_5 {

	public static void main(String[] args) {
		if (args.length < 1) {
			err.println("Usage: java -ea ListSort <file> ...");
	        exit(1);
		}

		LinkedList<String> lines = new LinkedList<>();
		for(int a = 0; a < args.length; a++) {
			File fin = new File(args[a]);
	        readLines(fin, lines);
		}
		quickSort(lines);

		lines.print();
	}

	// Read lines from a file and append them to a list
	static void readLines(File fin, LinkedList<String> lst) {
		try {
			// read the lines
	        Scanner scf = new Scanner(fin);
	        while (scf.hasNextLine()) {
	        	lst.addLast(scf.nextLine());
	        }
	        scf.close();
		} catch (IOException e) {
			err.println(e);
	        exit(1);
		}
	}

	/** A quick sort on a generic list.
	* @param lst is a linked list containing comparable elements.
	* The list is sorted 'in-place'.
	*/
	public static <T extends Comparable<T>> void quickSort(LinkedList<T> lst) {
		if (lst.size() > 1) {
			// Take first element as a pivot value:
			T pivot = lst.first(); lst.removeFirst();

	        // A list for elements smaller than the pivot:
	        LinkedList<T> smaller = new LinkedList<T>();
	        // A list for elements not smaller than the pivot:
	        LinkedList<T> greater = new LinkedList<T>();
	        
	        // Now, take each element from lst and append it
	        // to the smaller list, if element < pivot, or
	        // to the greater list, otherwise.
	        //... FILL IN THE CODE ...
	        // Another solution
	        /*Node<T> n = lst.getNode(); // Created new function in LinkedList to return the node.first
	        for(int i = 0; i < lst.size(); i++) {
	        	if(n.elem.compareTo(pivot) < 1)
	        		smaller.addLast(n.elem);
	        	else
	        		greater.addLast(n.elem);
	        	n = n.next;
	        }*/
	        int maxVal = lst.size();
		    for(int i = 0; i < maxVal; i++) {
	        	T value = lst.first();
	        	lst.removeFirst();
	        	if(value.compareTo(pivot) < 1)
	        		smaller.addLast(value);
	        	else
	        		greater.addLast(value);
	        }
		    
	        // The lst should be empty now:
	        assert lst.isEmpty();

	        // Sort each of the lists:
	        quickSort(smaller);
	        quickSort(greater);
	        
	        // Transfer smaller elements back to lst:
	        //... FILL IN THE CODE ...
	        maxVal = smaller.size();
	        for(int i = 0; i < maxVal; i++) {
	        	lst.addLast(smaller.first());
	        	smaller.removeFirst();
	        }
	        
	        // Append the pivot:
	        lst.addLast(pivot);
	        
	        // Transfer greater elements back to lst:
	        //... FILL IN THE CODE ...
	        maxVal = greater.size();
	        for(int i = 0; i < maxVal; i++) {
	        	lst.addLast(greater.first());
	        	greater.removeFirst();
	        }
		}
	}
}
