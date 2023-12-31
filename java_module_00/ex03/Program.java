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

	static void	checkTest( long n )
	{
		if ( n < 1 || n > 9 )
		{
			System.err.println( "IllegalArgument" );
			System.exit( -1 );
		}
	}

	static long findMin( Scanner scan )
	{
		long	min = scan.nextLong();
		checkTest( min );
		long	temp = 0;
		int		x = 0;

		while ( ++x < 5 )
		{
			temp = scan.nextLong();
			checkTest( temp );
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

	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );
		String	week = scan.next();
		long	min = 0;
		long	res = 0;
		int		w = 1;
		
		while ( !week.equals( "42" ) && w <= 18)
		{
            int inputWeek = scan.nextInt();
            if ( !week.equals( "Week" ) || inputWeek != w )
			{
                System.err.println( "IllegalArgument" );
                System.exit(-1);
            }
            min = findMin( scan );
			res += elevate( min, w );
            scan.nextLine();
            week = scan.next();
            w++;
        }
		printChart( res );
	}
}
