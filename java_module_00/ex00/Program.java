public class Program
{
    public static void main(String[] args)
    {
        int n;
        int r1;
        int r2;
        int sum;
        int flag;

        n = 479598;
        sum = 0;
        flag = 0;
        while ( n != 0 )
        {
            r1 = n % 10;
            n /= 10;
            r2 = n % 10;
            if ( flag == 0 )
            {
                sum += r1 + r2;
                flag = 1;
            }
            else
                sum += r2;
        }
        System.out.println( "sum = " + sum );
    }
}