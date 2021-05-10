
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

   /** Removes the first element in the list. */
   public void removeFirst() {
      assert !isEmpty(): "Should not be empty!";
      first = first.next;
      size--;
      if (isEmpty())
         last = null;
   }

   // `addFirst(e)`
   // acrescenta o elemento `e` no início da lista,
   // mas mantém os restantes elementos intactos.
   public void addFirst(E e) {
      first = new Node<>(e, first);
      if(isEmpty())
         last = first;
      size++;
      
      assert !isEmpty(): "empty!";
      assert first().equals(e) : "wrong element";
   }

   // `count(x)`
   // Determina e devolve quantos elementos da lista são _iguais_ a `x`.
   // Naturalmente, a lista não deve ser modificada por esta operação.
   public int count(E x) {
      if(size==0) return 0;
      return count(first, x, 0);
   }
   
   public int count(Node<E> n, E x, int c){
      if(n==null) return c;
      if(n.elem==x) return count(n.next, x, c+1);
      return count(n.next, x, c);
   }

   // `remove(p)`
   // Elimina o elemento da posição `p` da lista.
   // Por exemplo, `remove(0)` deve eliminar o primeiro elemento da lista.
   public void remove(int p) {
      assert 0<=p && p<size : "Index out of bounds";
      if(p==0){
         first = first.next;
         size--;
         if(size==0) last = first;
         return;
      }
      Node<E> n = first;
      int i = 0;
      while(n!=null){
         if(i+1==p){
            if(i+1==size-1){
               n.next = null;
               last = n;
            }else{
               n.next = n.next.next;
            }
            break;
         }
         n = n.next;
         i++;
      }
      size--;
   }


}