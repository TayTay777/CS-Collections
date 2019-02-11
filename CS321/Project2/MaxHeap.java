
/*
 * @author Taylor
 * 
 * 
 */

public class MaxHeap {

	public int left;
	public int right;
	public int largest;
	public Process switchOne;
	public Process switchTwo;
	public Process[] queue;


	public MaxHeap(Process[] queue)
	{
		this.queue = queue;
	}

	public Process[] buildMaxHeap(Process[] queue)
	{
		int n = queue.length;

		for (int i = n/2; i >= 1; i--)
		{
			maxHeapify(queue, i , queue.length);
		}
		return queue;
	}
	
	public Process[] getMaxHeap()
	{
		return buildMaxHeap(queue);
	}

	//the key is the priority level
	//ordered based on priority level
	//Parent(i) = i/2
	//Left(i) = 2i
	//Right(i) = 2i + 1
	public Process[] maxHeapify(Process[] queue, int i, int size)
	{
		//subtract one from every array index b/c the array index starts @ zero
		left = 2*i;
		right = 2*i + 1;

		if ((left <= size) && (queue[left - 1].getPriority() > queue[i - 1].getPriority()))
		{
			largest = left;
		}
		//in case of a tie, the lowest arrival time is the largest
		else if ((left <= size) && (queue[left - 1].getPriority() == queue[i - 1].getPriority()))
		{
			if (queue[left - 1].getArrivalTime() < queue[i - 1].getArrivalTime())
			{
				largest = left;
			}
			else largest = i;
		}
		else largest = i;

		
		if ((right <= size) && (queue[right - 1].getPriority() > queue[largest - 1].getPriority())) 
		{
			largest = right;
		}
		//in case of a tie, the lowest arrival time is the largest
		else if ((right <= size) && (queue[right - 1].getPriority() == queue[largest - 1].getPriority()))
		{
			if (queue[right - 1].getArrivalTime() < queue[largest - 1].getArrivalTime())
			{
				largest = right;
			}
		}

		if (largest != i)
		{
			switchOne = queue[i - 1];
			switchTwo = queue[largest - 1];
			queue[i - 1] = switchTwo;
			queue[largest - 1] = switchOne;
			maxHeapify(queue, largest, size);
		}

		return queue;
	}

	public Process[] heapSort(Process[] queue)
	{
		buildMaxHeap(queue);
		for (int i = queue.length; i >= 2; i--)
		{
			switchOne = queue[0];
			switchTwo = queue[i - 1];
			queue[0] = switchTwo;
			queue[i-1] = switchOne;
			maxHeapify(queue, 1, i - 1);
		}
		
		return queue;
	}
	
	public Process[] getHeapSort() {
		return heapSort(queue);
	}
}
