/* For information about the exercise, check the folder class_contents */
package Aula_06;

import static java.lang.System.*;

import java.io.File;

public class Exercise_6_7 {

	public static void main(String[] args) {
		requireEA();
		assert args.length == 2 : "Arguments must be provided";
		File f = new File(args[0]);
		searchDir(f, args[1]);
		
		
	}
	
	public static void searchDir(File fin1, String key) { //listar o diretório atual, usado apenas para testes
        File[] lista;
		if (fin1.isDirectory()){
		    lista = fin1.listFiles();   // devolve array de strings com nomes ficheiro
		    for (File f : lista) {
		    	if(f.isDirectory())
		    		searchDir(f, key);
			    	if(f.toString().indexOf(key) > 0)
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
