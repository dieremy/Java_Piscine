import java.util.UUID;

public class Transaction
{
	private final UUID	identifier;
	private User	receiver;
	private User	sender;
	private String	category;
	private double	amount;

	public Transaction( User receiver, User sender, String category, double amount )
	{
		this.identifier = UUID.randomUUID();
		this.receiver = receiver;
		this.sender = sender;
		this.category = category;
		this.amount = amount;
	}

	public void	setIdentifier( UUID id )
	{
		this.identifier = id;
	}

	public UUID	getIdentifier()
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

	public void printTransferInfo()
	{
		System.out.print( "\tSender name: " + this.sender.getName() + "\tReceiver name: " + this.receiver.getName() );
		System.out.println( "\tCategory: " + this.getCategory() + "\tAmount: " + this.getAmount() );
    }
}