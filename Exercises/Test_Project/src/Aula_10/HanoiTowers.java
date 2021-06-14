package Aula_10;

import static java.lang.System.*;

public class HanoiTowers {
	private Stack<Integer> p1, p2, p3;
	private int m = 0;
	
	public HanoiTowers() {} // Construtor default
	public HanoiTowers(int discs) {
		p1 = new Stack<Integer>();
		p2 = new Stack<Integer>();
		p3 = new Stack<Integer>();
		
		int i = 0;
		for(i = 0; i < discs; i++) 
			p1.push(i); // inicializar os discos na primeira torre
		assert i == discs;
		showState(1);

		
	}
	
	public int numberOfMoves() { return m;}
	
	public void solve() {
		//moverDiscos();
	}
	
	public void moveDisk(String a, String b) {
		
		m++;
	}
	
	public void showState(int moves) {
		out.println("After " + moves + " moves: ");
		out.println("A: [");
		printTower(p1);
		out.println("] ");
		out.println("B: [");
		printTower(p1);
		out.println("] ");
		out.println("C: [");
		printTower(p1);
		out.println("] ");
	}
	
	public void printTower(Stack t) {
		Stack<Integer> aux = t;
		
		out.print(aux.top());
		aux.pop();
		
		if(aux.top() != null)
			printTower(aux);
	}
	
	public void moverDiscos(int n, String origem, String destino, String auxiliar){
		assert n >= 0;
		if (n > 0){
			moverDiscos(n-1, origem, auxiliar, destino);
			//out.println("Move disco "+n+" da torre "+origem+" para a torre "+destino);
			moverDiscos(n-1, auxiliar, destino, origem);
		}
	}
	
	public String reverseToString(Stack t) {
		//return printTower(t);
		return "hello";
	}

}
