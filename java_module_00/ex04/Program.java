import java.util.Scanner;

public class Program {

    // Count character occurrences in the text
    private static int[] countCharacterOccurrences(String text) {
        int[] occurrences = new int[65536]; // Assuming Unicode BMP
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            occurrences[c]++;
        }
        return occurrences;
    }

    // Sort characters by occurrence count and lexicographic order
    private static char[] sortCharactersByOccurrences(int[] occurrences) {
        int index = 0;
        for (int count : occurrences)
        {
            if (count > 0)
                index++;
        }

        char[] characters = new char[index]; // Assuming Unicode BMP
        int x = 0;
        for ( char i = 0; i < occurrences.length; i++ ) {
            if ( occurrences[i] > 0 )
                characters[x++] = i;
        }
        // System.out.print( "dioporco2" );

        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - i - 1; j++) {
                if (occurrences[characters[j]] < occurrences[characters[j + 1]] ||
                        (occurrences[characters[j]] == occurrences[characters[j + 1]] &&
                                characters[j] > characters[j + 1])) {
                    // Swap characters
                    char temp = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temp;
                }
            }

        }
        return characters;
    }

    // Display histogram
    private static void displayHistogram(char[] characters, int[] occurrences) {
        int maxOccurrences = findMaxOccurrences(occurrences);
        int scaleFactor = (maxOccurrences + 9) / 10; // Scale factor for proportional display

        for (int i = 10; i > 0; i--) {
            for (int j = 0; j < characters.length; j++) {
                int count = occurrences[characters[j]];
                int scaledCount = (count + scaleFactor - 1) / scaleFactor;
                if (scaledCount >= i) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // Print character labels
        for (char c : characters) {
            System.out.print(c + " ");
        }
    }

    // Find the maximum number of occurrences
    private static int findMaxOccurrences(int[] occurrences) {
        int max = 0;
        for (int count : occurrences) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Read input text
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter the input text: ");
        String text = scanner.nextLine();
        // scanner.close();


        // Count character occurrences
        int[] occurrences = countCharacterOccurrences(text);

        // Sort characters by occurrence count and lexicographic order
        char[] characters = sortCharactersByOccurrences(occurrences);
        System.out.print( "dioporco" );

        // Display histogram
        displayHistogram(characters, occurrences);
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