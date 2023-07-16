class Task implements Runnable
{
	private int[] vector;
	private int startIndex;
	private int endIndex;
	private int threadSum;
	private int sum;

	public Task( int[] vector, int startIndex, int endIndex, int sum )
	{
		this.vector = vector;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.sum = sum;
	}

	public int getSum()
	{
		return ( sum );
	}

	@Override
	public synchronized void run()
	{
		threadSum = 0;
		// System.out.println( "\t\tafter += " + sum + "\tFIRSTgetsum " + getSum() );
		for ( int i = startIndex; i < endIndex; i++ )
			threadSum += vector[i];

		System.out.println( "Thread " + Thread.currentThread().getId() + ": from "
			+ startIndex + " to " + ( endIndex - 1 ) + " sum is " + threadSum);// + "\tcazzo di SUM prima del +=:  " + sum );

		sum += threadSum;
		// System.out.println( "\t\tafter += " + sum + "\tgetsum " + getSum() );
		// synchronized ( Program.class )
		// {
		// } // synchronized (Program.class) block ensures that only 
	} // one thread can update the shared sum variabl at a time.
} // prevents data races and correctness of sum.