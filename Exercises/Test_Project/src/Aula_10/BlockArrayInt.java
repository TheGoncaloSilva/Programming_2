package Aula_10;

//Altere esta classe para implementar um tipo de dados abstrato que funciona
//como um array, com m�todos de put e get.
//A implementa��o fornecida cria um �nico array, mas queremos substitu�-lo
//por uma lista de blocos (arrays de tamanho blocksize), que poder�o crescer
//juntando progressivamente mais blocos � lista.
public class BlockArrayInt
{
	private int[] a;
	
	public BlockArrayInt(int blockSize, int numBlocks) {
		assert blockSize > 0;
		assert numBlocks > 0;
	
		a = new int[blockSize*numBlocks];
	}
	
	public int get(int index) {
		assert validIndex(index);
	
		return a[index];
	}
	
	public void put(int elem, int index) {
		assert validIndex(index);
	
		a[index] = elem;
	}
	
	public void incrementNumberOfBlocks() {
		assert false: "Not yet implemented!";
	}
	
	public int size() {
		return a.length;
	}
	
	public int numberOfBlocks() {
		return 1;
	}
	
	public int blockSize() {
		return a.length;
	}
	
	public boolean validIndex(int index) {
		return index >= 0 && index < size();
	}

}

