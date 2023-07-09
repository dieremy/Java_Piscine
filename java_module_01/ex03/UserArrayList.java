public class UserArrayList implements UserList
{
	private	int		userCount = 0;
	private	int		userLen = 10;
	private	User[]	user = new User[userLen];

	public void	addUser( User userNew )
	{
		int tmpLen;

		if ( this.userCount == this.userLen )
		{
			tmpLen = this.userLen + ( this.userLen / 2 );
			User[] newArrayUser = new User[tmpLen];

			for ( int i = 0; i < this.userLen; i++ )
				newArrayUser[i] = this.user[i];
			this.user = newArrayUser;
			this.userLen = tmpLen;
		}
		this.user[userCount++] = userNew;
	}

	public User	getUserById( int id )
	{
		for ( int i = 0; i < this.numUser; i++ )
			if ( i == user[i].getIdentifier() )
				return ( user[i] );
		throw new UserNotFoundException("User with ID " + id + " not found");
	}

	public User	getUserByIndex( int index )
	{
		if ( index < this.numUser && Index >= 0 )
            return users[index];
        throw new UserNotFoundException("User with index " + index + " not found");
	}

	public int		getUserNum()
	{
		return ( this.numUser );
	}

	public void printInfo()
	{
		for ( int i = 0; i < this.count; i++ )
		{
			System.out.print( i + "\tName: " + user[i].getName() + "  balance: " + user[i].getBalance() );
			System.out.println( "\tid: " + user[i].getIdentifier() );
		}
    }
}