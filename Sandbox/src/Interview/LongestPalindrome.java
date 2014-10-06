package Interview;

public class LongestPalindrome 
{
	public static void main(String[] args)
	{
		LongestPalindrome p = new LongestPalindrome();
		String s = "abccba";
		System.out.println(p.longestPalindrome(s.toCharArray(), 0, 5));
		s = "abc";
		System.out.println(p.longestPalindrome(s.toCharArray(), 0, s.length() - 1));
		s = "aa";
		System.out.println(p.longestPalindrome(s.toCharArray(), 0, s.length() - 1));
		s = "ab";
		System.out.println(p.longestPalindrome(s.toCharArray(), 0, s.length() - 1));
		s = "dddd";
		System.out.println(p.longestPalindrome(s.toCharArray(), 0, s.length() - 1));
	}

	public int longestPalindrome(char[] s, int start, int end)
	{
		if(start == s.length/2)
			return 0;
		
		if(start == end)
			return 1;
		
		if(s.length == 2)
			if(s[0] == s[1])
				return 2;
			else
				return 1;
		
		if(s[start] == s[end])
			return longestPalindrome(s, start + 1, end - 1) + 2;
		
		return Math.max(longestPalindrome(s, start + 1, end), longestPalindrome(s, start, end - 1));
	}
}
