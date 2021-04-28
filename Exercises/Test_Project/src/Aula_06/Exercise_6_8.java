/* For information about the exercise, check the folder class_contents */
// max common divisor 
package Aula_06;

import static java.lang.System.*;

public class Exercise_6_8 {

	public static void main(String[] args) {
		requireEA();
		if(args.length < 2) {
			err.println("USO: java -ea MDC <a> <b>");
			exit(1);
		}
		assert Integer.parseInt(args[0]) >= 0 && Integer.parseInt(args[1]) >= 0 : "Numbers need to be real and positive";

		out.printf("mdc(%s, %s) = %s\n", args[0], args[1], mdc(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
	
	public static int mdc(int a, int b) {
		if(b == 0)
			return a;
		else
			return mdc(b, a % b);
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
