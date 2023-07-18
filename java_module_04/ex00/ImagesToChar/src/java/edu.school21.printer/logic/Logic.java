package edu.school21.printer.logic;

import java.io.FileInputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;

public class Logic
{
	private static BufferedImage image;
	private static int width;
	private static int height;
	private static int color;
	private static int y;
	private static int x;

	public static int[][] plotBMPImage( char white, char black, String path ) throws IOException
	{
		image = ImageIO.read( new FileInputStream( path ) );
		
		width = image.getWidth();
		height = image.getHeight();

		int[][] matrix = new int[width][height];

		y = -1;
		while ( ++y < height )
		{
			x = -1;
			while ( ++x < width )
			{
				color = image.getRGB( x, y );
				if ( color == Color.BLACK.getRGB() )
					matrix[x][y] = black;
				else if ( color == Color.WHITE.getRGB() )
					matrix[x][y] = white;
			}
		}	
		return ( matrix );
	}
}