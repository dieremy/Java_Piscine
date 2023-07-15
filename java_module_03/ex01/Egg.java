public class Egg implements Runnable
{
    private final int count;
    private     Object obj;

    public Egg( int count, Object obj )
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
					System.out.println( "Egg" );
					this.obj.notify();
					this.obj.wait();
				}
                catch ( InterruptedException e )
                {
					System.out.println( "Thread interrupted" );
					System.exit(-1);
				}
            }
        }
    }
}
