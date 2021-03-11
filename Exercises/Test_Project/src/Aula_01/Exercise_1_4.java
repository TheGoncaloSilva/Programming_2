/* For information about the exercise, check the folder class_contents*/
package Aula_01;

import static java.lang.System.*;
import java.util.Scanner;

public class Exercise_1_4 {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String line;
		do {
			out.println("Linha?");
			line = in.nextLine();
			if(!line.isEmpty()) {
				translator(line);
			}
		}while(!line.isEmpty()); 
		out.println("Program Finished");
		
		in.close();
	}
	
	public static void translator(String text) {
		String result = "";
		for(int i = 0; i < text.length();i++) {
			char temp = text.charAt(i);
			if(temp == 'r') {
				temp = 0;
			}else if(temp == 'l') {
				temp = 'u';
			}else if(temp == 'R') {
				temp = 0;
			}else if(temp == 'L') {
				temp = 'U';
			}
			result += temp;
		}
		out.println(result);
	}

}
