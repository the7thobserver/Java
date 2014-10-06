public class FindCycle {
	public static void main(String[] args) {
		FindCycle c = new FindCycle();
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = head;
		System.out.println(c.hasCycle(head));
		
	}
	
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	}
	
	public boolean hasCycle(ListNode head) {
        if(head == null)
         return false;
         
        ListNode temp = head;
        
        while(head != null && temp != null)
        {
        	if(head.next != null)
        		head = head.next;
        	else
        		return false;
        	
        	if(temp.next != null && temp.next.next != null)
        		temp = temp.next.next;
        	else
        		return false;
        	
            if(head == temp)
                return true;
                //1 2 3 4 5 6
        }
        
        return false;
    }

}
