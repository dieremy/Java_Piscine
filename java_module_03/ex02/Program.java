import java.util.Random;

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
            // System.out.println( "arraySize: " + arraySize + "\tthreadsCount: " + threadsCount );
            
			// System.out.println();
			int[] vector = startArray();

			divideInChunks();
			// for ( int i = 0; i < vector.length; i++ )
			// 	System.out.println( "vector[i]: " + vector[i] );
            // System.out.println();
			
			System.out.println( "Sum: " + sum );
		}
		catch ( Exception e )
		{
			System.out.println( "Invalid input. Enter a valid number." );
			System.out.println( e.getMessage() );
		}
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
		return ( vector );
	}

	public static void	divideInChunks()
	{
		chunkLen = arraySize / threadsCount;

		if ( ( arraySize % threadsCount ) != 0 )
			lastChunkLen = arraySize - ( chunkLen * threadsCount );
		else
			lastChunkLen = 0;
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