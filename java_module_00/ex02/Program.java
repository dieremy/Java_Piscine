import java.util.Scanner;

public class Program
{
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

	public static int Sum( int n )
    {
        int sum;

        sum = 0;
        while ( n != 0 )
        {
            sum += n % 10;
            n /= 10;
        }
        return ( sum );
    }

	public static void checkExit( int n, int count )
	{
		if ( n == 42 )
		{
			System.out.println( "Count of coffe-request - " + count );
			System.exit( -1 );
		}
	}

    public static void main(String[] args)
    {
		Scanner myObj = new Scanner( System.in );  // Create a Scanner object
		int	sum = 0;
		int	count = 0;
		int	n = 0;

		while ( true )
		{
			n = myObj.nextInt();  // Read user input
			sum = Sum( n );
			checkExit( n, count );
			if ( isPrimeBool( sum ) )
				count++;
		}
    }
}