import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*driver class that gets a list of one or more filenames from the 
 * command line and collects statistics on each of the files using 
 * an instance of the TextStatistics object
 * @author taylorpaulroberts
 */
public class ProcessText {

	
	public static void main(String[] args) {

	/*if statement that checks whether the person
	 * entered a file name at all for the args[] array.
	 * If not, an example is printed out. */
		
		if (args.length == 0) 
		{
			System.err.println();
			System.err.println("Usage: java ProcessText file1 [file2 ...]");
			System.err.println();
			System.exit(1);
		}
		
		/*Creates an object using the TextStatistics class then prints 
		 * out the statistics for the file using methods from the same 
		 * class that are implemented in the toString.
		 * if a file does not exist the user will get a message stating
		 * so, yet the program will continue to check the next file inputed,
		 * if any at all. */
		
		TextStatistics xfile;
		
		File file = null;
		for (int i = 0; i < args.length; i++) {
			file = new File(args[i]);
			if (file.exists()) {
				xfile = new TextStatistics(file);
				System.out.println();
				System.out.println("Statistics for " + args[i]);
				System.out.println(xfile.toString());
			} else {
				System.err.println("Invalid file path: " + args[i]);
			}
		}
	}
}