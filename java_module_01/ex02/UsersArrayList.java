import java.util.Arrays;

public class UsersArrayList implements UsersList
{
	private	int		userCount = 0;
	private	int		userLen = 10;
	private	User[]	user = new User[userLen];

	private void increaseCapacity()
	{
		int newCapacity = user.length + ( user.length / 2 );
		user = Arrays.copyOf( user, newCapacity );  
	}

	public void	addUser( User userNew )
	{
		if ( userCount >= user.length )
			increaseCapacity();
		user[userCount] = userNew;
		userCount++;
	}

	public User	getUserById( int id ) throws UserNotFoundException
	{
		for ( int i = 0; i < this.userCount; i++ )
			if ( id == user[i].getIdentifier() )
				return ( user[i] );
		throw new UserNotFoundException( "User with ID " + id + " not found" );
	}

	public User	getUserByIndex( int index ) throws UserNotFoundException
	{
		if ( index < this.userCount && index >= 0 )
            return user[index];
        throw new UserNotFoundException( "User with index " + index + " not found" );
	}

	public int		getUserNum()
	{
		return ( this.userLen );
	}

	public void printInfo()
	{
		for ( int i = 0; i < this.userCount; i++ )
		{
			System.out.print( i + "\tName: " + user[i].getName() + "  balance: " + user[i].getBalance() );
			System.out.println( "\tid: " + user[i].getIdentifier() );
		}
    }
}