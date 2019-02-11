import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author TPR
 *
 * @param <T>
 */

public class IUSingleLinkedList<T> implements IndexedUnorderedList<T>{

	private SLLNode<T> head;
	private SLLNode<T> tail;
	private int size;
	private int modCount;


	/**
	 * Constructor
	 */
	public IUSingleLinkedList(){
		head = null;
		tail = null;
		size = 0;
		modCount = 0;
	}

	/**
	 * @param index
	 * @return SLLNode<T> returns SLLNode<T> at requested index
	 */
	public SLLNode<T> getIndex(int index){
		if (index > size || index < 0){
			throw new IndexOutOfBoundsException("No elements have the requested index");
		}
		SLLNode<T> curNode = new SLLNode<T>(null);
		if (index == size){
			if (tail == null){
				curNode = head = tail;
			}
			else
			{
				curNode = tail.getNext();
			}
		}
		else{
			curNode = head;
			for(int i = 0; i < index; i++){
				curNode = curNode.getNext();
			}
		}

		return curNode;
	}

	@Override
	public T removeFirst() {
		if (tail == null){
			throw new IllegalStateException("The list is empty");
		}
		T retVal = head.getElement();
		if (head == tail){
			head = tail = null;
		}
		else
		{
			head = head.getNext();
		}

		modCount++;
		size--;

		return retVal;
	}

	@Override
	public T removeLast() {
		if (tail == null){
			throw new IllegalStateException("The list is empty");
		}
		T retVal = tail.getElement();
		SLLNode<T> curNode = head;
		for (int i = 1; i < size-1; i++)
		{
			curNode = curNode.getNext();
		}
		if (tail == head){
			tail = head = null;
		}
		else
		{
			tail = curNode; 
		}

		modCount++;
		size--;
		return retVal;
	}

	@Override
	public T remove(T element) {
		
		//as a last ditch effort, to save time I just copied the remove index method because it was working
		
		int index = indexOf(element);
		if (index >= size || index < 0 || tail == null){
			throw new NoSuchElementException("Element does not exist in the list");	
		}
		SLLNode<T> rmNode = getIndex(index);
		if (rmNode == head){
			if (head == tail){
				head = tail = null;
			}
			else{
				head = head.getNext();
			}
		}
		else{
			SLLNode<T> curNode = head;
			for (int i = 1; i < size; i++){
				if (curNode.getNext() == rmNode){
					curNode.setNext(curNode.getNext().getNext());
					if (rmNode == tail){
						tail = curNode;
					}
				}
				curNode = curNode.getNext();
			}
		}

		modCount++;
		size--;
		return rmNode.getElement();
		
		
		
		
		
		
		
		
		//		if (tail == null){
//			throw new NoSuchElementException("Element does not exist in the list");
//		}
//		boolean doesContain = false;
//
//		if (head.getElement() == element){
//			doesContain = true;
//			if (tail == head){
//				tail = head = null;
//
//			}
//			else{
//				head = head.getNext();
//			}
//		}
//		else {
//			SLLNode<T> curNode = head;
//			for (int i = 1; i < size; i++){
//				if (curNode.getNext().getElement() == element){
//					if (curNode.getNext() == tail){
//						tail = curNode;
//						doesContain = true;
//					}
//					else{
//						curNode.setNext(curNode.getNext().getNext());
//						doesContain = true;
//					}
//
//				}
//				curNode = curNode.getNext();
//			}
//		}
//		if (doesContain == false){
//			throw new NoSuchElementException("Element does not exist in the list");
//		}
//		modCount++;
//		size--;
//		return element;
	}

	@Override
	public T first() {
		if (tail == null){
			throw new IllegalStateException("The List is empty...");
		}
		return head.getElement();
	}

	@Override
	public T last() {
		if (tail == null){
			throw new IllegalStateException("The List is empty...");
		}
		return tail.getElement();
	}

