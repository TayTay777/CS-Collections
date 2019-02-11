import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Cache {

	private static boolean isInt(String string) {
		try 
		{
			Integer.parseInt(string);
		} catch (NumberFormatException nFE) 
		{
			return false;
		}
		return true;
	}

	private static String levelsNotEntered()
	{
		String levels = "\nLevel options are '1' or '2'";
		return levels;
	}

	private static String cacheSizeNotEntered()
	{
		String Cache = " argument must be a counting number\n";
		return Cache;
	}

	private static String genericUsage()
	{
		String gUse = "\nUsage: Test <1 or 2> <L1 Cache size> <L2 Cache size> <File name>";
		return gUse;
	}

	public static void main(String[] args) {


		File file = null;
		int cacheOneRef = 0;
		int cacheTwoRef = 0;
		int cacheOneHits = 0;
		int cacheTwoHits = 0;
		int levelOneLength;
		int levelTwoLength;
		IUSingleLinkedList<String> levelOneList = new IUSingleLinkedList<String>();
		IUSingleLinkedList<String> levelTwoList = new IUSingleLinkedList<String>();

		if (args.length == 0)
		{
			System.err.println(genericUsage());
		}

		if (args.length > 5) 
		{
			System.err.println("\nYou've gone over the program's expected input values!");
			System.err.println(genericUsage());
		}

		if (args.length < 4) 
		{
			System.err.println("\nYou've gone under the program's expected input values!");
			System.err.println(genericUsage());
		}

		if (args[0].equals("Test") == false)
		{
			System.err.println("Arguments must begin with <Test>"); 
			System.err.println(genericUsage());
		}

		if ((args[1].equals("1") == false) && (args[1].equals("2") == false))
		{
			System.err.println(levelsNotEntered());
			System.err.println(genericUsage());
		}

		if ((isInt(args[2]) != true) || (args[2] == null) || (isInt(args[2]) != true) || (args[2] == null))
		{
			System.err.println("Third argument" + cacheSizeNotEntered());
			System.err.println(genericUsage());
		}
		if (args.length == 5) {
			if ((isInt(args[3]) != true) || (isInt(args[3]) != true))
			{
				System.err.println("Fourth argument" + cacheSizeNotEntered());
				System.err.println(genericUsage());
			}
		}


		//fix later

		if (args[1].equals("1"))
		{
			levelOneLength = Integer.parseInt(args[2]);
		}
		if (args[1].equals("2"))
		{
			levelOneLength = Integer.parseInt(args[2]);
			levelTwoLength = Integer.parseInt(args[3]);
		}


		file = new File(args[args.length - 1]);

		try 
		{
			@SuppressWarnings("resource")
			Scanner fileScan = new Scanner(file);
			while (fileScan.hasNextLine()) 
			{
				String line = fileScan.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(line, " ,.;:'\"&!?-_\n\t12345678910[]{}()@#$%^*/+-");

				while (tokenizer.hasMoreTokens())
				{
					String word = tokenizer.nextToken();
					String s = word.toLowerCase();



					//Singly Linked List code




				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.err.println("\nInvalid file path: " + args[args.length - 1]);
			System.err.println();
		}

		String test = "12345";
		int numest = Integer.parseInt(test);

		System.out.println(numest);


	}

}
