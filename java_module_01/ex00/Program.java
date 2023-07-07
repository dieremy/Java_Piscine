public class Program
{
	public static void main( String[] args )
	{
		// CREATE USERS
		User user1 = new User( 1, "James Bond", 1500 );
		User user2 = new User( 2, "Mickey Mouse", 600 );

		// CREATE TRANSACTION
		Transaction transaction = new Transaction( user1, user2, "debit", 200 );

		// USER 1 INFOS
		System.out.println( "User 1" );
		System.out.println( "ID: " + user1.getIdentifier() );
		System.out.println( "Name: " + user1.getName() );
		System.out.println( "Balance: " + user1.getBalance() );

		System.out.println();

		// USER 2 INFOS
		System.out.println( "User 2" );
		System.out.println( "ID: " + user2.getIdentifier() );
		System.out.println( "Name: " + user2.getName() );
		System.out.println( "Balance: " + user2.getBalance() );

		System.out.println();

		// TRANSACTION INFOS
		System.out.println( "Transaction" );
		System.out.println( "ID: " + transaction.getIdentifier() );
		System.out.println( "Recipient name: " + transaction.getReceiver().getName() );
		System.out.println( "Sender name: " + transaction.getSender().getName() );
		System.out.println( "Category: " + transaction.getCategory() );
		System.out.println( "Amount: " + transaction.getAmount() );
	}
}