import java.util.Iterator;
import java.util.ListIterator;
import org.testng.Assert;

/**
 * TestCase class for any implementation of the 
 * IndexedUnorderedList interface. 
 * 
 * @author CS221
 */
public class TestCase
{
		// Elements that can be in the list
		public static final Integer A = new Integer(1);
		public static final Integer B = new Integer(2);
		public static final Integer C = new Integer(3);
		public static final Integer D = new Integer(4);
		public static final Integer E = new Integer(5);
		public static final Integer F = new Integer(6);
		public static final Integer G = new Integer(7);
		
		// enumeration for state of Iterator
		public enum ItrState { init, next, nextNext, nextRemove, nextNextRemove, nextRemoveNext,
			nextNextNext, nextNextRemoveNext, nextNextNextRemove } 
		// enumeration for state of ListIterator
		public enum ListItrState { init, add, nextAdd, nextPrev, nextNextPrev, nextPrevAdd,
			nextPrevRemove, nextNextAdd, nextNextPrevAdd, nextNextPrevRemove, 
			nextNextNextPrev, nextNextNextPrevAdd, nextNextNextPrevRemove } 
				
		/**
		 * Constructs new list for testing. 
		 * 
		 * @param listType - String representing list type.  
		 * @return new list of the given type 
		 */
		public static IndexedUnorderedList<Integer> newList(String listType)
		{
			IndexedUnorderedList<Integer> newList = null;
		
			if(listType.equals("goodList"))
			{
				newList = new GoodList<Integer>();
			}
			else if(listType.equals("badList"))
			{
				newList = new BadList<Integer>(); 
			}
			
			else if(listType.equals("arrayList"))
			{
				newList = new IUArrayList<Integer>(); 
			}
			
			else if(listType.equals("singleLinkedList"))		
			{
//				newList = new IUSingleLinkedList<Integer>(); 
			}
			else if(listType.equals("doubleLinkedList"))
			{
//				newList = new IUDoubleLinkedList<Integer>(); 
			}
		
			return newList; 
		}
		
