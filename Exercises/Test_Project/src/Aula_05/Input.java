package Aula_05;

import static java.lang.System.*;
import java.util.*;
import java.io.*;

/** This class contains methods for robust interactive input. */
public class Input {
  private static Scanner input = new Scanner(System.in);

  /** Get a double value from a line read from standard input.
   * Should repeat until a valid double value is actually read.
   * @param prompt the message to prompt for input.
   * @return the value read from input.
   */
  public static double getDouble(String prompt) {
    double r = 0;
    while(r == 0) {
        err.print(prompt);
        String line = input.nextLine();
	    try {
	        r = Double.parseDouble(line.trim());
	    }catch (NumberFormatException e) {
	    	err.println("Invalid input format!");
	    }
    }
    return r;
  }

  /** Get a double value within a given range, from standard input.
   * Should repeat until a valid double value is actually read.
   *
   * @param prompt the message to prompt for input.
   * @param min minimum value allowed.
   * @param max maximum value allowed.
   * Precondition: min<=max
   * @return the value read from input.
   * Postcondition: result in in [min, max].
   */
  public static double getDouble(String prompt, double min, double max) {
    assert min <= max : "Minimum value must be smaller than max number";
    double r = 0;
    while (true) {
      err.print(prompt);
      String line = input.nextLine();
      try {
    	  r = Double.parseDouble(line.trim());
    	  if (min <= r && r <= max) break;
    	  err.printf("Value must be in range [%f, %f]\n", min, max);
      }catch (NumberFormatException e) {
    	  err.println("Invalid input format!");
      }
    }
    assert min <= r && r <= max : "Postcondition";
    return r;
  }

}
