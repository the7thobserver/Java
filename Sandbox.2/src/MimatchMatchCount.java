import java.util.Stack;


public class MimatchMatchCount
{
	// find index i where the number of matches on the left equals the number of mismatches on the right
	public static void main(String[] args) {		
		int[] a = {0,1};
		int b = 0;
	
		MimatchMatchCount m = new MimatchMatchCount();
		System.out.println("Index: " + m.findIndex(a, b));
	}
	
	public int findIndex(int[] a, int t)
	{
		if(a == null)
			return -1;
		
		if(a.length == 0)
			return -1;
		
		int p1 = 0;
		int p2 = a.length - 1;
		
		int match = 0;
		int mismatch = 0;
		
		boolean found = false;
		
		while(p1 < p2)
		{
			// find first match
			while(!found)
			{
				if(a[p1] == t)
				{
					match++;
					found = true;
				}
				
				p1++;
				
				if(p1 >= a.length)
					return -1;
			}
			
			System.out.println("Match: " + (p1-1));
			found = false;
			
			while(!found)
			{
				if(a[p2] != t)
				{
					mismatch++;
					found = true;
					p2--;
				}
				else
					p2--;
				
				if(p2 < 0)
					return -1;
			}
			
			found = false;
			System.out.println("Mismatch: " + (p2+1));
			
		}
		
		if(match == mismatch)
			return p1;
		
		return -1;
	}

}
