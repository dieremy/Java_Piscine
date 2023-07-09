public class Program
{
	public static void main( String[] args )
	{
		User[] users = new User[5];
		for ( int i = 0; i < 5; i++ )
			users[i] = new User();

		UsersArrayList userList = new UsersArrayList();
		for ( int i = 0; i < 5; i++ )
			userList.addUser( users[i] );
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