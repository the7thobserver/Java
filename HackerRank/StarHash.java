import java.util.HashMap;


public class StarHash 
{
	public static void main(String[] args)
	{
		String x = "*##*###**";
		
		char[] c = x.toCharArray();
		int[] q = new int[c.length];
		
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] == '*')
			{
				q[i] = -1;
			}
			else
			{
				q[i] = 1;
			}
		}
		
		int sum = 0;
		
		int longestFromBegin = 0;
		
		for(int i = 0; i < q.length; i++)
		{
			sum += q[i];
			
			if(sum == 0)
				longestFromBegin = i;
			
			q[i] = sum;
		}
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		// find substring - find all same
		int max = 0;
		for(int i = 0; i < q.length; i++)
		{
			if(!m.containsKey(q[i]))
			{
				m.put(q[i], i);
			}
			else
			{
				// store max
				max = Math.max(max, i - m.get(q[i]));
			}
		}
		
		System.out.println("Max: " + max);
		
		
		
	}

}
