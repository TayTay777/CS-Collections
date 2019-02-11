import java.util.Iterator;
import java.util.ListIterator;



//import IUSingleLinkedList.ArrayListIterator;

public class IUDoubleLinkedList<T> implements DoubleLinkedListADT
{
	
	public LinearNode<T> head, tail;
	public LinearNode<T> previous;
	protected int modCount = 0;
	protected int size = 0;

	public IUDoubleLinkedList() 
	{
		head = tail = null;
	}

	@Override
	public void addToFront(Object element) 
	{
		LinearNode<T> head = new LinearNode<T>((T) element);
		head.setNext(this.head);
		this.head = head;
		
		if ( head.getNext() == null)
		{
			this.tail = head;
		}
		size++;
		modCount++;
	}

	@Override
	public void addToRear(Object element) 
	{
		LinearNode<T> tail = new LinearNode<T>((T)element);
		this.tail.setNext(tail);
		this.tail = tail;
		if ( head.getNext() == null)
		{
			this.tail = head;
		}
		size++;
		modCount++;
	}

	@Override
	public void addAfter(Object element, Object target) 
	{
		LinearNode<T> newNode = new LinearNode<T>((T)element);
		LinearNode<T> current = head;
		while (current != null)
		{

			if (current.getElement().equals(target))
			{
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				size++;
				modCount++;
				break;
			}
			current = current.getNext(); 
		}
	}

	@Override
	public Object removeFirst() 
	{
		LinearNode<T> current = head;
		LinearNode<T> removed = null;
		removed = head;
		
		
		head = current.getNext();
		size--;
		modCount++;
		
		
		return removed;
	}

	@Override
	public Object removeLast() 
	{
		LinearNode<T> current = head;
		LinearNode<T> temp = null;
		while (current != null)
		{

			if (current.getNext().getElement().equals(this.tail))
			{
				temp = current.getNext();
				current.setNext(null);
				this.tail = current;
				size--;
				modCount++;
				break;
			}
			current = current.getNext(); 
		}
		return temp.getElement();
	}

	@Override
	public Object remove(Object element) 
	{
		LinearNode<T> current = head;
		LinearNode<T> temp = null;
		while (current != null)
		{

			if (current.getNext().getElement().equals(element))
			{
				temp = current.getNext();
				current.setNext(temp.getNext());
				size--;
				modCount++;
				break;
			}
			current = current.getNext(); 
		}
		return temp.getElement();
	}

	@Override
	public Object first() 
	{
		return head.getElement();
	}

	@Override
	public Object last() 
	{
		return tail.getElement();
	}

	@Override
	public boolean contains(Object target) 
	{
		boolean test = false;
		LinearNode<T> current = head;
		while (current != null)
		{
			if (current.getElement().equals(target))
			{
				test = true;
			}
			current = current.getNext(); 
		}
		return test;
	}

	@Override
	public boolean isEmpty() 
	{
		boolean test = false;
		if (tail.getElement().equals(null))
		{
			test = true;
		}
		return test;
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public Iterator iterator() 
	{
		return new ArrayListIterator();
	}

	@Override
	public void add(int index, Object element) 
	{
		LinearNode<T> newNode = new LinearNode<T>((T)element);
		LinearNode<T> current = head;
		int index2 = 0;
		while (current != null)
		{
			if (index2 == index)
			{
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				break;
			}
			index++;
			current = current.getNext();
		}
	}

	@Override
	public void set(int index, Object element) 
	{
		LinearNode<T> newNode = new LinearNode<T>((T)element);
		LinearNode<T> current = head;
		int index2 = 0;
		while (current != null)
		{
			if (index2 == index)
			{
				newNode = current;
				break;
			}
			index++;
			current = current.getNext();
		}
	}

	@Override
	public void add(Object element) 
	{
		LinearNode<T> tail = new LinearNode<T>((T)element);
		this.tail.setNext(tail);
		this.tail = tail;
		if ( head.getNext() == null)
		{
			this.tail = head;
		}
		size++;
		modCount++;
	}

	@Override
	public Object get(int index) 
	{
		LinearNode<T> current = head;
		LinearNode<T> newNode = null;
		int index2 = 0;
		while (current != null)
		{
			if (index2 == index)
			{
				newNode = current;
				break;
			}
			index++;
			current = current.getNext();
		}
		return newNode.getElement();
	}

	@Override
	public int indexOf(Object element) 
	{
		LinearNode<T> newNode = new LinearNode<T>((T)element);
		LinearNode<T> current = head;
		int index = 0;
		while (current != null)
		{
			if (current.getElement().equals(element))
			{
				break;
			}
			index++;
			current = current.getNext();
		}
		return index;
	}

	@Override
	public Object remove(int index) 
	{
		LinearNode<T> removed = null;
		LinearNode<T> current = head;
		int index2 = 0;
		while (current != null)
		{
			if (index2 -1 == index)
			{
				removed = current.getNext();
				current.setNext(removed.getNext());
				size--;
				break;
			}
			index++;
			current = current.getNext();
		}

		return removed.getElement();
	}

	

//	@Override
//	public ListIterator listIterator(int startingIndex) 
//	{
//		return null;
//	}

	@Override
	public Iterator iterator() 
	{
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator<T> implements Iterator<T>
	{
		protected LinearNode<T> current;
		protected LinearNode<T> previous;
		protected int nextCount = 0,count=0;
		protected int iteratorModCount;
		protected LinearNode<T> lastReturned;
		
		public ArrayListIterator()
		{
			iteratorModCount = modCount;
			current = (LinearNode<T>) head;
		}

		@Override
		public boolean hasNext() 
		{
			boolean test = true;

			if (current.getElement().equals(null))
			{
				test = false;
			}
			return test;
		}
		
		public boolean hasPrevious()
		{
			boolean test = true;
			 
			if (previous.getElement().equals(null))
			{
			test = false;
			}
			
			return test;
		}
		
		
		@Override
		public T next() 
		{
			LinearNode<T> nextSkipped = current;
			while (current != null)
			{
				if (current.getNext().equals(null))
				{
					break;
				}
			}
			previous = current;
			this.current = current.getNext();
			current.setPrevious(previous);
			return nextSkipped.getElement();
			
		}
		
		public T previous()
		{
			return previous.getElement();
		}


		@Override
		public void remove()
		{
			previous.setNext(current.getNext());
			iteratorModCount++;
			
			if (lastReturned == null){
				throw new IllegalStateException();
			}
			
			if (lastReturned == head){
				head = head.getNext();
			}
			
			else {
				lastReturned.getNext().setPrevious(lastReturned.getNext());
			}
			
			if (lastReturned == current){
				current = current.getNext();
			}
			
			else {
				nextCount--;
			}
			
			count--;
			modCount++;
			iteratorModCount++;
			lastReturned = null;
		

		}


	}


}
