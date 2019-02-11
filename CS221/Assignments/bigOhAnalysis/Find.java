/**
 * Returns index of a value in an int[] or -1 if it isn't found.
 * @author mvail
 */
public class Find {

	/**
	 * Return index where value is found in array or -1 if not found.
	 * @param array ints where value may be found
	 * @param value int that may be in array
	 * @return index where value is found or -1 if not found
	 */
	
	//double value representing the total number of statements executed by the algorithm
	//running the find constructor based on array size, which in this case is n for the 
	//big-Oh analysis
	private static double numOfStatements = 0;
	
	
	public static int find(int[] array, int value) 
	{
		//checks for loop
		numOfStatements++;
		
		for (int i = 0; i < array.length; i++) 
		{
			//each time for loop is executed...
			//bulk of statements depending on probability of finding said int value
			//checking if statement
			numOfStatements += 2;
			
			if (array[i] == value) 
			{
				//running through if statement, return statement
				numOfStatements += 2;
				
				return i;
			}
		}
		//return statement
		numOfStatements++;
		return -1;
	}
	
	public static void resetStatements(){
		numOfStatements = 0;
	}
	
	public static double getStatements(){
		return numOfStatements;
	}
}
