import java.util.ArrayList;


public class GCD 
{
	public ArrayList<Integer> findGCD(int i)
	{
		ArrayList<Integer> a = new ArrayList<Integer>(); 
		return findGCD(i, a);
	}
	
	private ArrayList<Integer> findGCD(int i, ArrayList<Integer> a)
	{
		for(int j = 2; j <= i;)
		{
			if(i == 1)
				break;
			
			if(i % j == 0)
			{
				a.add(j);
				i = i/j;
				j = 2;
			}
			else
				j++;
		}
		
		return a;
	}
}
