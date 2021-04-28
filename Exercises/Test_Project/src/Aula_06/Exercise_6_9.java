/* For information about the exercise, check the folder class_contents */
//Loan 
package Aula_06;

import static java.lang.System.*;

public class Exercise_6_9 {

	public static void main(String[] args) {
		requireEA();
		if(args.length < 4) {
			err.println("USO: java -ea Loan <Months> <Ammout> <Tax> <Montly Payment>");
			exit(1);
		}
		for(int i = 0; i < 4; i++) {
			assert Integer.parseInt(args[i]) >= 0 : "Numbers need to be real and positive";
		}
		

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
