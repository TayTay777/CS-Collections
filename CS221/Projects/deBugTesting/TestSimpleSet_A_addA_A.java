import java.util.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testing for SimpleSet interface implementation: 
 * Tests for Scenario: [A] -> add(A) -> [A]
 *
 * @author CS221
 */
public class TestSimpleSet_A_addA_A
{
	// SimpleSet running tests on 
	private SimpleSet<Integer> set; 
	
	// variable for tests 
	private final int SIZE = 1; 
	
	/**
	 * Reinitializes set before each test. 
	 */
	@BeforeMethod 
	public void initializeSet()
	{
		set = new ArraySet<Integer>();
		set.add(SetTestCase.A);
		set.add(SetTestCase.A);
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
	 * Expected Result: 1
	 */
	@Test
	public void testSize()
	{
		SetTestCase.size(set, SIZE);
	}

	/**
	 * Test: isEmpty() - whether set is empty
	 * Expected Result: false
	 */
	@Test
	public void testIsEmpty()
	{
		SetTestCase.isEmpty(set, false);
	}

	/**
	 * Test: contains(A) - whether set contains A 
	 * Expected Result: true 
	 */
	@Test
	public void testContains_A()
	{
		SetTestCase.contains(set, SetTestCase.A, true);
	}
	
	/**
	 * Test: contains(B) 
	 * - whether set contains element B not in set
	 * Expected Result: false
	 */
	@Test
	public void testContains_B()
	{
		SetTestCase.contains(set, SetTestCase.B, false);
	}
	
	/**
	 * Test: add(A) - tries to add A to set, but already in it
	 * Expected Result: No exceptions
	 */
	@Test
	public void testAdd_A()
	{
		SetTestCase.add(set, SetTestCase.A);
	}
	
	/**
	 * Test: add(B) - adds element B to set
	 * Expected Result: No exceptions 
	 */
	@Test
	public void testAdd_B()
	{
		SetTestCase.add(set, SetTestCase.B);
	}
	
	/**
	 * Test: remove(A) - removes A from set
	 * Expected Result: Reference to A
	 */
	@Test
	public void testRemove_A()
	{
		SetTestCase.remove(set, SetTestCase.A);
	}
	
	/**
	 * Test: remove(B) 
	 * - tries to remove B not in set from set
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testRemove_B()
	{
		SetTestCase.remove(set, SetTestCase.B);
	}
}
