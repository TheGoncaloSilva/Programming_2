/* For information about the exercise, check the folder class_contents */
package Aula_08_Extra;

import Aula_04.Data;

import static java.lang.System.*;

public class Exercise_8_5 {
	
	// Analise e complete este programa.
	// Experimente chamar, por exemplo:
	//
	// java -ea Birthdays 1867-09-07 Curie 1879-03-14 Einstein 1809-02-12 Darwin

	public static void main(String[] args) {
		requireEA();
		if (args.length % 2 != 0) {
		      err.println("Erro: número de argumentos inválido");
		      err.println("Utilização: java Birthdays data1 nome1 data2 nome2 ...");
		      err.println("Cada data no formato YYYY-MM-DD.");
		      exit(1);
		    }

		// Criar lista para guardar pessoas:
		SortedList<Pessoa> pessoa = new SortedList<Pessoa>();

		for (int i=0; i<args.length/2; i++) {
			Data nasc = Data.parseData(args[2*i]); // devolve null, se inválida!
			String nome = args[2*i+1];

			// Criar nova pessoa com os dados dos argumentos e acrescentar à lista:
			pessoa.insert(new Pessoa(nasc, nome));
			
		}

		// Imprimir a lista:
		out.println("List of people");
		pessoa.print();

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
