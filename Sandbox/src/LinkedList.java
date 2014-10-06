
public class LinkedList<E>
{
	class Node<E>
	{
		Node<E> next;
		E data;
		
		public Node(E e, Node<E> node)
		{
			data = e;
			next = node;
		}
	}
	
	private Node<E> head, last;
	private int size;
	
	public LinkedList()
	{
		head = null;
		last = null;
		size = 0;
	}

	public void add(E e)
	{
		if(head == null)
		{
			head = new Node<E>(e, null);
			last = head;
		}
		else
		{
			Node<E> temp = new Node<E>(e, null);
			last.next = temp;
			last = temp;
		}
		
		size++;
	}
	
	public int removeN(int i)
	{
		int count = 1;
		
		Node<E> temp = head;
		
		if(size < i)
		{
			System.out.println("Not enough nodes");
			return -1;
		}
		
		while(temp != null)
		{
//			if(temp.next == null)
//				return -1;
			
			if(count == i)
			{
				head = temp.next;
				return 0;
			}
			
			count++;
			temp = temp.next;
		}
		
		return 0;
	}
	
	public int remove(E e)
	{
		// Empty
		if(head == null)
			return -1;
		
		// 1 unit
		if(head == last && head.data.equals(e))
		{
			head = null;
			size--;
			return 0;
		}
		
		// 1 unit and more
		if(head.data.equals(e))
		{
			head = head.next;
			size--;
			return 0;
		}
		
		// Reset
		Node<E> temp = head;
		
		while(temp != null)
		{
			if(temp.next== null)
				return -1;
			
			if(temp.next.data.equals(e))
			{
				temp.next = temp.next.next;
				size--;
				return 0;
			}
			
			temp = temp.next;
		}
		
		return 0;
		
	}
	
	public int getSize()
	{
		return size;
	}
	
	public Node<E> deepCopy()
	{
		if(head == null)
			return null;
		
		Node<E> head2;
		Node<E> temp = head;
		
		// Cpy head
		Node<E> temp2 = new Node<E>(temp.data, null);
		head2 = temp2;
		temp = temp.next;
		
		while(temp != null)
		{
			temp2 = new Node<E>(temp.data, null);
			head2.next = temp2;
			
			temp = temp.next;
		}
		
		return head2;
	}
	
	public void print()
	{
		Node<E> temp = head;
		
		if(size == 0)
			System.out.println("Empty LinkedList");
		
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
