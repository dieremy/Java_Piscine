public class Program
{
	public static void main( String[] args )
	{
		TransactionsService service = new TransactionsService();

		User user1 = new User( "User 1", 5000 );
		User user2 = new User( "User 2", 2500 );
		User user3 = new User( "User 3", 4000 );
		User user4 = new User( "User 4", 7000 );

		service.addUser( user1 );
		service.addUser( user2 );
		service.addUser( user3 );
		service.addUser( user4 );

		user1.setTransactionsList( new TransactionsLinkedList() );
		user2.setTransactionsList( new TransactionsLinkedList() );
		user3.setTransactionsList( new TransactionsLinkedList() );
		user4.setTransactionsList( new TransactionsLinkedList() );

		System.out.println( "User 1" + service.getUserBalance( user1.getIdentifier() ) );
		System.out.println( "User 2" + service.getUserBalance( user2.getIdentifier() ) );
		System.out.println( "User 3" + service.getUserBalance( user3.getIdentifier() ) );
		System.out.println( "User 4" + service.getUserBalance( user4.getIdentifier() ) );

		System.out.println( "\nTransfers >>" );
		service.executeTransfer( user1.getIdentifier(), user3.getIdentifier(), 200 );
		service.executeTransfer( user2.getIdentifier(), user1.getIdentifier(), 100 );
		service.executeTransfer( user3.getIdentifier(), user2.getIdentifier(), 300 );
		service.executeTransfer( user4.getIdentifier(), user2.getIdentifier(), 250 );
		service.executeTransfer( user4.getIdentifier(), user3.getIdentifier(), 234 );
		service.executeTransfer( user4.getIdentifier(), user3.getIdentifier(), 280 );
		service.executeTransfer( user4.getIdentifier(), user1.getIdentifier(), 300 );
		service.executeTransfer( user1.getIdentifier(), user2.getIdentifier(), 400 );
		service.executeTransfer( user3.getIdentifier(), user4.getIdentifier(), 100 );

		System.out.print( "User 1 " + user1 );
		System.out.println( "\nUser 1 list: " + user1.getTransactionsList() );
		System.out.print( "\nUser 2 " + user2 );
		System.out.println( "\nUser 2 list: " + user2.getTransactionsList() );
		System.out.print( "\nUser 3 " + user3 );
		System.out.println( "\nUser 3 list: " + user3.getTransactionsList() );
		System.out.print( "\nUser 4 " + user4 );
		System.out.println( "\nUser 4 list: " + user4.getTransactionsList() );

		System.out.println( "\n\nGet transactions by user ID >>" );
		Transaction[] transactions = service.getTransactionsList( user1.getIdentifier() );
		for ( Transaction t : transactions )
			System.out.println( t );

		System.out.println( "\nRemove transactions by ID >>" );
		try
		{
			service.removeTransactionById( transactions[1].getIdentifier(), user1.getIdentifier() );
			service.removeTransactionById( transactions[2].getIdentifier(), user1.getIdentifier() );
			service.removeTransactionById( transactions[3].getIdentifier(), user1.getIdentifier() );
			System.out.print( "User 1 " + user1 );
			System.out.println( "\nUser 1 list: " + user1.getTransactionsList() );
		}
		catch ( TransactionNotFoundException ex )
		{
			System.out.println( ex.getMessage() );
		}

		System.out.println( "\nCheck unpaired transactions >>" );
		transactions = service.unpairedTransactions();
		for ( Transaction t : transactions )
			System.out.println( t );

		try
		{
			service.executeTransfer( user1.getIdentifier(), user4.getIdentifier(), 200000 );
		}
		catch ( IllegalTransactionException ex )
		{
			System.out.println( "\n" + ex.getMessage() );
		}
	}
}
