public class Program
{
    public static void main(String[] args)
    {
        int n;
        int sum;

        n = 479598;
        sum = 0;
        while ( n != 0 )
        {
            sum += n % 10;
            n /= 10;
        }
        System.out.println( sum );
    }
}