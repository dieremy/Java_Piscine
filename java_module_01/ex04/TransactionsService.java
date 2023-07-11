import java.util.UUID;

public class TransactionsService
{
	private TransactionsLinkedList invalidtransactionList = new TransactionsLinkedList();
	TransactionsList transactionList = new TransactionsLinkedList();
	UsersList userList = new UsersArrayList();

	public void addUser( User user )
	{
		this.userList.addUser( user );
	}

	public int getUserBalance( int id )
	{
		return ( userList.getUserById( id ).getBalance() );
	}

	public int getUserBalance( User user )
	{
		int id = user.getIdentifier();
		int	len = userList.getUserNum();

		for ( int i = 0; i < len; i++ )
			if ( userList.getUserByIndex( i ).getIdentifier() == id )
				return ( user.getBalance() );
		throw new IllegalTransactionException( "User not found" );
	}

	public void executeTransfer( int idSender, int idReceiver, int amount )
	{
		User sender = userList.getUserById( idSender );
		User receiver = userList.getUserById( idReceiver );

		if ( amount <= 0 || sender.getBalance() < amount || idSender == idReceiver )
			throw new IllegalTransactionException( "Illegal Transaction" );
		
		Transaction debit = new Transaction( sender, receiver, "DEBIT", amount );
		Transaction credit = new Transaction( receiver, sender, "CREDIT", amount );
		
		debit.setIdentifier( UUID.randomUUID() );
		credit.setIdentifier( debit.getIdentifier() );

		sender.getTransactionsList().addTransaction( debit );
		receiver.getTransactionsList().addTransaction( credit );
		
		sender.setBalance( sender.getBalance() - amount );
		receiver.setBalance( receiver.getBalance() + amount );
	}

	public Transaction[]	getTransactionsList( int idUser )
	{
		return ( userList.getUserById( idUser ).getTransactionsList().toArray() );
	}

	public void removeTransactionById( UUID transactionId, int idUser )
	{
		userList.getUserById( idUser ).getTransactionsList().removeTransactionById( transactionId );
	}

	public Transaction[] unpairedTransactions()
	{
		int size = userList.getUserNum();
		int start = 0;
		int max = 10;
		Transaction[] out = new Transaction[max];

		for ( int i = 0; i < size; i++ )
		{
			User user = userList.getUserById( i );
			Transaction[] transactions = user.getTransactionsList().toArray();
			for ( int j = 0; j < transactions.length; j++ )
			{
				if ( isUnpairedTransaction( i, transactions[j].getIdentifier(), size ) )
				{
					max *= 2;
					Transaction[] tmp = out;
					out = new Transaction[max];
					for ( int x = 0; x < tmp.length; x++ )
						out[x] = tmp[x];
				}
				out[start++] = transactions[j];
			}
		}
		return ( modifiedArray( start, out ) );
	}

	private boolean isUnpairedTransaction( int i, UUID id, int size )
	{
		for ( int x = 0; x < size; x++ )
		{
			if ( i == x )
				continue ;
			
			User user = userList.getUserById( x );
			Transaction[] transactions = user.getTransactionsList().toArray();
			
			for ( int j = 0; j < transactions.length; x++ )
				if ( id.equals( transactions[j].getIdentifier() ) )
					return ( false );
		}
		return ( true );
	}

	private Transaction[] modifiedArray( int max, Transaction[] tmp )
	{
		Transaction[] out = new Transaction[max];

		for ( int i = 0; i < max; i++ )
			out[i] = tmp[i];
		return ( out );
	}
}