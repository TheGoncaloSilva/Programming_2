/* For information about the exercise, check the folder class_contents*/
// Complete o programa para calcular a nota final NF de
// um aluno de Programação 2 (2019-2020) na Época normal.

package Aula_01;

import java.util.Scanner;
import static java.lang.System.*;

public class Exercise_1_2 {
	
	public static final Scanner in = new Scanner(System.in);

	  // Nota mínima em cada componente:
	  public static final double NOTA_MINIMA = 6.5;


	public static void main(String[] args) {
		
		double atp1 = readInRange("ATP1? ", 0.0, 20.0);
	    double ap1 = readInRange("AP1? ", 0.0, 20.0);
	    double atp2 = readInRange("ATP2? ", 0.0, 20.0);
	    double ap2 = readInRange("AP2? ", 0.0, 20.0);

	    // Use estas variáveis para calcular o resultado:
	    double ctp = (atp1 + atp2) / 2; // componente TP
	    double cp = (ap1 + ap2) / 2;  // componente P
	    int nf = -66;
	    if(ctp > NOTA_MINIMA && cp > NOTA_MINIMA) {
	    	nf = (int) Math.round(((cp * 0.70) + (ctp * 0.30))); // nota final (inteiro positivo ou -66 se RNM)
	    }
	    
	    boolean aprovado = false; // indica se passou ou não
	    if(Math.round(nf) > 9.5) {
	    	aprovado = true;
	    }
	      

	    // Complete com os cálculos e variáveis auxiliares:
	    //...

	    out.printf(" %7s %7s %7s %7s\n", "CTP", "CP", "NF", "APROV?");
	    out.printf(" %7.1f %7.1f %7d %7s\n", ctp, cp, nf, aprovado);
	  }

	  // Reads a double that must be in the range [min, max].
	  // Shows the prompt, reads a double value.
	  // If the value is not in the range, prints a warning and repeats.
	  public static double readInRange(String prompt, double min, double max)
	  {
	    assert min <= max : "max must be at least as large as min!";
	    double value;
	    do {
	    	out.println(prompt);
		    value = in.nextDouble();
		    if(value < min || value > max) {
		    	out.println("Value must be in range [" + min + "," + max + "]!");
		    }
	    }while(value < min || value > max);
	    
	    return value;
	  }
	  
	}