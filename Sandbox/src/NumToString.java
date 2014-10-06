
public class NumToString 
{
	public static void main(String[] args)
	{
		NumToString x = new NumToString();
		int val = 1210;
		System.out.println("ANS: " + x.convert(val));
	}
	
	public StringBuilder convert(int val)
	{
		StringBuilder ans = new StringBuilder();
		char[] c = Integer.toString(val).toCharArray();
		
		// Go over all the digits
		for(int i = 0; i < c.length; i++)
		{	
			// If 10/20/etc, single digit followed by zeroes, don't need to process anymore
			for(int j = i; j < c.length; j++)
			{
				if(c[j] != '0')
					break;
				
				if(j == c.length - 1)
					return ans;
			}
			
			// If it's a teen
			if(c.length - i == 2)
			{
				boolean found = getTeenPlace(c[i], c[i] + "" + c[i+1], ans);
			
				// if we found 11-19, done
				if(found)
					return ans;
			}
			else
				getDigit(c[i], ans);
			
			// Find the place, ten, hundred, thousand
			getPlace(c.length - i, ans);
		}
		
		return ans;
	}

	private boolean getTeenPlace(char v, String c, StringBuilder ans) {
		switch(Integer.parseInt(v + ""))
		{
			case 1:
				getTeen(c, ans);
				return true;
			case 2:
				ans.append(" twenty");
				return false;
			case 3:
				ans.append(" thirty");
				return false;
			case 4:
				ans.append(" fourty");
				return false;
			case 5:
				ans.append(" fifty");
				return false;
			case 6:
				ans.append(" sixty");
				return false;
			case 7:
				ans.append(" seventy");
				return false;
			case 8:
				ans.append(" eighty");
				return false;
			case 9:
				ans.append(" ninty");
				return false;
		}
		
		return false;
	}
		
	private void getTeen(String c, StringBuilder ans)
	{
		switch(Integer.parseInt(c))
		{
		case 10:
			ans.append(" ten");
			break;
		case 11:
			ans.append(" eleven");
			break;
		case 12:
			ans.append(" twelve");
			break;
		case 13:
			ans.append(" thirteen");
			break;
		case 14:
			ans.append(" fourteen");
			break;
		case 15:
			ans.append(" fifteen");
			break;
		case 16:
			ans.append(" sixteen");
			break;
		case 17:
			ans.append(" seventeen");
			break;
		case 18:
			ans.append(" eighteen");
			break;
		case 19:
			ans.append(" nineteen");
			break;
		}
	}
	

	private void getPlace(int i, StringBuilder ans) {
		if(i == 4)
		{
			ans.append(" thousand");
		}
		else if(i == 3)
		{
			ans.append(" hundred");
		}
	}
	
	private void getDigit(char c, StringBuilder ans) {	
		
		switch(Integer.parseInt(c + ""))
		{
		case 0:
			ans.append(" zero");
			break;
		case 1:
			ans.append(" one");
			break;
		case 2:
			ans.append(" two");
			break;
		case 3:
			ans.append(" three");
			break;
		case 4:
			ans.append(" four");
			break;
		case 5:
			ans.append(" five");
			break;
		case 6:
			ans.append(" six");
			break;
		case 7:
			ans.append(" seven");
			break;
		case 8:
			ans.append(" eight");
			break;
		case 9:
			ans.append(" nine");
			break;
		}
	}
}
