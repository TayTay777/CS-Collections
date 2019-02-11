import java.util.ArrayList;

/**
 * CS 121 Lab: Conditionals and Loops 2
 * 
 * @author ?
 */
public class GoingLoopy {

	public static void main(String[] args) {

		/*
		 * Multiples of 7 between 0 and 100 using a while loop
		 *
		 * Use a while loop to evaluate every integer from 0 to 100 to see which
		 * are evenly divisible by 7. Print the discovered multiples of 7 as you
		 * go and, afterward, print the total number of multiples of 7.
		 */
		System.out.println("multiples of 7 between 0 and 100 (using while loop):");
		int count = 0; // Keeps track of the number of integers evenly divisible
						// by 7.
						// You need a separate loop variable.

		// TODO: Your code goes here

		int i = 0;
		while (i < 100) {
			System.out.print(i + " ");
			i += 7;
			count++;
		}

		System.out.println("total: " + count);
		System.out.println();

		/*
		 * Multiples of 7 between 0 and 100 using a for loop
		 *
		 * Use a for loop to accomplish exactly the same task as in the previous
		 * while loop.
		 */
		System.out.println("multiples of 7 between 0 and 100 (using for loop):");
		int count2 = 0; // Keeps track of the number of integers evenly
						// divisible by 7.
						// You need a separate loop variable.

		// TODO: Your code goes here
		for (int j = 0; j < 100; j += 7)
		{
			System.out.print(j + " ");
			count2++;
		}

		System.out.println("total: " + count2);
		System.out.println();

		/*
		 * Multiples of 7 between 0 and 100 using a do loop
		 *
		 * Use a do loop to accomplish exactly the same task as in the previous
		 * while and for loops.
		 */
		System.out.println("multiples of 7 between 0 and 100 (using do loop):");
		int count3 = 0; // Keeps track of the number of integers evenly
						// divisible by 7.
						// You need a separate loop variable.
		int k = 0;

		// TODO: Your code goes here
		do 
		{
			System.out.print(k + " ");
			k += 7;
			count3++;
		}
		while (k < 100);
		

		System.out.println("total: " + count3);
		System.out.println();

		/*
		 * Populate an ArrayList in a loop
		 *
		 * In a loop (your choice) create 5 Sphere objects, with radii 1, 2, ...
		 * 5.
		 *
		 * To create a sphere object, use the constructor, which accepts the
		 * radius of the sphere. For example,
		 *
		 * Sphere s = new Sphere(radius);
		 *
		 * Add them to ArrayList<Sphere> spheres, using its add() method.
		 * spheres.add( s ) adds Sphere s to the collection
		 *
		 */
		ArrayList<Sphere> spheres = new ArrayList<Sphere>();
		

		// TODO: Your code goes here

		/*
		 * Print contents of an ArrayList with a for-each loop
		 *
		 * Use a for-each loop to print the radius, surface area, and volume of
		 * each Sphere s from ArrayList<Sphere> spheres.
		 *
		 * NOTE: You don't need to calculate these. You may use the toString()
		 * method available in the Sphere class.
		 */
		System.out.println("radius, surface area, and volume of 5 spheres:");

		// TODO: Your code goes here
		for (int l = 1; l <= 5; l++){
			Sphere T = new Sphere(l);
			spheres.add(T); 
			spheres.get(3);
	}
		for (Sphere T: spheres)
		System.out.println(T.toString());

		/*
		 * Build a 2D table of values in a nested for loop
		 *
		 * Build a table using a nested for loop. The outer loop will iterate
		 * over 5 rows and the inner loop will iterate over 10 columns. Print
		 * each value in the table as the row number times the column number.
		 * Create variables or constants for the maximum row and column values
		 * rather than hard-coding numeric literals in your condition
		 * statements. Sample output: 
		 * 1 2 3 4 5 6 7 8 9 10 
		 * 2 4 6 8 10 12 14 16 18 20 
		 * 3 6 9 12 15 18 21 24 27 30 
		 * 4 8 12 16 20 24 28 32 36 40 
		 * 5 10 15 20 25 30 35 40 45 50
		 */

		// TODO: Your code goes here
		for (int row = 1; row <= 5; row++){
			for (int col = 1; col <= 10; col++){
				System.out.print(col * row + " ");
				
			}
			System.out.println();
		}
	}
}
