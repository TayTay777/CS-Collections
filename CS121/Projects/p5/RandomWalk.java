import java.awt.Point;
import java.util.Random;
import java.util.ArrayList;

/* This class is used for creating methods that set orientation for 
 * an object to randomly navigate itself to a specific end point. 
 * The path is randomly generated with a set value grid line that can be duplicated
 * predictably with the use of a seed number. 
 * 
 * @author TaylorPaulRoberts
 *
 */
/**
 * @author troberts
 *
 */
public class RandomWalk {
	/*private variables that cannot be changed by anything except by
	 * the methods.
	 */
	@SuppressWarnings("unused")
	private long seed;
	private int gridSize;
	private boolean done;
	private Random rand;
	private ArrayList<Point> path = new ArrayList<Point>();
	private Point step = new Point(0,0);


	/**Establishes what the gridSize is only. 
	 * Random number generator is created without seed.
	 * @param gridSize
	 */
	public RandomWalk(int gridSize)
	{
		this.gridSize = gridSize;
		rand = new Random();
	}

	/**Establishes what the variable gridSize is
	 * @param gridSize
	 * Establishes what the variable seed is 
	 * @param seed
	 */
	public RandomWalk(int gridSize, long seed)
	{
		//path.add(step);
		this.gridSize = gridSize;
		rand = new Random(seed);
		this.seed = seed;
	}

	/**Moves the new RandomWalk object on step, either south or east
	 * depending on the random seed. If seed is 0, the steps will be 
	 * differnt for every seed that is 0 compared to other seeds that
	 * are 0.
	 * -Stores the steps in the ArrayList variable
	 */
	public void step()
	{
		path.add(step);
		this.step = new Point (step.x, step.y);
		boolean xOry = rand.nextBoolean();
		if (xOry == true)
		{
			if (step.x < gridSize - 1)
			{
				step.x = step.x + 1;
			}
			else if (step.y < gridSize -1)
			{
				step.y = step.y + 1;
			}
			//this.step = new Point(step.x, step.y);
			//path.add(step);
		}
		else if (xOry == false)
		{
			if (step.y < gridSize - 1)
			{
				step.y = step.y + 1;
			}
			else if (step.x < gridSize - 1)
			{
				step.x = step.x + 1;
			}
			//this.step = new Point(step.x, step.y);
			//path.add(step);
		}

		if (step.x == gridSize - 1 && step.y == gridSize - 1)
		{
			done = true;
			path.add(step);
		}
	}

	/**This method creates all the steps needed for the object to reach the end
	 * of the grid map. 
	 */
	public void createWalk()
	{
		do	
		{
			//this.step = new Point (step.x, step.y);
			//path.add(step);
			step();
		}
		while (done == false);
	}

	/**returns true if the object has reached the end of the path
	 * otherwise it would show false. 
	 * @return
	 */
	public boolean isDone()
	{
		return done;
	}

	/**returns the object's entire set of steps that are stored
	 * in the ArrayList.
	 * @return
	 */
	public ArrayList<Point> getPath()
	{
		return path;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Returns the list of steps stored in the ArrayList in a nice, 
	 * easy to read format. 
	 */
	public String toString()
	{
		String r = "";
		for (Point ts: path)
		{
			r += "[" + ts.x + "," + ts.y + "] ";
		}
		return r;
	}


}
