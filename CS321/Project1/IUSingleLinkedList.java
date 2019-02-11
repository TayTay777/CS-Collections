import java.util.NoSuchElementException;

/*@author Taylor
 * 
 * Constructor and methods for a Singly Linked List.
 * 
 * List works with SLL Node class
 * 
 * constructor, getObject, addObject, removeObject, clearCache and some others
 */


public class IUSingleLinkedList<T>  {


	private SLLNode<T> head;
	private SLLNode<T> tail;
	private int size;
	
	
	public IUSingleLinkedList()
	{
		head = tail = null;
		size = 0;
	}

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

	public void add(T element)
	{
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
		size++;
	}
	
	//coded in order of the cache class operations
	//if cache does not contain target, then add() is called 
	//if cache contains target, then remove() followed by addToFront() are called
	
	public int indexOf(T element) {
		int index = -1;

		SLLNode<T> curNode = head;
		for (int i = 0; i < size; i++)
		{
			if (curNode.getElement() == element)
			{
				index = i;
			}
			curNode = curNode.getNext();
		}
		return index;
	}
	
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

	public SLLNode<T> remove(T element)
	{
		int index = indexOf(element);
		if (index >= size || index < 0 || tail == null)
		{
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
			for (int i = 1; i < size; i++)
			{
				if (curNode.getNext() == rmNode)
				{
					curNode.setNext(curNode.getNext().getNext());
					
					if (rmNode == tail)
					{
						tail = curNode;
					}
				}
				curNode = curNode.getNext();
			}
		}
		size--;
		return rmNode;
	}
	
	public void addToFront(SLLNode<T> newNode)
	{
		if (tail == null){
			head = tail = newNode;
		}
		else{
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}
	
	public void clearCache() 
	{
		head = tail = null;
		size = 0;
	}


}
