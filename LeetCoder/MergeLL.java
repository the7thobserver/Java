
public class MergeLL {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
            
        
        ListNode newHead = null;
        ListNode last = null;
        boolean first = true;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                if(first)
                {
                    newHead = l1;
                    last = newHead;
                    first = false;
                }
                else
                {
                    last.next = l1;
                    last = last.next;
                }
                
                
                l1 = l1.next;
            }
            else if(l2.val <= l1.val)
            {
                if(first)
                {
                    newHead = l2;
                    last = newHead;
                    first = false;
                }
                else
                {
                    last.next = l2;
                    last = last.next;
                }
                
                l2 = l2.next;
            }
        }
        
        while(l1 != null)
        {
            last.next = l1;
            last = last.next;
            l1 = l1.next;  
        }
        
        while(l2 != null)
        {
           last.next = l2;
           last = last.next;
           l2 = l2.next;
        }
        
        return newHead;
    }
    

}
