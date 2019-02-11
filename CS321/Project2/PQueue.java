/*
 * @author Taylor
 * 
 * 
 */


public class PQueue {

	public MaxHeap pQueueHeap;
	public Process[] maxPQueue = new Process[0];
	public Process[] bufferQueue = new Process[0];
	public Process dePQueue;
	public int size;



	//heap-sort method is ran to put highest priority @ the end of the array
	//array content is then buffered, then put into an array that is a size smaller
	//new array content is re-sorted into a max-heap
	//returns highest priority process
	public Process dePQueue()
	{
		size--;
		dePQueue = maxPQueue[0];
		pQueueHeap.getHeapSort();

		bufferQueue = new Process[size];
		for (int i = 0; i < bufferQueue.length; i++)
		{
			bufferQueue[i] = maxPQueue[i];
		}

		maxPQueue = new Process[size];
		for (int i = 0; i < maxPQueue.length; i++)
		{
			maxPQueue[i] = bufferQueue[i];
		}
		pQueueHeap = new MaxHeap(maxPQueue);
		pQueueHeap.getMaxHeap();


		return dePQueue;
	}

	//Array content is buffered and then put into an array that is one size larger
	//Enters process into end of new queue array
	//new array is then then re-sorted into a max-heap, just like dePQueue
	public void enPQueue(Process process)
	{
		size++;
		bufferQueue = new Process[size];
		for (int i = 0; i < maxPQueue.length; i++)
		{
			bufferQueue[i] = maxPQueue[i];
		}

		maxPQueue = new Process[size];
		for (int i = 0; i < maxPQueue.length; i++)
		{
			maxPQueue[i] = bufferQueue[i];
		}
		maxPQueue[size - 1] = process;

		pQueueHeap = new MaxHeap(maxPQueue);
		pQueueHeap.getMaxHeap();

	}


	//checks for empty queue
	public boolean isEmpty()
	{
		if (size == 0)
			return true;

		else return false;
	}

	//updates the entire queue
	public void update(int timeToIncrementPriority, int maxLevel)
	{
		for (int i = 0; i < maxPQueue.length; i++)
		{
			if (maxPQueue[i].getPriority() != maxLevel)
			{
				if (maxPQueue[i].timeNotProcessed != timeToIncrementPriority)
					maxPQueue[i].incrementTimeNotProcessed();

				if (maxPQueue[i].timeNotProcessed == timeToIncrementPriority)
				{
					maxPQueue[i].incrementPriority();
					maxPQueue[i].resetTimeNotProcessed();
				}
			}
			pQueueHeap.getMaxHeap();
		}
	}

}
