/* For information about the exercise, check the folder class_contents */
package Aula_06;

import static java.lang.System.*;

import java.util.Arrays;

public class Exercise_6_10 {

	public static void main(String[] args) {
		if (args.length != 2) {
			out.println("Uso: java -ea Levenshtein <palavra1> <palavra2>");
			exit(1);
		}

		int d = distancia(args[0], args[1]);
		out.printf("\"%s\" <-> \"%s\" = %d\n", args[0], args[1], d);
	}
	// calculate levenshtein distance
	//1 + min(d(S1, P2), d(P1, S2), d(S1, S2))
	public static int distancia(String p1, String p2) {
		if(p1.length() == 0)
			return p2.length();
		else if(p2.length() == 0)
			return p1.length();
		
		// calculate the number of distinct characters to be
        // replaced in str1
        // by recursively traversing each substring
  
        int replace = distancia(
              p1.substring(1), p2.substring(1))
              + NumOfReplacement(p1.charAt(0),p2.charAt(0));
        
        // calculate the number of insertions in p1
        int insert = distancia(p1, p2.substring(1))+ 1;
        
        // calculate the number of deletions in p2
        int delete = distancia(
                         p1.substring(1), p2)+ 1;
  
        // returns minimum of three operations
        return minm_edits(replace, insert, delete);
		
	}
	
	public static int NumOfReplacement(char c1, char c2){
        // check for distinct characters
        // in str1 and str2
        
        return c1 == c2 ? 0 : 1;
    }
	
	public static int minm_edits(int... nums){
        // receives the count of different
        // operations performed and returns the
        // minimum value among them.
        
        return Arrays.stream(nums).min().orElse(
            Integer.MAX_VALUE);
    }
	

}