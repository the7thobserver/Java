import java.util.HashMap;


public class SingleNumber 
{
	 public int singleNumber_no_x_mem(int[] A) {
		 int r = 0;
		 
		 for(int i = 0; i < A.length; i++)
			r = r ^ A[i]; 
		 
		 return r;
	 }
	 
	 public int singleNumber(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < A.length; i++)
			if(map.containsKey(A[i]))
			{
				map.put(A[i], map.get(A[i]) + 1);
			}
			else
				map.put(A[i], 1);
		
		for(Integer i : map.keySet())
		{
			if(map.get(i) == 1)
				return i;
		}
		return -1;
	 }
}
