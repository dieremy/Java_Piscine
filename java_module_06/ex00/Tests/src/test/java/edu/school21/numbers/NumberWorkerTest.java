package edu.school21.numbers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest
{
    @ParameterizedTest
    @ValueSource( ints = { 12, 18, 27 } )
    public void isPrimeForPrimes( int n ) throws Exception
    {
        assertTrue(new NumberWorker().isPrime(n));
    }
    
    @ParameterizedTest
    @ValueSource( ints = { 12, 18, 27 } )
    public void isPrimeForNotPrimes( int n ) throws Exception
    {
        assertFalse(new NumberWorker().isPrime(n));
    }

    @ParameterizedTest
    @ValueSource( ints = { -12, -18, -27 } )
    public void isPrimeForIncorrectNumbers( int n ) throws Exception
    {
        assertThrows(NumberWorker.IllegalNumberException.class, () -> NumberWorker.isPrime(n));
    }

    @ParameterizedTest
	@CsvFileSource( resources = "/data.csv", numLinesToSkip = 1 )
    public void dataSum( int input, int expected ) throws Exception
    {
    	assertEquals(expected, new NumberWorker().digitsSum(input));
	}

	@Test
	public void testNegativeSum() throws Exception
    {
		assertEquals(-10, new NumberWorker().digitsSum(-154));
	}
}
