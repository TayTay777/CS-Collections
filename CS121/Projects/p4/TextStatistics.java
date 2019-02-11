import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

/*Class that reads a text file, parses, and stores info about 
 * words and characters in the file
 * @author taylorpaulroberts
 */


public class TextStatistics implements TextStatisticsInterface{

	private double average;
	private int[] alphabet = new int[26];
	private int[] wordLengths = new int[24];
	private File file;
	private int alpha;
	private int numOfChar;
	private int numOfWords;
	private int numOfLines;

	public TextStatistics(File file)
	{
		this.file = file;
		try 
		{
			Scanner fileScan = new Scanner(file);
			numOfLines = 0;
			numOfWords = 0;
			numOfChar = 0;
			while (fileScan.hasNextLine()) 
			{
				String line = fileScan.nextLine();
				numOfLines++;
				numOfChar += line.length() + 1;
				StringTokenizer tokenizer = new StringTokenizer(line, " ,.;:'\"&!?-_\n\t12345678910[]{}()@#$%^*/+-");

				while (tokenizer.hasMoreTokens())
				{
					String word = tokenizer.nextToken();
					numOfWords++;
					String s = word.toLowerCase();
					wordLengths[word.length()]++;


					for(int i = 0; i < s.length(); i++)
					{	
						if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
						{
							alpha = s.charAt(i) - 'a';	
							alphabet[alpha]++;
						}
					}

				}
			}


		}
		catch (FileNotFoundException e)
		{
			System.err.println("Invalid file path: " + file);
			System.err.println();
		}
		double totalWords = 0;
		double lengthsAdded = 0;
		for (int i = 0; i < 24; i++)
		{
			lengthsAdded += i * wordLengths[i];
			totalWords += wordLengths[i];
		}
		average = lengthsAdded / totalWords;

	}

	/**
	 * @return the number of characters in the text file
	 */
	public int getCharCount() 
	{
		return numOfChar;
	}

	/**
	 * @return the number of words in the text file
	 */
	public int getWordCount() 
	{
		return numOfWords;
	}

	/**
	 * @return the number of lines in the text file
	 */
	public int getLineCount() 
	{
		return numOfLines;
	}

	/**
	 * @return the letterCount array with locations [0]..[25] for 'a' through 'z'
	 */
	public int[] getLetterCount() 
	{
		// TODO Auto-generated method stub
		return alphabet;
	}

	/**
	 * @return the wordLengthCount array with locations [0]..[23] with location [i] 
	 * storing the number of words of length i in the text file. Location [0] is not used.
	 * Location [23] holds the count of words of length 23 and higher.
	 */
	public int[] getWordLengthCount() 
	{
		// TODO Auto-generated method stub
		return wordLengths;
	}

	/**
	 * @return the average word length in the text file
	 */
	public double getAverageWordLength() 
	{
		// TODO Auto-generated method stub
		return average;
	}

	/*Prints out the different statistics for a TextStatistics object
	 * using the above methods, giving the user all the information on the 
	 * object in a nice orderly format. 
	 * @return */
	
	public String toString()
	{
		String letters = "==========================================================\n" 
		+ numOfLines + " lines \n" +
		numOfWords + " words \n" +
		numOfChar + " characters \n" +
		"------------------------------\n" +
		String.format("%-16s", "a = " + alphabet[0]) + "n = " + alphabet[13] + "\n" +
		String.format("%-16s", "b = " + alphabet[1]) + "o = " + alphabet[14] + "\n" +
		String.format("%-16s", "c = " + alphabet[2]) + "p = " + alphabet[15] + "\n" +
		String.format("%-16s", "d = " + alphabet[3]) + "q = " + alphabet[16] + "\n" +
		String.format("%-16s", "e = " + alphabet[4]) + "r = " + alphabet[17] + "\n" +
		String.format("%-16s", "f = " + alphabet[5]) + "s = " + alphabet[18] + "\n" +
		String.format("%-16s", "g = " + alphabet[6]) + "t = " + alphabet[19] + "\n" +
		String.format("%-16s", "h = " + alphabet[7]) + "u = " + alphabet[20] + "\n" +
		String.format("%-16s", "i = " + alphabet[8]) + "v = " + alphabet[21] + "\n" +
		String.format("%-16s", "j = " + alphabet[9]) + "w = " + alphabet[22] + "\n" +
		String.format("%-16s", "k = " + alphabet[10]) + "x = " + alphabet[23] + "\n" +
		String.format("%-16s", "l = " + alphabet[11]) + "y = " + alphabet[24] + "\n" +
		String.format("%-16s", "m = " + alphabet[12]) + "z = " + alphabet[25] + "\n" +
		"------------------------------\n";  
		//String.format("%6d", #) keeping for further inquiry 
		//String.format("%10d", #)
		
		
		String frequency = "length  frequency" + "\n"
		+ "------  ---------" + "\n";
		for (int i = 0; i < wordLengths.length; i++)
			if (wordLengths[i] != 0)
			{
				frequency += String.format("%6d", i) + 
						String.format("%10d", wordLengths[i]) + "\n";
			}
		
		DecimalFormat fmt = new DecimalFormat("0.00");
		
		String faverage = "\n" + "Average word length = " + fmt.format(average) + "\n" 
				+ "==========================================================" + "\n";
		
		String fin = letters + frequency + faverage;
		return fin;
		

	}

}
