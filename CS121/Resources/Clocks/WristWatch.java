/*
 * @author TaylorPaulRoberts
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class WristWatch extends Clock{

	/**
	 * clocktype and drag are set here
	 */
	public WristWatch() {
		super(ClockType.digital, 0.000034722);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Clock#display()
	 */
	@Override
	public void display() 
	{
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.CEILING);
		System.out.println(String.format("%-36s", getClockType() + " WristWatch clock") + String.format("%-26s", " time: [ " 
	+ time.formattedReportedTime() + " ], ") + "total drift = " + df.format(time.getTotalDrift()) );
	}

}
