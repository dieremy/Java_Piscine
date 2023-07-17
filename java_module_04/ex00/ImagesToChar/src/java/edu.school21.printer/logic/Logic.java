package edu.school21.printer.logic;

import java.io.FileInputStream;
import java.awt.image.BufferedImage;
import java.awt.*;

class Logic
{
	public static int[] plotBMPImage( char white, char black, String path )
	{
		BufferedImage image = ImageIO.read( new FileInputStream( path ) );

		int[][] matrix = new int[image.getWidth()][image.getHeight()];
		for ( int i = 0; i < image.getWidth(); i++ )
		{
			for ( int j = 0; j < image.getHeight(); j++ )
			{
				int color = image.getRGB( i, j );
				if ( color == Color.BLACK.getRGB() )
					matrix[i][j] = black;
				else if ( color == Color.WHITE.getRGB() )
					matrix[i][j] = white;
			}
		}
		return ( matrix );
	}
}