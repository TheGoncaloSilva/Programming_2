package Aula_08_Extra;

public class SortedList<E extends Comparable<E>> {
	// private attributes
	  private Node<E> first = null;
	  private int size = 0;

	  public SortedList() { }

	  /**
	   * @return Number of elements in the list
	   */
	  public int size() { return size; }

	  /** Checks if the list is empty.
	   * @return  {@code true} if list empty, otherwise {@code false}.
	   */
	  public boolean isEmpty() { return size == 0; }

	  /**
	   * @return  First element in the list
	   */
	  public E first() {
	    assert !isEmpty(): "empty!";
	      return first.elem;
	  }

	  /** Inserts a new element in the list.
	   * @param e the element to be inserted
	   */
	  public void insert(E e) {
	    first = insert(first,e);
	    size++;
	  }
	  private Node<E> insert(Node<E> n,E e) {
	    if (n == null || e.compareTo(n.elem) < 0)
	      return new Node<E>(e,n);
	    n.next = insert(n.next,e);
	    return n;
	  }

	  /** Removes the first element in the list.
	   */
	  public void removeFirst() {
	    assert !isEmpty(): "empty!";
	    first = first.next;
	    size--;
	  }
	  
	  /** Prints all elements, one per line. */
	  public void print() {
	    print(first);
	  }
	  private void print(Node<E> n) {
	    if (n != null) {
	      System.out.println(n.elem);
	      print(n.next);
	    }
	  }

	  /** Checks if the list is sorted.
	   * @return {@code true} if sorted, {@code false} otherwise
	   */
	  public boolean isSorted() { 
	    if (size < 2)
	      return true;
	    return isSorted(first,first.next); 
	  }
	  private boolean isSorted(Node<E> prev,Node<E> n) {
	    if (n == null) return true;
	    if (n.elem.compareTo(prev.elem) < 0) return false;
	    return isSorted(n,n.next);
	  }
	  
	  /** Checks if the given element exists in the list.
	   * @param e an element
	   * @return {@code true} if the element exists and {@code false} otherwise
	   */
	  public boolean contains(E e) { 
	    return contains(first, e); 
	  }
	  private boolean contains(Node<E> n, E e) {
	    if (n == null) return false;
	    if (n.elem==null) return e==null; //dispensável, se impedirmos elem==null
	    if (n.elem.equals(e)) return true; 
	    return contains(n.next, e);
	  }
	  
	  /** String representation of list.
	  * @return string like "[E0, E1, ...]", where Ek are the elements of the list
	  */
	  public String toString() {
		String sep = "";
	    String s = "";
	    for (Node<E> n = first; n != null; n = n.next) {
	    	s += sep + n.elem;
	        sep = ", ";
	    }
	    return "[" + s + "]";
	   }
	  
	  // Returns a new sorted list with the elements of two lists
	  // Recursive solution version
	  public SortedList<E> merge(SortedList<E> lst){
		  if(lst.isEmpty() && this.isEmpty())
			  return null;
		  
		  SortedList<E> aux = new SortedList<E>();
		  
		  merge(this, this.first, aux, 0);
		  
		  merge(lst, lst.first, aux, 0);
		  
		  return aux;
	  }
	  
	  private SortedList<E> merge(SortedList<E> lst1, Node<E> n, SortedList<E> lst2, int cicle){
		  if(cicle < lst1.size()) {
			  lst2.insert(n.elem);
			  merge(lst1, n.next, lst2, cicle += 1);
		  }
		  return lst2;
	  }
	  
	  
	   
}