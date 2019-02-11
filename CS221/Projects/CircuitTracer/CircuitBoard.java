import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents a 2D circuit board as read from an input file.
 *  
 * @author TaylorPaulRoberts based on code by mvail
 */
public class CircuitBoard {


	private char[][] board;
	private Point startingPoint;
	private Point endingPoint;


	private final int ROWS; //initialized in constructor
	private final int COLS; //initialized in constructor


	private final char OPEN = 'O'; //capital 'o'
	private final char CLOSED = 'X';
	private final char TRACE = 'T';
	private final char START = '1';
	private final char END = '2';

	/** Construct a CircuitBoard from a given board input file, where the first
	 * line contains the number of rows and columns as ints and each subsequent
	 * line is one row of characters representing the contents of that position.
	 * Valid characters are as follows:
	 *  'O' an open position
	 *  'X' an occupied, unavailable position
	 *  '1' first of two components needing to be connected
	 *  '2' second of two components needing to be connected
	 *  'T' is not expected in input files - represents part of the trace
	 *   connecting components 1 and 2 in the solution
	 *   
	 *   You can choose to throw FileNotFoundException by itself or add on 
	 *   a pre-made message. Commented out above fnfexception. 
	 * 
	 * @param filename
	 * 		file containing a grid of characters
	 * @throws FileNotFoundException if Scanner cannot read the file
	 * @throws InvalidFileFormatException for any other format or content issue that prevents reading a valid input file
	 */

	@SuppressWarnings("resource")
	public CircuitBoard(String filename) throws FileNotFoundException 
	{



		//initial row and column number count
		int row = 0;
		int col = 0;



		//Scanner used to scan the whole file
		Scanner fileScan = new Scanner(new File(filename));
		//String used to store an entire row of elements
		String line = fileScan.nextLine();
		//2nd scanner to scan the the row only
		Scanner fileScan2 = new Scanner(line);


		//values for row and column should only be int values, hence the hasNextInt method
		if (fileScan2.hasNextInt())
		{
			row = Integer.parseInt(fileScan2.next());

			if (row <= 0)
			{
//				System.out.println();
//				System.out.println(filename);
//				System.out.println("The file's row number is 0 or negative. Must be a positive integer.");
//				System.out.println("INVALID");
//				System.out.println();
				throw new InvalidFileFormatException("The file's row number is 0 or negative. Must be a positive integer.");
			}

			if (fileScan2.hasNextInt()){

				col = Integer.parseInt(fileScan2.next());

				if (col <= 0)
				{
//					System.out.println();
//					System.out.println(filename);
//					System.out.println("The file's column number is 0 or negative. Must be a positive integer.");
//					System.out.println("INVALID");
//					System.out.println();
					throw new InvalidFileFormatException("The file's column number is 0 or negative. Must be a positive integer.");
				}

				if (fileScan2.hasNext())
				{
//					System.out.println();
//					System.out.println(filename);
//					System.out.println("The file has more data than required.");
//					System.out.println("The file should only have a row, then column integer.");
//					System.out.println("INVALID");
//					System.out.println();
					throw new InvalidFileFormatException("The file has more data than required. \nThe file should only have a row, then column integer.");

				}

			}
			else 
			{
//				System.out.println();
//				System.out.println(filename);
//				System.out.println("The file does not contain an integer column#");
//				System.out.println("INVALID");
//				System.out.println();
				throw new InvalidFileFormatException("The file does not contain an integer column#");
			}


		}
		else
		{
//			System.out.println();
//			System.out.println(filename);
//			System.out.println("The file does not contain an integer row & column #");
//			System.out.println("INVALID");
//			System.out.println();
			throw new InvalidFileFormatException("The file does not contain an integer row & column #");

		}

		//if the program has made it this far, row and column number should be stored
		//ROWS and COLS is implemented at the bottom of CircuitBoard constructor

		board = new char[row][col];
		boolean hasStart = false;
		boolean hasEnd = false;
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

					char next = fileScan2.next().charAt(0);


					if (next != START && next != END && next != CLOSED && next != OPEN)
					{
//						System.out.println();
//						System.out.println(filename);
//						System.out.println("The file contains an invalid element type in row/column. Invalid element '" + next + "'");
//						System.out.println("Must be a 1, 2, O, or X (O is a capital 'o')");
//						System.out.println("INVALID");
//						System.out.println();
						throw new InvalidFileFormatException("The file contains an invalid element type in row/column. Invalid element '" + next + "'\nMust be a 1, 2, O, or X (O is a capital 'o')");
					}

					colCount++;
					//Below code for simple testing
					//System.out.println(colCount);


					if (next == START){
						startingPoint = new Point(rowCount -1, colCount -1);
						hasStart = true;
					}

					if (next == END){
						endingPoint = new Point(rowCount -1, colCount -1);
						hasEnd = true;
					}

					board[rowCount -1][colCount -1] = next;


				}

