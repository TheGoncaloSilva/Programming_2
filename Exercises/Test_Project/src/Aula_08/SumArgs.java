/* For information about the exercise, check the folder class_contents */
// Better to run this program with command line arguments but not obligatory
package Aula_08;

import static java.lang.System.*;

public class SumArgs
{
	public static void main(String[] args) {
		requireEA();
	    // Criar array com um elemento por cada argumento do programa:
	    double[] arr = new double[args.length];
	
	    // Preencher arr com os valores obtidos dos argumentos:
	    for(int i = 0; i < arr.length; i++) {
	    	try {
	    		arr[i] = Double.parseDouble(args[i]);
	    	}catch (NumberFormatException e) {
	    	    err.println("Cannot convert String arguments to double numbers");
	    	    exit(1);
	    	}
	    }
	    	
	    // Calcular a soma com função recursiva:
	    double total = sumRec(arr, 0, arr.length);
	    out.printf("sum of arguments = %f\n", total);
	
	    // Verificação de correçãoo do resultado:
	    assert total == sum(arr, 0, arr.length);
	}

	// Iteractive form
	// sum of subarray [start,end[ of arr:
	public static double sum(double[] arr, int start, int end) {
	    assert arr != null;
	    assert start >= 0 && start <= end && end <= arr.length;
	
	    double res = 0;
	    for (int i = start; i < end; i++)
	      res += arr[i];
	    return res;
	 }

	// same thing, recursive:
	public static double sumRec(double[] arr, int start, int end) {
	    assert arr != null;
	    assert start >= 0 && start <= end && end <= arr.length;

	    if(start != end)
	    	return arr[start++] + sumRec(arr, start, end);
	    else
	    	return 0;
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

