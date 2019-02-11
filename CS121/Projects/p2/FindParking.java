import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

/* This program is used to find the 4 nearest parking spots from a random location.
 * It gives you the cost of your parking duration input 
 * and the distance to the parking spot
 * Parking Spot 1-2 are $.25 per 10 minute intervals
 * Parking Spot 3-4 are $.30 per 10 minute intervals
 *
 * @author TaylorPaulRoberts 
 */

public class FindParking {

	public static void main(String[] args){

		/*Formula of code that generates the same random x and y coordinates 
		 * with correspondence to the same random seed.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Random Seed:  ");
		long randomseed = scan.nextLong();
		Random rand = new Random(randomseed);
		System.out.print("Enter Parking time (minutes): ");
		NumberFormat moneyfmt = NumberFormat.getCurrencyInstance();

		/*Formula of code that rounds parking time up to the full interval
		 * charge by moving decimal place and rounding up. 
		 */
		double duration = scan.nextLong();
		duration = Math.ceil(duration * .1);

		System.out.println();

		/*Establishes random x and y coordinates for the parking spot distaces 
		 * and the car position spots. 
		 */
		int p1x = rand.nextInt(100);
		int p1y = rand.nextInt(100);
		int p2x = rand.nextInt(100);
		int p2y = rand.nextInt(100);
		int p3x = rand.nextInt(100);
		int p3y = rand.nextInt(100);
		int p4x = rand.nextInt(100);
		int p4y = rand.nextInt(100);
		int carposx = rand.nextInt(100);
		int carposy = rand.nextInt(100);

		/*Calculates parking spot distances from car 
		 * by using Manhattan geometry
		 */
		int Vdisx1 = Math.abs(carposx - p1x);
		int Vdisy1 = Math.abs(carposy - p1y);
		int p1dis = Vdisx1 + Vdisy1;

		int Vdisx2 = Math.abs(carposx - p2x);
		int Vdisy2 = Math.abs(carposy - p2y);
		int p2dis = Vdisx2 + Vdisy2;

		int Vdisx3 = Math.abs(carposx - p3x);
		int Vdisy3 = Math.abs(carposy - p3y);
		int p3dis = Vdisx3 + Vdisy3;

		int Vdisx4 = Math.abs(carposx - p4x);
		int Vdisy4 = Math.abs(carposy - p4y);
		int p4dis = Vdisx4 + Vdisy4;

		/*calculates the minimum or smallest distance from 
		 * car spawn point.
		 */
		int set1 = Math.min(p1dis, p2dis);
		int set2 = Math.min(p3dis, p4dis);
		int closest = Math.min(set1, set2);

		/*Creates toString variables for the 4 individual parking spots
		 * with random x and y coordinates inputted.
		 */
		ParkingSpot p1 = new ParkingSpot("David St.",p1x,p1y);
		double cost1 = duration * p1.getCharge(); 
		ParkingSpot p2 = new ParkingSpot("Catalina St.",p2x,p2y);
		double cost2 = duration * p2.getCharge(); 
		ParkingSpot p3 = new ParkingSpot("RedZone St.",p3x, p3y);
		//Used to change DEFAULT_CHARGE from .25 to .30 for p3
		p3.setCharge(.30);
		double cost3 = duration * p3.getCharge();
		ParkingSpot p4 = new ParkingSpot("Whiteout St.", p4x, p4y);
		//Used to change DEFAULT_CHARGE from .25 to .30 for p4
		p4.setCharge(.30);
		double cost4 = duration * p4.getCharge();

		/*Code that prints the variables created above in an orderly readable fashion
		 */
		System.out.print("Parking Spot 1: ");
		System.out.println(p1);
		System.out.println("	distance = " + p1dis + " cost = " + moneyfmt.format(cost1));

		System.out.print("Parking Spot 2: ");
		System.out.println(p2);
		System.out.println("	distance = " + p2dis + " cost = " + moneyfmt.format(cost2));

		System.out.print("Parking Spot 3: ");
		System.out.println(p3);
		System.out.println("	distance = " + p3dis + " cost = " + moneyfmt.format(cost3));

		System.out.print("Parking Spot 4: ");
		System.out.println(p4);
		System.out.println("	distance = " + p4dis + " cost = " + moneyfmt.format(cost4));

		System.out.println();
		System.out.println("Position of vehicle: x = " + carposx + " y = " + carposy);
		System.out.println("Distance to closest spot: " + closest);

		/* if statement that ties "closest" variable (distance to closest spot)
		 * with p1, p2, p3, or p4, then prints the parking spot.
		 */
		if (closest == p1dis)
			System.out.println("Closest spot: " + p1);
		else if (closest == p2dis)
			System.out.println("Closest spot: " + p2);
		else if (closest == p3dis)
			System.out.println("Closest spot: " + p3);
		else if (closest == p4dis)
			System.out.println("Closest spot: " + p4);
		
		scan.close();


	}
} 
