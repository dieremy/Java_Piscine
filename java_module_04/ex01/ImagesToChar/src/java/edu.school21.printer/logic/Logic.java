package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;

public class Logic
{
	private static BufferedImage image;
	private static char white;
	private static char black;
	private static int height;
	private static int width;
	private static int color;
	private static int y;
	private static int x;

	public Logic( char white, char black, String path ) throws IOException
	{
		this.image = ImageIO.read( Logic.class.getClassLoader().getResourceAsStream( path ) );
		
		this.width = image.getWidth();
		this.height = image.getHeight();

		this.white = white;
		this.black = black;

		this.plotImage();
	}

	public void plotImage()
	{
		y = -1;
		while ( ++y < height )
		{
			x = -1;
			while ( ++x < width )
			{
				color = image.getRGB( x, y );
				if ( color == Color.BLACK.getRGB() )
					System.out.printf( "%c", black );
				else if ( color == Color.WHITE.getRGB() )
					System.out.printf( "%c", white );
			}
			System.out.println();
		}	
	}
}

// Logic.class refers to the class itself

// getClassLoader() returns the class loader
// associated with the Logic class.
// class loader loads classes during runtime

// getResourceAsStream() method of the class loader that retrieves
// a resource file as an argument and returns an InputStream object


// jar file is a package file format used to aggregate
// multiple Java class files, resource files
// and metadata into a single file 

// -cfm => Create; File; M --manifest : includes manifest info from
// manifest file

// manifest.txt specifies the output JAR file name and location
