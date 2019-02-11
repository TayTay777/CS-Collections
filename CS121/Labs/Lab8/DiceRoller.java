import java.util.Scanner;
/*uses PairOfDice.java to make a game where you and the computer vs. eachother. 
 * You roll two dice, then add them together. The computer does the same. Whoever's number is greater
 * is the winner!!!
 * @author TaylorPaulRoberts
 * 
 */
public class DiceRoller {


	public static void main (String[] args)
	{


		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a number of sides for your two dice: ");
		int numberOfSides = scan.nextInt();
		PairOfDice Pair = new PairOfDice(numberOfSides);


		String YorN;
		scan.nextLine();
		do 
		{
			System.out.println();
			int p1 = Pair.roll();
			System.out.println("Your roll: " + p1 + " (" + Pair.getFaceValue1() + " + " + Pair.getFaceValue2() + ")");
			int p2 = Pair.roll();
			System.out.println("Computer's roll: " + p2 + " (" + Pair.getFaceValue1() + " + " + Pair.getFaceValue2() + ")");



			String winner = "";
			int p1wins = 0;
			int cwins = 0;
			int ties = 0;
			if (p1 > p2)
			{
				winner = "You win!";
				p1wins++;
			}
			else if (p1 < p2)
			{
				winner = "You Lose!";
				cwins++;
			}
			else 
			{
				winner = "Tie!";
				ties++;
			}
			System.out.println(winner);
			System.out.println();
			System.out.println("Your wins: " + p1wins + "   Computer's wins: " + cwins + "   Ties: " + ties);
			System.out.println();
			System.out.println("Do you want to roll again? (Y)es to continue, anything else to quit.");
			YorN = scan.nextLine();
		}

		while ( YorN.equals("y"));



	}

}
