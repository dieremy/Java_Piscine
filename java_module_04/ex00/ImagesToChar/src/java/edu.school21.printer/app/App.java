package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

class App
{
	public static void main( String[] args )
	{
		checkArgs( args );

		char white = args[0].charAt( 0 );
		char black = args[1].charAt( 0 );
		String imgPath = args[2];

		int[][] vector = Logic.plotBMPImage( white, black, imgPath );

		for ( int i = 0; i < vector.length; i++ )
		{
			for ( int j = 0; j < vector[i].length; j++ )
				System.out.printf( "%c", vector[i][j] );
			System.out.printf( "\n" );
		}
	}

	public static void checkArgs( String[] args )
	{
		if ( args.length != 3 )
		{
			System.out.println( "Wrong number of arguments." );
			System.exit( -1 );
		}
	}
}