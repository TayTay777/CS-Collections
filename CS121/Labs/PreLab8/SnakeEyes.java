import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

/**
 * Demonstrates the use of a programmer-defined class.
 * @author Java Foundations
 * @author Taylor 
 *for editing
 */
public class SnakeEyes
{
   /**
    * Creates two Die objects and rolls them several times, counting
    * the number of snake eyes that occur.
    * 
    * @param args (unused)
    * 
    * 
    */
	

	
   public static void main (String[] args)
   {
	   Scanner scan = new Scanner(System.in);
		System.out.print("Enter a seed (or 0 for no seed): ");
		int seed = scan.nextInt();
		Die die1;
		Die die2;
		if (seed == 0)
		{
		      die1 = new Die(6);
		      die2 = new Die(6);
		}
		else
		{
			  die1 = new Die(6, seed);
		      die2 = new Die(6, seed);
		}
	   
      final int ROLLS = 500;
      int num1, num2, count = 0;

      for (int roll = 1; roll <= ROLLS; roll++)
      {
         num1 = die1.roll();         
         num2 = die2.roll();
         
         //print the value of die1 and die2
         System.out.println("roll " + roll);
         
         System.out.println("die1 value: " + die1.getFaceValue());
         System.out.println("die2 value: " + die2.getFaceValue());
         
         System.out.println();
         
         if (num1 == 1 && num2 == 1)    // check for snake eyes
            count++;
      }

      System.out.println ("Number of rolls: " + ROLLS);
      System.out.println ("Number of snake eyes: " + count);
      System.out.println ("Ratio: " + (double)count / ROLLS);
   }
}
