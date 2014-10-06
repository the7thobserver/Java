import java.util.HashMap;


public class PairsOfElements 
{
	public static void main(String[] args)
	{
		//int[] ar = {0,2,4,2,4,2};
		int[] ar = {0, 2, 4, 2,4,2,2};
		// 0 2 2 2 4 4
		// 2 2 = 1
		// 2 2 2 = 2
		// 2 2 2 2 = 3
		// 2 2 2 2 2 = 4 
		
		System.out.println(countDuplicates(ar));
	}

	private static int countDuplicates(int[] ar) 
	{
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < ar.length; i++)
		{
			if(m.containsKey(ar[i]))
			{
				m.put(ar[i], m.get(ar[i]) + 1);
			}
			else
				m.put(ar[i], 1);
		}
		
		int count = 0;
		for(Integer i : m.keySet())
		{
			if(m.get(i) == 2)
				count++;
			else if(m.get(i) > 2)
				count += m.get(i) - 1;
				
		}
		
		return count;
	}

	
}
