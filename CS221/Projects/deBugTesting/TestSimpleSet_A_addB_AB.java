import java.util.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Testing for SimpleSet interface implementation: 
 * Tests for Scenario: [A] -> add(B) -> [A,B]
 *
 * @author CS221
 */
public class TestSimpleSet_A_addB_AB
{
	// SimpleSet running tests on 
	private SimpleSet<Integer> set; 
	
	// variables for tests 
	private final int SIZE = 2; 
	//private static final Object[][] VALID_ELEMENTS = { {SetTestCase.A}, {SetTestCase.B} }; //MV: can't get this to work, so ditching it

	/**
	 * Reinitializes set before each test. 
	 */
	@BeforeMethod 
	public void initializeSet()
	{
		set = new ArraySet<Integer>();
		set.add(SetTestCase.A);
		set.add(SetTestCase.B);
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
	 * Expected Result: SIZE (2)
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

//	/**
//	 * Test: contains(X) - whether set contains X, an element in set
//	 * Expected Result: True 
//	 */
//	@Test(dataProvider = "validElements") //MV: can't get this to work
//	public void testContains_validElement(Integer element)
//	{
//		SetTestCase.contains(set, element, true);
//	}
	
	/**
	 * Test: contains(A)
	 * Expected Result: True 
	 */
	@Test
	public void testContains_A()
	{
		SetTestCase.contains(set, SetTestCase.A, true);
	}

	/**
	 * Test: contains(B)
	 * Expected Result: True 
	 */
	@Test
	public void testContains_B()
	{
		SetTestCase.contains(set, SetTestCase.B, true);
	}
	
	/**
	 * Test: contains(C) 
	 * - whether set contains an element C not in set
	 * Expected Result: False
	 */
	@Test
	public void testContains_C()
	{
		SetTestCase.contains(set, SetTestCase.C, false);
	}
	
//	/**
//	 * Test: add(X) - tries to add elements (X) already in set to set
//	 * Expected Result: No exceptions
//	 */
//	@Test(dataProvider = "validElements")
//	public void testAdd_validElement(Integer element)
//	{
//		SetTestCase.add(set, element);
//	}
	
	/**
	 * Test: add(A)
	 * Expected Result: No exceptions
	 */
	@Test
	public void testAdd_A()
	{
		SetTestCase.add(set, SetTestCase.A);
	}
	
	/**
	 * Test: add(B)
	 * Expected Result: No exceptions
	 */
	@Test
	public void testAdd_B()
	{
		SetTestCase.add(set, SetTestCase.B);
	}
	
	/**
	 * Test: add(C) - adds an element C to set
	 * Expected Result: No exceptions 
	 */
	@Test
	public void testAdd_C()
	{
		SetTestCase.add(set, SetTestCase.C);
	}
	
//	/**
//	 * Test: remove(X) - removes elements (X) in set from set
//	 * Expected Result: Reference to X
//	 */
//	@Test(dataProvider = "validElements")
//	public void testRemove_validElements(Integer element)
//	{
//		SetTestCase.remove(set, element);
//	}
	
	/**
	 * Test: remove(A)
	 * Expected Result: Reference to A
	 */
	@Test
	public void testRemove_A()
	{
		SetTestCase.remove(set, SetTestCase.A);
	}
	
	/**
	 * Test: remove(B)
	 * Expected Result: Reference to B
	 */
	@Test
	public void testRemove_B()
	{
		SetTestCase.remove(set, SetTestCase.B);
	}

	/**
	 * Test: remove(C) 
	 * - tries to remove element C not in set from set
	 * Expected Result: NoSuchElementException
	 */
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testRemove_C()
	{
		SetTestCase.remove(set, SetTestCase.C);
	}
	
//	//********** Data Provider ***************************
//	/**
//	 * Data: Integer elements.
//	 * @return 2D array of Integer elements
//	 */
//	@DataProvider
//	   public static Object[][] validElements() 
//	   {
//	      return VALID_ELEMENTS; 
//	   }
}