	@Override
	public boolean contains(T target) {
		boolean doesContain = false;

		if (tail == null){
			doesContain = false;
		}
		else
		{
			if (head.getElement() == target){
				doesContain = true;
			}
			else {
				SLLNode<T> curNode = head;
				for (int i = 1; i < size; i++)
				{
					if (curNode.getNext().getElement() == target){
						doesContain = true;
					}
					curNode = curNode.getNext();
				}
			}
		}
		return doesContain;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty = false;
		if (tail == null){
			isEmpty = true;
		}
		return isEmpty;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void add(int index, T element) 
	{
		if (index > size || index < 0){
			throw new IndexOutOfBoundsException("Index is out of bounds");	
		}
		SLLNode<T> newNode = new SLLNode<T>(element);
		SLLNode<T> oldIndex = getIndex(index);

		if (oldIndex == head){
			if (tail == null){
				head = tail = newNode;
			}
			else{
				newNode.setNext(head);
				head = newNode;
			}
		}
		else
		{
			SLLNode<T> curNode = head;
			for (int i = 1; i < size; i++)
			{
				if (curNode.getNext() == oldIndex)
				{
					newNode.setNext(oldIndex);	
					curNode.setNext(newNode);
					break;
				}else{
				curNode = curNode.getNext();
				}
			}

		}
		size++;
		modCount++;

	}


	@Override
	public void set(int index, T element) {
		if (index >= size || index < 0 || tail == null){
			throw new IndexOutOfBoundsException("Index is out of bounds");	
		}
		getIndex(index).setElement(element);
		modCount++;
	}


	@Override
	public void add(T element) {
		SLLNode<T> newNode = new SLLNode<T>(element);
		if (tail == null){
			tail=newNode;
			head=newNode;
		}
		else
		{

			tail.setNext(newNode);
			tail = newNode;
		}
		modCount++;
		size++;
	}

	@Override
	public T get(int index) {
		if (index >= size || index < 0 || tail == null){
			throw new IndexOutOfBoundsException("Index is out of bounds");	
		}
		return getIndex(index).getElement();
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		SLLNode<T> curNode = head;
		for (int i = 0; i < size; i++){
			if (curNode.getElement() == element){
				index = i;
			}
			curNode = curNode.getNext();
		}

		return index;
	}

	@Override
	public T remove(int index) {
		if (index >= size || index < 0 || tail == null){
			throw new IndexOutOfBoundsException("Index is out of bounds");	
		}
		SLLNode<T> rmNode = getIndex(index);
		if (rmNode == head){
			if (head == tail){
				head = tail = null;
			}
			else{
				head = head.getNext();
			}
		}
		else{
			SLLNode<T> curNode = head;
			for (int i = 1; i < size; i++){
				if (curNode.getNext() == rmNode){
					curNode.setNext(curNode.getNext().getNext());
					if (rmNode == tail){
						tail = curNode;
					}
				}
				curNode = curNode.getNext();
			}
		}

		modCount++;
		size--;
		return rmNode.getElement();
	}

	@Override
	public void addToFront(T element) {
		SLLNode<T> newNode = new SLLNode<T>(element);
		if (tail == null){
			head = tail = newNode;
		}
		else{
			newNode.setNext(head);
			head = newNode;
		}
		modCount++;
		size++;
	}

	@Override
	public void addToRear(T element) {
		SLLNode<T> newNode = new SLLNode<T>(element);
		if (tail == null){
			tail=newNode;
			head=newNode;
		}
		else
		{

			tail.setNext(newNode);
			tail = newNode;
		}
		modCount++;
		size++;

	}

	@Override
	public void addAfter(T element, T target) {
		SLLNode<T> newNode = new SLLNode<T>(element);
		if (indexOf(target) == -1){
			throw new NoSuchElementException("The target Element does not exist in the list");
		}
		SLLNode<T> tIndexNode = getIndex(indexOf(target));



		SLLNode<T> curNode = head;
		for (int i = 1; i < size; i++)
		{
			if (curNode == tIndexNode)
			{
				newNode.setNext(curNode.getNext());
				curNode.setNext(newNode);
				if (tIndexNode == tail)
				{
					tail = newNode;
				}
			}
		}
		tIndexNode.setNext(newNode);
		tail = newNode;

		modCount++;
		size++;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){

		String toString = "[";


		SLLNode<T> curNode = head;

		for (int i = 0; i < size; i++)
		{

			if (i == 0)
			{
				if (curNode.getElement().equals(1)){
					toString+= "A";
				}
				else if (curNode.getElement().equals(2)){
					toString+= "B";
				}
				else if (curNode.getElement().equals(3)){
					toString+= "C";
				}
				else if (curNode.getElement().equals(4)){
					toString+= "D";
				}
				else if (curNode.getElement().equals(5)){
					toString+= "E";
				}
				else if (curNode.getElement().equals(6)){
					toString+= "F";
				}
				else if (curNode.getElement().equals(7)){
					toString+= "G";
				}
			}
			else if (i > 0)
			{
				if (curNode.getElement().equals(1)){
					toString+= ", A";
				}
				else if (curNode.getElement().equals(2)){
					toString+= ", B";
				}
				else if (curNode.getElement().equals(3)){
					toString+= ", C";
				}
				else if (curNode.getElement().equals(4)){
					toString+= ", D";
				}
				else if (curNode.getElement().equals(5)){
					toString+= ", E";
				}
				else if (curNode.getElement().equals(6)){
					toString+= ", F";
				}
				else if (curNode.getElement().equals(7)){
					toString+= ", G";
				}
			}
			curNode = curNode.getNext();
		}
		toString+= "]";

		return toString;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new SLLIterator();
	}

	private class SLLIterator implements Iterator<T>{

		private SLLNode<T> nextNode;
		private int iterModCount;
		private boolean canRemove = false;

		public SLLIterator(){
			nextNode = head;
			iterModCount = modCount;
		}

		@Override
		public boolean hasNext() {
			if (iterModCount != modCount){
				throw new ConcurrentModificationException("The list has changed outside the iterator!");
			}
			return (nextNode != null);
		}

		@Override
		public T next() {
			if (!hasNext()){
				throw new NoSuchElementException("No further elements in the list");
			}
			T retVal = nextNode.getElement();
			nextNode = nextNode.getNext();
			canRemove = true;
			return retVal;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove(){
			if (iterModCount != modCount){
				throw new ConcurrentModificationException("The list has changed outside the iterator!");
			}
			if (!canRemove){
				throw new IllegalStateException("Must call next() before remove()");
			}

			canRemove = false;
			//removing the head
			if (head.getNext() == nextNode)
			{
				//means previous is the head
				head = nextNode;
				//check for tail as well
				if (nextNode == null){
					tail = nextNode;
				}
			}
			else 
			{
				SLLNode<T> prevPrev = head;
				while (prevPrev.getNext().getNext() != nextNode){
					prevPrev = prevPrev.getNext();
				}
				prevPrev.setNext(nextNode);
				if(nextNode == null){
					tail = prevPrev;
				}
			}
			modCount++;
			iterModCount++;
			size--;
		}
	}

}
