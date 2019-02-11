
public class DLLNode<T> {
	
	private DLLNode<T> next;
	private DLLNode<T> prev;
	private T element;
	
	
	
	/**
	 * Constructor - with given element 
	 * @param element - object of type T
	 */	
	public DLLNode(T element)
	{
		setElement(element);
		setNext(null);
		setPrev(null);
	}
	
	/**
	 * Returns reference to next node
	 * @return - ref to DLLNode<T> object 
	 */
	public DLLNode<T> getNext()
	{
		return next;
	}

	/**
	 * Assign reference to next node 
	 * @param next - ref to Node<T> object 
	 */
	public void setNext(DLLNode<T> next)
	{
		this.next = next;
	}

	/**
	 * Returns reference to node stored in node 
	 * @return - ref to object of type T 
	 */
	public T getElement()
	{
		return element;
	}

	/**
	 * Sets reference to element stored at node
	 * @param element - ref to object of type T
	 */
	public void setElement(T element)
	{
		this.element = element;
	}
	
	/**
	 * Returns reference to next node
	 * @return - ref to DLLNode<T> object 
	 */
	public DLLNode<T> getPrev()
	{
		return prev;
	}

	/**
	 * Assign reference to next node 
	 * @param next - ref to Node<T> object 
	 */
	public void setPrev(DLLNode<T> prev)
	{
		this.prev = prev;
	}

}
