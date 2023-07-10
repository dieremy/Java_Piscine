import java.util.UUID;

public class Program
{
	public static void main( String[] args )
	{
		User user1 = new User( "User 1", 5000 );
		User user2 = new User( "User 2", 2500 );

		TransactionsLinkedList listTransactionUser1 = user1.getTransactionList();

		Transaction t1 = new Transaction( user1, user2, "Debit", 200 );
		Transaction t2 = new Transaction( user1, user2, "Credit", -100 );
		Transaction t3 = new Transaction( user1, user2, "Debit", 300 );
		Transaction t4 = new Transaction( user1, user2, "Credit", -150 );

		listTransactionUser1.addTransaction(t1);
		listTransactionUser1.addTransaction(t2);
		listTransactionUser1.addTransaction(t3);
		listTransactionUser1.addTransaction(t4);

		System.out.println( user1.getName() + " made " + user1.getTransactionList().getListSize() + " transactions." );

		System.out.println( "Removing transaction ID:" );
		listTransactionUser1.removeTransactionById( t3.getIdentifier() );
		
		try
		{
			listTransactionUser1.removeTransactionById( UUID.randomUUID() );
		}
		catch ( UserNotFoundException ex )
		{
			System.out.println( ex );
		}

		System.out.println( "Transfering in Transaction Array:" );
		Transaction[] arrayTransaction = listTransactionUser1.toArray();

		for ( Transaction elem : arrayTransaction )
			elem.printTransferInfo();
	}
}



/// public interface UserList ( .java )
/// methods declaration:
/// void addUser( User new )
/// User getUserById( int id )
/// User getUserByIndex( int index )
/// int getUserCount() - getter

/// public class UserArrayList ( .java ) implements UserList
/// addUser method fill and insert more space
/// getUserById return the user[i] when iter matches /// if not, throw new exception
/// getUserByIndex returns User[i] where i is passed as argument /// if not, throw new exception
/// getUserCount - getter
/// printInof loop to print each User

/// public class UserNotFoundException ( .java ) extends RuntimeException
/// UserNotFoundException( String msg )
///       super( msg );
