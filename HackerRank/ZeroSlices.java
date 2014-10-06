import java.util.HashMap;

/*
 * Write a function: int countZeroSlices(int* arr); that returns number of slices in an array, 
 * which their sum is equal to 0. example: arr = {2, -2, 3, 0, 4, -7} slices that satisfy requirement 
 * are: (2,-2) (0), (3,4,-7), (2,-2,0,3,4,-7) so the function should return "4" slices. 
 * Solution must be O(n.Log(n)), where n is size of array
 * 
 */
public class ZeroSlices 
{
	
	public static void main(String[] args)
	{
		int[] a =  {4,  6,  3, -9, -5, 1, 3, 0, 2};
			//{2, -2, 3, 0, 4, -7};
		
		// n^2, 1 space
//		zeroSlices(a, 0, a.length);
		
		// n, n space
		zeroSlices2(a);
	}
	
	private static void zeroSlices2(int[] a) {
		int[] temp = new int[a.length];
		temp[0] = a[0];
		
		for(int i = 1; i < temp.length; i++)
		{
			temp[i] = temp[i - 1] + a[i];
		}		
		
		// sum to 0 from the start
		for(int i = 1; i < temp.length; i++)
		{
			if(temp[i] == 0)
			{
				print(a, i);
			}
		}
		
		// sum in the middle
		// find same index
		// index, amount
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		// index, start
		HashMap<Integer, Integer> m2 = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < a.length; i++)
		{
			if(m.containsKey(temp[i]))
			{
				m.put(temp[i], m.get(temp[i]) + 1);
			}
			else
			{
				m.put(temp[i], 1);
				m2.put(temp[i], i);
		}}


		for(Integer i : m.keySet())
		{
			if(m.get(i) >= 2)
				findMatch(a, i, m2, temp);
		}
			
	}

	private static void findMatch(int[] a, Integer d, HashMap<Integer, Integer> m2, int[] temp) {
		for(int i = m2.get(d) + 1	; i < a.length; i++)
		{		
			System.out.print(a[i] + " ");

			if(temp[i] == d)
				break;
		}
		System.out.println();
	}



	private static void print(int[] a, int end) {
		for(int i = 0; i < end + 1; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void zeroSlices(int[] a, int start, int end) 
	{
		MergeSort m = new MergeSort();
		a = m.sort(a);
		
		if(start == end)
			return;
		
		int sum = 0;
		
		for(int i = start; i < end; i++)
		{
			sum += a[i];
		}
		
		if(sum == 0)
		{
			for(int i = start; i < end; i++)
			{
				System.out.print(a[i] + " ");
			}
			System.out.println();
			zeroSlices(a, start, end - 1);
			
		}
		else if(sum < 0)
			zeroSlices(a, start + 1, end);
		else if(sum >0)
			zeroSlices(a, start, end - 1);
	}

}
