import java.util.Scanner;

/**
 * @author 
 */
public class RandomWalkTest
{
	private static int gridSize = 0;
	private static long seed = 0;

	private static Scanner scan = new Scanner(System.in);

	/**
	 * Method that prompts the user for the grid size and seed. if 
	 * the user enters a gridsize that is <= 0, they will get another 
	 * changce to enter in the information. The same goes for the seed.
	 * If a user enters in anything < 0 the user gets informed, then prompted 
	 * for a new number. If 0 is entered for the seed, the random generator 
	 * will be randomly different every 0. 
	 */
	private static void getInput() 
	{
		System.out.print("Enter grid size: ");
		gridSize = scan.nextInt();
		System.out.print("");
		if (gridSize <= 0)
		{
			System.out.println("Error: grid size must be positive!");
			//System.exit(1);
			getInput();
		}
		System.out.print("Enter random seed (0 for no seed): ");
		seed = scan.nextInt();
		do if (seed < 0)
		{
			System.out.println("Error: seed must be >= 0!");
			//System.exit(1);
			System.out.print("Enter random seed (0 for no seed): ");
			seed = scan.nextInt();
		}
		while (seed < 0);

	}



	/**Intiates the getInput() method from above and then creates
	 * a new object using the RandomWalk constructor for a seed and 
	 * one without a seed if the entered seed is 0.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//String XorY;
		//do
		//{
			getInput();
			if (seed == 0)
			{
				RandomWalk RWTest = new RandomWalk(gridSize);
				RWTest.createWalk();
				System.out.println(RWTest.toString());
			}
			else
			{
				RandomWalk RWTest = new RandomWalk(gridSize, seed);
				RWTest.createWalk();
				System.out.println(RWTest.toString());
			}
			//scan.nextLine();
			//System.out.println("Run again? y or n");
			//XorY = scan.nextLine();
		//}

		//while (XorY.equals("y"));
	}
}
