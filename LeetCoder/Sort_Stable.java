public class Sort_Stable {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Sort a linked list in O(n log n) time using constant space complexity.
	public static void main(String[] args)
	{
		
	}
	
	public ListNode sortList(ListNode head) 
	{
		int size = getSize(head);
		
		
		
//		sort(head, size/2);	
//		sort(half, size/2);
		return null;
	}
	
	public int getSize(ListNode head)
	{
		int size = 0;
		
		while(head != null)
		{
			size++;
			head = head.next;
		}
		
		return size;
	}
	
	public ListNode sort(ListNode head)	{
		if(head == null)
			return null;
		
		if(head.next == null)
			return head;
		
		
		
		sortList(head);

		return null;
	}
}
