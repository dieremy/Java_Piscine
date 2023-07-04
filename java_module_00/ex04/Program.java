import java.util.Scanner;

public class Program
{
    static int percentVal( int max, int len )
    {
        if ( max < 1 || len < 1 )
            return (0);
        return ( ( len * 10 ) / max );
    }

    public static void main( String[] args )
    {
        Scanner myObj = new Scanner( System.in );
        String  line = myObj.nextLine();
        // char[]  alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        // int[][] iter = new int[26][999];
        int     count = 0;
        int     x = 0;

        char[] ch = line.toCharArray();
        for ( int i = 0; i < ch.length; i++ )
        {
            System.out.println( "A[" + i + "]" + ch[i] );
                count++;
            for ( int j = 1; j < ch.length; j++ )
            {
                if ( ( ch[i] - ch[j] ) == 0 )
                {
                    // System.out.println( "dioporco bagnato");
                    count++;
                    System.out.println( "dioporco ch[i]: " + ch[i] + " enacoid [x]: " + count );
                    // int max = 36;
                    // int elem = 35;

                    // count++;
                }
                count = 0;
            }
            // i++;
        }

                // int n = percentVal( i, count );
                // x = 0;

                // System.out.println( count );
                // while ( x++ < n )
                //     System.out.println( "#" );
        // for ( int i = 0; i < iter.length; i++ )
        //     for (int k = 0; k < iter[i].length; k++ )
                // System.out.println( "elem: " + ch[i] + " iter: " + iter[i][count] );




    }
}