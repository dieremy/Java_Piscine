package edu.school21.numbers;

public class NumberWorker
{
    public boolean isPrime( int number )
	{
		int	i;

		i = 2;
		if ( number < 2 )
			return ( false );
		while ( i <= ( number / 2 ) )
		{
			if ( ( number % i ) == 0 )
				return ( false );
			i++;
		}
		return ( true );
	}

	public int digitsSum( int number )
    {
        int sum;

        sum = 0;
        while ( number != 0 )
        {
            sum += number % 10;
            number /= 10;
        }
        return ( sum );
    }

    public class IllegalNumberException extends RuntimeException
    {
        public IllegalNumberException()
        {
            super( "Input number has to be > 1." );
        }
    }
}