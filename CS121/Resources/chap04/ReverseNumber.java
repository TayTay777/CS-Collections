import java.util.Scanner;

/**
 * Demonstrates the use of a do loop.
 * 
 * @author Java Foundations
 */
public class ReverseNumber
{
	/**
	 * Reverses the digits of an integer mathematically.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int number, lastDigit, reverse = 0;

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a positive integer: ");
		number = scan.nextInt();

		do {
			lastDigit = number % 10;
			reverse = (reverse * 10) + lastDigit;
			number = number / 10;
		} while (number > 0);

		System.out.println("That number reversed is " + reverse);

		scan.close();
	}
}
