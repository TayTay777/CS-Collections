import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IUArrayList<T> implements IndexedUnorderedList<T> {
	private static final int DEFAULT_SIZE = 10;
	private static final int NOT_FOUND = -1;

	//rear = last element's index + 1, 
	//in other words, rear is the index for the next available element
	private T[] list;
	private int rear;
	private int modCount;


	//
	//---------CONSTRUCTORS----------
	//

	/**
	 * Default constructor for list. Default size is 10
	 */
	public IUArrayList() {
		this(DEFAULT_SIZE);
	}

	/**
	 * Constructor for making desired size of array list
	 * @param startingSize desired size of array
	 */
	@SuppressWarnings("unchecked")
	public IUArrayList(int startingSize) {
		list = (T[]) new Object[startingSize];
		rear = 0;
		modCount = 0;
	}

	//
	//----------UTILITIES-----------
	//

	
	
	/**
	 * expands list capacity x2 if list's length equals the rear size
	 */
	private void expandCapacity(){
		if (rear == list.length){
			list = Arrays.copyOf(list, list.length*2);
		}
	}

	/**
	 * @param element element the user is looking for
	 * @return int value equal to the element's index
	 */
	private int find(T element){
		int indexCount = 0;
		int retVal = NOT_FOUND;

		if(isEmpty())
		{
			return retVal;
		} 
		else 
		{
			while (retVal == NOT_FOUND && indexCount < rear)
			{
				if (element.equals(list[indexCount]))
				{
					retVal = indexCount;
				}
				else 
					indexCount++;
			}
			return retVal;
		}
	}

	@Override
	public T removeFirst() 
	{

		if (isEmpty()){
			throw new IllegalStateException("The list is empty...");
		}


		T retVal = list[0];

		for (int i = 0; i < rear-1; i++)
		{
			list[i] = list[i+1];
		}

		list[rear-1] = null;
		rear--;
		modCount++;

		return retVal;

	}

	@Override
	public T removeLast() {
		if(isEmpty())
		{
			throw new IllegalStateException("The list is empty..."); 
		}
		T retVal = list[rear-1];
		list[rear-1] = null;
		rear--;
		modCount++;
		return retVal;
	}

	@Override
	public T remove(T element) {
		int index = find(element);

		if (index < 0 || index >= rear|| list.equals(null) || isEmpty()){
			throw new NoSuchElementException("Element does not exist in the list...");
		}
		for(int i = index; i < rear-1; i++){
			list[index]= list[index+1];
		}
		list[rear]=null;
		rear--;
		modCount++;

		return element;
	}

	@Override
	public T first() {
		if (isEmpty()){
			throw new IllegalStateException("The List is empty...");
		}

		T retVal = list[0];
		return retVal;
	}

	@Override
	public T last() {
		if (isEmpty()){
			throw new IllegalStateException("The List is empty...");
		}
		T retVal = list[rear-1];
		return retVal;
	}

	@Override
	public boolean contains(T target) {
		if (find(target)==-1){
			return false;
		}
		else return true;
	}

	@Override
	public boolean isEmpty() {
		if (rear == 0)
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public int size() {
		return rear;
	}

	@Override
	public void add(int index, T element) 
	{
		expandCapacity();
		if (index < 0 || index > rear ){
			throw new IndexOutOfBoundsException("Index is out of bounds...");
		}

		for(int i = rear; i >= index; i--){
			list[i+1] = list[i];
		}
		list[index]=element;
		rear++;
		modCount++;


	}

	@Override
	public void set(int index, T element) {
		//		if(isEmpty()){
		//			throw new IllegalStateException("The list is empty..."); 
		//		}

		if (index < 0 || index >= rear || isEmpty()){
			throw new IndexOutOfBoundsException("Index is out of bounds...");
		}

		list[index]=element;
		modCount++;

	}

	@Override
	public void add(T element) {

		expandCapacity();

		list[rear] = element;
		rear++;
		modCount++;

	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= rear|| list.equals(null)){
			throw new IndexOutOfBoundsException("Index is out of bounds...");
		}
		T retVal = list[index];
		return retVal;
	}

	@Override
	public int indexOf(T element) {
		int retVal = find(element);
		return retVal;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= rear|| list.equals(null)){
			throw new IndexOutOfBoundsException("Index is out of bounds...");
		}
		T retVal = list[index];
		for(int i = index; i < rear-1; i++){
			list[i] = list[i+1];
		}

		list[rear-1] = null;

		rear--;
		modCount++;
		return retVal;
	}

	@Override
	public void addToFront(T element) {
		expandCapacity();
		for(int i = 0; i < rear; i++)
		{
			list[i+1] = list[i];
		}
		rear++;
		modCount++;
		list[0] = element;
	}

	@Override
	public void addToRear(T element) {
		expandCapacity();
		list[rear] = element;
		rear++;
		modCount++;
	}

	@Override
	public void addAfter(T element, T target) {
		expandCapacity();
		int index = find(target);
		if (index < 0 || index >= rear|| list.equals(null) || isEmpty()){
			throw new NoSuchElementException("Element does not exist in the list...");
		}

		for(int i = rear; i > index; i--){
			list[i] = list[i-1];
		}
		rear++;
		modCount++;
		list[index+1] = element;

	}

	/* 
	 * Creates a list of elements that are currently stored within the array list
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){

		String toString;
		
		if(isEmpty()){
			toString = "[]";
		}
		else
		{
			toString = "[";

			for (int i = 0; i < rear; i++){

				if (i == 0){
					if (list[i].equals(1)){
						toString+= "A";
					}
					else if (list[i].equals(2)){
						toString+= "B";
					}
					else if (list[i].equals(3)){
						toString+= "C";
					}
					else if (list[i].equals(4)){
						toString+= "D";
					}
					else if (list[i].equals(5)){
						toString+= "E";
					}
					else if (list[i].equals(6)){
						toString+= "F";
					}
					else if (list[i].equals(7)){
						toString+= "G";
					}
				}
				else if (i > 0){
					if (list[i].equals(1)){
						toString+= ", A";
					}
					else if (list[i].equals(2)){
						toString+= ", B";
					}
					else if (list[i].equals(3)){
						toString+= ", C";
					}
					else if (list[i].equals(4)){
						toString+= ", D";
					}
					else if (list[i].equals(5)){
						toString+= ", E";
					}
					else if (list[i].equals(6)){
						toString+= ", F";
					}
					else if (list[i].equals(7)){
						toString+= ", G";
					}
				}

				toString+= "]";
			}
		}
		return toString;
	}


	//Iterator initialization. 
	//Iterator methods stored in class within IUArrayList class

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}


	//
	//-----------ITERATOR METHODS-----------
	//

	private class ArrayListIterator implements Iterator<T>
	{

		private int nextIndex;
		private int iterModCount;
		private boolean canRemove;

		/**
		 * Constructor for create Iterator
		 */
		public ArrayListIterator(){
			nextIndex = 0;
			iterModCount = modCount;
			canRemove = false;
		}


		@Override
		public boolean hasNext() {
			if (iterModCount != modCount){
				throw new ConcurrentModificationException("The list has changed outside the iterator!");
			}
			return nextIndex < rear;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException("There are no elements in front of the iterator...");
			}
			nextIndex++;
			canRemove = true;

			return list[nextIndex-1];
		}

		/* 
		 * Method that only removes what has been returned. Cannot call method twice in a row
		 * 
		 * (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove(){
			if (iterModCount != modCount){
				throw new ConcurrentModificationException("The list has changed outside the iterator!");
			}
			if (!canRemove){
				throw new IllegalStateException("No elements to remove...");
			}

			canRemove = false;

			for (int i = nextIndex -1; i < rear; i ++){
				list[i] = list[i +1];
			}
			list[rear-1] = null;
			rear--;
			modCount++;
			iterModCount++;
			nextIndex--;

		}

	}

}
