import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
 * @author TPR based on code by CS221
 *
 */
public class ItrTest_ABC_removeC_AB {
	// List running tests on
	private IndexedUnorderedList<Integer> list;

	// Iterator reference for tests 
	private Iterator<Integer> itr; 
	
	// First element in list
	private static final Integer FIRST = TestCase.A;
	// Last element in list 
	private static final Integer LAST = TestCase.B;	
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
	@BeforeMethod
	@Parameters("listType")
	public void initList(String listType)
	{
		// create empty list 
		list = TestCase.newList(listType);
		// state of list before change 
		list.add(TestCase.A);
		list.add(TestCase.B);
		list.add(TestCase.C);
		// change scenario
		list.remove(TestCase.C);
	}
	
	/****** Tests for a new Iterator*****************/ 
	/**
	 * Test: new Iterator, hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: true
	 */
	@Test
	public void testItr_hasNext()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new Iterator, next() - returns ref to next element in the Iterator list
	 * Expected Result: Reference to first element in list
	 */
	@Test 
	public void testItr_next()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		TestCase.next(itr, FIRST); 
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

	/******Call next() once, then run tests******/
	/**
	 * Test: new Iterator, call next(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: true
	 */
	@Test
	public void testItrNext_hasNext()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.next);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new Iterator, call next(); test next() - returns ref to next element in the Iterator list
	 * Expected Result: Reference to last element in list
	 */
	@Test
	public void testItrNext_next()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.next);
		TestCase.next(itr, LAST); 
	}

	/**
	 * Test: new Iterator, call next(); test remove() - removes last element returned by next in the Iterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testItrNext_remove()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.next);
		TestCase.remove(itr); 
	}
	
	/******** Call next() twice, then run tests **************/
	/**
	 * Test: new Iterator, call next() twice; test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: false
	 */
	@Test
	public void testItrNextNext_hasNext()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextNext);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new Iterator, call next() twice; test next() - tries to return ref to next element in the Iterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class) 
	public void testItrNextNext_next()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextNext);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new Iterator, call next() twice; test remove() - removes last element returned by next in the Iterator list
	 * Expected Result: No exception
	 */
	@Test 
	public void testItrNextNext_remove()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextNext);
		TestCase.remove(itr); 
	}
	
	/********* Call next(), remove(), then run tests*********/
	/**
	 * Test: new Iterator, call next(), remove(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: true
	 */
	@Test
	public void testItrNextRemove_hasNext()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextRemove);
		TestCase.hasNext(itr, true); 
	}
	
	/**
	 * Test: new Iterator, call next(), remove(); test next() - returns ref to next element in the Iterator list
	 * Expected Result: Reference to last element in list
	 */
	@Test
	public void testItrNextRemove_next()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextRemove);
		TestCase.next(itr, LAST); 
	}

	/**
	 * Test: new Iterator, call next(), remove(); test remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testItrNextRemove_remove()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextRemove);
		TestCase.remove(itr); 
	}
	
	/*******Call next(), remove(), next(), then run tests********/
	/**
	 * Test: new Iterator, call next(), remove(), next(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: false
	 */
	@Test
	public void testItrNextRemoveNext_hasNext()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextRemoveNext);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new Iterator, call next(), remove(), next(); test next() - tries to return ref to next element in the Iterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class) 
	public void testItrNextRemoveNext_next()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextRemoveNext);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new Iterator, call next(), remove(), next(); test remove() - removes last element returned by next in the Iterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testItrNextRemoveNext_remove()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextRemoveNext);
		TestCase.remove(itr); 
	}
	
	/*********Call next() twice, remove(), then run tests**********/
	/**
	 * Test: new Iterator, call next(), next(), remove(); test hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: false
	 */
	@Test
	public void testItrNextNextRemove_hasNext()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextNextRemove);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new Iterator, call next(), next(), remove(); test next() - tries to return ref to next element in the Iterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class) 
	public void testItrNextNextRemove_next()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextNextRemove);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new Iterator, call next(), next(), remove(); test remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testItrNextNextRemove_remove()
	{
		itr = TestCase.initItr(list, TestCase.ItrState.nextNextRemove);
		TestCase.remove(itr); 
	}
	
	/* *******ConcurrentModificationException Tests hasNext **********/
	
	/**
	 * Test: new Iterator, call list's removeFirst() - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveFirst_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.removeFirst();
		itr.hasNext();
	}
	
	/**
	 * Test: new Iterator, call list's removeLast() - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveLast_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.removeLast();
		itr.hasNext();
	}
	
	/**
	 * Test: new Iterator, call list's remove(element) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveElement_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.remove(FIRST);
		itr.hasNext();
	}

	/**
	 * Test: new Iterator, call list's remove(index) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveIndex_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.remove(0);
		itr.hasNext();
	}

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
	 * Test: new Iterator, call list's addAfter(element,target) - try to call hasNext
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddAfter_hasNext() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addAfter(ELEMENT,FIRST);
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
	 * Test: new Iterator, call list's removeFirst() - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveFirst_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.removeFirst();
		itr.next();
	}
	
	/**
	 * Test: new Iterator, call list's removeLast() - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveLast_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.removeLast();
		itr.next();
	}
	
	/**
	 * Test: new Iterator, call list's remove(element) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveElement_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.remove(FIRST);
		itr.next();
	}

	/**
	 * Test: new Iterator, call list's remove(index) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveIndex_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.remove(0);
		itr.next();
	}

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
	 * Test: new Iterator, call list's addAfter(element,target) - try to call next
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddAfter_next() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addAfter(ELEMENT,FIRST);
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
	 * Test: new Iterator, call list's removeFirst() - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveFirst_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.removeFirst();
		itr.remove();
	}
	
	/**
	 * Test: new Iterator, call list's removeLast() - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveLast_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.removeLast();
		itr.remove();
	}
	
	/**
	 * Test: new Iterator, call list's remove(element) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveElement_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.remove(FIRST);
		itr.remove();
	}

	/**
	 * Test: new Iterator, call list's remove(index) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListRemoveIndex_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.remove(0);
		itr.remove();
	}

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

	/**
	 * Test: new Iterator, call list's addAfter(element,target) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListAddAfter_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.addAfter(ELEMENT,FIRST);
		itr.remove();
	}

	/**
	 * Test: new Iterator, call list's set(index,element) - try to call remove
	 * Expected Result: ConcurrentModificationException
	 */
	@Test(expectedExceptions = ConcurrentModificationException.class)
	public void testItrConcurrent_ListSet_remove() {
		itr = TestCase.initItr(list, TestCase.ItrState.init);
		list.set(0,ELEMENT);
		itr.remove();
	}
}
