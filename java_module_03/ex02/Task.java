package ex02;

class Task implements Runnable
{
	private int[] vector;
	private int startIndex;
	private int endIndex;
	private int threadSum;

	public Task( int[] vector, int startIndex, int endInedx )
	{
		this.vector = vector;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	@Override
	public void run()
	{
		for ( int i = startIndex; i < endIndex; i++ )
			threadSum += vector[i];

		System.out.println( "Thread " + Thread.currentThread().getId() + ": from "
			+ startIndex + " to " + ( endIndex - 1 ) + " sum is " + threadSum );

		synchronized ( Program.class )
		{
			sum += threadSum;
		} // synchronized (Program.class) block ensures that only 
	} // one thread can update the shared sum variabl at a time.
} // prevents data races and correctness of sum.