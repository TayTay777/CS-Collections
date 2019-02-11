import java.util.ArrayList;
import java.util.Random;

/**
 * Use an ArrayList to store a collection of objects and use a for-each loop to process the objects.
 * 
 * @author amit
 *
 */
public class ArrayListExample {

    public static void main(String[] args)
    {
        Random rand = new Random();
        final int RADIUS_MAX = 100;
        //TODO: declare a constant for the number of spheres NUM_SPHERES and 
		        //      initialize it appropriately
        final int NUM_SPHERES = 100 ;
        //TODO: Declare the ArrayList to hold the Sphere objects
        
        
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();
        
        //TODO: Create the spheres using a normal for loop and add them to an ArrayList<Sphere>
        
        for (int i = 0; i < NUM_SPHERES; i++)
        {
        	Sphere s1 = new Sphere(rand.nextInt(RADIUS_MAX));
        	spheres.add(s1);
        }
        double min = Double.MAX_VALUE;
        int n = 1;
        for (Sphere sph: spheres)	
        {
	        if (sph.getSurfaceArea() < min){
	        	min = sph.getSurfaceArea();
	        }
        	System.out.println("Sphere " + n + ":	"+ sph); 
        	System.out.println();
        	n++;
        }
        System.out.print("Volume of the smallest sphere: " + min);
        
        
        //TODO: Convert to a for-each loop to print out the spheres
        
        
        //TODO: Convert to a for-each loop to find the volume of the smallest sphere
       // double min1 = Math.min(s1.getVolume(), s2.getVolume());
        //double min2 = Math.min(s3.getVolume(), s4.getVolume());
        //double min = Math.min(min1, min2);

        //System.out.printf("Volume of the smallest sphere: %.2f\n", min);
    }
}
