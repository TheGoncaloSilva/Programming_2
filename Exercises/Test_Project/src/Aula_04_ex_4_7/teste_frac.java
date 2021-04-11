package Aula_04_ex_4_7;

import static java.lang.System.*;

public class teste_frac {

	public static void main(String[] args) {
		out.println("Creating fractions...");
	    Fraction two = new Fraction(2, 1);
	    out.printf("two = %s\n", two);
	    Fraction top = new Fraction(45, -21);
	    out.printf("x = %s\n", top);
	    Fraction x = randomFraction();
	    out.printf("x = %s\n", x);
	    Fraction x2 = new Fraction(-2*x.num(), -2*x.den());  // == x
	    out.printf("x2 = %s\n", x2);
	    Fraction y = randomFraction();
	    out.printf("y = %s\n", y);
	    Fraction z = randomFraction();
	    out.printf("z = %s\n", z);

	}

	// Gera uma fração aleatória com numerador e denominador entre -100 e 100.
		  static Fraction randomFraction() {
		    int n, d;
		    n = (int)(Math.random()*201.0) - 100;
		    do {
		      d = (int)(Math.random()*201.0) - 100;
		    } while (d == 0);  // avoid zero!
		    return new Fraction(n, d);
		  }
}
