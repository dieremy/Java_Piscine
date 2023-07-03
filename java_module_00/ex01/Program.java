import java.util.Scanner;

// PRIME NUMBERS TILL 100
// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
// 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.

public class Program
{
	static int isPrime( int nb )
	{
		int	i;

		i = 2;
		if ( nb < 2 )
			return (0);
		while ( i <= ( nb / 2 ) )
		{
			if ( (nb % i) == 0 )
				return (0);
			else
				i++;
		}
		return ( i );
	}

    public static void main(String[] args)
    {
		Scanner myObj = new Scanner( System.in );  // Create a Scanner object
		// System.out.println("ENTER NUMBER PLZ ");

		int number = myObj.nextInt();  // Read user input
		if ( number < 2 )
		{
			System.out.println( "IllegalArgument" );
			System.exit( -1 );
		}
		int	check = isPrime( number );
		if ( check != 0 )
		{
			// System.out.println( number + " is a prime number" );
			System.out.println( "true " + check );
		}
		else
		{
			// System.out.println( number + " is NOT a prime number" );
			System.out.println( "false " + check );

		}
    }
}