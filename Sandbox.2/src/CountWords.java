import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class CountWords 
{
	public static void main(String[] args)
	{
		HashMap<Character, Integer> invalid = new HashMap<Character, Integer>();
		invalid.put(',', 0);
		invalid.put('*', 0);
		invalid.put('[', 0);
		invalid.put(']', 0);
		invalid.put('!', 0);
		invalid.put(',', 0);
		invalid.put('.', 0);
		invalid.put(';', 0);
		invalid.put(':', 0);
		invalid.put('?', 0);
		invalid.put('/', 0);
		invalid.put('&', 0);
		invalid.put('-', 0);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		Scanner reader = null;
		try {
			reader = new Scanner(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();

		while(reader.hasNext())
		{
			sb.setLength(0);
			String word = reader.next().toLowerCase();
			char[] temp = word.toCharArray();
			
			
			for(int i = 0; i < temp.length; i++)
			{
				if(!invalid.containsKey(temp[i]))
				{
					sb.append(temp[i]);
				}
			}
			
			if(!sb.toString().equals(""))
				if(map.containsKey(sb.toString()))
					map.put(sb.toString(), map.get(sb.toString()) + 1);
				else
					map.put(sb.toString(), 1);
		}
		
		for(String s : map.keySet())
		{
			System.out.println("\"" + s + "\" " + map.get(s));
		}
		System.out.println("Total: " + map.size());
	}
}
