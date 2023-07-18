package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;
import java.io.IOException;

class App
{
	private static char white;
	private static char black;

	public static void main( String[] args ) throws IOException
	{
		parseInput( args );

		Logic logic = new Logic( white, black, "/resources/image.bmp" );
	}

	public static void parseInput( String[] args )
	{
		if ( args.length != 2 || args[0].length() != 1 || args[1].length() != 1 )
		{
			System.out.println( "Wrong number of arguments." );
			System.exit( -1 );
		}

		white = args[0].charAt( 0 );
		black = args[1].charAt( 0 );
	}
}

// Exception in thread "main" java.io.FileNotFoundException: resources/image.bmp (No such file or directory)
// 	at java.base/java.io.FileInputStream.open0(Native Method)
// 	at java.base/java.io.FileInputStream.open(FileInputStream.java:216)
// 	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
// 	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:111)
// 	at edu.school21.printer.logic.Logic.<init>(Logic.java:22)
// 	at edu.school21.printer.app.App.main(App.java:15)
