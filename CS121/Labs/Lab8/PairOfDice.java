
public class PairOfDice {
	
	private Die die1;
	private Die die2;
	
	
	/**constructs the number of sides the die has
	 * @param numberOfSides
	 */
	public PairOfDice(int numberOfSides)
	{
		die1 = new Die(numberOfSides);
		die2 = new Die(numberOfSides);
	}

	
	/**constructs the number of sides the die has
	 * @param numberOfSides
	 * Establishes a random seed for the first dice
	 * @param seed1
	 * Establishes a random seed for the first dice
	 * @param seed2
	 */
	public PairOfDice(int numberOfSides, int seed1, int seed2)
	{
		die1 = new Die(numberOfSides, seed1);
		die2 = new Die(numberOfSides, seed2);
	}
	
	/**returns the total 
	 * @return
	 */
	public int roll()
	{
		int total = die1.roll() + die2.roll();
		return total;
	}
	
	/**Returns the value of the two dice added together
	 * @return
	 */
	public int getTotal()
	{
		return die1.getFaceValue() + die2.getFaceValue();
	}
	
	/**returns face value of the first dice
	 * @return
	 */
	public int getFaceValue1()
	{
		return die1.getFaceValue();
	}
	
	/**returns face value of the second dice
	 * @return
	 */
	public int getFaceValue2()
	{
		return die2.getFaceValue();
	}
}
