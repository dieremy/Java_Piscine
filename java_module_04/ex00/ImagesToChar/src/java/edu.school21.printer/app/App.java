package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;

class App
{
	private static String imgPath;
	private static char white;
	private static char black;

	public static void main( String[] args ) throws IOException
	{
		parseInput( args );

		Logic logic = new Logic( white, black, imgPath );
	}

	public static void parseInput( String[] args )
	{
		if ( args.length != 3 || args[0].length() != 1 || args[1].length() != 1 )
		{
			System.out.println( "Wrong number of arguments." );
			System.exit( -1 );
		}

		white = args[0].charAt( 0 );
		black = args[1].charAt( 0 );
		imgPath = args[2];
	}
}