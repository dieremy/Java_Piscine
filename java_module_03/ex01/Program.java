import java.io.*;
import java.util.*;

public class Program
{
	public static void main( String[] args )
	{
		Thread threadEgg;
		Thread threadHen;

		int count = checkArgs( args );
		if ( count < 1 )
			System.exit( -1 );

		try
		{
			Object obj = new Object();
			threadEgg = new Thread( new Egg( count, obj ) );
			threadHen = new Thread( new Hen( count, obj ) );

			threadHen.start();
			threadEgg.start();
			threadEgg.join();
			threadHen.join();
		}
		catch ( InterruptedException e )
		{
			System.out.println( "Thread interruption." );
			System.out.println( e.getMessage() );
		}
	}

	public static int checkArgs( String[] args )
	{
		if ( args.length != 1 || !args[0].startsWith( "--count=" ) )
		{
			System.err.println( "Please test using '--count='" );
			return ( -1 );
		}
		try
		{
			int count = Integer.parseInt( args[0].substring( 8 ) );
			if ( count < 1 )
				System.err.println( "Please test using '--count=[number >= 1]'" );
			return ( count );
		}
		catch ( NumberFormatException e )
		{
			System.out.println( "Invalid input. Enter a valid number." );
			System.out.println( e.getMessage() );
		}
		return ( -1 );
	}
}
