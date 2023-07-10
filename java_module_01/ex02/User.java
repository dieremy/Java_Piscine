public class User
{
	private final int	identifier;
	private String		name;
	private double		balance;

	public User()
	{
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.balance = 0;
	}

	public User( String name, double balance )
	{
		this.identifier = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		if ( balance > 0 )
			this.balance = balance;
		else
			this.balance = 0;

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
		{
			System.out.print( "Balance cannot be negative." );
			this.balance = 0;
		}
		else
			this.balance = balance;
	}

	@Override
	public String toString()
	{
		return ( "User | ID: " + identifier + "\tName: " + name + "\tBalance: " + balance + " |" );
	}
}


// @Override annotation is used to indicate the intention
// to override a method from the superclass (  )

// 'final' keyword in this case is used like a const
// in C/C++, so that identifier variable cannot change his
// value providing read-only access

// final variable: constant or immutable value

// final class: the class cannot be subclassed

// final method: method cannot be overridden by subclasses
