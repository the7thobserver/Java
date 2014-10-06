
public class RemoveDuplicates 
{
	public static void main(String[] args)
	{
		RemoveDuplicates n = new RemoveDuplicates();
		int[] x = {1,1,2};
		System.out.println(n.removeDuplicates(x));
		
	}
	
	public int removeDuplicates(int[] A) {
		// only 1 item
		if(A.length == 1)
			return 1;
		
		// insertion sort in place
		for(int i = 1; i < A.length; i++)
    	{
    		int j = i;
    		    		
    		while(j > 0 && A[j-1] > A[j])
    		{
    			int temp = A[j-1];
    			A[j - 1] = A[j];
    			A[j] = temp;
    			
    			j--;
    		}
    	}

		int count = 0;
		boolean first = true;
		
		// go across ignoring duplicates
		for(int i = 1; i < A.length; i++)
		{
			if(first)
			{
				count++;
			}
			
			if(A[i] == A[i-1])
			{
				first = false;
				continue;
			}
			else
				first = false;
			
			count++;
			// 1 1 2 3 4 5 5 5
			
		}
		
    
		return count;
	}
	
	public int[] mergesort(int[] A)
	{
		if(A.length <= 1)
			return A;
		
		int[] l = new int[A.length / 2];
		int[] r = new int[(int) Math.ceil(A.length / 2)];
	
		for(int i = 0; i < A.length / 2; i++)
			l[i] = A[i];
		
		for(int i = 0; i < (int) Math.ceil(A.length / 2); i++)
			r[i] = A[A.length / 2 + i];
		
		l = mergesort(l);
		r = mergesort(r);
	
		return merge(l, r);
	}
	
	public int[] merge(int[] a, int[] b)
	{
		int[] c = new int[a.length + b.length];
		int ai = 0, bi = 0, ci = 0;
		
		while(ai < a.length && bi < b.length)
		{
			if(a[ai] < b[bi])
			{
				c[ci] = a[ai];
				ci++;
				ai++;
			}
			else if(a[ai] >= b[bi])
			{
				c[ci] = b[bi];
				bi++;
				ci++;
			}
		}
		
		while(ai < a.length)
		{
			c[ci] = a[ai];
			ai++;
			ci++;
		}
		while(bi < b.length)
		{
			c[ci]= b[bi];
			bi++;
			ci++;
		}
		
		return c;
	}
}
