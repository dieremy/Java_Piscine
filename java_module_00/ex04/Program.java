import java.util.Scanner;

public class Program
{

    static int[] countCharFrequence( String text )
    {
        int[] occurrences = new int[65536];
        char[] chars = text.toCharArray();

        int i = -1;
        while ( ++i < chars.length )
        {
            char c = chars[i];
            occurrences[c]++;
        }
        
        return ( occurrences );
    }

    static void sortByPrevalence( char[] chars, int[] occurrences )
    {
        for ( int i = 0; i < chars.length - 1; i++ )
        {
            for ( int j = i + 1; j < chars.length; j++ )
            {
                int iterI = occurrences[chars[i]];
                int iterJ = occurrences[chars[j]];
                
                if ( iterI < iterJ || ( iterI == iterJ && chars[i] > chars[j] ) )
                {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
    }

    static int proportion( int max, int count )
    {
        return ( ( count * 10 ) / max );
    }

    static boolean checkToPrint( int charIndex, int i, int j, int count, int maxOccurrences, boolean f )
    {
        int scaledCount = count;
        if ( j == charIndex )
            return ( false );
        if ( f )
            scaledCount = proportion( maxOccurrences, count );
        if ( i == scaledCount + 1 )
            System.out.print( count + " " );
        else if ( scaledCount >= i )
            System.out.print( "# " );
        else
            System.out.print( "  " );
        return ( true );
    }

    static void displayChart( char[] characters, int[] occurrences, int charIndex )
    {
        int maxOccurrences = occurrences[characters[0]];
        boolean flag = false;
        if ( maxOccurrences > 10 )
            flag = true;

        int scaledCount = 0;
        System.out.println();
        for ( int i = 11; i > 0; i-- )
        {
            for ( int j = 0; j < 10; j++ )
            {
                int count = occurrences[characters[j]];
                if ( !checkToPrint( charIndex, i, j, count, maxOccurrences, flag ) )
                    break ;
            }
            System.out.println();
        }

        for ( int j = 0; j < 10; j++ )
            System.out.print( characters[j] + " " );
        System.out.println(); 
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        int[] occurrences = countCharFrequence( text );

        char[] chars = new char[65536];
        int charIndex = 0;
        int i = -1;
        while ( ++i < occurrences.length )
        {
            if ( occurrences[i] > 0 )
            {
                chars[charIndex] = (char)i;
                charIndex++;
            }
        }
        
        sortByPrevalence( chars, occurrences );

        displayChart( chars, occurrences, charIndex );
    }
}
