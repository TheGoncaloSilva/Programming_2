/* For information about the exercise, check the folder class_contents */
package Aula_03;

import static java.lang.System.out;

import java.util.Scanner;

import Aula_02.Data;

public class Exercise_3_1 {
	static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		Data today = new Data();
		out.printf("today = %s\n", today);

		Data[] dates = {new Data("987-12-31"), new Data("988-01-01"),
		                new Data("2000-02-29"), new Data("2018-02-27"),
		                new Data("2018-2-28"), new Data("2018-03-1")};

		for (Data d: dates) {
			out.printf("%s: %s\n", d, d.extenso());
		}

		for (Data d1: dates) {
			out.println();
		for (Data d2: dates) {
		    int c = d1.toString().compareTo(d2.toString());
		    String op;
		    if (c < 0)
		    	op = "<";
		    else if (c > 0)
		    	op = ">";
		    else
		        op = "=";
		     	out.printf("%s %s %s\n", d1, op, d2);
			}
		}
	}

}

