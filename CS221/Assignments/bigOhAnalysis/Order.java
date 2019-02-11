import java.util.Arrays;

/**
 * Takes an array and reorders it so elements are in ascending order.
 * @author mvail
 */
public class Order {

	/**
	 * Take an int[] and reorganize it so they are in ascending order.
	 * @param array ints that need to be ordered 
	 */
	
	private static long numOfStatements = 0;
	
	public static void order(int[] array) {
		//checks for loop
		numOfStatements++;
        for (int next = 1; next < array.length; next++) 
        {
        	//runs through for loop, initializes two variables, checks while loop, swaps array value
        	numOfStatements+=5;
            int val = array[next];
            int index = next;
            while (index > 0 && val < array[index - 1]) 
            {
            	//runs through while loop, swaps variable, increment
            	numOfStatements+=3;
                array[index] = array[index - 1];
                index--;
                //System.out.println(Arrays.toString(array));
            }
            //System.out.println(Arrays.toString(array));
            array[index] = val; 
            //System.out.println(Arrays.toString(array));

        }
	}
	
	public static void resetStatements(){
		numOfStatements = 0;
	}
	
	public static long getStatements(){
		return numOfStatements;
	}
}
