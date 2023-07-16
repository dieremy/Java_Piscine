import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class Program
{
    private static int arraySize;
    private static int threadsCount;
    private static int chunkLen;
    private static int lastChunkLen;
	private static int sum;

    public static void main( String[] args )
	{
		try
		{
			if ( !checkArguments( args ) )
				System.exit( -1 );

			int[] vector = startArray();

			divideInChunks();

			executeTasks( vector );
		}
		catch ( Exception e )
		{
			System.out.println( "Invalid input. Enter a valid number." );
			System.out.println( e.getMessage() );
		}
	}

	public static void	executeTasks( int[] vector )
	{
		try
		{
			ExecutorService pool = Executors.newFixedThreadPool( threadsCount );
			int startIndex = 0;
			Task t;
			int count = 0;
			sum = 0;

			for ( int i = 0; i < threadsCount - 1; i++ )
			{
				sum = count;
				int endIndex = startIndex + chunkLen;
				t = new Task( vector, startIndex, endIndex, sum );
				pool.execute( t );
				count = t.getSum();
				// System.out.println( "Sum test: " + i + " " + count );
				startIndex = endIndex;
			}

			// int endIndex = startIndex + chunkLen + lastChunkLen;
			int endIndex = arraySize;
			t = new Task( vector, startIndex, endIndex, sum );
			pool.execute( t );

			// method that shutdowns the threadpool
			pool.shutdown();
			// method waits util all tasks in the thread pool
			// have completed execution or until specifieed timeout
			pool.awaitTermination( Long.MAX_VALUE, TimeUnit.NANOSECONDS );
			System.out.println( "Sum by threads: " + t.getSum() );
		}
		catch ( InterruptedException e )
		{
			System.out.println( "Interrupted exception in method." );
			System.out.println( e.getMessage() );
		}
	}

	public static void	divideInChunks()
	{
		chunkLen = arraySize / threadsCount;

		if ( ( arraySize % threadsCount ) != 0 )
			lastChunkLen = ( arraySize - ( chunkLen * threadsCount ) ) + chunkLen;
		else
			lastChunkLen = 0;
	}

	public static int[] startArray()
	{
		Random	r = new Random();
		int[]	vector = new int[arraySize];

		for ( int i = 0; i < vector.length; i++ )
		{
			vector[i] = r.nextInt(50);
			sum += vector[i];
		}

		System.out.println( "Sum: " + sum );
		return ( vector );
	}

	public static boolean checkArguments( String[] args )
	{
		if ( args.length != 2 || !args[0].startsWith( "--arraySize=" ) || !args[1].startsWith( "--threadsCount=" ) )
		{
			System.err.println( "Please test using '--arraySize=[number] --threadsCount=[number]'" );
			return ( false );
		}
		try
		{
			arraySize = Integer.parseInt( args[0].substring( 12 ) );
			threadsCount = Integer.parseInt( args[1].substring( 15 ) );
            if ( arraySize > 2_000_000 || arraySize < 1 || threadsCount < 1 || threadsCount > arraySize )
            {
                System.err.println( "Illegal argument for arraySize or threadsCount" );
                return ( false );
            }
		}
		catch ( NumberFormatException e )
		{
			System.out.println( "Invalid input. Enter a valid number." );
			System.out.println( e.getMessage() );
            return ( false );
		}
        return ( true );
    }
}