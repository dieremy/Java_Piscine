package edu.school21.numbers;

// import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest
{
    @ParameterizedTest
    @ValueSource( ints = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 2147483647 } )
    public void isPrimeForPrimes( int n )
    {
        assertTrue(new NumberWorker().isPrime(n));
    }
    
    @ParameterizedTest
    @ValueSource( ints = { 4, 6, 10, 14, 16, 18, 22, 28, 30, 36, 40, 42, 48, 54, 58, 60, 66, 70, 72, 77, 81, 88, 90, 92, 98 } )
    public void isPrimeForNotPrimes( int n )
    {
        assertFalse(new NumberWorker().isPrime(n));
    }

    @ParameterizedTest
    @ValueSource( ints = { 0, 1, -10, -14, -16, -18, -22, -28, -30, -36, -40, -42, -48, -54, -58, -60, -66, -70, -72, -77, -81, -2147483647 } )
    public void isPrimeForIncorrectNumbers( int n ) throws Exception
    {
        assertThrows(NumberWorker.IllegalNumberException.class, () -> new NumberWorker().isPrime(n));
    }

    @ParameterizedTest
	@CsvFileSource( resources = "/data.csv", numLinesToSkip = 1 )
    public void dataSum( int input, int expected )
    {
    	assertEquals(expected, new NumberWorker().digitsSum(input));
	}
}
