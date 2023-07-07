public class User
{
	private int		identifier;
	private String	name;
	private double	balance;

	public User( int identifier, String name, double balance )
	{
		this.identifier = identifier;
		this.name = name;
		this.balance = balance;
	}

	public int	getIdentifier()
	{
		return ( this.identifier );
	}

	public String	getName()
	{
		return ( this.name );
	}
	
	public double	getBalance()
	{
		return ( this.balance );
	}

	public void	setBalance( double balance )
	{
		if ( balance < 0 )
			System.out.print( "Balance cannot be negative." );
		this.balance = balance;
	}
}