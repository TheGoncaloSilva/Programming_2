/* For information about the exercise, check the folder class_contents */
/* *#*#*##*#*#*#* Para testar o programa *#*#*##*#*#*#*
 * Ficheiro entrada - C:\Users\gonca\OneDrive\Documents\Repositorios\Programming_2\Exercises\Test_Project\src\Aula_01\Files\Texto1.txt
 * Ficheiro Saída - C:\Users\gonca\OneDrive\Documents\Repositorios\Programming_2\Exercises\Test_Project\src\Aula_01\Files\Texto2.txt
 */
package Aula_01;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_1_7 {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		String[] files = new String[2];
		
		readPath(files);
		writeFile(files);

	}
	
	public static void writeFile(String[] files) throws FileNotFoundException {
		File fin = new File(files[0]);
		Scanner fRead = new Scanner(fin);
		File fout = new File(files[1]);
		PrintWriter pwf = new PrintWriter(fout);
		int aux = 0;
		
		while(fRead.hasNextLine()) {
			String line = fRead.nextLine();
			pwf.println(line);
			aux++;
		}
		if(aux > 0) {
			out.println("Dados gravados com sucesso");
		}else {
			out.println("Sem dados para gravar");
		}
		
		pwf.close();
	}
	
	public static void readPath(String[] files) throws FileNotFoundException{
		boolean pass = false;
		do {
			out.println("Caminho para o ficheiro inicial: ");
			String path = in.nextLine();
			if(verifyFile(path, 'R')) {
				files[0] = path;
				do {
					out.println("Caminho para o segundo ficheiro");
					path = in.nextLine();
					if(verifyFile(path, 'W')) {
						files[1] = path;
						pass = true;
					}
				}while(!pass);
			}
		}while(!pass);
	}
	
	public static boolean verifyFile(String path, char type) throws FileNotFoundException {
		boolean good = false;
		File fin = new File(path); //declarar o ficheiro
		if(fin.exists()) {
			if(fin.isFile()) {
				if(fin.canRead()) {
					System.out.println("Ficheiro válido");
					if(type == 'W') {
						out.println("Tem a certeza que deseja destruir este ficheiro? (s para aceitar ou outro caracter para rejeitar)");
						if(in.next().charAt(0) == 's') {
							good = true;
						}else{
							out.print("Ficheiro não aceite");
						}
					}else {
						good = true;
					}	
				}else {
					System.err.println("ERRO: ficheiro " + path + " não pode ser lido!");
		            //System.exit(4);
				}
			}else {
	            System.err.println("ERRO: ficheiro " + path + " não é um ficheiro!");
	            //System.exit(3);
			}
		}else {
			System.err.println("ERRO: ficheiro " + path + " não existe!");
            //System.exit(2);
		}
		return good;
	}

}
