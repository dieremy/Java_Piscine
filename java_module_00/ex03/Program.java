import java.util.Scanner;

public class Program
{
	static long elevate( long n, int i )
	{
		long	dex = 1;
		int		x = 0;

		while ( ++x < i )
			dex *= 10;
		n *= dex;
		return ( n );
	}

	static long findMin()
	{
		Scanner myObj = new Scanner( System.in );  // Create a Scanner object
		long min = myObj.nextInt();
		long temp = 0;
		int x = 0;

		while ( ++x < 5 )
		{
			temp = myObj.nextInt();
			if ( temp < min )
				min = temp;
		}
		return ( min );
	}

	static void printChart( long res )
	{
		int j = 1;
		while ( res > 0 )
		{
			System.out.print( "Week " + j + " ");
			for ( long l = res % 10; l > 0; l-- )
				System.out.print( "=" );
			System.out.println( ">" );
			res /= 10;
			j++;
		}
	}

	public static void main(String[] args)
	{
		Scanner myObj = new Scanner( System.in );  // Create a Scanner object
		String	week = myObj.nextLine();
		long	min = 0;
		long	res = 0;

		while ( !week.equals("42") )
		{
			int		i = 0;
			while ( ++i <= 18 )
			{
				if ( week.equals( "Week" + " " + i ) )
				{
					min = findMin();
					res += elevate( min, i );
				}
			}
			week = myObj.nextLine();
		}
		printChart( res );
	}
}
