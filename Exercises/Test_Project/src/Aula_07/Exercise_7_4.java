/* For information about the exercise, check the folder class_contents */
package Aula_07;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_7_4 {

	public static void main(String[] args) {
		requireEA();
		if (args.length != 1) {
	        err.printf("Usage: java -ea FilterLines2 text-file\n");
	        exit(1);
	      }
	      File fil = new File(args[0]);

	      LinkedList<String> list = new LinkedList<String>();	      
	      
	      try {
	    	  Scanner sf = new Scanner(fil);
	    	  
	    	  // exceções poderiam ser intercetadas e mostrar mensagem de erro.
		      while (sf.hasNextLine()) {
		        String line = sf.nextLine();
		        assert line.length() >= 0 : "File line doesn't have the appropriate size";
		        // Guardar linha na lista apropriada, consoante o tamanho.
		        if(line.length() < 20) {
		        	list.addFirst(line);
		        	list.reverse();
		        }else
		        	list.addLast(line);
		      }
		      sf.close();
	      } catch (FileNotFoundException e) {
	    	  err.println("ERROR: Exception found : " + e.getMessage());
	    	  exit(1);
	      }

	      // Escrever conteúdo das listas...
	      out.println("lista---|---------|---------|---------|---------");
	      list.print();
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
