
public class TrueFalse {

	private int arraySize;
	private boolean[] flags;


	public boolean[] flags()
	{
		boolean tf = false;

		boolean[] flags = new boolean[arraySize];

		for (int i = 0; i < flags.length; i++)
		{
			if (i % 2 == 0)
			{
				flags[i] = false;
			}
			else 
			{
				flags[i] = true;
			}
			String q = " ";
			for (int t = 0; t < flags.length; t++)
			{
				q = q + flags[t];
			}
		}
		return flags;
	}

	public boolean[] copyArray(boolean[] origional)
	{
		boolean[] flags2 = new boolean[origional.length];

		for (int y = 0; y < origional.length; y++)
		{
			flags2[y] = origional[y];
		}
		return flags2;
	}
}
