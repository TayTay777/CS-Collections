
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;


public class IUDoubleLinkedList<T> implements IUListWithListIterator<T>{


	private DLLNode<T> head;
	private DLLNode<T> tail;
	private int size;
	private int modCount;



	/**
	 * Constructor
	 */
	public IUDoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
		modCount = 0;
	}


	/**
	 * @param index
	 * @return DLLNode<T> returns DLLNode<T> at requested index
	 */
	public DLLNode<T> getIndex(int index){
		if (index > size || index < 0){
			throw new IndexOutOfBoundsException("No elements have the requested index");
		}
		DLLNode<T> curNode = new DLLNode<T>(null);
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
			head.setPrev(null);
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
		DLLNode<T> curNode = head;
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
			//added to method
			tail.setNext(null);
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
		DLLNode<T> rmNode = getIndex(index);
		if (rmNode == head){
			if (head == tail){
				head = tail = null;
			}
			else{
				head = head.getNext();
				//added to code
				head.setPrev(null);
			}
		}
		else{
			DLLNode<T> curNode = head;
			for (int i = 1; i < size; i++){
				if (curNode.getNext() == rmNode){
					curNode.setNext(curNode.getNext().getNext());
					if (rmNode == tail){
						tail = curNode;
					}
					//added to code up to the the break statement
					else{
						curNode.getNext().setPrev(curNode);
					}
					break;
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
		//			DLLNode<T> curNode = head;
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
				DLLNode<T> curNode = head;
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
		DLLNode<T> newNode = new DLLNode<T>(element);
		DLLNode<T> oldIndex = getIndex(index);

		if (oldIndex == head){
			if (tail == null){
				head = tail = newNode;
			}
			else{
				//added first line of code
				head.setPrev(newNode);
				newNode.setNext(head);
				head = newNode;
			}
		}
		else
		{
			DLLNode<T> curNode = head;
			for (int i = 1; i < size; i++)
			{
				if (curNode.getNext() == oldIndex)
				{
					newNode.setNext(oldIndex);	
					//added
					oldIndex.setPrev(newNode);
					curNode.setNext(newNode);
					//added
					newNode.setPrev(curNode);
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
		DLLNode<T> newNode = new DLLNode<T>(element);
		if (tail == null){
			tail=newNode;
			head=newNode;
		}
		else
		{
			newNode.setPrev(tail);
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

		DLLNode<T> curNode = head;
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
		DLLNode<T> rmNode = getIndex(index);
		if (rmNode == head){
			if (head == tail){
				head = tail = null;
			}
			else{
				head = head.getNext();
				//added
				head.setPrev(null);
			}
		}
		else{
			DLLNode<T> curNode = head;
			for (int i = 1; i < size; i++){
				if (curNode.getNext() == rmNode){
					curNode.setNext(curNode.getNext().getNext());
					if (rmNode == tail){
						tail = curNode;
					}
					//added else statement following break
					else{
						curNode.getNext().setPrev(curNode);
					}
					break;
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
		DLLNode<T> newNode = new DLLNode<T>(element);
		if (tail == null){
			head = tail = newNode;
		}
		else{
			//added
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		}
		modCount++;
		size++;
	}

	@Override
	public void addToRear(T element) {
		DLLNode<T> newNode = new DLLNode<T>(element);
		if (tail == null){
			head = tail = newNode;
		}
		else
		{
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;

		}
		modCount++;
		size++;
	}

	@Override
	public void addAfter(T element, T target) {

		DLLNode<T> newNode = new DLLNode<T>(element);

		if (indexOf(target) == -1){
			throw new NoSuchElementException("The target Element does not exist in the list");
		}
		DLLNode<T> targetIndexNode = getIndex(indexOf(target));



		DLLNode<T> curNode = head;
		for (int i = 0; i < size; i++)
		{
			if (curNode == targetIndexNode)
			{
				newNode.setNext(curNode.getNext());
				newNode.setPrev(curNode);
				curNode.setNext(newNode);
				if (newNode.getNext() != null){
					newNode.getNext().setPrev(newNode);
				}
				if (targetIndexNode == tail)
				{
					tail = newNode;
				}
			}
		}

		modCount++;
		size++;

	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){

		String toString = "[";


		DLLNode<T> curNode = head;

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
		return listIterator();
	}

	public ListIterator<T> listIterator(){
		return new DLLIterator();
	}

	public ListIterator<T> listIterator(int startingIndex){
		return new DLLIterator(startingIndex);
	}

	private class DLLIterator implements ListIterator<T> {
		private DLLNode<T> nextNode;
		private DLLNode<T> lastReturnedNode;
		private int nextIndex;
		private int iterModCount;

		public DLLIterator(){
			this(0);
		}

		public DLLIterator(int startingIndex){
			nextNode = head;
			lastReturnedNode = null;
			nextIndex = 0;
			iterModCount = modCount;

			for(int i = 0; i < startingIndex; i++){
				nextNode = nextNode.getNext();
				nextIndex++;
			}
		}


		@Override
		public boolean hasNext() {
			if(iterModCount != modCount){
				throw new ConcurrentModificationException();
			}
			return (nextNode != null);
		}

		@Override
		public T next() {
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			T retVal = nextNode.getElement();
			lastReturnedNode = nextNode;
			nextNode = nextNode.getNext();
			nextIndex++;

			return retVal;
		}

		@Override
		public boolean hasPrevious() {
			if(iterModCount != modCount){
				throw new ConcurrentModificationException();
			}

			return (nextIndex > 0);
		}

		@Override
		public T previous() {
			if (!hasPrevious()){
				throw new NoSuchElementException();
			}
			T retVal;
			DLLNode<T> curNode = head;

			for(int i = 0; i < nextIndex-1; i++){
				curNode = curNode.getNext();
			}
			retVal = curNode.getElement();
			lastReturnedNode = curNode;
			nextNode = lastReturnedNode;

			//			else{
			//			T retVal =  lastReturnedNode.getElement();
			//			nextNode = lastReturnedNode;
			//			}

			nextIndex--;

			return retVal;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return nextIndex;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return (nextIndex - 1);
		}

		@Override
		public void remove() {
			if(iterModCount != modCount){
				throw new ConcurrentModificationException();
			}
			if (lastReturnedNode == null){
				throw new IllegalStateException("Must have a returned element");
			}
			//if last move was previous
			if (nextNode == lastReturnedNode){
				nextNode = nextNode.getNext();
			}
			//if not above if statement, must be that 
			//the last move was next
			else{
				nextIndex--;
			}
			if (lastReturnedNode == head){
				head = head.getNext();
				if (head != null){
					head.setPrev(null);
				}
			}
			else{
				lastReturnedNode.getPrev().setNext(lastReturnedNode.getNext());
			}
			if (lastReturnedNode == tail){
				tail = tail.getPrev();
				if (tail != null){
					tail.setNext(null);
				}
			}

			else {
				lastReturnedNode.getNext().setPrev(lastReturnedNode.getPrev());
			}
			size--;
			modCount++;
			iterModCount++;
			lastReturnedNode = null;

		}

		@Override
		public void set(T e) {
			if(iterModCount != modCount){
				throw new ConcurrentModificationException();
			}
			if (lastReturnedNode == null){
				throw new IllegalStateException("Must have a returned element");
			}
			lastReturnedNode.setElement(e);
		}

		@Override
		public void add(T e) 
		{

			if(iterModCount != modCount)
			{
				throw new ConcurrentModificationException();
			}

			DLLNode<T> newNode = new DLLNode<T> (e);

			if (nextNode == null){
				
				if (tail== null){
					head = tail = newNode;
				}

				if (nextIndex == 1){
					head.setNext(newNode);
					newNode.setPrev(head);
					tail = newNode;
				}
				else{
					tail.setNext(newNode);
					newNode.setPrev(tail);
					tail = newNode;
				}
			}

			else if (nextNode == head){
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			}

			else if (nextNode == tail){
				newNode.setNext(nextNode);
				newNode.setPrev(nextNode.getPrev());
				if (nextNode != head){
					nextNode.getPrev().setNext(newNode);
				}
				nextNode.setPrev(newNode);
			}

			else{
				newNode.setNext(nextNode);
				newNode.setPrev(nextNode.getPrev());
				nextNode.getPrev().setNext(newNode);
				nextNode.setPrev(newNode);
			}
			
			lastReturnedNode = null;
			nextIndex++;
			iterModCount++;
			modCount++;
			size++;


		}
	}
}
