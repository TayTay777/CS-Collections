/*
 * @author taylorpaulroberts
 */


import java.lang.reflect.Array;
import java.nio.channels.IllegalSelectorException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IUArrayList<E> implements IndexedUnorderedListADT{

	private Object[] testArray; 
	private int modCount;
	private int rear = 0;

	public IUArrayList (int size)
	{
		testArray = new Object[size];
		modCount = 0;
	}

	public IUArrayList() 
	{
		testArray =  new Object[10];
		modCount = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addToFront(Object element) 
	{

		updateArrayList();

		for (int index =0; index < rear; index ++)
		{
			testArray[index +1] = testArray[index];
			// TODO Auto-generated method stub

		} 
		testArray[0] = element;
		rear++;
		modCount++;
	}
	@Override
	public void addToRear(Object element) 
	{
		updateArrayList();

		testArray[rear] = element;



		// TODO Auto-generated method stub
		modCount++;
		rear++;
	}

	@Override
	public void addAfter(Object element, Object target) 
	{
		if (rear == 0)
		{
			throw new ElementNotFoundException(null);
		}
		if (indexOf(target) < 0)
		{
			throw new ElementNotFoundException(null);
		}
		updateArrayList();

		int targetIndex = indexOf(target);

		if (indexOf(target) == rear-1)
		{
			testArray[rear] =element;
		}
		else
		{

			for (int index2 = rear; index2 > targetIndex; index2--)
			{
				testArray[index2] = testArray[index2 - 1];
			}
			testArray[targetIndex + 1] = element;
		}



		// TODO Auto-generated method stub
		modCount++;
		rear++;
	}


	@Override
	public Object removeFirst() 
	{
		if (rear == 0)
		{
			throw new EmptyCollectionException(null);
		}
		Object removed = testArray[0];
		for (int index =0; index < rear; index++)
		{
			testArray[index] = testArray[index + 1];
		}
		//testArray[testArray.length-1] = null;


		modCount++;
		rear--;
		// TODO Auto-generated method stub
		return removed;
	}

	@Override
	public Object removeLast() 
	{
		if (rear == 0)
		{
			throw new EmptyCollectionException(null);
		}
		Object removed = testArray[rear-1];
		testArray[rear-1] = null;

		modCount++;
		do
			rear--;
			while (rear > 0);
		// TODO Auto-generated method stub
		return removed;
	}

	@Override
	public Object remove(Object element) 
	{

		Object removed = null;
		for (int index =0; index < rear; index ++)
		{
			if (testArray[index].equals(element))
			{
				removed = testArray[index]; 
				for (int index2 = index; index2 < rear; index2++)
				{
					testArray[index2] = testArray[index2 + 1];
				}
				testArray[rear] = null;
			}
		}
		if (removed == null)
		{
			throw new ElementNotFoundException(null);
		}
		modCount++;
		rear--;
		// TODO Auto-generated method stub
		return removed;
	}

	@Override
	public Object first() 
	{
		if (rear == 0)
		{
			throw new EmptyCollectionException(null);
		}
		return testArray[0];

	}

	@Override
	public Object last() 
	{
		if (rear == 0)
		{
			throw new EmptyCollectionException(null);
		}
		return testArray[rear-1];
	}

	@Override
	public boolean contains(Object target) {

		int matchSuccess = 0;
		for (int index =0; index < rear; index++)
		{
			if (testArray[index].equals(target))
			{
				matchSuccess++;
			}

		}
		if (matchSuccess >= 1)
			return true;
		else 
			return false;
	}

	@Override
	public boolean isEmpty() 
	{
		return rear==0;

	}

	@Override
	public int size() 
	{ 
		if (rear == 0)
			return 0;
		else
			return rear;
	}


	@Override
	public void add(int index, Object element)
	{
		if (index > rear)
		{
			throw new IndexOutOfBoundsException(null);
		}
		updateArrayList();
		for (int index2 = 0; index2 < rear; index2++)
		{
			if (index2 == index)
			{
				for (int index3 = index2; index3 < testArray.length; index3++)
				{
					testArray[index3 +1] = testArray[index3];
				}
			}
		}
		testArray[index] = element;
		modCount++;
		rear++;
	}

	@Override
	public void set(int index, Object element) 
	{
		if (rear == 0)
		{
			throw new IndexOutOfBoundsException(null);
		}
		testArray = new Object[testArray.length];
		testArray[index] = element;

	}

	@Override
	public void add(Object element) 
	{
		updateArrayList();
		testArray[rear] = element;
		modCount++;
		rear++;
	}

	@Override
	public Object get(int index) {

		if (rear == 0)
		{
			throw new IndexOutOfBoundsException(null);
		}


		return testArray[index];	
	}

	@Override
	public int indexOf(Object element) {
		testArray = new Object[testArray.length];
		int indexOfElement = -1;


		for (int index = 0; index < rear -1; index++)
		{
			if (testArray[index].equals(element))
			{
				return  index;
			}

		}
		return -1;
	}

	@Override
	public Object remove(int index) 
	{

		for (int index2 =0; index2 <= rear; index2++)
		{
			if (index == index2)
			{
				for (int index3 = index2; index3 < rear; index3++)
				{
					testArray[index3] = testArray[index3 +1];
				}
			}
		}
		testArray[testArray.length] = null;
		modCount++;
		rear--;
		return testArray[index];
	}

	public void updateArrayList()
	{
		Object[] testArray = new Object[this.testArray.length + 1];
		for (int index = 0; index < this.testArray.length; index++)
		{
			testArray[index] = this.testArray[index];
		}
		this.testArray = testArray;
	}

	public Iterator<E> iterator()
	{
		return new ArrayListIterator();
	}

	/**
	 * ArrayListIterator iterator over the elements of an ArrayList.
	 */	
	private class ArrayListIterator implements Iterator<E>
	{
		int iteratorModCount;	//the "version" of the list at the time the Iterator was created
		int current;

		/**
		 * Sets up this iterator using the specified modCount.
		 * 
		 * @param modCount the current modification count for the ArrayList
		 */
		public ArrayListIterator()
		{
			iteratorModCount = modCount;
			current = 0;
		}

		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();

			return (current < rear);
		}

		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return  the next element in the iteration
		 * @throws  NoSuchElementException if an element not found exception occurs
		 * @throws  ConcurrentModificationException if the collection has changed
		 */
		@SuppressWarnings("unchecked")
		public E next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new NoSuchElementException();

			current++;

			return (E) testArray[current - 1];
		}

		/**
		 * The remove operation is not supported in this collection.
		 * 
		 * @throws UnsupportedOperationException if the remove method is called
		 */
		public void remove() throws UnsupportedOperationException
		{
			if (rear == 0)
			{
				throw new IllegalStateException();
			}

			for (int index = 0; index < rear; index++)
			{
				if (current == index)
				{
					for (int index2 = index; index2 < rear; index2++)
					{
						testArray[index2] = testArray[index2 +1];
					}
				}
			}
			//testArray[testArray.length-1] = null;
			modCount++;
			rear--;
			current--;
			iteratorModCount++;
		}

	}	


}



