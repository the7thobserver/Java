import java.util.HashMap;

/*
 * 

e.g. [1, 2, 3, 1, 4, 5, 6, 7, 8, 6, 1, 8, 8] returns [1,8]

Do this in max: O(n)

 */
public class TopFreq {
	
	public static void main(String[] args)
	{
		int[] x = {1, 2, 3, 1, 4, 5, 6, 7, 8, 6, 1, 8, 8};
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < x.length; i++)
		{
			if(m.containsKey(x[i]))
			{
				m.put(x[i], m.get(x[i]) + 1);
			}
			else
				m.put(x[i], 1);
		}
		
//		for(Integer i : m.keySet())
//		{
//			System.out.println(x[i] + " " + m.get(x[i]));
//		}
		
		getTopN(m, 2);
	}

	private static void getTopN(HashMap<Integer, Integer> m, int t) {
		int max = 0;
		int c = -1;
		
		for(int i = 0; i < t; i++)
		{
			max = 0;
			for(Integer j : m.keySet())
			{
				if(m.get(j) > max)
				{
					max = m.get(j);
					c = j;
				}
			}
			m.remove(c);
			System.out.print(c + " ");
		}
	}
}
