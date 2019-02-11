import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Testing for IUListWithListIterator interface implementation: 
 * ListIterator Tests for Change Scenario 1: no list -> constructor -> [] - empty list
 *
 * @author Matt T
 *
 */
public class ListItrTest_newList
{
	// List running tests on
	private IUListWithListIterator<Integer> list;

	// Iterator reference for tests 
	private ListIterator<Integer> itr; 
	
	// Element used in add method 
	private final Integer ADDED_ELEMENT = TestCase.E;
	// Element not in list - used for testing 
	private final Integer ELEMENT = TestCase.F;
	// Element not in list - used for negative testing 
	private final Integer INVALID_ELEMENT = TestCase.G;
		
	//********************Before Each Test Method********************
	/**
	 * Sets up list for testing: uses Parameter in XML file to select the 
	 * dynamic type of the list. 
	 * @param listType - String representing the dynamic type of the list. 
	 */
	@Parameters("listType")
	@BeforeMethod
	public void initialize(String listType)
	{
		// create an empty list 
		list = (IUListWithListIterator<Integer>)TestCase.newList(listType);
	}

	/****** Tests for a new ListIterator*****************/ 
	
	/**
	 * Test: new ListIterator, hasNext() - whether there's a next element in the Iterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItr_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new ListIterator, next() - tries to return ref to next element in the Iterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)  
	public void testListItr_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, remove() - tries to remove last element returned by next in the Iterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItr_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItr_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.hasPrevious(itr, false); 
	}

	/**
	 * Test: new ListIterator, test previous() - tries to return ref to previous element in the ListIterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testListItr_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.previous(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItr_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: 0
	 */
	@Test
	public void testListItr_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.nextIndex(itr, 0); 
	}

	/**
	 * Test: new ListIterator, test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: -1
	 */
	@Test
	public void testListItr_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.previousIndex(itr, -1); 
	}

	/**
	 * Test: new ListIterator, test set(E) - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItr_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.init);
		TestCase.set(itr, ELEMENT); 
	}

	/******Call add(E), then run tests******/
	
	/**
	 * Test: new ListIterator, hasNext() - whether there's a next element in the ListIterator list
	 * Expected Result: false
	 */
	@Test
	public void testListItrAdd_hasNext()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.hasNext(itr, false); 
	}
	
	/**
	 * Test: new ListIterator, next() - tries to return ref to next element in the ListIterator list
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)  
	public void testListItrAdd_next()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.next(itr, INVALID_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, remove() - tries to remove last element returned by next in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class) 
	public void testListItrAdd_remove()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.remove(itr); 
	}

	/**
	 * Test: new ListIterator, call add(E); test hasPrevious() - whether there's a previous element in the ListIterator list
	 * Expected Result: true
	 */
	@Test
	public void testListItrAdd_hasPrevious()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.hasPrevious(itr, true); 
	}

	/**
	 * Test: new ListIterator, call add(E); test previous() - returns ref to previous element in the ListIterator list
	 * Expected Result: Reference to ADD_ELEMENT (E)
	 */
	@Test
	public void testListItrAdd_previous()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.previous(itr, ADDED_ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call add(E); test add() - adds new element to the ListIterator list
	 * Expected Result: No exception
	 */
	@Test
	public void testListItrAdd_add()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.add(itr, ELEMENT); 
	}

	/**
	 * Test: new ListIterator, call add(E); test nextIndex() - index of next element in the ListIterator list
	 * Expected Result: 1
	 */
	@Test
	public void testListItrAdd_nextIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.nextIndex(itr, 1); 
	}

	/**
	 * Test: new ListIterator, call add(E); test previousIndex() - index of previous element in the ListIterator list
	 * Expected Result: 0
	 */
	@Test
	public void testListItrAdd_previousIndex()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.previousIndex(itr, 0); 
	}
	
	/**
	 * Test: new ListIterator, call add(E); test set(E) - tries to set element in the ListIterator list
	 * Expected Result: IllegalStateException
	 */
	@Test(expectedExceptions = IllegalStateException.class)
	public void testListItrAdd_set()
	{
		itr = TestCase.initListItr(list, TestCase.ListItrState.add);
		TestCase.set(itr, ELEMENT); 
	}

}
