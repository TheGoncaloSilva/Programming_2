/* For information about the exercise, check the folder class_contents */
package Aula_07;

import static java.lang.System.err;
import static java.lang.System.exit;

import java.io.File;

public class Exercise_7_3 {
	
	public static LinkedList<File> aux = new LinkedList<File>();

	public static void main(String[] args) {
		requireEA();
		if (args.length != 1) {
			err.println("Uso: java -ea ListRec2 <dir>");
			exit(1);
		}

		File dir = new File(args[0]);

		// Verificar entrada
		if (!dir.exists()) {
			err.printf("ERRO: %s nao existe!\n", dir);
			exit(2);
		}

		LinkedList<File> files = recListFiles(dir);
		files.print();
		}

	/** Devolve uma lista com o conteúdo de um directório f
	*  e de todos os seus subdiretórios recursivamente.
	*/
	public static LinkedList<File> recListFiles(File f) {
		//LinkedList<File> aux = new LinkedList<File>(); Perguntar se existe outra maneira sem ser implementar uma variável universal
        File[] lista;									
		if (f.isDirectory()){
		    lista = f.listFiles();   // devolve array de strings com nomes ficheiro
		    for (File f2 : lista) {
		    	if(f2.isDirectory())
		    		recListFiles(f2);
		    	//System.out.printf("%s\n", f);
		    	aux.addLast(f2);
		    }
		}else {
			err.println("ERROR: The provided path needs to be a directory");
			exit(1);
		}

		return aux;
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
