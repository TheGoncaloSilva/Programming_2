/* For information about the exercise, check the folder class_contents */
/* To run this program in Eclipse must adjust running configurations and insert the arguments
 *  Run -> Run Configurations
 *  Arguments Tab - Program Arguments
 *  Change the value, ex: 1.5 -1.5 or 3.0
 */
package Aula_02;

import static java.lang.System.out;
import java.util.Scanner;

public class Exercise_2_1 {
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Complex a;
		
		if(args.length > 0 ) {
			if(args.length == 2) {
				a = new Complex(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
			}else if(args.length == 1) {
				a = new Complex(Double.parseDouble(args[0]), 0.0);
			}else {
				a = new Complex(5.0, 6.0);
			}
		}else {
			a = new Complex(5.0, 6.0);
		}		
		
		//Complex a = new Complex(5.0, 6.0);

	    // Vamos usar métodos do objeto a
	    out.printf("(%.2f+%.2fi)\n", a.real(), a.imag());
	    out.println("parte real = " + a.real());
	    out.println("parte imaginaria = " + a.imag());
	    out.println("modulo = " + a.abs());
	    out.printf("argumento = %.2f\n", a.arg());

	}
}



