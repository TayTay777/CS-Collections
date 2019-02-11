/*Program designed to test several different classes, all children of the 
 * Clock class
 * @author TaylorPaulRoberts
 */


public class ClockSimulation {

	public static void main (String[] args){


		Bag<Clock> clockBag = new Bag<Clock>();


		clockBag.add(new Sundial());
		clockBag.add(new CuckooClock());
		clockBag.add(new GrandfatherClock());
		clockBag.add(new AtomicClock());
		clockBag.add(new WristWatch());

		System.out.println("Times before start:");
		clockBag.get(0).display();
		clockBag.get(1).display();
		clockBag.get(2).display();
		clockBag.get(3).display();
		clockBag.get(4).display();

		//accumulates time after one day
		for (int i = 0; i < 86400; i++)
		{
			clockBag.get(0).tick();
			clockBag.get(1).tick();
			clockBag.get(2).tick();
			clockBag.get(3).tick();
			clockBag.get(4).tick();
		}

		//one day display
		System.out.println("\n" + "\n" + "After one day:");
		clockBag.get(0).display();
		clockBag.get(1).display();
		clockBag.get(2).display();
		clockBag.get(3).display();
		clockBag.get(4).display();

		//resets the time back to start
		clockBag.get(0).reset();
		clockBag.get(1).reset();
		clockBag.get(2).reset();
		clockBag.get(3).reset();
		clockBag.get(4).reset();


		//accumulates time after one week
		for (int i = 0; i < 604800; i++)
		{
			clockBag.get(0).tick();
			clockBag.get(1).tick();
			clockBag.get(2).tick();
			clockBag.get(3).tick();
			clockBag.get(4).tick();
		}

		System.out.println("\n" + "\n" +"After one week:");
		clockBag.get(0).display();
		clockBag.get(1).display();
		clockBag.get(2).display();
		clockBag.get(3).display();
		clockBag.get(4).display();

		//resets the time back to start
		clockBag.get(0).reset();
		clockBag.get(1).reset();
		clockBag.get(2).reset();
		clockBag.get(3).reset();
		clockBag.get(4).reset();


		//accumulates time after one month
		for (int i = 0; i < 2592000; i++)
		{
			clockBag.get(0).tick();
			clockBag.get(1).tick();
			clockBag.get(2).tick();
			clockBag.get(3).tick();
			clockBag.get(4).tick();
		}

		System.out.println("\n" + "\n" +"After one month:");
		clockBag.get(0).display();
		clockBag.get(1).display();
		clockBag.get(2).display();
		clockBag.get(3).display();
		clockBag.get(4).display();

		//resets the time back to start
		clockBag.get(0).reset();
		clockBag.get(1).reset();
		clockBag.get(2).reset();
		clockBag.get(3).reset();
		clockBag.get(4).reset();

		//accumulates time after one year
		for (int i = 0; i < 31536000; i++)
		{
			clockBag.get(0).tick();
			clockBag.get(1).tick();
			clockBag.get(2).tick();
			clockBag.get(3).tick();
			clockBag.get(4).tick();
		}

		System.out.println("\n" + "\n" + "After one year:");
		clockBag.get(0).display();
		clockBag.get(1).display();
		clockBag.get(2).display();
		clockBag.get(3).display();
		clockBag.get(4).display();

		//resets the time back to start
		clockBag.get(0).reset();
		clockBag.get(1).reset();
		clockBag.get(2).reset();
		clockBag.get(3).reset();
		clockBag.get(4).reset();

	}

}
