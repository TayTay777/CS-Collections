/**
 * Returns index of a value in an int[] or -1 if it isn't found.
 * @author mvail
 * 
 */
public class Find {
	private static long numStatements = 0;

	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 */
	public static int find(int[] array, int value) 
	{
		numStatements += 2; //condition check, loop init, 
		for (int i = 0; i < array.length; i++) 
		{
			numStatements += 2; //1st for loop condition check (2nd check), 
			                   // condition check for if loop
			if (array[i] == value) 
			{
				numStatements += 2; //condition check for if loop (2nd check), return
				return i;
			}
		}
		numStatements++; //return
		return -1;
	}
	
	public static long getStatements()
	{
		return numStatements;
	}
}
