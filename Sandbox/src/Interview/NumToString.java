package Interview;

public class NumToString 
{
	// look at the one in ....LeetCoder 
	public static void main(String[] args)
	{
		numToString(10);
	}
	
	public static void numToString(int n)
	{
		String s = Integer.toString(n);
		
		System.out.println(s);
			
		for(int i = 0; i < s.length(); i++)
		{
//			System.out.println("ITER " + i);
			int temp = findLocation(s, s.length() - i);
			
			i = s.length() - temp;
			
			
//			System.out.println("ITER " + i);
			
		}
	}

	private static int findLocation(String s, int i) 
	{
//		System.out.println("Looking at " + i);
		if(i == 4)
		{
			digit(s, i - 4);
			System.out.print(" thousand");
		}
		else if(i == 3)
		{
			digit(s, i-3);
			System.out.print(" hundred");
		}
		else if(i == 2)
		{
//			System.out.println("TEENDIGI " + s.substring(i-1, i));
			int v = Integer.valueOf(s.substring(i-1,i));
			
			switch(v)
			{
			case 1:
//				System.out.println("CASE");
				teens(s, i);
				return i - 1;
			case 2:
				System.out.print(" twenty");
				break;
			case 3:
				System.out.print(" thirty");
				break;
			case 4:
				System.out.print(" fourty");
				break;
			case 5:
				System.out.print(" fifty");
				break;
			case 6:
				System.out.print(" sixty");
				break;
			case 7:
				System.out.print(" seventy");
				break;
			case 8:
				System.out.print(" eighty");
				break;
			case 9:
				System.out.print(" ninty");
				break;
			default:
				digit(s, i);
			}
		}
		else if(i == 1)
			digit(s, i-1);

		return i;
	}

	private static void digit(String s, int i)
	{
		if(s.length() == 1)
		{
			System.out.println(Integer.valueOf(s));
			return;
		}
		
//		System.out.println(s.substring(i,i+1));
		
		switch(Integer.valueOf(s.substring(i,i+1)))
		{
		case 0:
			System.out.print(" zero");
			break;
		case 1:
			System.out.print(" one");
			break;
		case 2:
			System.out.print(" two");
			break;
		case 3:
			System.out.print(" three");
			break;
		case 4:
			System.out.print(" four");
			break;
		case 5:
			System.out.print(" five");
			break;
		case 6:
			System.out.print(" six");
			break;
		case 7:
			System.out.print(" seven");
			break;
		case 8:
			System.out.print(" eight");
			break;
		case 9:
			System.out.print(" nine");
			break;
		}
	}
	
	private static void teens(String s, int i) 
	{
//		System.out.println("TEENS " + i);
//		System.out.println(Integer.valueOf(s.substring(i-2,i)));
		
		switch(Integer.valueOf(s.substring(i - 2,i)))
		{
		case 10:
			System.out.println(" ten");
			break;
		case 11:
			System.out.print(" eleven");
			break;
		case 12:
			System.out.print(" twelve");
			break;
		case 13:
			System.out.print(" thirteen");
			break;
		case 14:
			System.out.print(" fourteen");
			break;
		case 15:
			System.out.print(" fifteen");
			break;
		case 16:
			System.out.print(" sixteen");
			break;
		case 17:
			System.out.print(" seventeen");
			break;
		case 18:
			System.out.print(" eighteen");
			break;
		case 19:
			System.out.print(" nineteen");
			break;
		}
	}
}
