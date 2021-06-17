/* For information about the exercise, check the folder class_contents */
package Aula_11;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_11_1 {

	public static void main(String[] args) {
		requireEA();
		assert args.length > 0 : "The file must be provided";
		Scanner sc = new Scanner(System.in);
		KeyValueList<String> list = readFile(args[0]);
		
		while(true) {
			out.print("Username: ");
			String user = sc.nextLine();
			if(user == null) // Não quer ler mais
				break;
			out.print("Password: ");
			String pass = sc.nextLine();
			if(list.contains(pass)) {
				if(list.get(pass).equals(user)) {
					out.println("Authentication successful");
				}else out.println("Authentication failed");
				
			}else out.println("Authentication failed");
			
			out.println();
		}
		
		sc.close();

	}
	
	public static KeyValueList readFile(String filePath) {
		KeyValueList<String> list = new KeyValueList<>();
		
		File fil = new File(filePath);
		try {
	    	  Scanner sf = new Scanner(fil);
	    	  
	    	  // exceções poderiam ser intercetadas e mostrar mensagem de erro.
		      while (sf.hasNextLine()) {
		        String line = sf.nextLine();
		        String[] parts = line.split(" ");	// Parts[1] has the key value
		        									// Parts[0] has the user name
		        assert list.set(parts[1], parts[0]) : "ERROR saving the file values";
		      }
		      sf.close();
	      } catch (FileNotFoundException e) {
	    	  err.println("ERROR: Exception found : " + e.getMessage());
	    	  exit(1);
	      }
		
		return list;
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
