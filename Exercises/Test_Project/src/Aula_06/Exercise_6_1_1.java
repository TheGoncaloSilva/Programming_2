/* For information about the exercise, check the folder class_contents */
// Needs to be ran with -ea
// Number needs to be provided with command line in run configurations
// Completar para a alínea B
package Aula_06;

import static java.lang.System.*;

public class Exercise_6_1_1 {
	
	public void main(String[] args) {
		if (args.length < 1) {
	      out.println("USO: java -ea Fibonacci N [N ...]");
	      exit(1);
	    }

	    // Alguns testes:
	    assert fibonacci(0) == 0;
	    assert fibonacci(1) == 1;
	    assert fibonacci(2) == 1;
	    assert fibonacci(5) == 5;
	    
	    record[] memo = new record[100];

	    for(int i = 0; i < args.length; i++) {
	      int n = Integer.parseInt(args[i]);
	      long time = nanoTime();  // System.nanoTime() gives the time in ns.
	      int f;
	      if(memo[i].search(n, memo, 0)) {
	    	  f = memo[i].result();
	      }else { 
	    	  f = fibonacci(n);
	    	  
	      }
	      time = nanoTime() - time;
	      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
	    }
	  }
	public int fibonacci(int n) {
	    assert n >= 0;	    
		if(n <= 1)
			return n;
		else {
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
		
	}

}

class record{
	private int number, result;
	
	public record() {}
	
	public record(int number, int result) {
		this.number = number;
		this.result = result;
	}
	
	public int number() { return number;}
	
	public int result() { return result;}
	
	public boolean search(int n, record[] memo, int p) {
		if(memo.equals(n)) {
			return true;
		}
		return search(n, memo, p++);
		
	}
	
	public boolean equals(int n) {
		return n == number;
		
	}
	
}
