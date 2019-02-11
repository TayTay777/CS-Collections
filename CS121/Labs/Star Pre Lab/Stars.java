/**
 * Demonstrates the use of nested for loops.
 * 
 * @author Java Foundations
 */
public class Stars
{
   /**
    * Prints a triangle shape using asterisk (star) characters.
    * @param args
    */
   public static void main (String[] args)
   {
      final int MAX_ROWS = 1;

      for (int row = MAX_ROWS; row < 11 ; row++)
    	  //             10     10 > 0   10-1    
      {
         for (int space = 10; space > row; space--)
        	 System.out.print (" ");
    	  
    	  
    	  for (int star = 0; star < row; star++)
        	//                0  <  10   0+1
        	 
            System.out.print ("*");
        

         System.out.println();
      }
   }
}