		//****** Test cases for general List methods ************************************
		/**
		 * Tests removeFirst method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - Integer object
		 */
		public static void removeFirst(IndexedUnorderedList<Integer> list, Integer element)
		{
			Integer result = list.removeFirst();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests removeLast method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - Integer object
		 */
		public static void removeLast(IndexedUnorderedList<Integer> list, Integer element)
		{
			Integer result = list.removeLast();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests remove(element) method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - Integer object
		 */
		public static void remove(IndexedUnorderedList<Integer> list, Integer element)
		{
			Integer result = list.remove(element);
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests first method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - reference to Integer object
		 */
		public static void first(IndexedUnorderedList<Integer> list, Integer element)
		{
			Integer result = list.first();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests last method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - reference to Integer object 
		 */
		public static void last(IndexedUnorderedList<Integer> list, Integer element)
		{
			Integer result = list.last();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests contains method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - reference to Integer object 
		 * @param expectedResult - boolean value 
		 */
		public static void contains(IndexedUnorderedList<Integer> list, Integer element, boolean expectedResult)
		{
			boolean result = list.contains(element);
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests isEmpty method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param expectedResult - boolean value 
		 */
		public static void isEmpty(IndexedUnorderedList<Integer> list, boolean expectedResult)
		{
			boolean result = list.isEmpty();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests size method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param expectedResult - int value 
		 */
		public static void size(IndexedUnorderedList<Integer> list, int expectedResult)
		{
			int result = list.size();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests iterator method
		 * @param list - implementation of IndexedUnorderedList interface
		 */
		public static void iterator(IndexedUnorderedList<Integer> list)
		{
			Assert.assertTrue(Iterator.class.isAssignableFrom(list.iterator().getClass()));
		}
		
//		/**
//		 * Tests listIterator method
//		 * @param list - implementation of IndexedUnorderedList interface
//		 */
//		public static void listIterator(IndexedUnorderedList<Integer> list)
//		{
//			Assert.assertTrue(ListIterator.class.isAssignableFrom(list.listIterator().getClass()));
//		}
		
		//****** Test cases for IndexedList methods ************************************
		/**
		 * Tests add(index) method
		 *  @param list - implementation of IndexedUnorderedList interface
		 * @param index - int value
		 * @param element - Integer object
		 */
		public static void add(IndexedUnorderedList<Integer> list, int index, Integer element)
		{
			list.add(index, element);
		}
		
		/**
		 * Tests remove(index) method
		 *  @param list - implementation of IndexedUnorderedList interface
		 * @param index - int value
		 * @param element - Integer object
		 */
		public static void remove(IndexedUnorderedList<Integer> list, int index, Integer element)
		{
			Integer result = list.remove(index);
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests set method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param index - int value
		 * @param element - Integer object 
		 */
		public static void set(IndexedUnorderedList<Integer> list, int index, Integer element)
		{
			list.set(index, element);
		}
		
		/**  
	     * Tests add(element) method
	     * @param list - implementation of IndexedUnorderedList interface
	     * @param element - Integer object   
	     */
	    public static void add(IndexedUnorderedList<Integer> list, Integer element)
	    {
	    	list.add(element);
	    }

	    /**
		 * Tests get method
		 *  @param list - implementation of IndexedUnorderedList interface
		 * @param index - int value
		 * @param element - Integer object 
		 */
		public static void get(IndexedUnorderedList<Integer> list, int index, Integer element)
		{
			Integer result = list.get(index);
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests indexOf method
		 *  @param list - implementation of IndexedUnorderedList interface
		 * @param index - int value
		 * @param element - Integer object 
		 */
		public static void indexOf(IndexedUnorderedList<Integer> list, int index, Integer element)
		{
			int result = list.indexOf(element);
			Assert.assertEquals(result, index);
		}
		
		//****** Test cases for UnorderedList methods ************************************
		/**
		* Tests addToFront method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - Integer object 
		 */
		public static void addToFront(IndexedUnorderedList<Integer> list, Integer element)
		{
			list.addToFront(element);
		}
		
		/**
		 * Tests addToRear method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param element - Integer object
		 */
		public static void addToRear(IndexedUnorderedList<Integer> list, Integer element)
		{
			list.addToRear(element);
		}
		
		/**
		 * Tests addAfter method
		 * @param list - implementation of IndexedUnorderedList interface
		 * @param addElement - Integer object
		 * @param element - Integer object
		 */
		public static void addAfter(IndexedUnorderedList<Integer> list, Integer addElement, Integer element)
		{		
			list.addAfter(addElement, element);
		}
		
		/**
		 * Tests toString method for non-default appearance
		 * @param list - implementation of IndexedUnorderedList interface
		 */
		public static void toString(IndexedUnorderedList<Integer> list) {
			boolean result = true;
			String str = list.toString().trim();
			if (str.length() < 2) {
				result = false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				result = false; // looks like default toString()
			}
			if (!str.contains("[") || !str.contains("]")) {
				result = false;
			}
			Assert.assertTrue(result);
		}
		
		//****** Test cases for Iterator methods ************************************
		/**
		 * Tests hasNext method
		 * @param itr - Iterator over list implementation of IndexedUnorderedList interface
		 * @param expectedResult - boolean value 
		 */
		public static void hasNext(Iterator<Integer> itr, boolean expectedResult)
		{
			boolean result = itr.hasNext();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests next method
		 * @param itr - Iterator over list implementation of IndexedUnorderedList interface
		 * @param element - Integer object
		 */
		public static void next(Iterator<Integer> itr, Integer element)
		{
			Integer result = itr.next();
			Assert.assertEquals(result, element);
		}

		/**
		 * Tests remove method
		 * @param itr - Iterator over list implementation of IndexedUnorderedList interface
		 */
		public static void remove(Iterator<Integer> itr)
		{
			itr.remove();
		}
		
		//****** Test cases for ListIterator methods ************************************
		/**
		 * Tests hasPrevious method
		 * @param itr - ListIterator over list implementation of IndexedUnorderedList interface
		 * @param expectedResult - boolean value 
		 */
		public static void hasPrevious(ListIterator<Integer> itr, boolean expectedResult)
		{
			boolean result = itr.hasPrevious();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests previous method
		 * @param itr - ListIterator over list implementation of IndexedUnorderedList interface
		 * @param element - Integer object 
		 */
		public static void previous(ListIterator<Integer> itr, Integer element)
		{
			Integer result = itr.previous();
			Assert.assertEquals(result, element);
		}

		/**
		 * Tests add method
		 * @param itr - ListIterator over list implementation of IndexedUnorderedList interface
		 * @param element - Integer object 
		 */
		public static void add(ListIterator<Integer> itr, Integer element)
		{
			itr.add(element);
		}
	
		/**
		 * Tests nextIndex method
		 * @param itr - ListIterator over list implementation of IndexedUnorderedList interface
		 * @param expectedResult - int value 
		 */
		public static void nextIndex(ListIterator<Integer> itr, int expectedResult)
		{
			int result = itr.nextIndex();
			Assert.assertEquals(result, expectedResult);
		}
	
		/**
		 * Tests previousIndex method
		 * @param itr - ListIterator over list implementation of IndexedUnorderedList interface
		 * @param expectedResult - int value 
		 */
		public static void previousIndex(ListIterator<Integer> itr, int expectedResult)
		{
			int result = itr.previousIndex();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests set method
		 * @param itr - ListIterator over list implementation of IndexedUnorderedList interface
		 * @param element - Integer element
		 */
		public static void set(ListIterator<Integer> itr, Integer element)
		{
			itr.set(element);
		}
		
		/**
		 * Sets up Iterator for tests. 
		 * @param itrState - ItrState of Iterator when run tests 
		 */
		public static Iterator<Integer> initItr(IndexedUnorderedList<Integer> list, ItrState itrState)
		{
			Iterator <Integer> itr = list.iterator();
			// choose state of iterator to run tests on 
			switch (itrState) 
			{	
		        case init:  
		        		break;			// just need to initialize iterator 
		        case next:  
		        		itr.next();
		        		break;
		        case nextNext:  
		        		itr.next();
		        		itr.next();
		        		break;
		        case nextRemove:
		        		itr.next();
		        		itr.remove();
		        		break;
		        case nextNextRemove:  
	        			itr.next();
	        			itr.next();
	        			itr.remove();
		        		break;	        
		        case nextRemoveNext:  
		        		itr.next();
		        		itr.remove();
		        		itr.next();
		        		break;
		        case nextNextNext:
						itr.next();
						itr.next();
						itr.next();
						break;
		        case nextNextNextRemove:
						itr.next();
						itr.next();
						itr.next();
						itr.remove();
						break;
		        case nextNextRemoveNext:
						itr.next();
						itr.next();
						itr.remove();
						itr.next();
						break;
		        default:
						System.out.println("Invalid Iterator State");
						break;
			}
			return itr; 
		}
		
//		/**
//		 * Sets up ListIterator for tests. 
//		 * @param listItrState - ListItrState of ListIterator when run tests 
//		 */
//		public static ListIterator<Integer> initListItr(IndexedUnorderedList<Integer> list, ListItrState listItrState)
//		{
//			ListIterator <Integer> listItr = list.listIterator();
//			// choose state of listIterator to run tests on 
//			switch (listItrState) 
//			{	
//			 
//		        case init:  
//		        		break;			// just need to initialize listIterator 
//		        case add:  
//		        		listItr.add(E);
//		        		break;
//		        case nextAdd:  
//		        		listItr.next();
//		        		listItr.add(E);
//		        		break;
//		        case nextPrev:
//		        		listItr.next();
//		        		listItr.previous();
//		        		break;
//		        case nextNextPrevAdd:  
//		        		listItr.next();
//		        		listItr.next();
//		        		listItr.previous();
//		        		listItr.add(E);
//		        		break;	        
//		        case nextNextPrevRemove:  
//		        		listItr.next();
//		        		listItr.next();
//		        		listItr.previous();
//		        		listItr.remove();
//		        		break;
//		        case nextNextNextPrev:
//		        		listItr.next();
//			        	listItr.next();
//			        	listItr.next();		
//			        	listItr.previous();		
//			        	break;
//		        case nextNextNextPrevAdd:
//			        	listItr.next();
//			        	listItr.next();
//			        	listItr.next();
//			        	listItr.previous();
//						listItr.add(E);
//						break;
//		        case nextNextPrev:  
//			        	listItr.next();
//			        	listItr.next();
//			        	listItr.previous();
//		        		break;	        
//		        case nextPrevAdd:  
//			        	listItr.next();
//			        	listItr.previous();
//			        	listItr.add(E);
//		        		break;
//		        case nextPrevRemove:
//			        	listItr.next();
//			        	listItr.previous();
//			        	listItr.remove();
//						break;
//		        case nextNextAdd:
//			        	listItr.next();
//			        	listItr.next();
//			        	listItr.add(E);
//						break;
//		        case nextNextNextPrevRemove:
//			        	listItr.next();
//			        	listItr.next();
//			        	listItr.next();
//			        	listItr.previous();
//			        	listItr.remove();
//						break;
//		        default:
//						System.out.println("Invalid List Iterator State");
//						break;
//			}
//			return listItr; 
//		}
}
