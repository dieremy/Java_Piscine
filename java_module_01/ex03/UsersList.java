public interface UsersList
{
	void	addUser( User New );
	User	getUserById( int Id );
	User	getUserByIndex( int Index );
	int		getUserNum();
}