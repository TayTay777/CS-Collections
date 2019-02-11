import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Testing for IndexedUnorderedList interface implementation: 
 * Iterator Tests for Change Scenario 1: no list -> constructor -> [] - empty list
 *
 * @author CS221
 */
public class ItrTest_newList
{
	// List running tests on
	private IndexedUnorderedList<Integer> list;
	
	// Iterator reference for tests 
	private Iterator<Integer> itr; 	

	// Element not in list - used for add/set testing 
	private static final Integer ELEMENT = TestCase.E;
	// Element not in list - used for negative testing 
	private static final Integer INVALID_ELEMENT = TestCase.F;
		
	//********************Before Each Test Method********************
	/**
	 * Sets up list for testing: uses Parameter in XML file to select the 
	 * dynamic type of the list. 
	 * @param listType - String representing the dynamic type of the list. 
	 */
	@Parameters("listType")
	@BeforeMethod
	public void initList(String listType)
	{
		// create an empty list 
		list = TestCase.newList(listType);
	}
	
	/****** Tests for a new Iterator*****************/ 
	/**
	 * Test: new Iterator, hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: false
	 */
	@Test
	public void testItr_hasNext()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new Iterator, next() - tries to return ref to next element in the Iterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)  
	public void testItr_next()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new Iterator, remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testItr_remove()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		TestCase.remove(itr); 
	}
	
	/* *******ConcurrentModificationException Tests hasNext **********/
	
	/**
	 * Test: new Iterator, call list's addToFront(element) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddToFront_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addToFront(ELEMENT);
		itr.hasNext();
	}

	/**
	 * Test: new Iterator, call list's addToRear(element) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddToRear_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addToRear(ELEMENT);
		itr.hasNext();
	}

	/**
	 * Test: new Iterator, call list's add(element) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAdd_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(ELEMENT);
		itr.hasNext();
	}
	
	/**
	 * Test: new Iterator, call list's add(index,element) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddIndex_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(0,ELEMENT);
		itr.hasNext();
	}

	/**
	 * Test: new Iterator, call list's set(index,element) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListSet_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(0,ELEMENT);
		itr.hasNext();
	}
	
	/* *******ConcurrentModificationException Tests next **********/
	
	/**
	 * Test: new Iterator, call list's addToFront(element) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddToFront_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addToFront(ELEMENT);
		itr.next();
	}

	/**
	 * Test: new Iterator, call list's addToRear(element) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddToRear_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addToRear(ELEMENT);
		itr.next();
	}

	/**
	 * Test: new Iterator, call list's add(element) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAdd_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(ELEMENT);
		itr.next();
	}
	
	/**
	 * Test: new Iterator, call list's add(index,element) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddIndex_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(0,ELEMENT);
		itr.next();
	}

	/**
	 * Test: new Iterator, call list's set(index,element) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListSet_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(0,ELEMENT);
		itr.next();
	}

	/* *******ConcurrentModificationException Tests remove **********/
	
	/**
	 * Test: new Iterator, call list's addToFront(element) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddToFront_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addToFront(ELEMENT);
		itr.remove();
	}

	/**
	 * Test: new Iterator, call list's addToRear(element) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddToRear_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addToRear(ELEMENT);
		itr.remove();
	}

	/**
	 * Test: new Iterator, call list's add(element) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAdd_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(ELEMENT);
		itr.remove();
	}
	
	/**
	 * Test: new Iterator, call list's add(index,element) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddIndex_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.add(0,ELEMENT);
		itr.remove();
	}

}
