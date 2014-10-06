import java.util.ArrayList;
import java.util.Arrays;


public class LongestPalindrome 
{
	public static void main(String[] args)
	{
		LongestPalindrome l = new LongestPalindrome();
//		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//		System.out.println(l.longestPalindrome(s));
		String s = "aaa";
		System.out.println(l.longestPalindromeDP(s));
	}
	
	// n^2 - clumped together
	public String longestPalindrome_2(String s)
	{
		char[] c =s.toCharArray();
		int start = 0;
		int end = 0;
		
		for(int mid = 0; mid < c.length; mid++)
		{			
			int left = mid;
			int right = mid;
			
			while(left >= 0 && right < c.length)
			{
				if(c[left] == c[right])
				{
					if(right - left > end - start)
					{
						start = left;
						end = right;
					}
				}
				left--;
				right++;
			}
			
			left = mid;
			right = mid + 1;
			
			while(left >= 0 && right < c.length)
			{
				if(c[left] == c[right])
				{
					if(right - left > end - start)
					{
						start = left;
						end = right;
					}
				}
				left--;
				right++;
			}
			
		}
		
		return s.substring(start, start + end+1);
	}
	
	public String longestPalindromeDP(String s) {
		// n = length of string
		  int n = s.length();
		  
		  int longestBegin = 0;
		  int maxLen = 1;
		  
		  // table 
		  boolean table[][] = new boolean[n][n];
		  // init all to false
		  for(int i = 0; i < table.length; i++)
			  for(int j = 0; j < table.length; j++)
				  table[i][j] = false;
		  
		  // init diagnal to true
		  for (int i = 0; i < n; i++) {
		    table[i][i] = true;
		  }
		  
		  char[] c = s.toCharArray();
		  
		  for (int i = 0; i < n-1; i++) {
		    if (c[i] == c[i+1]) {
		      table[i][i+1] = true;
		      longestBegin = i;
		      maxLen = 2;
		    }
		  }
		  
		  print2D(table);
		  
		  
		  for (int len = 3; len <= n; len++) {
		    for (int i = 0; i < n-len+1; i++) {
		      int j = i+len-1;
		      if (c[i] == c[j] && table[i+1][j-1]) {
		        table[i][j] = true;
		        longestBegin = i;
		        maxLen = len;
		      }
		    }
		  }

		  print2D(table);
		  return s.substring(longestBegin, longestBegin + maxLen);
		}
	

	
	private void print2D(boolean[][] table) {
		System.out.println("--");
		for(int i = 0; i < table.length; i++)
		{
			for(int j = 0; j < table.length; j++)
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		
	}



	// exponential runtime b/c redo alot of work
	boolean isOdd = false;
	
	public String longestPalindrome(String s) {
		isOdd = false;
		ArrayList<Character> pal = new ArrayList<Character>();
		longestPalindrome(s, pal, 0, s.length() - 1);
		
		//System.out.println(pal.size());
		
		return createPal(pal);
	}

	private String createPal(ArrayList<Character> pal) {
		String s1 = "";
		
		if(!isOdd)
		{
			// Create palindrome from 1/2 even
			for(int i = 0; i < pal.size(); i++)
				s1 += pal.get(i);
			for(int i = pal.size() - 1; i >= 0; i--)
				s1 += pal.get(i);
		}
		else if(isOdd)
		{
			for(int i = 0; i < pal.size(); i++)
				s1 += pal.get(i);
			for(int i = pal.size() - 2; i >= 0; i--)
				s1 += pal.get(i);
		}
				
		return s1;
	}

	// exp...
	private ArrayList<Character> longestPalindrome(String s, ArrayList<Character> pal, int start, int end) {
		if(start > end)
			return pal;
		
		char[] c = s.toCharArray();
		
		if(start == end)
		{
			isOdd = true;
			pal.add(c[start]);
			return pal;
		}
		
		ArrayList<Character> x = new ArrayList<Character>();
		
		int p = start;
		int p1 = end;
		
		//System.out.println(c[p] + " "+ c[p1]);
		
		if(c[p] == c[p1])
		{
			pal.add(c[p]);
			pal.addAll(longestPalindrome(s, x, start + 1, end - 1));
		}
		else
		{
			ArrayList<Character> y = new ArrayList<Character>();
			
			ArrayList<Character> temp = longestPalindrome(s, x, start + 1, end);
			ArrayList<Character> temp2 = longestPalindrome(s, y, start, end - 1);
			
			if(temp.size() > temp2.size())
				pal.addAll(temp);
			else
				pal.addAll(temp2);
		}
		
		return pal;
    }
}
