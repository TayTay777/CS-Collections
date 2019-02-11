
import java.util.Scanner;

/**
 * Illustrates how to grow an array on the fly. Show the time taken when we grow
 * the array by 1 each time.
 *
 * time java GrowingArray < wordlist.txt 1
 *
 * Then see the improvement if we double the capacity each time we grow the array. The
 * command line argument of 0 doubles the size each time.
 *
 * time java GrowingArray < wordlist.txt 0
 * 
 * @author amit
 */

public class GrowingArray
{
	private String[] words;

	// words[0...capacity-1]
	private int capacity;

	// size points to next free slot in words
	private int size;

	private int increment;

	/**
	 * Construct a Growing Array with an initial capacity.
	 * 
	 * @param initialCapacity
	 *            The initial capacity of the array.
	 * @param increment 
	 */
	public GrowingArray(int initialCapacity, int increment)
	{
		words = new String[initialCapacity];
		capacity = initialCapacity;
		size = 0;
		this.increment = increment;
	}

	/**
	 * Increase capacity of internal array.
	 */
	private void growArray()
	{
		int extra = increment; 
		if (increment == 0) 
			extra = capacity;
		String[] temp = new String[capacity + extra];
		for (int i = 0; i < capacity; i++)
			temp[i] = words[i];

		capacity = capacity + extra;
		words = temp;
		System.out.println("Increased capacity to " + capacity);
	}

	/**
	 * Read in words (one per line) and store in array words, growing it as needed.
	 * 
	 * @throws IOException
	 */
	public void readData()
	{
		Scanner input = new Scanner(System.in);

		while (input.hasNext()) {
			String line = input.nextLine();
				if (size == capacity)
					growArray();
				words[size] = line;
				size++;
		}
		input.close();
	}

	/**
	 * Print words array on console.
	 */
	public void printData()
	{
		for (int i = 0; i < size; i++) {
			System.out.println(words[i]);
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args)
	{
		int increment = Integer.parseInt(args[0]);
		GrowingArray example = new GrowingArray(1, increment);
		example.readData();
		/* example.printData(); */
	}

}
