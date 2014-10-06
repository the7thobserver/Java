import java.util.Scanner;


public class IceCreamParlor 
{
	public static void main(String[] args)
	{
//		 Scanner in = new Scanner(System.in);
//	     int tests = in.nextInt();
//	     
//	     for(int i = 0 ; i < tests; i++)
//	     {
//	    	 int target = in.nextInt();
//	    	 int size = in.nextInt();
//	    	 
//	    	 int[] x = new int[size];
//	    	 
//	    	 for(int j = 0; j < size; j++)
//	    	 {
//	    		x[j] = in.nextInt(); 
//	    	 }
//
//	    	 solve(x, target);
//	     }
		
//		int[] x = {1,2,3,4,5,6,7,8,9,10};
		
		int[] x = {1,3,3,4,7,8};
		
		int target = 7;
		
		solve3(x, target);
	        
	}
	
	// subset sum
	private static void solve3(int[] x, int target) 
	{
		
		
	}

	// n^2
	private static void solve2(int[] x, int target) {
		for(int i = 0; i < x.length; i++)
			for(int j = 0; j < x.length; j++)
				if(x[i] + x[j] == target && i != j)
					System.out.println((i+1) + " " + (j+1));
		
	}



	private static void solve(int[] c, int t) 
	{
		int[] o = new int[c.length + 1];
		for(int i = 0; i < c.length; i++)
		{
			o[i] = c[i];
		}
		
		for(int i = 0; i < c.length; i++)
		{
			int j = i;
			while( j > 0 && c[j-1] > c[j])
			{
				int temp = c[j];
				c[j] = c[j-1];
				c[j-1]= temp;
				j--;
			}
		}
				
		int pt1  = 0;
		int pt2 = c.length - 1;
		
		while(pt1 < pt2)
		{
			int sum = c[pt1] + c[pt2];

			if(sum == t)
			{
				int x = find(c[pt1], o) + 1;
				int y = find2(c[pt2], o) + 1;

				if(x < y)
					System.out.println(x + " " + y);
				else
					System.out.println(y + " " + x);
				
				return;
			}else if(sum > t)
			{
				pt2--;
			}
			else if(sum < t)
			{
				pt1++;
				pt2 = c.length - 1;	// better way than this?
			}
		}
		
	}

	private static int find2(int t, int[] c) {

		for(int i = c.length-1; i >= 0 ; i--)
			if(c[i] == t)
				return i;
			
		return -1;
	}

	private static int find(int t, int[] c) {

		for(int i = 0; i < c.length; i++)
			if(c[i] == t)
				return i;
		
		return -1;
	}

}
