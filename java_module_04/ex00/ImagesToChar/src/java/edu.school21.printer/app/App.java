package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;

class App
{
	private static char white;
	private static char black;
	private static String imgPath;
	private static int y;
	private static int x;

	public static void main( String[] args ) throws IOException
	{
		parseInput( args );

		int[][] vector = Logic.plotBMPImage( white, black, imgPath );

		y = -1;
		while ( ++y < vector.length )
		{
			x = -1;
			while ( ++x < vector[y].length )
				System.out.printf( "%c", vector[x][y] );
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