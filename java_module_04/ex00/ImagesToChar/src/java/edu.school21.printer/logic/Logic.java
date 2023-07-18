package edu.school21.printer.logic;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
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
		this.image = ImageIO.read( new FileInputStream( path ) );
		
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