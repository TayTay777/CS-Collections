import java.util.Arrays;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * Class for sorting lists that implement the IUListWithListIterator interface,
 * using ordering defined by class of objects in list or a Comparator.
 * As written uses Quicksort algorithm.
 *
 * @author CS221
 */
public class Sort
{	
	/**
	 * Returns a new list that implements the IUListWithListIterator interface. 
	 * As configured, uses WrappedDLL. Must be changed if using 
	 * your own IUDoubleLinkedList class. 
	 * 
	 * @return a new list that implements the IUListWithListIterator interface
	 */
	private static <T> IUListWithListIterator<T> newList() 
	{
		//return new IUDoubleLinkedList<T>();
		return new WrappedDLL<T>(); //TODO: replace with your IUDoubleLinkedList for extra-credit
	}

	/**
	 * Sorts a list that implements the IUListWithListIterator interface 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IUListWithListIterator interface 
	 * @see IUListWithListIterator 
	 */
	public static <T extends Comparable<T>> void sort(IUListWithListIterator<T> list) 
	{
		quicksort(list);
	}

	/**
	 * Sorts a list that implements the IUListWithListIterator interface 
	 * using given Comparator.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IUListWithListIterator interface 
	 * @param c
	 *            The Comparator used
	 * @see IUListWithListIterator 
	 */
	public static <T> void sort(IUListWithListIterator <T> list, Comparator<T> c) 
	{
		quicksort(list, c);
	}

	/**
	 * Quicksort algorithm to sort objects in a list 
	 * that implements the IUListWithListIterator interface, 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IUListWithListIterator interface 
	 */

	private static <T extends Comparable<T>> void quicksort(IUListWithListIterator<T> list)
	{
		IUListWithListIterator<T> partitionedListL = newList();
		IUListWithListIterator<T> partitionedListR = newList(); 


		if (list.size() <= 1){
			return;
		}

		else{
			T pivot = list.removeFirst();
			while (0 < list.size()){
				
				if (pivot.compareTo(list.last()) > 0 ){
					partitionedListL.add(list.removeLast());
				}
				else if (pivot.compareTo(list.last()) < 0 ){
					partitionedListR.add(list.removeLast());
				}
				else {
					partitionedListL.add(list.removeLast());
				}
			}
			
			//recursion 
			quicksort(partitionedListL);
			quicksort(partitionedListR);

			
			while (0 < partitionedListL.size()){
				list.add(partitionedListL.removeFirst());
			}
			list.add(pivot);
			while (0 < partitionedListR.size()){
				list.add(partitionedListR.removeFirst());
			}
			return;
		}
	}

	/**
	 * Quicksort algorithm to sort objects in a list 
	 * that implements the IUListWithListIterator interface,
	 * using the given Comparator.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IUListWithListIterator interface 
	 * @param c
	 *            The Comparator used
	 */

	private static <T> void quicksort(IUListWithListIterator<T> list, Comparator<T> c)
	{
		IUListWithListIterator<T> partitionedListL = newList();
		IUListWithListIterator<T> partitionedListR = newList(); 

		if (list.size() <= 1){
			return;
		}
		


		else{
			T pivot = list.removeFirst();
			while (0 < list.size()){
				
				if (c.compare(pivot, list.last()) > 0 ){
					partitionedListL.add(list.removeLast());
				}
				else if (c.compare(pivot, list.last()) < 0 ){
					partitionedListR.add(list.removeLast());
				}
				else {
					partitionedListL.add(list.removeLast());
				}
			}
			
			quicksort(partitionedListL,c);
			quicksort(partitionedListR,c);
			
			while (0 < partitionedListL.size()){
				list.add(partitionedListL.removeFirst());
			}
			list.add(pivot);
			while (0 < partitionedListR.size()){
				list.add(partitionedListR.removeFirst());
			}
			return;
		}

	}

}
