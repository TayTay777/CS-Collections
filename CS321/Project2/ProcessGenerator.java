import java.util.Random;

/*
 * @author Taylor
 * 
 * 
 */

public class ProcessGenerator {

	private double probability;
	public Process newProcess;
	private Random ranNumQ;
	private Random ranNumMaxPL;
	private Random ranNumMaxProT;

	public ProcessGenerator(double probability) 
	{
		this.probability = probability;
	}

	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		ranNumMaxPL = new Random();
		ranNumMaxProT = new Random();
		newProcess = new Process(ranNumMaxPL.nextInt(maxLevel) + 1, 
				ranNumMaxProT.nextInt(maxProcessTime) + 1, currentTime);

		return newProcess;
	}

	//method for creating a process based on probability
	public boolean query() 
	{
		ranNumQ = new Random();
		double lottery = ranNumQ.nextDouble();
		if (lottery <= probability)
		{
			return true;
		}
		else return false;
	}


}
