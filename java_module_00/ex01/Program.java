import java.util.Scanner;

public class Program
{
	static int	ftSqrt( int n )
{
	int	out;
	// long	n;

	// n = nb;
	if (n <= 0)
		return (0);
	if (n == 1)
		return (1);
	out = 2;
	if ( n >= 2 )
	{
		while ( ( out * out ) <= n )
		{
			if ( ( out * out ) == n )
				break ;
				// return (out);
			out++;
		}
	}
	return (0);
}

	static int isPrimeIter( int nb )
	{
		int	i;

		i = 2;
		if ( nb < 2 )
			return (0);

		int r = ftSqrt( nb );
		System.out.println( r );

		while ( i <= ( nb / 2 ) )
		{
			if ( (nb % i) == 0 )
				break ;
			i++;
		}
		return (i);
	}

	static boolean isPrimeBool( int nb )
	{
		int	i;

		i = 2;
		if ( nb < 2 )
			return ( false );
		while ( i <= ( nb / 2 ) )
		{
			if ( (nb % i) == 0 )
				return ( false );
			i++;
		}
		return ( true );
	}

    public static void main(String[] args)
    {
		Scanner myObj = new Scanner( System.in );  // Create a Scanner object
		int number = myObj.nextInt();  // Read user input

		if ( number < 2 )
		{
			System.out.println( "IllegalArgument" );
			System.exit( -1 );
		}
		int	checkIter = isPrimeIter( number ) - 1;
		boolean	checkBool = isPrimeBool( number );
		if ( checkBool )
			System.out.println( checkBool + " " + checkIter );
		else
			System.out.println( checkBool + " " + checkIter );
    }
}