package Aula_03;

import static java.lang.System.*;
import Aula_02.Data;
import Aula_03.Tarefa;

public class Agenda {
	private int size = 1000;
	private Tarefa[] events = new Tarefa[size];
	private int count = 0;
	
	public Agenda() {} // Construtor por omissão
	
	public Agenda(Tarefa[] tarefa, int count) { // Construtor para inicializar a nova agenda
		this.events = tarefa;
		this.count = count;
	}

	public void escreve() {
		sort();
		out.println("Agenda:");
		for(int i = 0; i < count; i++) {
			out.println(events[i]);
		}
		
	}
	
	public void novaTarefa(Tarefa tarefa) {
		events[count] = tarefa;
		count++;
	}

	public Agenda filtra(Data d1, Data d2) {
		Tarefa[] result = new Tarefa[size];
		int aux = 0;
		for(int i = 0; i < count; i++) { 
			if(events[i].interseta(d1, d2)) {
				result[aux++] = events[i];
				//System.out.println(result[aux - 1]);
				
			}
		}
	return new Agenda(result, aux);
	}
	 
	public void sort() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (events[j].inicio().toString().compareTo(events[i].inicio().toString()) < 0) {
					Tarefa tmp = events[j];
					events[j] = events[i];
					events[i] = tmp;
				}
			}
		}
	}
}
