import java.util.NoSuchElementException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testing for SimpleSet interface implementation: 
 * Tests for Scenario: [A] -> remove(A) -> [ ]
 *
 * @author CS221
 */
public class TestSimpleSet_A_removeA_Empty
{
	// SimpleSet running tests on 
	private SimpleSet<Integer> set; 
	
	// variable for tests 
	private final int SIZE = 0; 
	
	/**
	 * Reinitializes set before each test. 
	 */
	@BeforeMethod 
	public void initializeSet()
	{
		set = new ArraySet<Integer>();
		set.add(SetTestCase.A);
		set.remove(SetTestCase.A);
	}

	/**
	 * Test: toString() - String representation of set 
	 * Expected Result: No exceptions 
	 */
	@Test
	public void testToString()
	{
		SetTestCase.toString(set);
	}

	/**
	 * Test: size() - number of elements in set 
	 * Expected Result: SIZE (0)
	 */
	@Test
	public void testSize()
	{
		SetTestCase.size(set, SIZE);
	}

	/**
	 * Test: isEmpty() - whether set is empty
	 * Expected Result: False
	 */
	@Test
	public void testIsEmpty()
	{
		SetTestCase.isEmpty(set, true);
	}

	/**
	 * Test: contains(A) 
	 * - whether set contains element A not in set
	 * Expected Result: False
	 */
	@Test
	public void testContains_A()
	{
		SetTestCase.contains(set, SetTestCase.A, false);
	}
	
	/**
	 * Test: add(A) - adds element A to set
	 * Expected Result: No exceptions 
	 */
	@Test
	public void testAdd_A()
	{
		SetTestCase.add(set, SetTestCase.A);
	}
	
	/**
	 * Test: remove(A) 
	 * - tries to remove element A not in set from set
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testRemove_A()
	{
		SetTestCase.remove(set, SetTestCase.A);
	}
}
