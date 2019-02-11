import java.util.Random;

/**
 * Die.java       Java Foundations
 *
 * Represents one die (singular of dice) with faces showing values
 * between 1 and 6.
 * @author Taylor
 * for editing
 */

public class Die
{
	private int seed;
	private int faceValue;  // current value showing on the die
	private int numberOfSides = 6;
	private Random rand;
	//private Random rand = new Random();

	/**
	 * Constructor: Sets the initial face value of this die.
	 */
	public Die()
	{
		faceValue = 1;
	}

	/**
	 * Constructor: Sets the initial face value of this die.
	 */
	public Die(int numberOfSides)
	{
		faceValue = 1;
		this.numberOfSides = numberOfSides;
		rand = new Random();
	}

	public Die(int numberOfSides, int seed)
	{
		faceValue = 1;
		this.numberOfSides = numberOfSides;
		this.seed = seed;
		rand = new Random(seed);
	}

	/**
	 * Computes a new face value for this die and returns the result.
	 * @return The new face value.
	 */
	public int roll()
	{
		//int faceValue = 5; //shows that this hides the instance variable!

		//faceValue = (int)(Math.random() * numberOfSides) + 1;

		faceValue = (rand.nextInt(numberOfSides)) + 1;

		return faceValue;
	}

	/**
	 * Face value mutator. The face value is not modified if the
	 * specified value is not valid.
	 * 
	 * @param value The new face value. Must be between 1 and max face 
	 * value.
	 */
	public void setFaceValue (int value)
	{
		if (value > 0 && value <= numberOfSides)
			faceValue = value;
	}

	/**
	 * Face value accessor.
	 * @return The current face value.
	 */
	public int getFaceValue()
	{
		return faceValue;
	}

	/**
	 * Returns a string representation of this die.
	 */
	public String toString()
	{
		String result = "Die [faceValue = " + faceValue + "]";

		return result;
	}
}
