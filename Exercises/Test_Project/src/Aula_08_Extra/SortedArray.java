package Aula_08_Extra;

public class SortedArray<E extends Comparable<E>> {
	private E[] array;
	private int size = 0, maxSize = 0;
	
	@SuppressWarnings("unchecked")// Obrigatório com array
	public SortedArray(int s){
		assert s >= 0 : "Value needs to be positive or neutral";
		this.maxSize = s;
		array = (E[]) new Comparable[maxSize];
		
	}
	
	@SuppressWarnings("unchecked")
	public SortedArray() { this.array = (E[]) new Comparable[maxSize];  }
	
	public boolean isFull() {return size == maxSize - 1;}
	
	/**
	* @return Number of elements in the list
	*/
	public int size() { return size; }
	
	/** Checks if the list is empty.
	* @return  {@code true} if list empty, otherwise {@code false}.
	*/
	public boolean isEmpty() { return size == 0; }
	
	/** Removes the first element in the list.
	*/
	public void removeFirst() {
		assert !isFull() : "empty!";
	    for(int i = 0; i < (size - 1); i++)
	    	array[i] = array[i + 1];
	    size--;
	}
	
	/**
	* @return  First element in the list
	*/
	public E first() {
		assert !isFull(): "empty!";
		return array[0];
	}
	
	/** Inserts a new element in the list.
	* @param e the element to be inserted
	*/
	public void insert(E e) {
		insert(0,e);
	    size++;
	}
	private void insert(int cicle, E e) {
		if ((array[cicle] == null || e.compareTo(array[cicle]) < 0) && !isFull())
	      array[cicle] = e;
	    insert(cicle + 1, e);
	}
	
	/** Checks if the list is sorted.
	* @return {@code true} if sorted, {@code false} otherwise
	*/
	public boolean isSorted() { 
		if (size < 2)
	      return true;
	    return isSorted(0); 
	}
	private boolean isSorted(int n) {
	    if (array == null) return true;
	    if(n == size - 1) return true;
	    if (array[n + 1].compareTo(array[n]) < 0) return false;
	    return isSorted(n + 1);
	}
	
	/** Checks if the given element exists in the list.
	* @param e an element
	* @return {@code true} if the element exists and {@code false} otherwise
	*/
	public boolean contains(E e) { 
		return contains(0, e); 
	}
	private boolean contains(int n, E e) {
		if (array == null) return false;
	    if (array[n] == null) return e == null; //dispensável, se impedirmos elem==null
	    if (array[n].equals(e)) return true; 
	    return contains(n + 1, e);
	}
	
	// Returns a new sorted list with the elements of two lists
	// Recursive solution version
	public SortedArray<E> merge(SortedArray<E> lst){
		if(lst.isEmpty() && this.isEmpty())
			return null;
			  
		SortedArray<E> aux = new SortedArray<E>(this.size + lst.size);
			  
		merge(this, aux, 0);
			  
		merge(lst, aux, 0);
			  
		return aux;
	}
		  
	private SortedArray<E> merge(SortedArray<E> lst1, SortedArray<E> lst2, int cicle){
		if(cicle < lst1.size()) {
			lst2.insert(lst1.array[cicle]);
			merge(lst1, lst2, cicle += 1);
		}
		return lst2;
	}
	
	public void copytoArray(E[] a) {
		
	}
	
}
