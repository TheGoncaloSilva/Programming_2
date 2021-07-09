package Aula_10;

import static java.lang.System.*;

public class HanoiTowers {
	private Stack<Integer> p1, p2, p3;
	private int m = 0, discs = 0;
	
	public HanoiTowers() {} // Construtor default
	public HanoiTowers(int discs) {
		p1 = new Stack<Integer>();
		p2 = new Stack<Integer>();
		p3 = new Stack<Integer>();
		this.discs = discs;
		
		int i = 0;
		for(i = 0; i < discs; i++) 
			p1.push(discs-i); // inicializar os discos na primeira torre
		assert i == discs;
		showState(1);

		
	}
	
	public int numberOfMoves() { return m;}
	
	public void solve(){
		solve(p1.size(),p1,p3,p2);
	}
	public void solve(int n, Stack<Integer> posteInicial, Stack<Integer> posteAuxiliar, Stack<Integer> posteFinal){
		if(n==0) {
			if(posteInicial.size()==0) return;
			moveDisk(posteInicial, posteFinal);
		}else{
			solve(n-1,posteInicial,posteFinal,posteAuxiliar);
			if(posteInicial.size()==0) return;
			moveDisk(posteInicial, posteFinal);
			solve(n-1,posteAuxiliar,posteInicial,posteFinal);
		}
	}
	
	public void moveDisk(Stack<Integer> a,Stack<Integer> b){
		int n = a.top();
		a.pop();
		b.push(n);
		m++;
		System.out.println("\nAfter " + m + " moves:");
		System.out.println("A: " + reverseToString(p1));
		System.out.println("B: " + reverseToString(p2));
		System.out.println("C: " + reverseToString(p3));
	}
	
	public void showState(int moves) {
		out.println("After " + moves + " moves: ");
		out.println("A: [" + printTower(p1) + "] ");
		out.println("B: [" + printTower(p2) + "] ");
		out.println("C: [" + printTower(p3) + "] ");
	}
	
	public String printTower(Stack t) {
	
		Stack<Integer> aux = t;
		
		return printTower2(t, "");
		
		
	}
	
	private String printTower2(Stack aux, String text) {
		if(aux.size() == 0) return text;
		int result = (int) aux.top();
		aux.pop();
		if(aux.size() > 0)
			return printTower2(aux, text += result + ", ");
		else
			return text.substring(0, text.length() - 2); // remove the ", "
	}
	
	public void moverDiscos(int n, String origem, String destino, String auxiliar){
		assert n >= 0;
		if(n == 1) {
			//out.println("Move disco " + n + " da torre " + origem + " para a torre " + destino);
			return;
		}
		moverDiscos(n-1, origem, auxiliar, destino);
		
		//out.println("Move disco "+n+" da torre "+origem+" para a torre "+destino);
		moverDiscos(n-1, auxiliar, destino, origem);
	}
	
	public String reverseToString(Stack t) {
		String result = "";
		String pT = printTower(t);
		for(int i = pT.length() - 1; i > 0; i++) {
			result += pT.charAt(i);
		}
		return result;
	}

}
