/**
 * This program converts Hours and minutes to seconds as well as adds seconds to converted seconds.
 * Input your Hours, Minutes, and Seconds after = sign. 
 *
 * @author Taylor Paul Roberts
 */
 
 import java.text.DecimalFormat;
import java.util.Scanner;
public class ConvertToSeconds
{
    public static void main(String[] args)
    {
         
     Scanner keyboard = new Scanner (System.in);
        //System.out.println( "Enter Hours:" );
   
     System.out.println("Enter Number:");
     double input = keyboard.nextInt();
     DecimalFormat decimalFmt = new DecimalFormat("0.00");
     System.out.println("decimal format is: "  +decimalFmt.format(input));
     
    }
}