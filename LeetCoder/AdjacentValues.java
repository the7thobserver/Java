import java.util.Arrays;


public class AdjacentValues 
{
	// http://www.careercup.com/question?id=5653018213089280
	
	public static void main(String[] args) {
		int[] a = {1,1,1,2,1,1,1};
		int n = 1;
		
		AdjacentValues x = new AdjacentValues();
		System.out.println(x.minAdgSum(a, n));
	}
	
	private int minAdgSum(int[] a, int n) {
		// find the largest number
		int maxIndex = findMax(a);
		// add outwards from the largest number
		a = countOut(a, maxIndex);
		
//		System.out.println(Arrays.toString(a));
		
		int min = Integer.MAX_VALUE;
		int minIndex = Integer.MIN_VALUE;
		
		// look right
		for(int i = maxIndex; i < a.length; i++)
		{
			if(a[i] >= n)
			{
				min = a[i];
				minIndex = i;
				break;
			}
				
		}
		

//		System.out.println(maxIndex + " " + minIndex);
		
		// look left
		for(int i = maxIndex; i >= 0; i--)
		{

			if(a[i] >= n)
			{
				min = a[i];
				minIndex = i;
				break;
			}
		}
		
//		System.out.println(maxIndex + " " + minIndex);
		
		// if not found
		if(minIndex == Integer.MIN_VALUE)
			return 0;
		
		return Math.abs(maxIndex - minIndex) + 1;
	}

	public int findMax(int[] a)
	{
		int max = -1;
		int ind = -1;
		
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > max)
			{
				max = a[i];
				ind = i;
			}
		}
		
		return ind;
	}
	
	public int[] countOut(int[] a,int start)
	{
		// right
		for(int i = start; i < a.length - 1; i++)
		{
			a[i + 1] = a[i] + a[i + 1];
		}
		
		// left
		for(int i = start; i > 0; i--)
		{
			a[i - 1] = a[i] + a[i - 1];
		}
		
		return a;
	}
}
