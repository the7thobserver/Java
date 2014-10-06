import java.util.HashMap;
import java.util.LinkedHashMap;

public class RemoveElement {
	public static void main(String[] args) {
		RemoveElement e = new RemoveElement();
		
		int[] A = {1,1,2,2,2,2,2,2,2,2};
		int elem = 3;
//		System.out.println("SIZE: " + e.removeElement(A, elem));
		System.out.println("SIZE: " + e.removeDup_CLO(A));
		
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		System.out.println();
	
		System.out.println("SIZE: " + e.removeElement_dup2(A));
		
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}
	
	class ListNode
	{

		public ListNode next;
		public int val;
		
	}
	
	private int removeDup_CLO(int[] A)
	{
		  if(A.length < 3) return A.length;
	        int count = 0;
	        int idx=0;
	        for(int i=1;i<A.length;i++){
	            if(A[idx] == A[i])
	                count++;
	            else
	                count = 0;

	            if(count < 2)
	                idx++;

	            A[idx] = A[i];
	        }
	        return idx+1;
	    }
	
	private int removeElement_dup2(int[] a) {
		if(a == null)
			return 0;
		
		if(a.length <= 2)
			return a.length;
		
		int p1 = 0;
		int p2 = a.length - 1;
		int size = a.length;
		
		int t = a[p1++];
		boolean isTwo = false;
		
		while(p1 <= p2)
		{
			if(a[p1] == t && isTwo == false)
			{
				isTwo = true;
				p1++;
			}
			else if(a[p1] == t && isTwo)
			{
				int temp = a[p1];
				a[p1] = a[p2];
				a[p2] = temp;
				
				p2--;
				size--;
			}
			else
			{
				t = a[p1];
				p1++;
				isTwo = false;
			}
		}
		
		return size;
	}

	public int removeElement_dup(int[] A) 
	{
		if(A.length <= 2)
			return 2;
		
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		
		for(int i = 0; i < A.length; i++)
		{
			if(map.containsKey(A[i]))
			{
				map.put(A[i], map.get(A[i]) + 1);
			}
			else
				map.put(A[i], 1);
		}
		
		int ind = 0;
		int end = 0;
		
		for(Integer i : map.keySet())
		{
			if(map.get(i) >= 3)
				end = 2;
			else
				end = map.get(i);
			
			for(int j = 0; j < end; j++)
			{
				A[ind] = i;
				ind++;
			}
			
		}
		
		return ind;
	}

	public int removeElement(int[] A, int elem)
	{
		if(A.length == 1)
		{
			if(A[0] == elem)
				return 0;
			return 1;
		}
		
		int p1 = 0;
		int p2 = A.length - 1;
		int size = A.length;
		
		while(p1 <= p2)
		{
			//System.out.println(p1 + " " + p2);
			if(A[p2] == elem)
			{
				p2--;
				size--;
			}
			else if(A[p1] == elem)
			{
				int temp = A[p1];
				A[p1] = A[p2];
				A[p2] = temp;

				p1++;
			}
			else
				p1++;
			
			if(p1 == p2)
			{
				if(A[p1] == elem)
					size--;
			
				
				
				break;
			}
		}
		
		
		
		return size;
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
            last = l1;
            last = last.next;
            l1 = l1.next;  
        }
        
        while(l2 != null)
        {
           last = l2;
           last = last.next;
           l2 = l2.next;
        }
        
        return newHead;
    }
}
