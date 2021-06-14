/* For information about the exercise, check the folder class_contents */
package Aula_10;

import static java.lang.System.*;

public class Exercise_10_2 {

	public static void main(String[] args) {
		requireEA();
		if (args.length != 1) {
			out.println("Usage: java -ea SolveHanoi Number-of-Disks");
		    exit(1);
		}

		int n = Integer.parseInt(args[0]);
		if (n < 1) {
			out.println("ERROR: invalid number of disks!");
			exit(2);
		}

		HanoiTowers t = new HanoiTowers(n);
		t.solve();
		out.format("Number of moves: %d\n", t.numberOfMoves());
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
