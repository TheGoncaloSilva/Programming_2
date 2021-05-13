package codecheck;

public class LinkedList<E> {

   private Node<E> first = null;
   private Node<E> last = null;
   private int size = 0;

   /** Constructor, empty so far.   */
   public LinkedList() { }

   /** List size.  */
   public int size() { return size; }

   /** Checks if the list is empty.  */
   public boolean isEmpty() { return size == 0; }

   /** First element.  */
   public E first() {
      assert !isEmpty(): "Should not be empty!";
      return first.elem;
   }

   /** Last element.  */
   public E last() {
      assert !isEmpty(): "Should not be empty!";
      return last.elem;
   }

   /** Clear list. */
   public void clear() {
      first = last = null;
      size = 0;
      // post-condition:
      assert isEmpty();
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

   /** Check if the given element exists in the list.
    * @param x the element to search for
    * @return {@code true} if the element exists and {@code false} otherwise
    */
   public boolean contains(E x) {
      return contains(first, x);
   }
   // Auxiliary function:
   // Check if x exists in sublist starting at node n.
   private boolean contains(Node<E> n, E x) {
      if (n == null) return false;
      if (n.elem == x || n.elem.equals(x)) return true;
      return contains(n.next, x);
   }

   // Mostra a lista (e alguns detalhes internos).
   public void show(String name) {
      System.out.printf("%s: %s size=%d first=%s last=%s\n",
         name, this.toString(), size,
         first==null? "-": first.elem,
         last==null? "-": last.elem);
   }

   /** Adds a new element to the start of the list. */
   public void addFirst(E e) {
      first = new Node<E>(e, first);
      if (isEmpty())
         last = first;
      size++;
      // post-condition:
      assert !isEmpty(): "Should not be empty!";
      assert first() == e : "First element should be e!";
   }

   /** Adds a new element to the end of the list. */
   public void addLast(E e) {
      Node<E> newest = new Node<E>(e);
      if (isEmpty())
         first = newest;
      else
         last.next = newest;
      last = newest;
      size++;
      // post-condition:
      assert !isEmpty(): "Should not be empty!";
      assert last() == e : "Last element should be e!";
   }

   // `removeSecond()`
   // Remove the second element in the list.
   public void removeSecond() {
      assert size >= 2: "List should contain two or more elements!";
      first.next = first.next.next;
      size--;

   }

   // `copyToArray(a)`
   // Copia elementos da lista para o array `a`.
   // Devem ser copiados tantos elementos quantos couberem no array.
   // O método deve devolver o número de elementos efetivamente copiados.
   // Naturalmente, a lista não deve ser modificada por esta operação.
   public int copyToArray(E[] a) {
	   if(size() < 2) {
		   a[0] = first.elem;
		   return 1;
	   }
	Node<E> n = this.first;
	int i = 0;
	for(i = 0; i < a.length; i++) {
		a[i] = n.elem;
		n = n.next;
	}
	return a.length;
      
   }

   // `removeElem(x)`
   // Elimina o (primeiro) elemento da lista _igual a_ `x`.
   // Repare que a pré-condição exige que `x` esteja na lista.
   public void removeElem(E x) {
      assert contains(x) : "Element x should exist in the list";
      // COMPLETE...

   }


}