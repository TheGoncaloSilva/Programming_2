/* For information about the exercise, check the folder class_contents */
package Aula_12;

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;
import java.io.File;

public class Exercise_12_1 {
	final static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		HashTable<Integer> ht = new HashTable<>(20);

	    for (int i=0; i<30; i++)
	      ht.set(""+i, i*i);

	    // Test keys():
	    String[] k = ht.keys();
	    out.printf("ht.keys() -> %s\n", Arrays.toString(k));
	    assert k.length == ht.size();

	    out.println("------------------------");

	    // Test toString():
	    out.printf("ht.toString() -> \"%s\"\n", ht.toString());
	}
}
