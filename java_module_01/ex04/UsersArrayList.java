import java.util.Arrays;

public class UsersArrayList implements UsersList
{
	private	int		userCount = 0;
	private	int		userLen = 10;
	private	User[]	users = new User[userLen];

	private void increaseLen()
	{
		int newLen = users.length + ( users.length / 2 );
		User[] newUsers = new User[newLen];

		for ( int i = 0; i < users.length; i++ )
			newUsers[i] = users[i];

		users = newUsers;  
	}

	public void	addUser( User userNew )
	{
		if ( userCount >= users.length )
			increaseLen();
		users[userCount] = userNew;
		userCount++;
	}

	public User	getUserById( int id ) throws UserNotFoundException
	{
		for ( int i = 0; i < this.userCount; i++ )
			if ( id == users[i].getIdentifier() )
				return ( users[i] );
		throw new UserNotFoundException( "User with ID " + id + " not found" );
	}

	public User	getUserByIndex( int index ) throws UserNotFoundException
	{
		if ( index < this.userCount && index >= 0 )
            return users[index];
		throw new UserNotFoundException( "User with index " + index + " not found" );
	}

	public int		getUserNum()
	{
		return ( this.userCount );
	}

	public void printInfo()
	{
		for ( int i = 0; i < this.userCount; i++ )
		{
			System.out.print( i + "  [ Name: " + users[i].getName() + "\tbalance: " + users[i].getBalance() );
			System.out.println( "  \tid: " + users[i].getIdentifier() + " ]" );
		}
    }
}