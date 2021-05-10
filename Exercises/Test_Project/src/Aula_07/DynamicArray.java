package Aula_07;

/** This class implements a "dynamic" array of elements of generic type.
 * The capacity of a dynamic array grows automatically, as needed.
 * It implements a random access abstract data type, with two main methods:
 * set and get.
 */
public class DynamicArray<E> {

  private E[] array;
  private int maxidx = -1;  // maximum index ever set

  private static final int BLOCK = 256;

  // Define the constructor to initialize the fields
  @SuppressWarnings("unchecked") // Obligatory when dealing with arrays
  public DynamicArray() { this.array = (E[]) new Object[0]; }
  
  /** Returns the length of the array.
   * The "length" is defined as 1 plus the maximum index that was set.
   * @return Number of elements in the array
   */
  public int length() { return 1 + maxidx; }

  /** Set the element in position idx to given value.
   * array[idx] = value
   */
  @SuppressWarnings("unchecked") // Obligatory when dealing with arrays
  public void set(int idx, E value) {
    assert idx >= 0 : "Index must be positive";
    //System.out.println(idx + " + " + maxidx);
    if(idx >= maxidx) {
    	int len = maxidx;
    	
    	for(int i = 0; i < 10; i++) {
    		len = (int) Math.pow(2, i);
    		if(len > idx)
    			break;
    	}
    	//System.out.println(len);
		E[] aux = (E[]) new Object[len];
		
		for(int i = 0; i < maxidx + 1; i++)
			aux[i] = array[i];
		array = aux;
		maxidx = len - 1;
    }
    array[idx] = value;
  }


  /** Return the element in a given position in the list.
   * @param idx  the index of the element (0 is the first).
   * @return value at position idx of the array, or null, if not set yet.
   */
  public E get(int idx) {
    assert idx >= 0 : "Index value muste be positive and within the length of the list";
    //System.out.println(idx + " + " + maxidx);
    if(idx > maxidx) return null;
	return get(idx - 1, 0);
  }

  private E get(int idx, int cicle) {
	  if(idx == cicle - 1) {
		  return array[idx];
	  }else
		  return get(idx, cicle + 1);
  }
  
  // v = a.get(n, d) returns d instead of null
  public boolean get(int idx, boolean con) {
	  assert idx >= 0 : "Index value muste be positive and within the length of the list";
	  if(idx > maxidx) return false;
	  return get(idx, 0) == null;
  }

}
