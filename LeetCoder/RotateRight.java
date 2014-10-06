import java.util.List;


public class RotateRight {
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		
//		ListNode head = new ListNode(1);
		RotateRight r = new RotateRight();
		head = r.rotateRight(head, 2);
		
		// print ll
		while(head != null)
		{
			System.out.println(head.val + " ");
			head = head.next;
		}
		
	}
	
	// template
	  static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	 
	public ListNode rotateRight(ListNode head, int n) {
		if(head == null)
			return head;
		
		if(n == 0)
			return head;
		
		if(head.next == null)
			return head;
			
		// handle n > size
		int size = getSize(head);
		n = n % size;

		if(n == 0)
			return head;
		
		// get the new head
		ListNode newHead = nthLast(head,n);
		
		ListNode last = newHead;
		
		//get the last and swing it around
		while(last.next != null)
			last = last.next;
		
		last.next = head;

		//find the new last and mark it
		while(head.next != newHead)
		{
			head = head.next;
		}
		
		head.next = null;
		
		
		return newHead;
	}
	
	// get the nth to last
	private ListNode nthLast(ListNode head, int n)
	{
		int size = getSize(head);
		ListNode temp = head;
		int count = 0;
		
		while(count != size - n)
		{
			temp = temp.next;
			count++;
		}

		return temp;
	}
	
	// size of the linkedlist
	private int getSize(ListNode head)
	{
		int size = 0;

		while(head != null)
		{
			head = head.next;
			size++;
		}
		
		return size;
	}
}
