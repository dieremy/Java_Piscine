public class UserIdsGenerator
{
	private static	UserIdsGenerator instance;
	private int		lastGeneratedId;

	private UserIdsGenerator()
	{
		lastGeneratedId = 0;
	}

	public static UserIdsGenerator getInstance()
	{
		if ( instance == null )
			instance = new UserIdsGenerator();
		return ( instance );
	}

	public int generateId() // synchronized
	{
		lastGeneratedId++;

		return ( lastGeneratedId );
	}
}

// public synchronized int generateId()
// 'synchronized' is used to provide thread safety in the method
// means that only one thread can execute that method at time
// this prevents concurrent threads from accessing
// and modifying the lastGeneratedId field simultaneously

// when method / constructor / instance is defined as private
// is to prevent direct instantiation, function call or creation
// of class / method from outside
// IN THIS CASE: the only way to obtain an instance of
// UserIdsGenerator is through the getInstance() method

// in summary, constuction is the process of calling the constructor
// to create an object, while instantiation is the overall process
// of creating an instance of a class by allocating memory and 
// initializing it. The constructor is responsible for the
// CONSTRUCTION of the OBJECT during the INSTANTIATION PROCESS.