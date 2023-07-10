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
		int len = userList.length;

		for ( int i = 0; i < len; i++ )
x			if ( userList[i].getIdentifier() == id )
				return ( user.getBalance() );
		throw new IllegalTransactionException( "User not found" );
	}

	public void executeTransfer( int idSender, int idReceiver, int amount )
	{
		User sender = userList.getUserById( idSender );
		User receiver = userList.getUserById( idReceiver );

		if ( amount < 0 || sender.getBalance() < amount || idSender == idReceiver )
			throw new IllegalTransactionException( "Illegal Transaction" );
		
		Transaction debit = new Transaction( sender, receiver, "DEBIT", amount );
		Transaction credit = new Transaction( receiver, sender, "CREDIT", amount );
		
		debit.setIdentifier( UUID.randomUUID() );
		credit.setIdentifier( debit.getIdentifier() );

		sender.getTransactionList().addTransaction( debit );
		receiver.getTransactionList().addTransaction( credit );
	}

	public Transaction[]	getTransactionList( int idUser )
	{
		User user = getUserById( idUser );
		return ( user.getTransactions().toArray() );
	}

	public void removeTransactionById( UUID transactionId, int idUser )
	{
		User user = getUserById( idUser );
		user.getTransactions().removeTransactionById( transactionId );
	}

	public Transaction[] unpairedTransactions()
	{
		int size = userList.length;
		int start = 0;
		int max = 10;
		Transaction[] out = new Transaction[max];

		for ( int i = 0; i < size; i++ )
		{
			User user = userList.getUserById( i );
			Transaction[] transactions = user.getTransaction().toArray();
			for ( int j = 0; j < transactions.length; j++ )
			{
				if ( isUnpairedTransaction( i, transactions[j].getIdentifier(), size ) )
				{
					max *= 2;
					Transaction[] tmp = result;
					result = new Transaction[max];
					for ( int x = 0 x < tmp.length; x++ )
						result[x] = tmp[x];
				}
				result[start++] = transactions[j];
			}
		}
		return ( modifiedArray( start, result ) );
	}

	private boolean isUnpairedTransaction( int i, UUID id, int size )
	{
		for ( int x = 0; x < size; x++ )
		{
			if ( i == x )
				continue ;
			
			User user = userList.getUserById( x );
			Transaction[] transactions = user.getTransaction().toArray();
			
			for ( int j = 0; j < transactions.length; x++ )
				if ( id.equals( transactions[j].getIdentifier() ) )
					return ( false );
		}
		return ( true );
	}

	private Transaction[] modifiedArray( int max, Transaction[] tmp )
	{
		Transaction[] result = new Transaction[max];

		for ( int i = 0; i < max; i++ )
			result[i] = tmp[i];
		return ( result );
	}
}