/* For information about the exercise, check the folder class_contents */
package Aula_06;

import static java.lang.System.*;

import java.util.Arrays;

public class Exercise_6_6 {

	public static void main(String[] args) {
		int N = 3;
	    switch (args.length) {
	    case 1:
	      break;
	    case 2:
	      try {
	        N = Integer.parseInt(args[1]);
	      }
	      catch (NumberFormatException e) {
	        err.printf("Second argument must be a number.\n");
	        exit(1);
	      }
	      break;
	    default:
	      out.println("USO: java -ea Ngrams ABC [N]");
	      exit(1);
	    }
	    String[] a;
	    // Crie a fun��o allNgrams e altere a invoca��o abaixo...
	    out.println(Arrays.toString(all3grams(args[0])));
	    out.println(Arrays.toString(allNgrams(args[0], N)));
	  }

	  // Gera todos os arranjos de 3 s�mbolos escolhidos do alfabeto alpha.
	public static String[] all3grams(String alpha) {
		int l = alpha.length();
	    String[] arr = new String[l * l * l];
	    int n = 0;
	    for (int i = 0; i < l; i++) {
	      for (int j = 0; j < l; j++) {
	        for (int k = 0; k < l; k++) {
	          arr[n++] = "" +  alpha.charAt(i) + alpha.charAt(j) + alpha.charAt(k);
	        }
	      }
	    }
	    assert n == arr.length;
	    return arr;
	  }

	  // Gera todos os N-gramas de s�mbolos escolhidos do alfabeto alpha.
	public static String[] allNgrams(String alpha, int n) {
	    assert n >= 0;
	    if(n < alpha.length()) {
	    	char ch = alpha.charAt(0);
	    	String tail = alpha.substring(1);
	    	
	    	System.out.println();
	    }
	    
	    return null;
	    //return new String[] {}   ;
	  }
	}
