import java.util.Scanner;

public class Program
{

    static int[] countCharOccurrences( String text )
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

    static void displayChart( char[] characters, int[] occurrences, int charIndex )
    {
        int maxOccurrences = occurrences[characters[0]];
        int scaleFactor = ( maxOccurrences + 9 ) / 10;

        for ( int i = 11; i > 0; i-- )
        {
            for ( int j = 0; j < charIndex; j++ )
            {
                int count = occurrences[characters[j]];
                int scaledCount = ( count + scaleFactor - 1 ) / scaleFactor;
                if ( i == scaledCount + 1 )
                    System.out.print( scaledCount + " " );
                else if ( scaledCount >= i )
                    System.out.print( "# " );
                else
                    System.out.print( "  " );
            }
            System.out.println();
        }

        for ( int j = 0; j < charIndex; j++ )
            System.out.print( characters[j] + " " );
        System.out.println(); 
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        int[] occurrences = countCharOccurrences( text );

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
