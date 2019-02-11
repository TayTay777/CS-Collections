import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseForCaps {

	public static final int ERROR_CODE = 1;


	public static void main(String[] args){


		Scanner scan = new Scanner(System.in);


		System.out.print("Enter a file name: ");
		String fileName = scan.nextLine().trim();


		File file = new File(fileName);

		try {
			Scanner fileScan = new Scanner(file);

			System.out.println("\nContents of \"" + fileName + "\":\n");

			while (fileScan.hasNextLine()) {

				String line = fileScan.nextLine();

				Scanner lineScan = new Scanner(line);

				while (lineScan.hasNext()) {

					String token = lineScan.next();
					
					if (Character.isUpperCase(token.charAt(0)) == true){
						System.out.print(token.charAt(0)); 
					}
				}
				lineScan.close();

			}

			fileScan.close();
		} catch (FileNotFoundException e) {

			System.out.println("File \"" + fileName + "\" could not be opened.");
			System.out.println(e.getMessage());
			System.exit(ERROR_CODE);
		}
	}
}
