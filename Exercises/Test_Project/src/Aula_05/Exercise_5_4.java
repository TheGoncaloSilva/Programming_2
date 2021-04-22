/* For information about the exercise, check the folder class_contents */
package Aula_05;

import java.io.File;
import static java.lang.System.*;

public class Exercise_5_4 {

	public static void main(String[] args) {
		String nomeDir = ".";
		requireEA();
		if(args.length == 1) {
			nomeDir = args[0];
		}
		listaDir(nomeDir);

	}
	
    public static void listaDir(String nomeDir) { //listar o diretório atual, usado apenas para testes
        File[] lista;
        File fin1 = new File(nomeDir);
		if (fin1.isDirectory()){
		    lista = fin1.listFiles();   // devolve array de strings com nomes ficheiro
		    int dir = 1, file = 1;
		    for (File f : lista) { // Dúvida, perguntar ao stor
				System.out.printf("%-50s %s %s\n", f, fileType(f), f.isDirectory()? "./DIR" + dir++ : "./File" + file++);
		    }
		}else {
			err.println("ERROR: The provided path needs to be a directory");
			exit(1);
		}
    }
    
    public static String fileType(File n) {
    	String result = "";
    	 if(n.isFile()) {
    		 result += "F";
    	 }else {
    		 result += "D";
    	 }
    	 
    	 if(n.canRead()) {
			 result += "R";
		 }else {
			 result += "-";
		 }
    	 if(n.canWrite()) {
    		 result += "W";
    	 }else {
    		 result += "-";
    	 }
    	
    	return result;
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
