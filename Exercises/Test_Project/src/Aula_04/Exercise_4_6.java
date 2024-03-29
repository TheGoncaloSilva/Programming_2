/* For information about the exercise, check the folder class_contents */
package Aula_04;

import static java.lang.System.*;
import java.util.Scanner;

public class Exercise_4_6 {
	  private static final Scanner scin = new Scanner(System.in);

	  public static void help(GuessGame game) {
	    assert game != null;
	    out.printf("Find the secret number in range [%d,%d]!\n",
	                game.min(), game.max());
	    out.printf("Available commands:\n");
	    out.printf("  <number>   (new attempt to guess secret)\n");
	    out.printf("  count      (show current number of attempts)\n");
	    //out.printf("  show       (show all attempts done)\n");
	    out.printf("  help       (information on command usage)\n");
	    out.printf("  quit       (exits the program)\n");
	  }
	  
	public static void main(String[] args) {
		if (args.length != 0 && args.length != 2) {
		      out.println("Usage: PlayGuessGame [ <min> <max> ]");
		      out.println("(by default range [0,20] is used)");
		      exit(1);
		    }
		    int min = 0;
		    int max = 20;
		    if (args.length == 2) {
		      min = Integer.parseInt(args[0]);
		      max = Integer.parseInt(args[1]);
		    }
		    GuessGame game = new GuessGame(min, max);

		    out.println();
		    help(game);
		    out.println();
		    while (!game.finished()) {
		      out.print("Command? ");
		      String command = scin.next();
		      out.println();
		      switch (command) {
		      case "quit":
		        exit(1);
		        break;
		      case "help":
		        help(game);
		        break;
		      case "count":
		        System.out.println("Number of attempts: " + game.numAttempts());
		        break;
		      default:
		        game.play(Integer.parseInt(command));
		        if(game.attemptIsHigher()) System.out.println("Number is too high");;
		        if(game.attemptIsLower()) System.out.println("Number is too low");
		        break;
		      }
		      out.println();
		    }
		    out.printf("Game finished in %d attempts\n", game.numAttempts());
		  }
		}