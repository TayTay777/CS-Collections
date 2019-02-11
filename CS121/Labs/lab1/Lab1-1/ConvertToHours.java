/**
 * Program converts seconds to hours, minutes, and remaining seconds. 
 *
 * @author Taylor Paul Roberts
 */
 
  import java.util.Scanner;
public class ConvertToHours
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner (System.in);
        System.out.println( "Enter #Seconds:" );
        int seconds = keyboard.nextInt();
        int hours = seconds / 3600;
        int minutes = seconds % 3600 / 60;
        int Seconds = seconds - (hours * 3600 + minutes * 60);
        System.out.println("hours: "+ hours);
        System.out.println("minutes: "+ minutes);
        System.out.println("minutes: "+ Seconds);
    }
}