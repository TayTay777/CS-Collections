import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author TaylorPaulRoberts based on code by mvail
 */
public class CircuitTracer {
	private CircuitBoard board;
	private Storage<TraceState> stateStore;
	private ArrayList<TraceState> bestPaths;

	/** launch the program
	 * @param args three required arguments:
	 *  first arg: -s for stack or -q for queue
	 *  second arg: -c for console output or -g for GUI output
	 *  third arg: input file name 
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			//print usage message
			printUsage();
			System.exit(1);
		}
		try {
			new CircuitTracer(args); //create this with args
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private static void printUsage() {
		System.out.println();
		System.out.println("***INVALID INPUT***");
		System.out.println();
		System.out.println("Run using the format 'java CircutTracer [-s or -q] [-c or -g] filename'");
		System.out.println("");
		System.out.println("-s for stack storage \n-q for queue storage \n\n-c for console output \n-g for GUI output");
		System.out.println();
	}

	/** 
	 * Set up the CircuitBoard and all other components based on command
	 * line arguments.
	 * 
	 * Traces through a path provided by the input file. 
	 * Uses a brute force algorithum 
	 * 
	 * @param args command line arguments passed through from main()
	 * @throws FileNotFoundException 
	 */
	private CircuitTracer(String[] args) throws FileNotFoundException {
		//TODO: parse command line args

		String storageType = args[0];
		String outputType = args[1];
		String fileName = args[2];

		bestPaths = new ArrayList<TraceState>();



		if (storageType.equals("-q")){
			//The below code will also work
			//stateStore = new Storage<TraceState>(Storage.DataStructure.queue);
			stateStore =  Storage.getQueueInstance();
		}
		else if (storageType.equals("-s")){
			//stateStore = new Storage<TraceState>(Storage.DataStructure.stack);
			stateStore = Storage.getStackInstance();
		}
		else {
			printUsage();
			System.exit(1);
		}

		board = new CircuitBoard(fileName);
		int row = (int) board.getStartingPoint().getX();
		int col = (int) board.getStartingPoint().getY();

		//checking surrounding points clockwise, starting at the top

		if (board.isOpen(row -1, col)){
			TraceState traceState = new TraceState(board, row -1, col);
			stateStore.store(traceState);
		}
		if (board.isOpen(row, col +1)){
			TraceState traceState = new TraceState(board, row , col +1);
			stateStore.store(traceState);
		}
		if (board.isOpen(row +1, col)){
			TraceState traceState = new TraceState(board, row +1, col);
			stateStore.store(traceState);
		}
		if (board.isOpen(row, col -1)){
			TraceState traceState = new TraceState(board, row, col -1);
			stateStore.store(traceState);
		}

		
		//Here is the brute force algorithm. Code lines 114 -152
		//the while loop will end once the stateStore is empty. 
		//the .retrieve() method of the Storage class retrieves AND removes
		//like the next method you see in the scanner class. 
		
		
		while (!stateStore.isEmpty()){
			TraceState finishLineCheck = stateStore.retreive();
			if (finishLineCheck.isComplete()){
				if (bestPaths.isEmpty()){
					bestPaths.add(finishLineCheck);
				}
				else if (bestPaths.get(0).pathLength() > finishLineCheck.pathLength()){
					bestPaths.clear();
					bestPaths.add(finishLineCheck);
				}
				else if (bestPaths.get(0).pathLength() == finishLineCheck.pathLength()){
					bestPaths.add(finishLineCheck);
				}
			}
			else {
				row = finishLineCheck.getRow();
				col = finishLineCheck.getCol();

				//again, the starting point's adjacent moves are check clockwise
				//starting from the top, ending at the left
				
				if (finishLineCheck.isOpen(row -1, col)){
					TraceState traceState = new TraceState(finishLineCheck, row -1, col);
					stateStore.store(traceState);
				}
				if (finishLineCheck.isOpen(row, col +1)){
					TraceState traceState = new TraceState(finishLineCheck, row , col +1);
					stateStore.store(traceState);
				}
				if (finishLineCheck.isOpen(row +1, col)){
					TraceState traceState = new TraceState(finishLineCheck, row +1, col);
					stateStore.store(traceState);
				}
				if (finishLineCheck.isOpen(row, col -1)){
					TraceState traceState = new TraceState(finishLineCheck, row, col -1);
					stateStore.store(traceState);
				}
			}
		}
		if (outputType.equals("-c") || outputType.equals("-g")){
			
			System.out.println();
			
			if (outputType.equals("-c")){
				for (int i = 0; i < bestPaths.size(); i++){
					System.out.println(bestPaths.get(i).toString());

				}
			}
			else {
				System.out.println("The type '-g' for GUI is currently unsupported... ");
				System.out.println("Please, use '-c' for console instead");
			}
		}
		else {
			printUsage();
			System.exit(1);
		}

	}

} // class CircuitTracer
