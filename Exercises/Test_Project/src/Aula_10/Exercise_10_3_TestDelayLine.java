/* For information about the exercise, check the folder class_contents */
package Aula_10;

import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;

public class Exercise_10_3_TestDelayLine {
	
	public static void main(String[] args) throws IOException {
		Scanner sf = new Scanner(new File("./src/Aula_10/temperaturas.txt"));
		printAverage(sf, 24);
		sf.close();
	}

	public static void printAverage(Scanner sf, int N) {
		DelayLine<Double> temp = new DelayLine<Double>(N, 0.0);
		out.printf("Temperaturas hora-a-hora e m�dia das �ltimas %d horas.\n", N);
		out.printf("(As primeiras %d m�dias n�o s�o exatas!)\n", N);
		out.printf("%3s %4s %7s %7s\n", "dia", "hora", "temp.", "m�dia");
		int t = 0;
		while (sf.hasNextDouble()) {
			double nova = sf.nextDouble();
			// Calcula soma das �ltimas N horas:
			temp.in(nova);
			double somaN = 0.0;
			for (int hora = -N; hora < 0; hora++) {
				somaN += temp.get(hora);
			}
			out.printf("%3d   %02d %7.1f %7.1f\n", t/24, t%24, nova, somaN/N);
		  	t++;
		}
	}
}
