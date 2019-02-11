/**
 * Demonstrates the use of nested for loops.
 * 
 * @author Java Foundations
 */
public class Star
{
   /**
    * Prints a triangle shape using asterisk (star) characters.
    * @param args
    */
   public static void main (String[] args)
   {final int i = 1;
      final int MAX_ROWS = 10;

      for (int row = 1; row <= MAX_ROWS; row++)
      {
         for (int i = 1; i <= MAX_ROWS-row; i++)
         {
            System.out.print (" ");
         }
         
         for (int star = i; star <= MAX_ROWS; star++)
         {
        	 System.out.println("*");
         }
         System.out.println();
         
      }
   }
}