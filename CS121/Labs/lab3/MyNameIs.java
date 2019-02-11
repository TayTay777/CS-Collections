import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * A simple application to test use of String, Math, DecimalFormat and NumberFormat classes.
 * @author 
 */
public class MyNameIs {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("First name: ");
		String firstName = keyboard.nextLine();
		
		System.out.print("Last name: ");
		String lastName = keyboard.nextLine();
		
		System.out.print("Enter a number: ");
		double n1 = keyboard.nextDouble();
		
		System.out.print("Enter another number (between 0 and 1): ");
		double n2 = keyboard.nextDouble();
		DecimalFormat decimalFmt = new DecimalFormat("0.00");
		NumberFormat numberFmt = NumberFormat.getPercentInstance();
		System.out.println("\nHi, my name is " + firstName + " " + lastName + ".");
		System.out.println("You'll find me under " + "\"" + lastName + "," + " " + firstName + "\".");
		System.out.println("My name badge: " + "\"" + firstName.charAt(0) + "." + " " + lastName + "\".");
		System.out.println(numberFmt.format(n2) + " of " + decimalFmt.format(n1) + " is " + decimalFmt.format(n2 * n1));
		System.out.println(decimalFmt.format(n1) + " raised to the power of " + n2 + " is " + decimalFmt.format(Math.pow(n1, n2)));
	
	}

}