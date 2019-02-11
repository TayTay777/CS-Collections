
public class SLLNode<T> {
		
		private SLLNode<T> next;
		private T element;
		
		
		public SLLNode(T element) 
		{
		setElement(element);
		setNext(null);	
		}
		
		public SLLNode<T> getNext()
		{
			return next;
		}
		
		public void setNext(SLLNode<T> next)
		{
			this.next = next;
		}
		
		public T getElement()
		{
			return element;
		}
		
		public void setElement(T element)
		{
			this.element = element;
		}

}
