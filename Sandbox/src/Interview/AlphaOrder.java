package Interview;

import java.util.HashMap;

public class AlphaOrder {

	static char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
		'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z' };
	
	
	
	public static void main(String[] args) 
	{
		System.out.println(alphaOrder("abcd"));
		System.out.println(alphaOrder("efg"));
		System.out.println(alphaOrder("abce"));
		System.out.println(alphaOrder("abbuyf"));
		System.out.println(alphaOrder("BUFF"));
		
	}
	
	public static boolean alphaOrder(String s)
	{
		HashMap<Character, Integer> alphabeto = new HashMap<Character, Integer>();
		
		for(int i = 0; i < alphabet.length; i++)
			alphabeto.put(alphabet[i], i);
		
		char[] c = s.toLowerCase().toCharArray();
		int lastPos = alphabeto.get(c[0]);
		
		for(int i = 0; i < c.length; i++)
		{
			if(lastPos > alphabeto.get(c[i]))
				return false;
			
			lastPos = alphabeto.get(c[i]);
		}
		
		return true;
	}
}
