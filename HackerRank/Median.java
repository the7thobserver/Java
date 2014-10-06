import java.util.Scanner;


public class Median {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	     int size = in.nextInt();
	     
	     int[] x = new int[size];
	     
	     for(int i = 0 ; i < size; i++)
	     {
	    	 x[i]= in.nextInt();
	     }
	     
	     
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
	     
	     System.out.println(x[size/2]);
	     
	}
}
