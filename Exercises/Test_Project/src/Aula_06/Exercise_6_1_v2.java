/* For information about the exercise, check the folder class_contents */
package Aula_06;

import static java.lang.System.*;

public class Exercise_6_1_v2 {

	public static void main(String[] args) {
		if (args.length < 1) {
		      out.println("USO: java -ea Fibonacci N [N ...]");
		      exit(1);
		    }

		    // Alguns testes:
		    assert fibonacci(0) == 0;
		    assert fibonacci(1) == 1;
		    assert fibonacci(2) == 1;
		    assert fibonacci(5) == 5;
		    

		    for(int i = 0; i < args.length; i++) {
		      int n = Integer.parseInt(args[i]);
		      long time = nanoTime();  // System.nanoTime() gives the time in ns.
		      int f = memoization(n);
		      time = nanoTime() - time;
		      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
		    }
		  }
		public static int fibonacci(int n) {
		    assert n >= 0;	    
			if(n <= 1)
				return n;
			else {
				return fibonacci(n - 2) + fibonacci(n - 1);
			}
			
		}
		
		public static int[] memo = new int[50]; // global array with values
		
		public static int memoization(int n) {
			assert n < 50 && n >= 0 : "Input value cannot exceed 50";
			if(n <= 1) {
				return n;
			}else if (memo[n] > 0) {
				return memo[n];
			}else {
				memo[n] = fibonacci(n);
				return memo[n];
			}
			
		}

	}