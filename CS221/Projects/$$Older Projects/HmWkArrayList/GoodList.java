import java.util.LinkedList;
import java.util.Iterator;

/**
 * Class that wraps the Java API LinkedList in the IndexedUnorderedListADT
 * interface to serve as a "good" implementation of a List. 
 * 
 * @param <T> the type of elements held in this collection
 * 
 * @author mvail
 */
public class GoodList<T> implements IndexedUnorderedListADT<T> {
	private LinkedList<T> list;
	
	public GoodList() {
		list = new LinkedList<T>();
	}

	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedList");
		}
		return list.removeFirst();
	}

	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedList");
		}
		return list.removeLast();
	}

	@Override
	public T remove(T element) {
		if (isEmpty()) {
			throw new ElementNotFoundException("UnorderedList");
		}
		
		int idx = list.indexOf(element);
		if (idx < 0) {
			throw new ElementNotFoundException("UnorderedList");
		}
		T t = list.get(idx);
		list.remove(t);
		return t;
	}

	@Override
	public T first() {
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedList");
		}
		return list.getFirst();
	}

	@Override
	public T last() {
		if (isEmpty()) {
			throw new EmptyCollectionException("UnorderedList");
		}
		return list.getLast();
	}

	@Override
	public boolean contains(T target) {
		return list.contains(target);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public void addToFront(T element) {
		list.addFirst(element);
	}

	@Override
	public void addToRear(T element) {
		list.addLast(element);
	}

	@Override
	public void addAfter(T element, T target) {
		if (isEmpty()) {
			throw new ElementNotFoundException("UnorderedList");
		}
		
		int targetIdx = list.indexOf(target);
		if (targetIdx < 0) {
			throw new ElementNotFoundException("UnorderedList");
		} else {
			list.add(targetIdx+1, element);
		}
	}
	
	@Override
	public String toString() {
		return list.toString();
	}

	@Override
	public void add(int index, T element) {
		list.add(index, element);
	}

	@Override
	public void set(int index, T element) {
		list.set(index, element);
	}

	@Override
	public void add(T element) {
		list.add(element);
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public int indexOf(T element) {
		return list.indexOf(element);
	}

	@Override
	public T remove(int index) {
		return list.remove(index);
	}
}
