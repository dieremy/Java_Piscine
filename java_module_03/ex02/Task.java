class Task implements Runnable
{
	private int[] vector;
	private int startIndex;
	private int endIndex;
	private int threadSum;
	private int i;

	public Task( int[] vector, int startIndex, int endIndex, int index )
	{
		this.vector = vector;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.i = index;
	}

	@Override
	public synchronized void run()
	{
		for ( int i = startIndex; i < endIndex; i++ )
			threadSum += vector[i];

		System.out.println( "Thread " + this.i + ": from "
			+ startIndex + " to " + ( endIndex - 1 ) + " sum is " + threadSum );

		synchronized ( Program.lock )
		{
			Program.sum += threadSum;
		} // synchronized (Program.lock) block ensures that only 
	} // one thread can update the shared sum variabl at a time.
} // prevents data races and correctness of sum.
// synchronized statements allow you to define a block of code
// that can only be executed by only one thread at a time.

// almost the same but you're obscuring an entire method