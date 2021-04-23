/* For information about the exercise, check the folder class_contents */
package Aula_06;

import static java.lang.System.*;

import java.io.File;

public class Exercise_6_5 {

	public static void main(String[] args) {
		requireEA();
		assert args.length == 1 : "Arguments must be provided";
		File f = new File(args[0]);
		listaDir(f);
		
		
	}
	
	public static void listaDir(File fin1) { //listar o diretório atual, usado apenas para testes
        File[] lista;
		if (fin1.isDirectory()){
		    lista = fin1.listFiles();   // devolve array de strings com nomes ficheiro
		    for (File f : lista) {
		    	if(f.isDirectory())
		    		listaDir(f);
				System.out.printf("%s\n", f);
		    }
		}else {
			err.println("ERROR: The provided path needs to be a directory");
			exit(1);
		}
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
