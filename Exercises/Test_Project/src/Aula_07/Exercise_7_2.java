/* For information about the exercise, check the folder class_contents */
package Aula_07;

import static java.lang.System.*;

public class Exercise_7_2 {
	
	public static void main(String[] args) {
		requireEA();
		LinkedList<Integer> lst = new LinkedList<Integer>();
	
	    for(int i=0; i<10; i++) {
	      lst.addFirst(i);
	      lst.addLast(100+i);
	    }
	    out.println(lst.first());
	
	    lst.removeFirst();
	
	    LinkedList<Integer> cln = lst.clone();
	
	    out.println(cln.first());
	    
	    LinkedList<Integer> rev = cln.reverse();
	
	    out.println(rev.first());
	
	    out.println(rev.contains(5));	  
	    
	    
	    rev.remove(5);
	    out.println(rev.contains(5));
	    
	    LinkedList<Integer> another = new LinkedList<Integer>();
	    another.addFirst(123);
	    another.addFirst(999);
	
	    LinkedList<Integer> conc = rev.concatenate(another);
	
	    for(int p=0; p<conc.size(); p++) 
	      out.println(conc.get(p));
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
