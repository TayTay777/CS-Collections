import java.util.ArrayList;
import java.util.Random;

public class BoxTest {


	public static void main(String[] args){

		Box smallBox = new Box(4, 5, 2);

		System.out.println(smallBox.toString());

		smallBox.setDepth(36);
		smallBox.setHeight(36);
		smallBox.setWidth(36);

		System.out.println(smallBox.toString());

		smallBox.setFull(true);

		System.out.println(smallBox.toString());

		smallBox.setFull(false);

		System.out.println(smallBox.toString());

		ArrayList<Box> boxes = new ArrayList<Box>();

		Random rand = new Random();

		for (int i = 0; i < 5; i++)
		{
			Box b = new Box(rand.nextInt(90), rand.nextInt(90), rand.nextInt(90));
			b.setFull(rand.nextBoolean());
			boxes.add(b);
		}

		int i = 1;
		
		for (Box b: boxes)
		{
			System.out.println("Box " + i + " " + b);
			System.out.println();
			i++;
		}

		Box largestBox = new Box(0, 0, 0);

		for (Box b: boxes)
		{
			if (b.getSurfaceArea() > largestBox.getSurfaceArea())
			{
				largestBox = b;
			}
		}
		System.out.println("Largest Box: "+ largestBox); 
	}

}
