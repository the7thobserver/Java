import java.util.Scanner;


public class Rotate 
{
	public static void main(String[] args)
	{
		 Scanner in = new Scanner(System.in);
	     int size = in.nextInt();
	     
	     int[] input = new int[size];
	     
	     for(int i = 0; i < size; i++)
	     {
	    	 input[i] = in.nextInt();
	     }
	     
	    System.out.println( rotate(input) );
	}

	private static int rotate(int[] input) {
		int max = 0;
		
		for(int i = 0; i < input.length; i++)
		{
			int x = rotate(input, i);
			
			//System.out.println("  "+ i + " " + x);
			
			if( x > max)
				max = x;
		}
		return max;
	}

	private static int rotate(int[] input, int start) 
	{
		int sum = 0;
		int index = 1;
		
		for(int i = start; i < input.length + start; i++)
		{
			//System.out.println(((i%input.length)+1) + " " + input[i%input.length]);
			
			sum += index * input[i%input.length];
			index++;
		}
		
		return sum;
	}
}
