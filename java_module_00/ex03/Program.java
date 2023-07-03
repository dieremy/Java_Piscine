import java.util.Scanner;

public class Program
{
	static int findMin( int A[] )
	{
		int	min;
		int	i;

		min = A[0];
		i = -1;
		while ( ++i < 5 )
			if ( min > A[i] )
				min = A[i];
		return ( min );
	}

	public static void main(String[] args)
	{
		Scanner myObj = new Scanner( System.in );  // Create a Scanner object
		int A[] = new int[5];
		int n = 0;
		int check;
		int i;
		
		while ( n < 5 )
		{
			check = myObj.nextInt();
			if ( check >= 1 && check <= 9 )
				A[n] = check;
			else
				System.exit( -1 );
			n++;
		}

		int min = findMin( A );

		char[] level = new char[min];
		int x = -1;
		while ( ++x < min )
			level[x] = '=';

		String str = "";
		System.out.println( "Week X " + str.copyValueOf( level, 0, min ) + ">" );
	}
}