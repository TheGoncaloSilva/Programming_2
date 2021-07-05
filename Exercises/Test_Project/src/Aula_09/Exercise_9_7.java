/* For information about the exercise, check the folder class_contents */
package Aula_09;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_9_7 {

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length < 1) {
			err.println("Usage: java GetWords <file>");
		    exit(1);
		}
		String[] Files = new String[args.length + 1];
		System.arraycopy(args, 0, Files, 0, args.length);
		Files[Files.length - 1] = "./src/Aula_09/Files/words.txt";
		
		int count = 0;
		String[] words = new String[0];
		for(int i = 0; i < Files.length; i++) {
			File fin = new File(Files[i]);
			String[] aux = extractWords(fin);
			String[] aux2 = words;
			count += aux.length;
			words = new String[(aux.length + aux2.length)];
			int a;
			for(a = 0; a < aux2.length; a++)
				words[a] = aux2[a];
			for(int l = 0; l < aux.length; l++)
				words[a++] = aux[l];
			
			assert a == (aux.length + aux2.length); // garantee that the array has been populated 
		}
		//File fin = new File(args[0]);
		//String[] words = extractWords(fin);
		
		// Sort the first n elements in the array with our algorithm:
		Sorting.mergeSort(words, 0, words.length);
		
		File fout = new File("./src/Aula_09/Files/words.txt");
		PrintWriter pwf = new PrintWriter(fout);
		
		for(int i = 0; i < words.length; i++) {
			out.printf("[%05d] %s\n", i+1, words[i]);
			pwf.printf("[%05d] %s\n", i+1, words[i]);
		}
		pwf.close();
		
		System.out.println("Total words: " + words.length);
		}

		// Read words from a file, return words in an array
	static String[] extractWords(File fin) {
		try {
			// count the words
			int n = 0;
			Scanner scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
			// (words are delimited by 1 or more punctuation or whitespace char)
			while (scf.hasNext()) {
				scf.next();
		        n++;
			}
		    scf.close();

		    // create the array
		    String[] result = new String[n];

		    // read the words
		    int i = 0;
		    scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
		    while (scf.hasNext()) {
		    	result[i] = scf.next();
		        i++;
		    }
		    scf.close();

		    return result;
		}catch (IOException e) {
			err.printf("Error: %s\n", e);
			exit(1);
		    return null;  // never happens...
		}
	}
}
