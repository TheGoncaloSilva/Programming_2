package Aula_02;



	public class Complex{
		private double re, im; // stores the real part, stores the imaginary part

		// Constructor
		// Example usage: "Complex n1 = new Complex(2,3);"
		Complex(double n1, double n2){
			this.re = n1;
			this.im = n2;
		}
		
		public double real(){ return re; } // real part
		
		public double imag(){ return im; } // imaginary part
		
		public double abs(){ return Math.sqrt(re * re + im * im); } // absolute value (modulus)
		
		public double arg(){ return Math.atan2(im, re); } // argument (aka angle or phase) between -pi and pi
		
	}


