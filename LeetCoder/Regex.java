
public class Regex 
{
	public static void main(String[] args)
	{
		System.out.println(isMatched("aa", "a"));
		System.out.println(isMatched("aa", "aa"));
		System.out.println(isMatched("aaa", "aa"));
		System.out.println(isMatched("aa", "a*"));
		System.out.println(isMatched("aa", ".*"));
		System.out.println(isMatched("ab", ".*"));
		System.out.println(isMatched("aab", "c*a*b*"));
		System.out.println(isMatched("ab", "a*c"));
		System.out.println(isMatched("aaa", "aaaa"));
		System.out.println(isMatched("a", "..a*"));
		System.out.println(isMatched("aaaaa", "a*"));
	}

	private static boolean isMatched(String s, String p) 
	{
		// . matches all except \n
		// *
		
		// straight up match
		if(s.matches(p))
			return true;
				
		char[] sc = s.toCharArray();
		char[] c = p.toCharArray();
		
		int i;
		int j = 0;
		
		// Go through regex
		for(i = 0 ; i < c.length; i++)
		{
			// make sure we're within the bounds of the regex and string
			if(j == sc.length && i != c.length)
				return false;
			
			// check dot
			if(c[i] == '.')
			{
				if(sc[j] != '\n')
				{
					j++;
					continue;
				}
				else
					return false;
			}
			else if(c[i] == '*')
			{
				// skip *
			}
			else if(c[i] == sc[j])
			{
				// check norms
				j++;
				continue;
			}
			else
			{
				// if not then it's not a match
				return false;
			}
		}
		
		return i == sc.length;
	}
}
