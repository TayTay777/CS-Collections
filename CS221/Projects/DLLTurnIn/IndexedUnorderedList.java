import java.util.Iterator;

/**
 *  Interface for an Iterable, Indexed, Unordered List ADT.
 *
 * @author CS 221
 *
 * @param <T> - class of objects stored in the list 
 */
public interface IndexedUnorderedList<T> extends Iterable<T>
{
	// ************** Methods for a general list collection. 
	   /**  
     * Removes and returns the first element from this list. 
     * 
     * @return the first element from this list
     * @throws IllegalStateException if list contains no elements
     */
    public T removeFirst();

    /**  
     * Removes and returns the last element from this list. 
     *
     * @return the last element from this list
     * @throws IllegalStateException if list contains no elements
     */
    public T removeLast();

    /**  
     * Removes and returns the specified element from this list. 
     *
     * @param element the element to be removed from the list
     * @return removed element
     * @throws NoSuchElementException if element is not in this list
     */
    public T remove(T element);

    /**  
     * Returns a reference to the first element in this list. 
     *
     * @return a reference to the first element in this list
     * @throws IllegalStateException if list contains no elements
     */
    public T first();

    /**  
     * Returns a reference to the last element in this list. 
     *
     * @return a reference to the last element in this list
     * @throws IllegalStateException if list contains no elements
     */
    public T last();

    /**  
     * Returns true if this list contains the specified target element. 
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element, else false
     */
    public boolean contains(T target);

    /**  
     * Returns true if this list contains no elements. 
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in this list. 
     *
     * @return the integer representation of number of elements in this list
     */
    public int size();

    /**  
     * Returns a string representation of this list. 
     *
     * @return a string representation of this list
     */
    public String toString();

	// *********** Methods for indexed list collection. 
    //Elements are referenced by contiguous numeric indexes.
    /**  
     * Inserts the specified element at the specified index. 
     * 
     * @param index   the index into the array to which the element is to be inserted.
     * @param element the element to be inserted into the array
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    public void add(int index, T element);

    /**  
     * Sets the element at the specified index. 
     *
     * @param index   the index into the array to which the element is to be set
     * @param element the element to be set into the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public void set(int index, T element);

    /**  
     * Adds the specified element to the rear of this list. 
     *
     * @param element  the element to be added to the rear of the list    
     */
    public void add(T element);

    /**  
     * Returns a reference to the element at the specified index. 
     *
     * @param index  the index to which the reference is to be retrieved from
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T get(int index);

    /**  
     * Returns the index of the specified element. 
     *
     * @param element  the element for the index is to be retrieved
     * @return the integer index for this element or -1 if element is not in the list    
     */
    public int indexOf(T element);

    /**  
     * Removes  and returns the element at the specified index. 
     *
     * @param index the index of the element to be retrieved
     * @return the element at the given index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public T remove(int index); 
        
	// ********* Methods for an unordered list collection.  
    /**  
     * Adds the specified element to the front of this list. 
     *
     * @param element the element to be added to the front of this list    
     */
    public void addToFront(T element);  

    /**  
     * Adds the specified element to the rear of this list. 
     *
     * @param element the element to be added to the rear of this list    
     */
    public void addToRear(T element); 

    /**  
     * Adds the specified element after the specified target. 
     *
     * @param element the element to be added after the target
     * @param target  the target is the item that the element will be added after
     * @throws NoSuchElementException if target element is not in this list
     */
    public void addAfter(T element, T target);
    
    // ************** Methods that return Iterator and ListIterator 
    /**  
     * Returns an Iterator for the elements in this list. 
     *
     * @return an Iterator over the elements in this list
     */
    
    public Iterator<T> iterator();
  
}
