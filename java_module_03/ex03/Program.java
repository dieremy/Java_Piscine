import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

class Program
{
	private static int threadsCount;
	private static final String PATH_F_URLS = "file_urls.txt";

	public static void main( String[] args )
	{
		try
		{
			if ( !checkArguments( args ) )
				System.exit( -1 );
			// System.out.println( "threadsCount: " + threadsCount );

			List<String> fileUrls = readUrlsFromFile( PATH_F_URLS );
			if ( fileUrls.isEmpty() )
			{
				System.out.println( "No URLs found in file." );
				return ;
			}




		}
		catch( Exception e )
		{
			System.out.println( "Invalid input. Enter a valid number." );
			System.out.println( e.getMessage() );
		}
	}

	public static List<String> readUrlsFromFile( String path )
	{
		List<String> fileUrls = new ArrayList<>();

		try ( BufferedReader reader = new BufferedReader( new FileReader( path ) ) )
		{
			String line;
			while ( ( line = reader.readLine() ) != null )
				fileUrls.add( line );
		}
		catch( IOException e )
		{
			System.out.println( "Error reading file URLs from file." );
		}
		return ( fileUrls );
	}

	public static boolean checkArguments( String[] args )
	{
		if ( args.length != 1 || !args[0].startsWith( "--threadsCount=" ) )
		{
			System.err.println( "Please test using '--threadsCount=[number]'" );
			return ( false );
		}
		try
		{
			threadsCount = Integer.parseInt( args[0].substring( 15 ) );
			if ( threadsCount < 1 )
			{
				System.err.println( "Illegal argument for threadsCount" );
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