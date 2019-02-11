/*Clock.java file uses methods created from the Time class and creates 
 * an enumeration for ClockType. All of these methods will be handed down 
 * the the children classes from inheritance. 
 * @author TaylorPaulRoberts
 */

abstract class Clock implements TimePiece {
	

	protected Time time;
	private ClockType clockType;
	public enum ClockType {natural, mechanical, digital, quantum}
	
	
	/**
	 * @param clockType
	 * @param drift
	 */
	public Clock(ClockType clockType, double drift)
	{
	this.clockType = clockType;
	time = new Time(0, 0, 0, drift);
	}
	
	/**
	 * @return 
	 * returns the type of clock from the enumeration
	 */
	public ClockType getClockType()
	{
		return clockType;
	}

	/**
	 * @param clockType
	 */
	public void setClockType(ClockType clockType)
	{
		this.clockType = clockType;
	}
	
	/* (non-Javadoc)
	 * @see TimePiece#reset()
	 */
	@Override
	public void reset() 
	{
		time.resetToStartTime();
		
	}

	/* (non-Javadoc)
	 * @see TimePiece#tick()
	 */
	@Override
	public void tick() 
	{
		time.incrementTime();		
	}

	/* (non-Javadoc)
	 * @see TimePiece#display()
	 */
	@Override
	public abstract void display();
	

}
