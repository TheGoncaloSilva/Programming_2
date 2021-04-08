package Aula_04;

public class Tarefa {
	private Data inicio;
	private Data fim;
	private String desc;
	
	public Tarefa(Data inicio, Data fim, String desc) {
		this.inicio = inicio;
		this.fim = fim;
		this.desc = desc;
		//assert desc != null || desc != "" : "A tarefa precisa de ter uma descrição";
		assert desc != null : "A tarefa precisa de ter uma descrição";
		assert desc != "" : "A tarefa precisa de ter uma descrição";
		assert inicio.toString().compareTo(fim.toString()) < 0 : "A data de fim precisa de ser superior à data de inicio";
	}
	
	/** Devolve esta data segundo a norma ISO 8601. */
	public String toString() {
		return String.format("%s --- %s: %s", inicio, fim, desc);
	}
	
	public Data inicio() { return inicio;}
	public Data fim() { return fim;}
	public String texto() { return desc;}
	
	public boolean interseta(Data t1, Data t2){
		/* Compare to values
		 * S1 == S2 : 0
		 * S1 > S2 : 1
		 * S1 < S2 : -1
		 */
		/*
		String start1 = t1.toString(), start2 = inicio().toString(), end1 = t2.toString(), end2 = fim().toString();
		return !(end1.compareTo(start2) < 0) || start1.compareTo(end2) > 0;
		*/
		
		return !(t2.toString().compareTo(inicio().toString()) < 0 || t1.toString().compareTo(fim().toString()) > 0); // Instead of coding the conditions when they intersect
																													 // code the two cases when the dates dont overlap and negate them, 
																													 // alternative could also use morgan logic and change the positive and negative values
	}
}
