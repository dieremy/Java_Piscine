// import java.util.Scanner;

public class Program
{
    public static void main(String[] args) {
        // Input text
        String text = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDD" +
                      "DDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOOO42";

        // Count character occurrences
        int[] occurrences = countCharacterOccurrences(text);

        // Sort characters by occurrence count and lexicographic order
        char[] characters = sortCharactersByOccurrences(occurrences);

        // Display histogram
        displayHistogram(characters, occurrences);
    }

    // Count character occurrences in the text
    static int[] countCharacterOccurrences(String text)
    {
        int[] occurrences = new int[65536]; // Assuming Unicode BMP
        char[] chars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            occurrences[chars[i]]++;
        }
        return occurrences;
    }

    // Sort characters by occurrence count and lexicographic order
    static char[] sortCharactersByOccurrences(int[] occurrences)
    {
        char[] characters = new char[65536]; // Assuming Unicode BMP
        for (char c = 0; c < 65536; c++)
        {
            characters[c] = c;
        }

        for (int i = 0; i < characters.length; i++)
        {
            for (int j = i + 1; j < characters.length; j++)
            {
                if (occurrences[characters[j]] > occurrences[characters[i]]
                    || (occurrences[characters[j]] == occurrences[characters[i]] && characters[j] < characters[i]))
                {
                char temp = characters[i];
                characters[i] = characters[j];
                characters[j] = temp;
                }
            }
        }

        return characters;
    }

    // Display histogram
    static void displayHistogram(char[] characters, int[] occurrences)
    {
        int maxOccurrences = findMaxOccurrences(occurrences);

        for (int i = maxOccurrences; i > 0; i--)
        {
            for (int j = 0; j < characters.length; j++)
            {
                int count = occurrences[characters[j]];
                if (count >= i)
                {
                    System.out.print("# ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Print character labels
        for (char c : characters)
        {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    // Find the maximum occurrence count
    static int findMaxOccurrences(int[] occurrences)
    {
        int maxOccurrences = 0;
        for (int count : occurrences)
        {
            if (count > maxOccurrences)
            {
                maxOccurrences = count;
            }
        }
        return maxOccurrences;
    }
}


// public class Program
// {
//     static int percentVal( int max, int len )
//     {
//         if ( max < 1 || len < 1 )
//             return (0);

//         int tmp = len * 10;
//         tmp /= 10;
//         return ( tmp );
//     }

//     static int cicleStr( char[] c, int index, int pos )
//     {
//         int count = 0;

//         for ( int i = 0; i < c.length; i++ )
//         {
//             if ( index == ( c[i] - 'a' ) )
//                 count++;
//         }
//         return ( count );
//     }

//     static int cicleToFindMax( int cnt )
//     {
//         int max = 0;

//         if ( max < cnt )
//             max = cnt;
//         return ( max );
//     }

//     static void printCicle( int i, int count, int max, char c )
//     {
//         int n = percentVal( max, count );

//         System.out.println( count );
//         for ( int x = 0; x < n; x++ )
//             System.out.println( "#" );
//         System.out.println( c );    
//     }
    
//     public static void main( String[] args )
//     {
//         Scanner myObj = new Scanner( System.in );
//         String  line = myObj.nextLine();
//         char[]  ch = line.toCharArray();
//         // int[][]   alpha = {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } , { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
//         int[]     alpha = new int[65535];
//         int     index;
//         int     count = 0;
//         int     maxCount = 0;
//         int     i = 0;
//         char    c = 0;
        
//         for ( int j = 0; j < ch.length; j++ )
//         {   
//             i = ch[j] - 'a';
//             c = ch[j];
//             alpha[c]++;
//             count = cicleStr( ch, i, j );
//             maxCount = cicleToFindMax( count );
//             boolean flag = true; 
//             // System.out.println( " i: " + i + " c[j]: " + ch[j] + " j: " + j + " cnt: " + count + " max: " + whatCount );
//             if ( flag )
//             {
//                 if ( count > 1 )
//                     flag = false;
//                 printCicle( i, maxCount, count, c );
//             }
//             System.out.print( "\n" );

//         }

//         // for ( int x = 0; i < alpha.length; i++ )
//         // {
//         //     System.out.print( alpha[c] );
//         // }

//     }
// }
//     // static int checkRepetition( char[] ch )
//     // {
//     //     int count = 1;

//     //     for ( int j = 0; j < ch.length; j++ )
//     //     {   
//     //         for ( int x = j + 1; x < ch.length; x++ )
//     //         {
//     //             if ( (ch[j] - ch[x]) == 0 )
//     //             {
//     //                 count++;
//     //                 break ;
//     //             }
//     //         }
//     //     }
//     //     System.out.println( "counter: " + count );
//     //     return ( count );
//     // }
//     // char[]  alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
//     // 65 = A
//     // 90 = Z