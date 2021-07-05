package Aula_10;

/**
 * Implementa uma linha de atraso.
 * Trata-se de uma fila, mas de tamanho fixo e com acesso direto a
 * qualquer dos elementos (amostras), atrav�s do get(pos).
 * N�o tem out(). Apenas tem in(x), que acrescenta uma nova amostra
 * e simultaneamente descarta a mais antiga.
 */
public class DelayLine<E> {
	/** Esta � a lista onde as amostras v�o ser armazenadas. */
	private LinkedList<E> buffer;

	/** Cria uma linha de atraso com size amostras inicializadas. */
	public DelayLine(int size, E init) {
		assert size >= 0;
		buffer = new LinkedList<>();
		
		// FALTA encher a lista com size amostras com o valor "init"
		for(int i = 0; i < size; i++) 
			buffer.addLast(init);
		
		// Invariante:
		assert size()==size: String.format("Delay line size should be %d", size);
		// Pr�-condi��o:
		assert get(-size()).equals(init) && get(-1).equals(init): "All samples should have the initial value";
	}
	
	/** Devolve a tamanho da linha de atraso. */
	public int size() { return buffer.size(); }

	/** Acrescenta uma nova amostra e descarta a mais antiga.
	 * @param x  A amostra atual que � acrescentada no fim da linha.
	 */
	public void in(E x) {
		assert size() > 0;
		buffer.addLast(x);
		buffer.removeFirst();
	}

	/** Valor da amostra do instante t.
	 * get(-1) devolve a �ltima amostra armazenada na linha,
	 * get(-2) devolve a pen�ltima e assim sucessivamente.
	 * Requer que -size() <= t < 0.
	 */
	public E get(int t) {
		assert -size() <= t && t < 0;
		// O m�todo get na LinkedList tem de estar implementado (Problema 7.1)
		return buffer.get(size()+t);
	}
}
