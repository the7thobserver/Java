public class AddTwoNumbers {
	public static void main(String[] args)
	{
//		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//		Output: 7 -> 0 -> 8
		
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
//		l1.next.next.next.next.next.next = new ListNode(0);
//		l1.next.next.next.next.next.next.next = new ListNode(1);
//		l1.next.next.next.next.next.next.next.next = new ListNode(6);
//		l1.next.next.next.next.next.next.next.next.next = new ListNode(1);

		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(5);
//		l2.next.next = new ListNode(8);
//		l2.next.next.next = new ListNode(6);
//		l2.next.next.next.next = new ListNode(2);
//		l2.next.next.next.next.next = new ListNode(5);
//		l2.next.next.next.next.next.next = new ListNode(8);
//		l2.next.next.next.next.next.next.next = new ListNode(2);
//		l2.next.next.next.next.next.next.next.next = new ListNode(6);
//		l2.next.next.next.next.next.next.next.next.next = new ListNode(1);

		print(a.addTwoNumbers(l1, l2));
	}
	
	private static void print(ListNode a) {
		System.out.println("NUMBER IS REVERSED");
		while(a != null)
		{
			System.out.print(a.val);
			a = a.next;
		}
		
	}

	// template
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// begining and end of the list
		ListNode head = null, listEnd = null;
		// flag to see if there's only one item
		boolean first = true;
		// carry digit
		int carry = 0;
		
		// while the two lists are the same lengths
		while(l1 != null && l2 != null)
		{
			// calculate answer
			int ans = l1.val + l2.val + carry;
			// reset the carry digit
			carry = 0;
			
			// calculate to see if there's a new carry
			if(ans >= 10)
			{
				carry = 1;
				ans = ans % 10;
			}
		
			// see if it's the first node being created
			if(first)
			{
				listEnd = new ListNode(ans);
				head = listEnd;
				first = false;
			}
			else	// just add it to the list
			{
				listEnd.next = new ListNode(ans);
				listEnd = listEnd.next;
			}
			
			// if there's a carry and there is no more digits to add
			if(carry == 1 && l1.next == null && l2.next == null)
			{
				listEnd.next = new ListNode(1);	
				return head;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		// while l1 is not empty and l2 is empty
		if(l1 != null)
		{
			// if l1 is the only list
			if(head == null)
				head = l1;
			else
			{
				ListNode temp = l1;
				
				// iterate through the list
				while(temp != null)
				{
					// calculate answer
					int ans = temp.val + carry;
					
					// calculate carry
					if(ans >= 10)
					{
						carry = 1;
						ans = ans % 10;
					}
					else
						carry = 0;
					
					// add to list
					listEnd.next = new ListNode(ans);

					listEnd = listEnd.next;
					temp = temp.next;
				}
			
				// additional carry at the end
				if(carry == 1 && listEnd.next == null)
				{
					listEnd.next = new ListNode(1);	
					return head;
				}
			}
		}
		
		// repeat of the above, would be nice to put into it's own function but you know 
		
		if(l2 != null)
		{
			if(head == null)
				head = l2;
			else
			{
				ListNode temp = l2;
				while(temp != null)
				{
					int ans = temp.val + carry;
					
					if(ans >= 10)
					{
						carry = 1;
						ans = ans % 10;
					}
					else
						carry = 0;
					listEnd.next = new ListNode(ans);

					listEnd = listEnd.next;
					temp = temp.next;
				}
				
				if(carry == 1 && listEnd.next == null)
				{
					listEnd.next = new ListNode(1);	
					return head;
				}
			}
		}
		
		return head;
	}
}
