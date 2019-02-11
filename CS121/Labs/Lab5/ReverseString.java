import java.util.Scanner;


public class ReverseString {
	/* Class that reverse String input by letters in the words and the word ordering
	 * @author TaylorPaulRoberts
	 */
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Sentence: ");
		String message = scan.nextLine().trim();
		
		//char lstLetter = message.charAt(message.length()-1);
		String reverse = "";
		for ( int lstLetter = message.length() -1; lstLetter >= 0; lstLetter -= 1)
		{
		reverse = reverse + message.charAt(lstLetter);
		}
		System.out.println(reverse);	
		
		scan.close();


}}