public class RemoveN {
	public static void main(String[] args) {
		RemoveN n = new RemoveN();
		
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
//		head.next.next = new ListNode(2);
		
		ListNode v = n.removeNthFromEnd(head, 1);

		// print what's in the ll
		while(v != null)
		{
			System.out.println(v.val);
			v = v.next;
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

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode temp = head;
		int size = getSize(head);
		int count = 1;	// instructions start count at 1 not 0
		
		// if it's a negative number, remove head
		if(n < 0)
			return head;
		
		// if it's bigger than the ll, remove the last
		if(n >= size)
			size = n;
		
		// if it's the first node, just remove it and return
		if(size == n)
			return head.next;
		
		// find nth to last, the one right before
		while(count != size - n)
		{
			count++;
			temp = temp.next;
		}
		
		// do the delete
		temp.next = temp.next.next;
		
		return head;
	}

	// get the size of the linked list
	private int getSize(ListNode head) {

		int size = 0;
		
		while(head != null)
		{
			head = head.next;
			size++;
		}
		return size;
	}
}
