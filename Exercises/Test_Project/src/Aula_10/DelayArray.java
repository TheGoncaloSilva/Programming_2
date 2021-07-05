package Aula_10;

/**
 * Implementa uma linha de atraso com array "circular".
 * Funciona como fila, mas de tamanho fixo e com acesso direto a
 * qualquer dos elementos (amostras), atrav�s do get(pos).
 * N�o tem out(). Apenas tem in(x), que acrescenta uma nova amostra
 * e simultaneamente descarta a mais antiga.
 */
public class DelayArray<E> {
	/** Este � o array onde as amostras v�o ser armazenadas. */
	private E[] buffer;

	/** Este � o �ndice onde se vai inserir a pr�xima amostra
	* (e onde est� a amostra mais antiga).
	*/
	private int next;

	/** Cria uma linha de atraso com size amostras inicializadas. */
	@SuppressWarnings(value = "unchecked")  // sem isto, d� warning!
	public DelayArray(int size, E init) {
		assert size >= 0;
	    // FALTA criar array de size elementos de tipo E (tem truque!)
	    //...

	    // FALTA encher buffer com size amostras com o valor "init"
	    //...

	    // Invariante:
	    assert size()==size: String.format("Delay line size should be %d", size);
	    // Pr�-condi��o:
	    assert get(-size()).equals(init) && get(-1).equals(init): "All samples should have the initial value";
	}

	/** Devolve a tamanho da linha de atraso. */
	public int size() { return buffer.length; }

	/** Acrescenta uma nova amostra e descarta a mais antiga.
	* @param x  A amostra atual que � acrescentada no fim da linha.
	*/
	public void in(E x) {
		// FALTA colocar x na posi��o next e incrementar next,
	    // mas "dar a volta" se next == length!
	    //...

	}

	/** Valor da amostra do instante t.
	* get(-1) devolve a �ltima amostra armazenada na linha,
	* get(-2) devolve a pen�ltima e assim sucessivamente.
	* Requer que -size() <= t < 0.
	*/
	public E get(int t) {
		assert -size() <= t && t < 0;
	    // FALTA devolver amostra da posi��o (next+t), mas "dar a volta" se < 0!
	    //...
		return null;

	}
}