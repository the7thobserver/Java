import java.util.Scanner;


public class partition2 
{
	
	public static void main(String[] args)
	{
		 Scanner in = new Scanner(System.in);
	     int t = in.nextInt();
	     
	     // loop over t
	     for(int run = 0; run < t; run++)
	     {
	    	 int size = in.nextInt();
	    	 
	    	 int ar[] = new int[size];
	    	 
	    	 for(int i = 0; i < size; i++)
		     {
		    	 ar[i] = in.nextInt();
		     }
	    	 
	    	 int i = find(ar);
	    	 
	    	 if(i == 0)
	    		 System.out.println("YES");
	    	 else
	    		 System.out.println("NO");
	    	 
	     }
	}
	
	// sorted ar
	public static int find(int[] ar)
	{
		int sum = ar[0];
		
		if(sum == ar[1])
			return 0;


		for(int i = 1; i < ar.length; i++)
		{
			sum += ar[i];
			
			if(sum == ar[i + 1])
				return 0;
		}
		
		return -1;
	}

}
