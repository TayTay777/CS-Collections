import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseAndRewrap {


	public static final int ERROR_CODE = 1;


	public static void main(String[] args){


		Scanner scan = new Scanner(System.in);


		System.out.print("Enter a file name: ");
		String fileName = scan.nextLine().trim();


		System.out.print("Please enter the maximum number of characters in a single line: ");
		int wrapL = scan.nextInt();

		System.out.println();


		File file = new File(fileName);

		try {
			Scanner fileScan = new Scanner(file);

			System.out.println(fileName + " reformatted with maximum line length of " + wrapL + ":");
			System.out.println();


			String line2 = "";
			int longest = 0;
			int shortest = wrapL;
			while (fileScan.hasNextLine()) {

				String line = fileScan.nextLine();

				Scanner lineScan = new Scanner(line);

				while (lineScan.hasNext()) {

					String token = lineScan.next();

					if (line2.length() + token.length() < wrapL)
					{
						line2 += token + " ";
				
					}

					else if (line2.length() + token.length() == wrapL)
					{
						line2 += token;
						System.out.println(line2);
						
						if (line2.length() > longest)
						{
							longest = line2.length();
						}
						if (line2.length() < shortest)
						{
							shortest = line2.length();
						}
						line2 = "";
					}

					else
					{
						System.out.println(line2);
						if (line2.length() > longest)
						{
							longest = line2.length();
						}
						if (line2.length() < shortest)
						{
							shortest = line2.length();
						}
						line2 = "";
						line2 = token + " ";
						
					}

				}
				lineScan.close();
			}
			
			System.out.print(line2);
			System.out.println();
			if (line2.length() > longest)
			{
				longest = line2.length();
			}
			System.out.println("Longest line: " + longest);
			if (line2.length() < shortest)
			{
				shortest = line2.length();
			}
			System.out.println("Shortest line: " + shortest);

			fileScan.close();
		} catch (FileNotFoundException e) {

			System.out.println("File \"" + fileName + "\" could not be opened.");
			System.out.println(e.getMessage());
			System.exit(ERROR_CODE);
		}
	}

}
