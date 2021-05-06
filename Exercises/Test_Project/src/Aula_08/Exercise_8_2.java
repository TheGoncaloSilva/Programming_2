/* For information about the exercise, check the folder class_contents */
package Aula_08;

import static java.lang.System.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_8_2 {
	
	public static SortedListInt list = new SortedListInt();

	public static void main(String[] args) throws FileNotFoundException {
		requireEA();
		assert args.length > 0 : "Files need to be provided";
		for(int i = 0; i < args.length; i++) {
			readFile(args[i]);
		}

	}
	
	public static void readFile(String file) throws FileNotFoundException {
		File f = new File(file);
		assert f.isFile() : "The provided path : " + file + " doesn't correspond to a valid file";
		assert f.canRead() : "The provided file path: " + file + " cannot be read";
		Scanner read = new Scanner(f);
		int n = 0;
		while(read.hasNext()) {
			try {
				n = read.nextInt();
				list.insert(n); // save the value in the list
				
			}catch (InputMismatchException e) {
				err.println("String character found!");
				read.next(); //Skip the current value string found
			}
		}
	}
	
	public void printNumbers() {
		
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
