/**
 * SingleLinkedList represents a LinearNode-based implementation of both an unordered and indexed list.
 *
 * @author Java Foundations, 
 * @version 4.0
 */
public class SingleLinkedList<T> extends AbstractLinkedList<T> implements IndexedUnorderedListADT<T>
{	
	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToFront(T element)
	{
		// TODO To be completed as a Programming Project
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element the element to be added to the list
	 */
	public void addToRear(T element)
	{
		// TODO To be completed as a Programming Project
	}	

	/**
	 * Adds the specified element to this list after the given target.
	 *
	 * @param  element the element to be added to this list
	 * @param  target the target element to be added after
	 * @throws ElementNotFoundException if the target is not found
	 */
	public void addAfter(T element, T target)
	{
		// TODO To be completed as a Programming Project
	}

	/**  
	 * Inserts the specified element at the specified index. 
	 * 
	 * @param index   the index into the array to which the element is to be
	 *                inserted.
	 * @param element the element to be inserted into the array   
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public void add(int index, T element) {
		// TODO To be completed as a Programming Project
	}

	/**  
	 * Adds the specified element to the rear of this list. 
	 *
	 * @param element  the element to be added to the rear of the list    
	 */
	public void add(T element) {
		// TODO To be completed as a Programming Project
	}

	/**  
	 * Sets the element at the specified index. 
	 *
	 * @param index   the index into the array to which the element is to be set
	 * @param element the element to be set into the list
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public void set(int index, T element) {
		// TODO To be completed as a Programming Project
	}

	/**  
	 * Returns a reference to the element at the specified index. 
	 *
	 * @param index  the index to which the reference is to be retrieved from
	 * @return the element at the specified index    
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public T get(int index) {
		// TODO To be completed as a Programming Project
		return null;
	}

	/**  
	 * Returns the index of the specified element. 
	 *
	 * @param element  the element for the index is to be retrieved
	 * @return the integer index for this element or -1 if element is not in the list
	 */
	public int indexOf(T element) {
		// TODO To be completed as a Programming Project
		return -1;
	}

	/**  
	 * Returns the element at the specified element. 
	 *
	 * @param index the index of the element to be retrieved
	 * @return the element at the given index    
	 * @throws IndexOutOfBoundsException for invalid index
	 */
	public T remove(int index) {
		// TODO To be completed as a Programming Project
		return null;
	}
}
