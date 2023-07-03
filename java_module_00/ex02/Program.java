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

	static int returnRemainder( int n )
	{
		return ( isPrimeBool( n % 10 ) ) ? n % 10 : 0 ;
	}

    public static void main(String[] args)
    {
		Scanner myObj = new Scanner( System.in );  // Create a Scanner object
		int n = myObj.nextInt();  // Read user input

        int r1 = 0;
        int r2 = 0;
        int sum;
        int flag;

        sum = 0;
        flag = 0;
        while ( n != 0 )
        {
			r1 = returnRemainder( n );
            n /= 10;
			r2 = returnRemainder( n );
            if ( flag == 0 )
            {
                sum += r1 + r2;
                flag = 1;
            }
            else
                sum += r2;
        }
		System.out.println( "sum: " + sum );
    }
}