import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * @author TaylorPaulRoberts
 * program designed to create and read MagicSquares either into or from standard text files
 *
 */
public class MagicSquare {

	private static int n;
	private static int[][] mSc = new int[n][n];




	/**
	 * method that checks magic square, making sure they are valid or not.
	 * @param file
	 * @throws FileNotFoundException
	 */
	public static void checkMatrix(File file) throws FileNotFoundException
	{
		readMatrix(file);

		int pass = n+n+2;
		int passCheck=0;
		int lineTotal=0;
		int magicNumber = n*(n*n+1)/2;
		boolean magicConfirmed = false;


		//code for adding from left to right
		for (int i = 0; i < n; i++){
			lineTotal=0;
			for (int ii = 0; ii < n; ii++){
				lineTotal = lineTotal + mSc[i][ii];
				if (lineTotal == magicNumber){
					passCheck++;
				}
			}
		}

		//code for adding top to bottom
		for (int i = 0; i < n; i++){
			lineTotal=0;
			for (int ii = 0; ii < n; ii++){
				lineTotal = lineTotal + mSc[ii][i];
				if (lineTotal == magicNumber){
					passCheck++;
				}
			}
		}

		//code for adding diagonal left(top) to right
		lineTotal=0;
		for (int i = 0; i < n; i++){
			lineTotal=lineTotal+mSc[i][i];
			if (lineTotal == magicNumber){
				passCheck++;
			}
		}

		//code for adding diagonal right(top) to left
		lineTotal=0;
		for (int i = 0; i < n; i++){
			int R =n-1;
			lineTotal=lineTotal+mSc[i][R];
			if (lineTotal == magicNumber){
				passCheck++;
			}
		}

		//boolean only true if all additions add up to the same magic number
		//adding across for all columns and rows, as well as the two diagonal directions
		
		if (pass == passCheck){
			magicConfirmed = true;
		}

		//can be used to compare number of passed lines VS. correct number
		//System.out.println(pass);
		//System.out.println(passCheck);

		//returns true or false depending on if it is a magic square or not
		//System.out.println(magicConfirmed);
		System.out.println();
		System.out.print("The matrix:");
		System.out.println();
		for (int i = 0; i<n; i++)
		{
			System.out.println();
			for (int ii = 0; ii<n; ii++)
			{
				System.out.print(mSc[i][ii] + " ");
			}
		}
		System.out.println();
		System.out.println();
		if (magicConfirmed==true){
			System.out.println("is a Magic Square!");
		}
		else System.out.println("is not a Magic Square...");

	}



	/**
	 * part of checkMatric() simply reads and stores the numbers from the magic squares
	 * @param file
	 * @throws FileNotFoundException
	 */
	private static void readMatrix(File file) throws FileNotFoundException
	{


		n = 0;


		@SuppressWarnings("resource")
		Scanner fileScan = new Scanner(file);
		n = Integer.parseInt(fileScan.next());
		fileScan.nextLine();

		mSc = new int[n][n];


		for (int i = 0; i < n; i++){
			for (int ii = 0; ii < n; ii++){
				if (fileScan.hasNext()){
					mSc[i][ii] = Integer.parseInt(fileScan.next());

					//code used for checking the code
					//System.out.println(mSc[i][ii]);

					if (i == n){
						fileScan.nextLine();
					}
				}
			}
		}
	}



	/**
	 * method that takes in a new file and number generated using the driver MagicSquareTester class
	 * contains the algorithm for generated the various numbers in a magic square based on the chosen 
	 * size of the square. 
	 * @param size
	 * @param file
	 * @throws IOException
	 */
	public static void createMagicSquare(int size, File file) throws IOException
	{

		n = size;
		mSc = new int[n][n];
		int row = n-1;
		int col = n/2;
		int oldRow;
		int oldCol;


		for (int i = 1; i <= n*n; i++)
		{
			mSc[row][col]=i;
			oldRow = row;
			oldCol = col;
			row++;
			col++;

			if (row == n)
			{
				row = 0;
			}
			if (col == n)
			{
				col = 0;
			}

			if(mSc[row][col] != 0)
			{
				row = oldRow;
				col = oldCol;
				row--;
			}
		}
		

		//Used to test correct output
//		for (int t = 0; t<n; t++)
//		{
//			for (int r = 0; r<n; r++)
//			{
//				System.out.println(mSc[t][r]);
//			}
//		}
		
		writeMatrix(file);
	}

	
	
	/**
	 * takes the information made from the createMagicSquare() method and writes the numbers 
	 * into the file added into the createMagicSquare() input field for file
	 * this method and createMagicSquare work together
	 * @param file
	 * @throws IOException
	 */
	private static void writeMatrix(File file) throws IOException{
		
		PrintWriter outFile = new PrintWriter(new FileWriter(file));
		
		outFile.print(n);
		for (int i = 0; i<n; i++)
		{
			outFile.println();
			for (int ii = 0; ii<n; ii++)
			{
				outFile.print(mSc[i][ii] + " ");
			}
		}
		outFile.close();
	}
}
