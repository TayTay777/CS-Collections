import java.text.DecimalFormat;

/* Custom class for the inputs of a box. 
 * @author TaylorPaulRoberts
 */


/**
 * @author troberts
 *
 */
/**
 * @author troberts
 *
 */
/**
 * @author troberts
 *
 */
/**
 * @author troberts
 *
 */
public class Box {


	private double width;
	private double height;
	private double depth;
	private boolean full;

	public Box(double width, double height, double depth)
	{
		this.width = width;
		this.height = height;
		this.depth = depth;
		full = false;
	}

	/**
	 * declares True or False for box being full
	 * @param full
	 */
	public void setFull(boolean full)
	{
		this.full = full;
	}
	
	/**
	 * @return box width
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * @return box height
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * @return the box's depth
	 */
	public double getDepth()
	{
		return depth;
	}

	/**
	 * Change the width of the box.
	 * @param width The width of the box
	 */
	public void setWidth(double width)
	{
		this.width = width;
	}

	/**
	 * changes the height of the box.
	 * @param height
	 */
	public void setHeight(double height)
	{
		this.height = height;
	}

	/**
	 * changes the depth of the box
	 * @param depth
	 */
	public void setDepth(double depth)
	{
		this.depth = depth;
	}

	/**
	 * @return the box's volume
	 */
	public double getVolume()
	{
		return width * height * depth;

	}

	/**
	 * @return the surface area.
	 */
	public double getSurfaceArea()
	{
		return (width * height) * 2 + (depth * height) *2 + (depth * width) * 2;
	}

	DecimalFormat fmt = new DecimalFormat("0.00");

	public String toString()
	{
		return "Box: Width: " + fmt.format(width) + " Height: " + fmt.format(height) 
		+ " Depth: " + fmt.format(depth) + " Volume: " + fmt.format(getVolume()) 
		+ " Surface Area: " + fmt.format(getSurfaceArea()) + " Box full? " + full;
	}

}
