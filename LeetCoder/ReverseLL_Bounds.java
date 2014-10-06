

public class ReverseLL_Bounds {
	public static void main(String[] args) {
		ReverseLL_Bounds r = new ReverseLL_Bounds();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		int m = 2;
		int n = 4;
		
		ListNode t = r.reverseBetween(head, m, n);
		
		
		System.out.println("--");
		while(t != null){
			System.out.println(t.val + " ");
			t = t.next;
	}		
	}
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * In place linkedlist reverse O(n) time, O(1) space
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverse(ListNode head)
	{
		// null or 1 unit
		if(head == null || head.next == null)
			return head;
		
		// 2 units
		if(head.next.next == null)
		{
			ListNode newHead = head.next;
			newHead.next = head;
			head.next = null;
			return newHead;
		}
		
		// 3+ units
		ListNode t = head;			// front
		ListNode t2 = head.next;	// middle to be pointing back
		ListNode next = t2.next;	// remaining nodes
		ListNode newHead = null, prev = null;	// to hold the 2nd to last for the connection/new head node
		
		while(next != null)
		{			
			// t   t2  next
			// 1 -> 2 -> 3 -> null
			t2.next = t;
			t = t2;
			
			// Save 2nd to last/newhead
			if(next.next==null)
			{
				prev = t2;
				newHead = next;
			}
			
			t2 = next;
			next = next.next;
		}
		
		// connect last
		newHead.next = prev;
		
		// purge tail
		head.next = null;
		
		return newHead;
	}
	
	/** 
	 * in place, one pass, reverse subset of linkedlist
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// null or 1 unit
		if(head == null || head.next == null)
			return head;
		
		// smallest val > largest
		if(n < m)
			return head;
		if(n == m)
			return head;
		if(m < 1)
			m = 1;
		
		// 2 units
		if(head.next.next == null)
		{
			ListNode newHead = head.next;
			newHead.next = head;
			head.next = null;
			return newHead;
		}
		
		// 3 units
		if(head.next.next.next == null)
		{
			ListNode newHead = head.next.next;
			newHead.next = head.next;
			newHead.next.next = head;
			newHead.next.next.next = null;
			
			return newHead;
		}
		
		int size = 1;
		ListNode temp = head;
		boolean swap = false;
		ListNode t = null, t2 = null, remain = null, newHead = null, prev = null;
		
		// Find beginning of swap
		while(temp != null)
		{
			if(size == m - 1)
			{
				prev = temp;
				t = temp.next;
				t2 = t.next;
				remain = t2.next;
				
				System.out.println("End " + prev.val + " (swap " + t.val + " & " + t2.val + ") rem " + remain.val);
				size++;
				swap = true;
				break;
			}
			
			temp = temp.next;
			size++;
		}
		
		// Swap nodes
		while(size < n)
		{
			System.out.println(size + " " + n);
			System.out.println("SWAP " + t.val + " " + t2.val + " " + remain.val);
			
			// t   t2  next
			// 1 -> 2 -> 3 -> null
			t2.next = t;
			t = t2;
			
			// Save 2nd to last/newhead
			if(remain.next == null)
			{
//				prev = t2;
				newHead = remain;
			}
			
			t2 = remain;
			remain = remain.next;
			size++;
		}
//		System.out.println("T" + prev.val);
		
		t2.next = t;
		head.next = t2;
		prev.next = head.next;
		
		return head;
	}
}
