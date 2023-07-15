class Program
{
    private static int arraySize;
    private static int threadsCount;

    public static void main( String[] args )
	{
		try
		{
			if ( !checkArguments( args ) )
				System.exit( -1 );
            System.out.println( "arraySize: " + arraySize + "\tthreadsCount: " + threadsCount );
            // Egg egg = new Egg( count );
            // Hen hen = new Hen( count );

            // egg.start();
            // hen.start();
            // egg.join();
            // hen.join();

            // for ( int i = 0; i < count; i++ )
            // 	System.out.println( "Human" );
		}
		catch ( Exception e )
		{
			System.out.println( "Invalid input. Enter a valid number." );
			System.out.println( e.getMessage() );
		}
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
            if ( arraySize < 1 || threadsCount < 1 )
            {
                System.err.println( "Please test using numbers > 0" );
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