import java.util.ArrayList;
import java.util.Scanner;


public class ClosestNumber 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	     int size = in.nextInt();
	     
	     int[] x = new int[size];
	     
	     for(int i = 0 ; i < size; i++)
	     {
	    	 x[i]= in.nextInt();
	     }
	    
	     // sort
	     for(int i = 0; i < size; i++)
	     {
	    	 int j = i;
	    	 while(j > 0 && x[j-1] > x[j])
	    	 {
	    		 int temp = x[j];
	    		 x[j] = x[j-1];
	    		 x[j - 1] = temp;
	    		 j--;
	    	 }
	     }
	     
//	     for(int i = 0; i < x.length; i++)
//	    	 System.out.println(x[i]);
	     
	     // difference
	     int min = Integer.MAX_VALUE;
	     
	     // save values
	     ArrayList<Integer> s = new ArrayList<Integer>();
	     
	     // upto 2nd last
	     for(int i = 1; i < x.length; i++)
	     {
	    	 int a = x[i-1] - x[i];
//	    	 System.out.println(Math.abs(a));
	    	 
	    	 if(Math.abs(a) == min)
	    	 {
	    		 s.add(x[i-1]);
	    		 s.add(x[i]);
	    	 }
	    	 if(Math.abs(a) < min)
	    	 {
	    		 min = Math.abs(a);
	    		 s.clear();
	    		 s.add(x[i-1]);
	    		 s.add(x[i]);
	    	 }
	     }
	     
//	     System.out.println(min + " " + s.size());
	     
	     for(int i = 0; i < s.size(); i++)
	    	 System.out.print(s.get(i) + " ");
	     
	}
	
	
}
