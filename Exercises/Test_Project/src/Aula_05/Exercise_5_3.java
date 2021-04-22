/* For information about the exercise, check the folder class_contents */
/* In order to run this program, tere needs to be preconditions
 * Run with assertions on
 * Choose files to run and provide them in the command line by changing run configurations -> ./src/Aula_05/Texto1.txt ./src/Aula_05/Texto2.txt
 */
package Aula_05;

import static java.lang.System.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_5_3 {
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		requireEA();
		assert args.length > 0 && args.length < 3: "At least one arguments must be given";
		if(args.length == 1) {
			String temp = args[0];
			args = new String[2];
			args[0] = temp;
			args[1] = "./src/Aula_05/Temp/Texto2.txt";
		}
		readPath(args);
		writeFile(args);
		
	}
	
	public static void writeFile(String[] files) throws FileNotFoundException {
		assert files != null;
		File fin = new File(files[0]);
		Scanner fRead = new Scanner(fin);
		File fout = new File(files[1]);
		Scanner fOutRead = new Scanner(fout);

		int aux = 0;

		if(fOutRead.hasNextLine()) { // -> Tirar duvida com o stor
			out.println("The file " + files[1] + " contains data that is about to be overwritten. Do you wish to continue the operation? (S/N)");
			while(true) {
				String command = in.nextLine();
				if(command.equals("S")) {
					break;
				}else if(command.equals("N")) {
				    err.println("Operation canceled by user");
				    exit(2);
				}else {
					err.print("Invalid choice given, please choose S or N");
				}
			}
		}
		fOutRead.close();
		PrintWriter pwf = new PrintWriter(fout);
		
		while(fRead.hasNextLine()) {
			String line = fRead.nextLine();
			pwf.println(line);
			aux++;
		}
		if(aux > 0) {
			out.println("Data Saved");
		}else {
			out.println("No Data to save");
		}
		
		fRead.close();
		pwf.close();
	}
	
	public static void readPath(String[] files) throws FileNotFoundException{
		assert verifyFile(files[0], 'R') : "File to read must be valid";
		assert verifyFile(files[1], 'W'): "File to write must be valid";

	}
	
	public static boolean verifyFile(String path, char type) throws FileNotFoundException {
		assert type != 'W' || type != 'R' : "File type must be valid";
		boolean good = false;
		File fin = new File(path); //declarar o ficheiro
		if(fin.exists()) {
			if(fin.isFile()) {
				if(fin.canRead()) {
					if(type == 'W') {
						if(fin.canWrite()) {
							System.out.println("Ficheiro válido");
							good = true;
						}else {
							System.err.println("ERROR: file " + path + " cannot be Written!");
				            exit(6);
						}
					}else {
						System.out.println("Ficheiro válido");
						good = true;
					}	
				}else {
					System.err.println("ERROR: file " + path + " cannot be read!");
		            exit(5);
				}
			}else {
	            System.err.println("ERROR: Path " + path + " is not a file!");
	            exit(4);
			}
		}else {
			if(fin.isDirectory()) {
				if(fin.canRead() && fin.canWrite()) {
					good = true;
				}else {
					System.err.println("ERROR: Directory " + path + " cannot be read and/ or written on!");
		            exit(7);
				}
			}else {
				System.err.println("ERROR: file " + path + " doesn't exist!");
				exit(3);
			}
		}
		return good;
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
