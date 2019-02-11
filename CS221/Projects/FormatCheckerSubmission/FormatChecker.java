import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author TaylorPaulRoberts
 * Program that takes in text files and makes sure they are in the right format
 * based on row & column number in first line of file, 
 * with the columns and rows being only Double numbers. 
 * RUNNING FORMAT: Navigate into this java file's directory in shell (Konsole, CMD, Terminal, etc...)
 * Compile line: javac FormatChecker.java
 * Command line: java FormatChecker [file1 file2 file3 etc...]
 * --Example: java FormatChecker valid1.dat valid2.dat invaled6.dat 
 */


public class FormatChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println();

		//for loop executes method fileFormatChecker() for every file name entered
		//in the command line
		for (int i=0; i < args.length; i++){

			File file = new File(args[i]);
			fileFormatChecker(file);

			System.out.println();
		}
	}


	private Scanner fileScan;

	/**
	 * This method is used to scan the entire file given from the argument array.
	 * There are several checks involved. 
	 * 1st, the file should only have two Int/Long values in the first line of the code, 
	 * representing row then column number
	 * 2nd, the numbers below the row and column should match these figures. 
	 * 3rd, all the values in the row/column table should only be Double values
	 * If any one of these checks fails by getting something out of bounds of the requirements,
	 * the method will print an "INVALID" marker for the file then quit.
	 * @param file
	 */
	private static void fileFormatChecker(File file){


		//try/catch statement for making sure the file variable is an actual file before 
		//proceeding further.
		try {

			
			//Scanner used to scan the whole file
			Scanner fileScan = new Scanner(file);
			//String used to store an entire row of elements
			String line = fileScan.nextLine();
			//2nd scanner to scan the the row only
			Scanner fileScan2 = new Scanner(line);

			//initial row and column number count
			int row = 0;
			int col = 0;



			//values for row and column should only be int values, hence the hasNextInt method
			if (fileScan2.hasNextInt())
			{
				row = Integer.parseInt(fileScan2.next());

				if (row <= 0)
				{
					System.out.println(file);
					System.out.println("The file's row number is 0 or negative. Must be a positive integer.");
					System.out.println("INVALID");
					return;
				}

				if (fileScan2.hasNextInt()){

					col = Integer.parseInt(fileScan2.next());

					if (col <= 0)
				:wq
	{
						System.out.println(file);
						System.out.println("The file's column number is 0 or negative. Must be a positive integer.");
						System.out.println("INVALID");
						return;
					}

					if (fileScan2.hasNext())
					{
						System.out.println(file);
						System.out.println("The file has more data than required.");
						System.out.println("The file should only have a row, then column integer.");
						System.out.println("INVALID");
						return;
					}

				}
				else 
				{
					System.out.println(file);
					System.out.println("The file does not contain an integer column#");
					System.out.println("INVALID");
					return;
				}


			}
			else
			{
				System.out.println(file);
				System.out.println("The file does not contain an integer row & column #");
				System.out.println("INVALID");
				return;

			}

			//if the program has made it this far, row and col number should be stored
			

			int rowCount = 0;
			
			//continues if there is another row
			while (fileScan.hasNextLine())
			{


				line = fileScan.nextLine();
				fileScan2 = new Scanner(line);
				int colCount = 0;

				//while loop placed in order to skip blank or empty rows, which is allowed
				while (fileScan2.hasNext() == true)
				{
					rowCount++;




					while (fileScan2.hasNext())
					{
						if (fileScan2.hasNextDouble() == false)
						{
							System.out.println(file);
							System.out.println("The file has contains an invalid element type in row/column. Invalid element '" + fileScan2.next() + "'");
							System.out.println("Must be a Double value");
							System.out.println("INVALID");
							return;
						}

						fileScan2.next();
						//System.out.println(fileScan2.next());
						colCount++;
						//System.out.println(colCount);

					}

					if (colCount > col)
					{
						System.out.println(file);
						System.out.println("The file has more elements in row " + rowCount + " than specified by the column value");
						System.out.println("INVALID");
						return;
					}
		
						
					if (colCount < col)
					{
						System.out.println(file);
						System.out.println("The file has less elements in row " + rowCount + " than specified by the column value");
						System.out.println("INVALID");
						return;
					}
				}
			}

			if (rowCount > row)
			{
				System.out.println(file);
				System.out.println("The file has more rows than specified by the row value");
				System.out.println("INVALID");
				return;
			}
			else if (rowCount < row)
			{
				System.out.println(file);
				System.out.println("The file has fewer rows than specified by the row value");
				System.out.println("INVALID");
				return;
			}

			System.out.println(file);
			System.out.println("VALID");





		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.toString();

			System.out.println(file);
			System.out.println("File not found.");
			System.out.println("INVALID");
			return;
		}
	}
}
