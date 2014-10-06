import java.util.ArrayList;
import java.util.HashMap;


public class WordCounter 
{
	public static void main(String[] args)
	{
		String s = "fieifre riririr";
		
		HashMap<String, Integer> map = count(s);
		
		int max = 0;
		ArrayList<String> a = new ArrayList<String>();
		
		for(String ss : map.keySet())
		{
			if(map.get(ss) > max)
			{
				max = map.get(ss);
				a.clear();
				a.add(ss);
			}
			else if(map.get(ss) == max)
			{
				a.add(ss);
			}
		}
		
		for(int i = 0; i < a.size(); i++)
		{
			System.out.println(a.get(i) + " " + max);
		}
		
	}
	
	private static HashMap<String, Integer> count(String s)
	{
		String[] exp = s.split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < exp.length; i++)
		{
			if(map.containsKey(exp[i]))
			{
				map.put(exp[i], map.get(exp[i]) + 1);
			}
			else
				map.put(exp[i], 1);
		}
		
		return map;
	}

}
