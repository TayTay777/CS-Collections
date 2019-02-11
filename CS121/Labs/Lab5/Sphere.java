/**
 * Represents a sphere.
 * @author mvail
 */
public class Sphere {
	private double radius;
	
	/**
	 * Constructor
	 * @param radius the sphere's radius
	 */
	public Sphere(double radius) {
		this.radius = radius;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * @return the surface area
	 */
	public double getSurfaceArea() {
		return 4.0*Math.PI*Math.pow(radius, 2);
	}
	
	/**
	 * @return the volume
	 */
	public double getVolume() {
		return 4.0/3.0*Math.PI*Math.pow(radius, 3);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("radius: %.2f\nsurface area: %.2f\nvolume: %.2f\n",
				radius, getSurfaceArea(), getVolume());
	}
}
