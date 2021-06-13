package Aula_10;

public class Stack<E> {

	private LinkedList<E> list = new LinkedList<E>();

	/** Adds a new element to the top of the stack.
   */
	public void push(E element) {
	  assert !isFull(); // Pré-condição
	  list.addFirst(element);
	  assert !isEmpty() && (top() == element); // Pós-condição
 	}
  
	/** Returns the top element in the stack.
	 * @return  Top element in the stack
	 */
	public E top() { 
		assert !isEmpty(); // Pré-condição
		return list.first(); }

	/** Removes the top element in the stack.
	 */
	public void pop() {
		assert !isEmpty(); // Pré-condição	
		list.removeFirst();
		assert !isFull(); // Pós-condição
	}

	/** Returns the number of elements in the stack.
	 * @return Number of elements in the stack
	 */
	public int size() { return list.size(); }

	/** Checks if the stack is empty.
	 * @return  {@code true} if stack empty, otherwise {@code false}.
	 */
	public boolean isEmpty() { return list.isEmpty(); }

	// Acrescente aqui outras funções necessárias:
	//...
  
	/** Checks if the stack is empty
	 * @return boolean value
	 */
	public boolean isFull() { return false ; }
  
	/** Clears the stack (remove all elements)
	 *  Stack.pop loop
	 */
	public void clear() {
	  
	}
 
}
