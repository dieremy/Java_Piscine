import java.util.Scanner;

public class Program
{
	static int isPrimeIter( int nb )
	{
		int	i;
		int	count = 0;

		i = 2;
		if ( nb < 2 )
			return (0);
		while ( i <= ( nb / 2 ) )
		{
			count++;
			if ( (nb % i) == 0 )
				break ;
			i++;
		}
		return ( count );
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
		int	checkIter = isPrimeIter( number );
		boolean	checkBool = isPrimeBool( number );
		System.out.println( checkBool + " " + checkIter );
    }
}