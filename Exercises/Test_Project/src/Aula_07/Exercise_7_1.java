/* For information about the exercise, check the folder class_contents */
package Aula_07;

import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Exercise_7_1 {
	
	@SuppressWarnings("unchecked")// Obrigatório com array
	public static void main(String[] args) throws FileNotFoundException {
		requireEA();
	    if (args.length != 1) {
	        err.printf("Usage: java -ea FilterLines text-file\n");
	        exit(1);
	      }
	      File fil = new File(args[0]);

	      // Criar listas para as linhas curtas, médias e longas.
	      // list[0] = lista com menos de 20 caracteres (lista curta)
	      // list[1] = lista com mais de 20 e menos de 40 caracteres (lista média)
	      // list[2] = lista com mais de 40 caracteres (lista longa)
	      LinkedList<String>[] list = (LinkedList<String>[]) new LinkedList[3];
	      for(int i = 0; i < 3; i++) {
	    	  list[i] = new LinkedList();
	      }

	      //LinkedList<String>[] list = (LinkedList<String>[]) new LinkedList[] { new LinkedList(), new LinkedList(), new LinkedList()};
	      
	      
	      try {
	    	  Scanner sf = new Scanner(fil);
	    	  
	    	  // exceções poderiam ser intercetadas e mostrar mensagem de erro.
		      while (sf.hasNextLine()) {
		        String line = sf.nextLine();
		        assert line.length() >= 0 : "File line doesn't have the appropriate size";
		        // Guardar linha na lista apropriada, consoante o tamanho.
		        if(line.length() < 20)
		        	list[0].addLast(line);
		        else if (line.length() > 20 && line.length() < 40)
		        	list[1].addLast(line);
		        else
		        	list[2].addLast(line);
		      }
		      sf.close();
	      } catch (FileNotFoundException e) {
	    	  err.println("ERROR: Exception found : " + e.getMessage());
	    	  exit(1);
	      }

	      // Escrever conteúdo das listas...
	      out.println("Curtas---|---------|---------|---------|---------");
	      list[0].print();

	      out.println("Médias---|---------|---------|---------|---------");
	      list[1].print();

	      out.println("Longas---|---------|---------|---------|---------");
	      list[2].print();
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
