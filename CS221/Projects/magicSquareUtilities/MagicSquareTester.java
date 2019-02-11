import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



/**
 * @author TaylorPaulRoberts
 * this class is designed to implement the functions of the MagicSquare using command arguments 
 * to create and read magic squares from plain text files
 */
public class MagicSquareTester {



	public static void main(String[] args) throws IOException{


		
		if (args[0].equals("-check") || args[0].equals("-create"))
		
		{

			
			//Checking a magic square 
			if (args[0].equals("-check")){

				MagicSquare testMagicSquare = new MagicSquare();
				File file = new File(args[1]);
				testMagicSquare.checkMatrix(file);

			}


			//Creating a magic square & printing to a file
			if (args[0].equals("-create")&& (Integer.parseInt(args[2]) % 2 != 0)){

				MagicSquare newMagicSquare = new MagicSquare();
				File file = new File(args[1]);
				int squareSize = Integer.parseInt(args[2]);
				newMagicSquare.createMagicSquare(squareSize,file);
			}
			else System.out.println("Incorrect input. Format java MagicSquareTester [-check | -create] [filename] [ |size] \nSize must be odd!");
		}
		else
			
			System.out.println("Incorrect input. Format java MagicSquareTester [-check | -create] [filename] [ |size]");

	}




}
