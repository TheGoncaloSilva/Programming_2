/* For information about the exercise, check the folder class_contents */
package Aula_10;

import static java.lang.System.*;

public class Exercise_10_4 {

	public static void main(String[] args) {
		requireEA();
		if(args.length < 3) {
			out.println("Requires more than 2 arguments");
			exit(1);
		}
		Stack<Integer> numbers = new Stack<>();
		
		for(int i = 0; i < args.length; i++) {
			try {
				Integer.parseInt(args[i]);
				numbers.push(Integer.parseInt(args[i]));
			}catch(NumberFormatException e){
				int operation = 0;
				switch(args[i]) {
				case "-" : operation = numbers.top(); numbers.pop(); operation = numbers.top() - operation;break;
				case "+" : operation = numbers.top(); numbers.pop(); operation += numbers.top();break;
				case "/" : operation = numbers.top(); numbers.pop(); operation = numbers.top() / operation;break;
				case "x" : operation = numbers.top(); numbers.pop(); operation *= numbers.top();break;
				case "%" : operation = numbers.top(); numbers.pop(); operation %= numbers.top();break;
				default : System.out.println("Operation failed: op -> " + args[i]); exit(1);break;
				}
				numbers.pop();
				numbers.push(operation);
			}
		}
		
		System.out.println("Result: " + numbers.top());
		numbers.pop();
		assert numbers.isEmpty();
		
		
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
