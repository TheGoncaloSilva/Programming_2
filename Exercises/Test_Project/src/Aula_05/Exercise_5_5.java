/* For information about the exercise, check the folder class_contents */
// Path to alter in run config -> ./src/Aula05/cutColumn.txt
package Aula_05;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Exercise_5_5 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		requireEA();
		assert args.length == 1 : "The program needs a file to run";
		try {
			assert verifyFile(args[0]) : "File to read must be valid";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] data = readFile(args[0]);
		String[] parts = data[0].split("[ \t]+");
		assert data.length > 2 : "The number of lines must be greater";
		
		int[] values = minMax(parts); // min and max values
		assert values.length == 2 : "Max size of array exceeded";
		int number = 0;
 		do {
			out.println("Choose a number");
			try {
				number = in.nextInt();
				if(number >= values[0] && number <= values[1]) {
					break;
				}else {
					err.println("value not in range!");
				}
			} catch (InputMismatchException e) {
				err.println("Invalid Type!");
				in.nextLine();
			}
		}while(true);
 		
 		// number contains the value of the word that is chosen by the user
 		
 		// value stars at 1, because we already processed the first line
 		int aux = 0; // aux value to be used
 		for(int i = 1; i < data.length; i++) {
 			String[] words = data[i].split("[ \t]+");
 			if(words.length >= number) { // if the number is smaller than the lenght of the current line
 				System.out.println(words[(number - 1)]); // then this line has out option
 				break;
 			}else aux += words.length; // if the number is bigger than the current line, will proceed to the next one
 		}								// but will take into account the number of words read by our program
 		out.println();
 		out.println("Program finished with success!");
 		in.close();
		
	}
	public static int[] minMax(String[] parts) {
		//Getting the min and max values
		int min = Integer.parseInt(parts[0]), max = Integer.parseInt(parts[1]);
		for(int i = 0; i < parts.length; i++) {
			if(Integer.parseInt(parts[i]) < min) min = Integer.parseInt(parts[i]);
			if(Integer.parseInt(parts[i]) > max) max = Integer.parseInt(parts[i]);
		}
		
		return new int[] {min, max}; 
	}
	
	public static String[] readFile(String file) throws FileNotFoundException {
		assert file != null;
		File fin = new File(file);
		Scanner fRead = new Scanner(fin);
		int aux = 0;
		String[] parts = new String[10];
		
		while(fRead.hasNextLine()) {
			parts[aux] = fRead.nextLine();
			aux++;
		}
		assert aux > 2 : "The file must have more lines";
		fRead.close();
		
		return parts;
	}
	
	public static boolean verifyFile(String path) throws FileNotFoundException {
		boolean good = false;
		File fin = new File(path); //declarar o ficheiro
		if(fin.exists()) {
			if(fin.isFile()) {
				if(fin.canRead()) {
					if(fin.canWrite()) {
						good = true;
					}else {
						System.err.println("ERROR: file " + path + " cannot be Written!");
				        exit(6);
					}
				}else {
					System.err.println("ERROR: file " + path + " cannot be read!");
		            exit(5);
				}
			}else {
	            System.err.println("ERROR: Path " + path + " is not a file!");
	            exit(4);
			}
		}else {
            System.err.println("ERROR: Path " + path + " doens't exist!");
            exit(3);
		}
		return good;
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
