import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.nio.file.*;
import java.io.*;

public class Program
{
	private static Path path;
	private static Files file;

	public static void main( String[] args )
	{
		if ( checkWrongArgs( args ) || checkPath( args[0] ) )
			System.exit( -1 );
		System.out.println( path );

		Scanner scan = new Scanner( System.in );
		while ( true )
			if ( !execute( scan ) )
				System.exit( 0 );
	}

	public static boolean checkWrongArgs( String[] args )
	{
		if ( args.length != 1 || !args[0].startsWith( "--current-folder=" ) )
		{
			System.err.println( "No absolute path encountered as program argument" );
			System.err.println( "Specify an absolute path using '--current-folder='" );
			return ( true );
		}
		return ( false );
	}

	public static boolean checkPath( String arg )
	{
		path = Paths.get( arg.substring( 17 ) );

		if ( !path.isAbsolute() || !file.isDirectory( path ) )
		{
			System.err.println( "Wrong current path." );
			return ( true );
		}
		return ( false );
	}

	public static boolean execute( Scanner scan )
	{
		String cmdLine = scan.nextLine();
		String[] cmdArgs = cmdLine.split( "\\s+" );

		if ( cmdArgs.length == 1 )
		{
			if ( cmdArgs[0].equals( "ls" ) )
				ls();
			else if ( cmdArgs[0].equals( "exit" ) )
			{
				scan.close();
				return ( false );
			}
		}
		else if ( cmdArgs.length == 2 && cmdArgs[0].equals( "cd" ) )
			cd( cmdArgs[1] );
		else if ( cmdArgs.length == 3 && cmdArgs[0].equals( "mv" ) )
			mv( cmdArgs[1], cmdArgs[2] );
		else
			System.out.println( cmdArgs[0] + ": bad usage" );
		return ( true );
	}

	public static void	ls()
	{
		long size;

		try
		{
			DirectoryStream<Path> files = Files.newDirectoryStream( path );
			for ( Path tmp : files )
			{
				if ( Files.isDirectory( tmp ) )
					size = dirSize( tmp );
				else
					size = Files.size( tmp );
				System.out.println( tmp.getFileName() + " " + ( size / 1000 ) + " KB" );
			}
		}
		catch( IOException e )
		{
			System.out.println( "Exception in method: ls" );
			System.out.println( e.getMessage() );
		}
	}	

	public static long dirSize( Path tmpPath )
	{
		long size = 0;

		try
		{
			DirectoryStream<Path> files = Files.newDirectoryStream( tmpPath );
			for ( Path tmp : files )
			{
				if ( Files.isDirectory( tmp ) )
					size += dirSize( tmp );
				else
					size += Files.size( tmp );
			}
		}
		catch ( IOException e )
		{
			System.out.println( e.getMessage() );
		}
		return ( size );
	}

	public static void	cd( String dest )
	{
		Path tmpPath = Paths.get( dest );
		tmpPath = path.resolve( tmpPath ).normalize();

		if ( Files.isDirectory( tmpPath ) )
			path = tmpPath;
		else
			System.err.println( "cd: no such directory: " + dest );
		System.out.println( path );
	}

	public static void	mv( String src, String dest )
	{
		try
		{
			Path source = Paths.get( src );
			Path target = Paths.get( dest );
			source = path.resolve( source );
			target = path.resolve( target );
			
			Path fileToMove = Files.createTempFile( Files.createTempDirectory( source.toString() ), src );
			// Files.exists( fileToMove );

			Path targetDir = Files.createTempDirectory( target.toString() );

			Path tmp = Files.move( fileToMove, targetDir.resolve( fileToMove.getFileName() ), StandardCopyOption.REPLACE_EXISTING );
			// File file = new File( src );
			// if ( file.renameTo( new File( dest ) ) )
			// 	file.delete();
			// else
			// 	System.out.println( "Failed to move the file" );


			// System.out.println( "source path: " + source );
			// System.out.println( "target path: " + target );

		}
		catch ( IOException e )
		{
				System.err.println( "Exception in method: mv" );
				System.err.println( e.getMessage() );
		}
	}
}
