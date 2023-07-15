public class Hen implements Runnable
{
    private final int count;
    private Object obj;

    public Hen( int count, Object obj )
    {
        this.count = count;
        this.obj = obj;
    }

    @Override
    public void run()
    {
        for ( int i = 0; i < this.count; i++ )
        {
            synchronized ( this.obj )
            {
				try
                {
					this.obj.notify();
					this.obj.wait();
					System.out.println( "Hen" );
				}
                catch ( InterruptedException e )
                {
					System.out.println( "Thread interrupted" );
					System.exit(-1);
				}
            }
        }
        synchronized ( this.obj )
        {
            this.obj.notify();
        }
    }
}
