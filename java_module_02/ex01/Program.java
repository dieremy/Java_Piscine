import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program
{
	private static final String DICTIONARY_FILE = "dictionary.txt";
	private static final ArrayList<String> dictionary = new ArrayList<String>();
	private static BufferedReader readerA;
	private static BufferedReader readerB;

	public static void main( String[] args )
	{
		try
		{
			if ( !writeToFile( args ) )
				System.exit( -1 );

            double[] arrayA = new double[dictionary.size()];
            double[] arrayB = new double[dictionary.size()];

            readerA = new BufferedReader( new FileReader( args[0] ) );
            readerB = new BufferedReader( new FileReader( args[1] ) );

            arrayA = fillArray( readerA, arrayA );
            arrayB = fillArray( readerB, arrayB );

            double result = floorSimilarity( arrayA, arrayB );

            System.out.println( "Similarity = " + result );

        }
		catch ( IOException e )
		{
            System.out.println( e.getMessage() );
        }
	}
	
	public static boolean	writeToFile( String[] args )
	{
		try
		{
			if ( checkWrongArgs( args ) )
				return( false );

			readerA = new BufferedReader( new FileReader( args[0] ) );
			readerB = new BufferedReader( new FileReader( args[1] ) );
			fillDictionary( readerA );
			fillDictionary( readerB );

			BufferedWriter writer = new BufferedWriter( new FileWriter( DICTIONARY_FILE ) );	
			for ( String word : dictionary )
			{
				writer.write( word );
				writer.newLine();
			}
			writer.close();
		}
		catch ( IOException e )
		{
            System.out.println( e.getMessage() );
        }
		return ( true );
	}

	public static boolean checkWrongArgs( String[] args )
	{
		if ( args.length != 2 )
		{
			System.err.println( "Run java Program <nameFile1> <namefile2>." );
			return ( true );
		}
		return ( false );
	}

	public static void fillDictionary( BufferedReader reader ) throws IOException
	{
        String line;

        while ( ( line = reader.readLine() ) != null )
		{
            String[] words = line.replaceAll( "\\p{Punct}", "" ).toLowerCase().split( "\\s+" );
            for ( String word : words )
                if ( !dictionary.contains( word ) && !word.isEmpty() )
                    dictionary.add( word );
        }
        reader.close();
    }

	public static double[] fillArray( BufferedReader reader, double[] array ) throws IOException
	{
        String line;
        int index;

        while ( ( line = reader.readLine() ) != null )
		{
            String[] words = line.replaceAll( "\\p{Punct}", "" ).toLowerCase().split( "\\s+" );
            for ( int i = 0; i < words.length; i++ )
			{
				String word = words[i];
                if ( !word.isEmpty() )
				{
                    index = dictionary.indexOf( word );
                    array[index]++;
                }
            }
        }
        reader.close();
		return ( array );
    }


	public static double floorSimilarity( double[] arrayA, double[] arrayB )
	{
		double num = 0.0;
		double normA = 0.0;
		double normB = 0.0;

		for ( int i = 0; i < arrayA.length; i++ )
		{
			num += arrayA[i] * arrayB[i];
			normA += Math.pow( arrayA[i], 2 );
			normB += Math.pow( arrayB[i], 2 );
		}
		double similarity = num / ( Math.sqrt( normA ) * Math.sqrt( normB ) );
		return ( Math.floor( similarity * 100.0 ) / 100.0 );
	}
}