import java.util.HashMap;


public class TestBox 
{
	public void findMatches()
	{
		int[] arr = {1,2,3,4,5,6};
		int target = 6;
		
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++)
			h.put(arr[i], arr[i]);
		
		for(int i = 0; i < arr.length; i++)
		{
			//System.out.println(arr[i] + " " + h.get(target - 1 - i));
			if(h.get(target - 1 - i) != null)
				if(arr[i] + h.get(target - 1 - i) == target)
				{
					System.out.println(i + " " + (target - i));
				}
		}
	}
}
