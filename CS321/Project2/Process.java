
/*
 * @author Taylor
 * 
 * 
 */

public class Process<T> implements Comparable<T> {

	public int priority;
	private int timeToFinish;
	private int prevTimeToFinish;
	public int arrivalTime;
	public int timeNotProcessed;


	public Process(int priority, int timeToFinish, int arrivalTime)
	{
		this.priority = priority;
		this.timeToFinish = timeToFinish;
		this.arrivalTime = arrivalTime;
		timeNotProcessed = 0;
	}

	@Override
	public int compareTo(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean finish()
	{
		if (timeToFinish == 0)
		{
			return true;
		}
		else return false;
	}

	public void reduceTimeRemaining() {
		timeToFinish = timeToFinish - 1;
	}
	
	public int getTimeRemaining()
	{
		return timeToFinish;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getTimeNotProcessed()
	{
		return timeNotProcessed;
	}

	public void resetTimeNotProcessed() 
	{
		timeNotProcessed = 0;
	}
	
	public void incrementTimeNotProcessed()
	{
		timeNotProcessed++;
	}

	public int getPriority() 
	{
		return priority;
	}
	
	public void incrementPriority()
	{
		priority = priority + 1;
	}

}
