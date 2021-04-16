/* For information about the exercise, check the folder class_contents */
package Aula_05;

import static java.lang.System.*;

public class Exercise_5_1 {
	static String MESSAGE =
		"This program requests several real values.\n" +
	    "Try inserting numbers with invalid format or out of range.\n";
	  
	public static void main(String[] args) {
		out.println(MESSAGE);
	    
	    double x = Input.getDouble("Real value X? ");
	    out.println(x);
	    
	    double nota = Input.getDouble("Nota? ", 0.0, 20.0);
	    out.println(nota);
	    
	    double temp = Input.getDouble("Temperature (Celsius)? ", 
	                                  -273.15, Double.POSITIVE_INFINITY);
	    out.println(temp);

	    //double z = Input.getDouble("Nota? ", 0.0, -10.0);  // should fail!
	    
	}
}
