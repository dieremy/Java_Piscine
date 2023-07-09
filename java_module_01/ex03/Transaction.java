import java.util.UUID;

public class Transaction
{
	private String	identifier;
	private User	receiver;
	private User	sender;
	private String	category;
	private double	amount;

	public Transaction( User receiver, User sender, String category, double amount )
	{
		this.identifier = UUID.randomUUID().toString();
		this.receiver = receiver;
		this.sender = sender;
		this.category = category;
		this.amount = amount;
	}

	public String	getIdentifier()
	{
		return ( this.identifier );
	}

	public User	getReceiver()
	{
		return ( this.receiver );
	}

	public User	getSender()
	{
		return ( this.sender );
	}

	public String	getCategory()
	{
		return ( this.category );
	}

	public double	getAmount()
	{
		return ( this.amount );
	}
}