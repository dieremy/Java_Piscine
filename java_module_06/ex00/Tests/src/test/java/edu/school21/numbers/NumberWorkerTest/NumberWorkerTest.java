package edu.school21.numbers.NumberWorkerTest;

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
    {}

    @ParameterizedTest
    @ValueSource( ints = { 12, 18, 27 } )
    public void isPrimeForNotPrimes( int n ) throws Exception
    {}

    @ParameterizedTest
    @ValueSource( ints = { 12, 18, 27 } )
    public void isPrimeForIncorrectNumbers( int n ) throws Exception
    {}

    @ParameterizedTest
	@CsvFileSource( resources = "/data.csv", numLinesToSkip = 1 ) throws Exception
    public void dataSum( int input, int expected )
    {
        
    }

}
