/* For information about the exercise, check the folder class_contents */
package Aula_11;

import static java.lang.System.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class Exercise_11_2 {

	public static void main(String[] args) {
		KeyValueList<Integer> counts = new KeyValueList<>();

	    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
	    	File fin = new File(args[a]);
	    	// Using a try-with-resources:
	    	try (Scanner scf = new Scanner(fin)) {
	    		while (scf.hasNextLine()) { // Processa cada linha
	    			String line = scf.nextLine();
	    			// Divide a linha em "palavras", considerando como separador
	    			// qualquer sequência de 1 ou mais carateres não alfabéticos:
	    			String[] palavras = line.split("[^\\p{IsAlphabetic}]+");
	    			// (Sobre expressões regulares usadas no split: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
	    			
	    			for (int i = 1; i < palavras.length; i += 2) { // Processa cada palavra
	    				if(counts.contains(palavras[i])) {
	    					assert counts.set(palavras[i], (int) counts.get(palavras[i]) + 1) : "ERROR saving the values";
	    				}else 
	    					assert counts.set(palavras[i], 1) : "ERROR saving the values";
	    			}
	    		}
	    	}catch (Exception e) {
	    		err.println("ERRO: " + e.getMessage());
	    	}
	    }
	    out.println(counts.toString("Results:\n", ";\n", "\nEnd"));
	    out.println(counts.toString()); // mesma lista, outro formato
	    mostFrequent(counts);
	}

	// Find and print the key with most occurrences
	// and its relative frequency.
	static void mostFrequent(KeyValueList<Integer> counts) {
		int oc = -1, counter = 0;
		String keyOut = "";
		for (String key : counts.keys()) {
			int tempKey = counts.get(key);
			counter += tempKey;
			if(tempKey > oc) {
				keyOut = key;
				oc = tempKey;
			}
		} // %% escape the string format
		System.out.printf("Most frequent: %s (%.2f%%) \n", keyOut, (double) ((double) oc * 100 / (double)counter));

	}
}
