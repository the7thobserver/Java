import java.util.Scanner;


public class Solution 
{
	public static void main(String[] args)
	{
		 Scanner in = new Scanner(System.in);
	     int t = in.nextInt();
	     
	     if(t < 1 || t > 10)
	    	 return;
	     
	     // loop over t
	     for(int run = 0; run < t; run++)
	     {
		     int size = in.nextInt();
		     int k = in.nextInt();
		     
		     int ar[] = new int[size];
		     int ar2[] = new int[size];
		     
		     for(int i = 0; i < size; i++)
		     {
		    	 ar[i] = in.nextInt();
		     }
		     
		     for(int i = 0; i < size; i++)
		     {
		    	 ar2[i] = in.nextInt();
		     }
		     
		     calculate(ar, ar2, k);
	     }
	}
	
	static void calculate(int[] ar, int[] ar2, int k)
	{
		int[] merged = sort(ar,ar2);
		
		if(merged.length % 2 != 0)
		{
			System.out.println("NO");
			return;
		}
		
		// go back and compare
		for(int i = 0; i < merged.length/2; i++)
		{
			if(merged[i] + merged[merged.length - 1 - i] < k)
			{
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	static int[] sort(int[] ar, int[] ar2)
	{
		int merged[] = new int[ar.length + ar2.length];
		
		for(int i = 0 ; i<ar.length; i++)
		{
			merged[i] = ar[i];
		}
		
		for(int i = ar.length; i<merged.length; i++)
		{
			merged[i] = ar2[i - ar.length];
		}
		

    	for(int i = 1; i < merged.length; i++)
    	{
    		int j = i;
    		while(j > 0 && merged[j-1] > merged[j])
    		{
    			int temp = merged[j-1];
    			merged[j - 1] = merged[j];
    			merged[j] = temp;
    			
    			j--;
    		}
    	}
    	
    	return merged;
    	
	}
	
	 private static void printArray(int[] ar) {
	      for(int n: ar){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	   }

}
