public class Program
{
	public static void main( String[] args )
	{
		User user1 = new User( "Britney Spears", 1200 );
		User user2 = new User( "Beyonce", 1000 );

		System.out.println( "User 1" );
		System.out.println( "ID: " + user1.getIdentifier() );
		System.out.println( "Name: " + user1.getName() );
		System.out.println( "Balance: " + user1.getBalance() );
		
		System.out.println();

		System.out.println( "User 2" );
		System.out.println( "ID: " + user2.getIdentifier() );
		System.out.println( "Name: " + user2.getName() );
		System.out.println( "Balance: " + user2.getBalance() );
	}
}