import java.util.ListIterator;

/**
 * Adds requirement that the list supports a java.util.ListIterator to an
 * IndexedUnorderedList
 * 
 * @author Java Foundations
 * @version 4.0
 * @author mvail
 */
public interface DoubleLinkedListADT<T> extends IndexedUnorderedListADT<T> {
	/**
	 * Returns a list iterator over the elements in this list (in proper sequence).
	 * 
	 * @return a list iterator over the elements in this list (in proper sequence)
	 */
	public ListIterator<T> listIterator();
	
	/**
	 * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list. The specified index indicates the first element that would be returned by an initial call to next. An initial call to previous would return the element with the specified index minus one.
	 * 
	 * @param startingIndex index of the first element to be returned from the list iterator (by a call to next)
	 * 
	 * @return a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list
	 * 
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	public ListIterator<T> listIterator(int startingIndex);
	
}
