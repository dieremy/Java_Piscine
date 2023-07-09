public interface TransactionList
{
	void			addTransaction( Transaction transaction );
	void			removeTransactionById( UUID id );
	Transaction[]	toArray();
}