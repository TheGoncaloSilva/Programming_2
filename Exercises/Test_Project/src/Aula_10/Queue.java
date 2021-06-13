package Aula_10;

public class Queue<E> {

	private LinkedList<E> list = new LinkedList<E>();

	/** Adds a new element to the queue.
	 */
	public void in(E element) { 
		assert !isFull(); // Pr�-condi��o
		list.addLast(element); 
		assert !isEmpty(); // P�s-condi��o
	}

 	/** @return  First element in the queue.
 	 */
	public E peek() { 
		assert !isEmpty(); // Pr�-condi��o
		return list.first();	
	}

	/** Removes the first element in the queue.
	 */
	public void out() { 
		assert !isEmpty(); // Pr�-condi��o
		list.removeFirst(); 
		assert !isFull(); // P�s-condi��o
	}
	
	/** @return Number of elements in the queue.
	 */
	public int size() { return list.size(); }

	/** Checks if the queue is empty.
	 * @return  {@code true} if queue empty, otherwise {@code false}.
	 */
	public boolean isEmpty() { return list.isEmpty(); }

	// Acrescente aqui outras fun��es necess�rias:
	
	/* Checks if the queue is Full
	 * @return {@code true} if queue is Full, otherwise {@code false}.
	 */
	public boolean isFull() {return false;}
	
	/* Clears the queue (remove all elements)
	 *  queue.out() loop
	 */
	public void clear() {}
}
