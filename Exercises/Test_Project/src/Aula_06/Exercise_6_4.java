/* For information about the exercise, check the folder class_contents */
package Aula_06;

import static java.lang.System.*;

public class Exercise_6_4 {

	public static void main(String[] args) {
		if(args.length < 1) {
			err.println("Arguments must be provided");
			exit(1);
		}
		reverseString(args[0]);

	}
	public static void reverseString(String s) {
		if(s.length() > 0) {
			reverseString(s.substring(1));
			out.print(s.charAt(0));
		}
		
	}

}
