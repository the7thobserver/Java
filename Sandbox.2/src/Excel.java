import java.util.ArrayList;


public class Excel 
{
	static char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
		'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
		'w', 'x', 'y', 'z' };

	public static ArrayList<Character> c = new ArrayList<Character>();
	
	public static void main(String[] args)
	{
		// alphabet 1 -> 26
		int size = 5916;
		
		while(size >= 26)
		{
			size = getLetter(size);	
		}
		
		if(size < 26)
			c.add(alphabet[size]);
		
		for(int i = c.size() - 1; i >= 0; i--)
			System.out.print(c.get(i));
	}
	
	public static int getLetter(int i)
	{
		int temp = i;
		int count = 0;
		
		while(temp >= 26)
		{
			count = temp / 26;
			temp = temp - count * 26;
		}
		
		c.add(alphabet[temp]);
		
		return count - 1;
	}
}
