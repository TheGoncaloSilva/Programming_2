package Aula_11;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.File;
import java.util.Scanner;

public class Exercise_11_3 {

	public static void main(String[] args) {
		requireEA();
		assert args.length > 0 : "The program requires an argument";
		
		System.out.println("Comando: " + args[0]);
		String[] args2 = {"./src/Aula_11/numbers.txt"};
		KeyValueList<Integer> counts = readFile(args2);
		
		StringBuilder sBuilder = new StringBuilder();
		StringBuilder sBuilder2 = new StringBuilder();
		
		String[] Parts = args[0].split(" ");
		for (String word : Parts) {
			if(counts.contains(word)) {
				sBuilder2.append(counts.get(word) + " ");
			}
			sBuilder.append(word + " ");
		}
		
		Parts = sBuilder2.toString().split(" ");
		int result = 0;
		if(Parts.length > 1) { // construir em forma crescente
			for(int i = 0; i < Parts.length; i++) {
				if(Parts[i].equalsIgnoreCase("1000000") || Parts[i].equalsIgnoreCase("1000") || Parts[i].equalsIgnoreCase("100"))
					result *= Integer.parseInt(Parts[i]);
				else
					result += Integer.parseInt(Parts[i]);
			}
			System.out.println(sBuilder.toString() + " -> " + result);
		}else
			System.out.println(sBuilder.toString() + " -> " + sBuilder2.toString());

	}
	
	@SuppressWarnings("unchecked")
	public static <E> KeyValueList<E> readFile(String[] args){
		KeyValueList<Integer> counts = new KeyValueList<>();

	    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
	    	File fin = new File(args[a]);
	    	// Using a try-with-resources:
	    	try (Scanner scf = new Scanner(fin)) {
	    		while (scf.hasNextLine()) { // Processa cada linha
	    			String line = scf.nextLine();
	    			// Divide a linha em "palavras", considerando como separador
	    			// qualquer sequência de 1 ou mais carateres não alfabéticos:
	    			String[] palavras = line.split(" - ");
	    			// (Sobre expressões regulares usadas no split: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html)
	    			
	    			for (int i = 1; i < palavras.length; i += 2) { // Processa cada palavra
	    				if(!counts.contains(palavras[i])) {
	    					assert counts.set(palavras[i], Integer.parseInt(palavras[i - 1])) : "ERROR saving the values";
	    				}
	    					
	    			}
	    		}
	    	}catch (Exception e) {
	    		err.println("ERRO: " + e.getMessage());
	    	}
	    }
	    
	    return (KeyValueList<E>) counts;
		
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
