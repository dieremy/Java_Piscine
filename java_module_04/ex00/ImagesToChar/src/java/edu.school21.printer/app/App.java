package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

class App
{
	private static char white;
	private static char black;
	private static String imgPath;

	public static void main( String[] args )
	{
		parseInput( args );

		int[][] vector = Logic.plotBMPImage( white, black, imgPath );

		for ( int i = 0; i < vector.length; i++ )
		{
			for ( int j = 0; j < vector[i].length; j++ )
				System.out.printf( "%c", vector[i][j] );
			System.out.printf( "\n" );
		}
	}

	public static void parseInput( String[] args )
	{
		if ( args.length != 3 )
		{
			System.out.println( "Wrong number of arguments." );
			System.exit( -1 );
		}

		white = args[0].charAt( 0 );
		black = args[1].charAt( 0 );
		imgPath = args[2];
	}
}