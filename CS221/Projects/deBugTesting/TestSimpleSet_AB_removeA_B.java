import java.util.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Testing for SimpleSet interface implementation: 
 * Tests for Scenario: [A,B] -> remove(A) -> [B]
 *
 * @author CS221
 */
public class TestSimpleSet_AB_removeA_B
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
		set = new ArraySet<Integer >();
		set.add(SetTestCase.A);
		set.add(SetTestCase.B);
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
	 * Expected Result: SIZE (1)
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
		SetTestCase.isEmpty(set, false);
	}

	/**
	 * Test: contains(B) - whether set contains B 
	 * Expected Result: True 
	 */
	@Test
	public void testContains_B()
	{
		SetTestCase.contains(set, SetTestCase.B, true);
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
	 * Test: add(B) - tries to add B to set, but already in it
	 * Expected Result: No exceptions
	 */
	@Test
	public void testAdd_B()
	{
		SetTestCase.add(set, SetTestCase.B);
	}
	
	/**
	 * Test: add(C) - adds element C to set
	 * Expected Result: No exceptions 
	 */
	@Test
	public void testAdd_C()
	{
		SetTestCase.add(set, SetTestCase.C);
	}
	
	/**
	 * Test: remove(B) - removes B from set
	 * Expected Result: Reference to B
	 */
	@Test
	public void testRemove_B()
	{
		SetTestCase.remove(set, SetTestCase.B);
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
