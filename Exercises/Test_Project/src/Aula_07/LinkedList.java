package Aula_07;

/** This class implements a List abstract data type using a linked list.
 * Please note that this is p2utils.LinkedList.
 * It is NOT the java.util.LinkedList class in the standard Java library!
 */
public class LinkedList<E> {

  private Node<E> first = null;
  private Node<E> last = null;
  private int size = 0;

  /** {@code LinkedList} constructor, empty so far.
   */
  public LinkedList() { }

  /** Returns the number of elements in the list.
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /** Returns the first element in the list.
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";

    return first.elem;
  }

  /** Returns the last element in the list.
   * @return Last element in the list
   */
  public E last() {
    assert !isEmpty(): "empty!";

    return last.elem;
  }

  /** Adds the given element to the start of the list.
   * @param e the element to add
   */
  public void addFirst(E e) {
    first = new Node<>(e, first);
    if (isEmpty())
      last = first;
    size++;

    assert !isEmpty(): "empty!";
    assert first().equals(e) : "wrong element";
  }

  /** Adds the given element to the end of the list.
   * @param e the element to add
   */
  public void addLast(E e) {
    Node<E> newest = new Node<>(e);
    if (isEmpty())
      first = newest;
    else
      last.next = newest;
    last = newest;
    size++;

    assert !isEmpty(): "empty!";
    assert last().equals(e) : "wrong element";
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
    if (isEmpty())
      last = null;
  }

  /** Removes all elements.
   */
  public void clear() {
    first = last = null;
    size = 0;
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
  
  /* Função de count para treinar
   * public int count(E x) {
	  int count = 0;
	  if (this != null) {
		  System.out.println(first.elem);
		  if(first.elem.toString().indexOf(x.toString()) > 0)
			  count++;
	      print(first.next);
	    }  
      return count;
   }*/

  // Função para clonar a lista (Devolve um lista nova na mesma sequência)
  public LinkedList<E> clone() {
	  if (isEmpty())
		  return null;
	  LinkedList<E> aux = new LinkedList<E>();
	  aux = clone(first, aux);
	  return aux; 
  }
  
  private LinkedList<E> clone(Node<E> n, LinkedList<E> lst) {
	  if(n != null) {
		  lst.addLast(n.elem);
		  //lst.size++;
		  return clone(n.next, lst);
	  }
	  return lst; 
  }
  
  //Devolver uma nova lista em ordem inversa
  public LinkedList<E> reverse(){
	  if (isEmpty())
		  return null;
	  
	  LinkedList<E> aux = new LinkedList<E>();
	  aux = reverse(first, aux);
	  return aux; 
  }
  
  private LinkedList<E> reverse(Node<E> n, LinkedList<E> lst){
	  if(n != null) {
		  lst.addFirst(n.elem);
		  //lst.size++;
		  return reverse(n.next, lst);
	  }
	  return lst; 
  }
  
  // Devolve o elemento na posição indicada
  public E get(int pos) {
	  assert pos >= 0 && pos < this.size() : "Invalid Position";
	  return get(first, pos, 0);
  }
  
  private E get(Node<E> n, int pos, int cicle) {
	  if(pos == cicle) return n.elem;
	  return get(n.next, pos, cicle += 1);
  }
  
  // Devolve uma nova lista com os elementos da lista que chama o método, seguido dos elementos da lista fornecida como argument
  // Iteractive version
  public LinkedList<E> concatenate(LinkedList<E> lst){
	  if(lst.isEmpty() && this.isEmpty())
		  return null;
	  
	  LinkedList<E> aux = new LinkedList<E>();
	  
	  Node<E> n = this.first;
	  for(int i = 0; i < this.size(); i++) {
		  aux.addLast(n.elem);
		  n = n.next;
	  }
	  
	  n = lst.first;
	  for(int i = 0; i < lst.size(); i++) {
		  aux.addLast(n.elem);
		  n = n.next;
	  }
	  
	  return aux;
  }
  
  // remove(e)
  // Elimina a primeira ocorrência do elemento.
  // Por exemplo, remove("batata") deve eliminar o primeiro elemento "batata" da lista.
  public void remove(E e) {
	  if(!isEmpty()) {
		  remove(first, e, 0);
	  }
		  
  }
  
  private void remove(Node<E> n, E x,int cicle) {
	  assert x != null : "A value is required";
	    if (n != null) {
	        /*if(n.elem.equals(x)) {
	        	if(cicle == 0) {
	                first = first.next;
	                size--;
	                if(size==0) last = first;
	                return;
	        	}else if(cicle + 1 == size() - 1) {
	        		n.next = null;
	                last = n;
	        	}else {
	        		n.next = n.next.next;
	        	}
	        	size--;
	        	return;
	        	*/
	    	if(n.elem.equals(x) && cicle == 0) {
	    		first = first.next;
	    		size--;
	    		if(size==0) last = first;
	    		return;
	        }else if(n.next.elem.equals(x)){
	        	if(cicle + 1 == size() - 1) {
	        		n.next = null;
	                last = n;
	        	}else {
	        		n.next = n.next.next;
	        	}
	        	size--;
	        	return;
	        }else
	        	remove(n.next, x, cicle + 1);
	    }
	  
  }

}
