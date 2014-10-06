
public class LinkedList<E> {

	class Node<E>
	{
		private E data;
		private Node next;
		
		public Node(E data, Node<E> next)
		{
			this.data = data;
			this.next = next;
		}
	}
	
	Node<E> root;
	Node<E> last;
	int size;
	
	public LinkedList()
	{
		size = 0;
	}
	
	public void addFront(E e)
	{
		size++;
		
		if(root == null)
		{
			Node<E> n = new Node<E>(e, null);
			root = n;
			last = n;
		}
		else
		{
			Node<E> cache = root;
			Node<E> n = new Node<E>(e, cache);
			root = n;
		}
	}
	
	public void addEnd(E e)
	{
		size++;
		
		Node<E> n = new Node<E>(e, null);
		last.next = n;
		last = n;
	}
	
	public E remove(E e) throws CustomException
	{
		
		// is head
		if(root.data == e)
		{
			Node<E> cache = root;
			root = root.next;
			size--;
			
			return cache.data;
		}
		
		Node<E> temp = root;
		
		// middle
		while(temp.next != null)
		{
			if(temp.next.data == e)
			{
				Node<E> cache = temp.next;
								
				if(temp.next.next != null)
					temp.next = temp.next.next;
				else	// end
					temp.next = null;
				
				cache.next = null;
				
				size--;
				return cache.data;
			}
			
			temp = temp.next;
		}
		
		// Not there
		throw new CustomException("Node not found");
	}
	
	public void printLL()
	{
		Node<E> temp = root;
		System.out.println("ROOT");
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public E getHead()
	{
		return root.data;
	}
}