				if (colCount > col)
				{
//					System.out.println();
//					System.out.println(filename);
//					System.out.println("The file has more elements in row " + rowCount + " than specified by the column value");
//					System.out.println("INVALID");
//					System.out.println();
					throw new InvalidFileFormatException("The file has more elements in row " + rowCount + " than specified by the column value");
				}


				if (colCount < col)
				{
//					System.out.println();
//					System.out.println(filename);
//					System.out.println("The file has less elements in row " + rowCount + " than specified by the column value");
//					System.out.println("INVALID");
//					System.out.println();
					throw new InvalidFileFormatException("The file has less elements in row " + rowCount + " than specified by the column value");
				}
			}
		}

		if (rowCount > row)
		{
//			System.out.println();
//			System.out.println(filename);
//			System.out.println("The file has more rows than specified by the row value");
//			System.out.println("INVALID");
//			System.out.println();
			throw new InvalidFileFormatException("The file has more rows than specified by the row value");
		}
		else if (rowCount < row)
		{
//			System.out.println();
//			System.out.println(filename);
//			System.out.println("The file has fewer rows than specified by the row value");
//			System.out.println("INVALID");
//			System.out.println();
			throw new InvalidFileFormatException("The file has fewer rows than specified by the row value");
		}
		//checks to make sure the circuitTracer has a beginning & end
		if (hasEnd == false || hasStart == false){
//			System.out.println();
//			System.out.println(filename);
//			System.out.println("The file does not have either an ending and beginning point");
//			System.out.println("INVALID");
//			System.out.println();
			throw new InvalidFileFormatException("The file does not have either an ending and beginning point");
		}

		fileScan.close();
		fileScan2.close();

		//initialized ROWS & COLS
		ROWS = row;
		COLS = col;

	}

	/** Copy constructor - duplicates original board
	 * 
	 * @param original board to copy
	 */
	public CircuitBoard(CircuitBoard original) {
		board = original.getBoard();
		startingPoint = new Point(original.startingPoint);
		endingPoint = new Point(original.endingPoint);
		ROWS = original.numRows();
		COLS = original.numCols();
	}

	/** utility method for copy constructor
	 * @return copy of board array */
	private char[][] getBoard() {
		char[][] copy = new char[board.length][board[0].length];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				copy[row][col] = board[row][col];
			}
		}
		return copy;
	}

	/** Return the char at board position x,y
	 * @param row row coordinate
	 * @param col col coordinate
	 * @return char at row, col
	 */
	public char charAt(int row, int col) {
		return board[row][col];
	}

	/** Return whether given board position is open
	 * @param row
	 * @param col
	 * @return true if position at (row, col) is open 
	 */
	public boolean isOpen(int row, int col) {
		//added to this method
		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length)   {
			return false;
		}
		return board[row][col] == OPEN;
	}

	/** Set given position to be a 'T'
	 * @param row
	 * @param col
	 * @throws OccupiedPositionException if given position is not open
	 */
	public void makeTrace(int row, int col) {
		if (isOpen(row, col)) {
			board[row][col] = TRACE;
		} else {
			throw new OccupiedPositionException("row " + row + ", col " + col + ", contains '" + board[row][col] + "'");
		}
	}

	/** @return starting Point */
	public Point getStartingPoint() {
		return new Point(startingPoint);
	}

	/** @return ending Point */
	public Point getEndingPoint() {
		return new Point(endingPoint);
	}

	/** @return number of rows in this CircuitBoard */
	public int numRows() {
		return ROWS;
	}

	/** @return number of columns in this CircuitBoard */
	public int numCols() {
		return COLS;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				str.append(board[row][col] + " ");
			}
			str.append("\n");
		}
		return str.toString();
	}

}// class CircuitBoard
