/**
 * Takes an array and reorders it so elements are in ascending order.
 * @author mvail
 */
public class Order {
	private static long numStatements = 0;

	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * @param array ints that need to be ordered 
	 */
	public static void order(int[] array) 
	{
		numStatements += 2; //loop init & condition check
        for (int next = 1; next < array.length; next++)  
        {
        	numStatements += 6; //condition check (2nd time), 2 initializations, 
        	                          //2 condition checks in the while loop, array initialization
            int val = array[next];
            int index = next;
            while (index > 0 && val < array[index - 1]) 
            {
            	numStatements += 4; // 2 condition checks (2nd time), increment, 
            	                    //initialization
               
            	array[index] = array[index - 1];
                index--;
            }
            
            array[index] = val;
        }
	}
	
	public static long getStatements()
	{
		return numStatements;
	}
}
