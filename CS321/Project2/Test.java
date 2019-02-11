
/*
 * @author Taylor
 * 
 * 
 */


public class Test {

	public static void main(String[] args) {


		Process X = new Process(55, 6, 7);
		Process Y = new Process(34, 23, 4);
		Process Z = new Process(92, 2, 2);
		Process A = new Process(2, 6, 7);
		Process B = new Process(99, 23, 4);
		Process C = new Process(58, 2, 2);
		Process E = new Process(22, 6, 7);
		Process F = new Process(79, 23, 4);
		Process G = new Process(3, 2, 2);


		Process[] testArray = new Process[8];
		testArray = new Process[9];


		testArray[0] = X;
		testArray[1] = Y;
		testArray[2] = Z;
		testArray[3] = A;
		testArray[4] = B;
		testArray[5] = C;
		testArray[6] = E;
		testArray[7] = F;
		testArray[8] = G;

		MaxHeap testHeap = new MaxHeap(testArray);

		System.out.println(testArray[0].getPriority() + ", " + testArray[1].getPriority() 
				+ ", " + testArray[2].getPriority() + ", " + testArray[3].getPriority() 
				+ ", " + testArray[4].getPriority() + ", " + testArray[5].getPriority() 
				+ ", " + testArray[6].getPriority()+ ", " + testArray[7].getPriority() 
				+ ", " + testArray[8].getPriority());

		testHeap.getMaxHeap();

		System.out.println(testArray[0].getPriority() + ", " + testArray[1].getPriority() 
				+ ", " + testArray[2].getPriority() + ", " + testArray[3].getPriority() 
				+ ", " + testArray[4].getPriority() + ", " + testArray[5].getPriority() 
				+ ", " + testArray[6].getPriority()+ ", " + testArray[7].getPriority() 
				+ ", " + testArray[8].getPriority());
		
		testHeap.getHeapSort();
		
		System.out.println(testArray[0].getPriority() + ", " + testArray[1].getPriority() 
				+ ", " + testArray[2].getPriority() + ", " + testArray[3].getPriority() 
				+ ", " + testArray[4].getPriority() + ", " + testArray[5].getPriority() 
				+ ", " + testArray[6].getPriority()+ ", " + testArray[7].getPriority() 
				+ ", " + testArray[8].getPriority());
		
		ProcessGenerator test = new ProcessGenerator(.4);
		Process testo = test.getNewProcess(0, 2000, 3000);
		
		System.out.println(testo.getArrivalTime() + ", " + testo.getTimeRemaining() + ", "+ testo.getPriority());
	}

}
