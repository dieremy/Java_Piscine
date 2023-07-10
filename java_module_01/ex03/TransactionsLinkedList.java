import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList
{
	private Node	head;
	private Node	tail;

	private static class Node
	{
		Transaction elemTrans;
		Node		next;
		Node		prev;

		public Node( Transaction transaction )
		{
			this.elemTrans = transaction;
		}

		public void	setNext( Node next )
		{
			this.next = next;
		}

		public void	setPrev( Node prev )
		{
			this.prev = prev;
		}

		public Transaction	getTransaction()
		{
			return ( this.elemTrans );
		}

		public Node	getNext()
		{
			return ( this.next );
		}

		public Node	getPrev()
		{
			return ( this.prev );
		}
	}

	public	void			addTransaction( Transaction transaction )
	{
		Node newNode = new Node( transaction );
		
		if ( head == null )
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.setNext( newNode );
			newNode.setPrev( tail );
			tail = newNode;
		}
	}

	public	void removeTransactionById( UUID id ) throws TransactionNotFoundException
	{
		if ( id == null )
			throw new TransactionNotFoundException( "Transaction ID is 'NULL'." ); 
		
		Node nodeToRemove = findNode( id );
		if ( nodeToRemove == null )
			throw new TransactionNotFoundException( "Transaction not found with ID: " + id ); 
		removeNode( nodeToRemove );
	}

	public Node	findNode( UUID id )
	{
		Node tmpNode = head;

		while ( tmpNode != null )
		{
			if ( tmpNode.getTransaction().getIdentifier().equals( id ) )
				return ( tmpNode );
			tmpNode = tmpNode.getNext();
		}
		return ( null );
	}

	public void	removeNode( Node current )
	{
		if ( current == head )
			removeHead();
		else if ( current == tail )
			removeTail();
		else
			removeInMiddle( current );
	}

	public void	removeHead()
	{
		head = head.getNext();
		if ( head != null )
			head.setPrev( null );
		else
			tail = null;
	}

	public void	removeTail()
	{
		tail = tail.getPrev();
		if ( tail != null )
			tail.setNext( null );
		else
			head = null;
	}

	public void	removeInMiddle( Node current )
	{
		current.getPrev().setNext( current.getNext() );
		current.getNext().setPrev( current.getPrev() );
	}

	public	Transaction[]	toArray()
	{
		int	size = getListSize();
		Transaction[] transArray = new Transaction[size];
		Node tmp = head;
		int i = 0;

		while ( tmp != null )
		{
			transArray[i] = tmp.getTransaction();
			tmp = tmp.getNext();
			i++;
		}
		return ( transArray );
	}

	public int	getListSize()
	{
		Node tmp = head;
		int i = 0;

		while ( tmp != null )
		{
			tmp = tmp.getNext();
			i++;
		}
		return ( i );
	}
}
