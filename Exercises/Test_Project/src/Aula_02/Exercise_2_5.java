/* For information about the exercise, check the folder class_contents */
package Aula_02;

import static java.lang.System.*;

public class Exercise_2_5 {

	public static void main(String[] args) {
	    Data atual = new Data();
	    Data inicial = new Data(25, 12, (atual.ano() - 1));
	    
		do {
	    	inicial.seguinte();
	    	out.println(inicial.extenso());
	    	
	    }while(!inicial.toString().equals(atual.toString()));
	}

}
