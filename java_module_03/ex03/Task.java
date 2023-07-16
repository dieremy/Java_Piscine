class Task implements Runnable
{
	private Thread th = new Thread();
	private String fileUrl;
	private int threadNumber;

	public Task( int threadNumber, String fileUrl )
	{
		this.threadNumber = threadNumber;
		this.fileUrl = fileUrl;
		th.start();
	}

	@Override
	public synchronized void run()
	{
		System.out.println( "Thread-" + threadNumber + " start download " + fileUrl );
		System.out.println( "Thread-" + threadNumber + " finish download " + fileUrl );
	}
}

// synchronized ( Program.lock )
// {
	// Program.sum += threadSum;
// } // synchronized (Program.lock) block ensures that only 
//} // one thread can update the shared sum variabl at a time.
//} // prevents data races and correctness of sum.
// synchronized statements allow you to define a block of code
// that can only be executed by only one thread at a time.

// almost the same but you're obscuring an entire method