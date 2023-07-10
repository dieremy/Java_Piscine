public class Program
{
	public static void main( String[] args )
	{
		User[] users = new User[30];
		for ( int i = 0; i < 30; i++ )
			users[i] = new User( ( "User " + ( i + 1 ) ), ( i * 1000 ) );

		UsersArrayList userList = new UsersArrayList();
		for ( int i = 0; i < 30; i++ )
			userList.addUser( users[i] );
		userList.printInfo();

		System.out.println();

		User user10 = userList.getUserById( 10 );
		User user11 = userList.getUserByIndex( 10 );
		System.out.print( "User ID[10]: " );
		System.out.println( user10 );
		System.out.print( "User INDEX[11]: " );
		System.out.println( user11 );
		
		System.out.println();

		try
		{
			User user30 = userList.getUserById( 30 ); 
		}
		catch ( UserNotFoundException ex )
		{
			System.out.println( ex );
		}

		try
		{
			User user1678 = userList.getUserByIndex( 1678 ); 
		}
		catch ( UserNotFoundException ex )
		{
			System.out.println( ex );
		}
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