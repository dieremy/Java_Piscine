public class TransactionLinkedList implements TransactionList
{
	private Node	head;

	private static class Node
	{
		Transaction elem;
		Node		next;
		Node		prev;

		public Node( Transaction transaction, Node next, Node prev )
		{
			this.elem = transaction;
			this.next = next;
			this.prev = prev;
		}
	}

	public	void			addTransaction( Transaction transaction )
	{
		
	}

	public	void			removeTransactionById( UUID id )
	{

	}

	public	Transaction[]	toArray()
	{

	}
}