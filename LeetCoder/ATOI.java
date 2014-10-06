public class ATOI {
	public static void main(String[] args) {
		ATOI r = new ATOI();
		
		String str = " 10114463838o";
		System.out.println(r.atoi(str));
		
	}
	
	// A C function
	public int atoi(String str)
	{
		// If nothing there return 0...
		if(str == null || str.length() == 0)
			return 0;
		
		// Remove leading and trailing white spaces
		str = str.trim();
		
		char[] c = str.toCharArray();
		String num = "";	// Will create integer
		int i = 0;			// Loop index
		
		// Determine if positive/negative
		if(c[0] == '+' || c[0] == '-')
			i = 1;
		
		// Loop over the string, converting to numbers
		for(; i < c.length; i++)
		{
			try
			{
				num += Integer.parseInt(c[i] + "");	// Note could have used a switch/default break so wouldn't have
													// to call Integer.parseInt(...) :P
			}
			catch(Exception e)	// If cannot convert, end parsing
			{
				break;
			}
		}
		
		// If we couldn't convert anything, return 0
		if(num.equals(""))
			return 0;
		
		int ans = -1;
		
		// Try to convert to integer
		try{
			ans = (Integer.parseInt(num));
		}catch(Exception e)
		{
			// Substring 2nd index to end
			int temp = Integer.parseInt(num.substring(1));
			
			// If begining number > max integer, return max
			if(num.length() > 10)
				if(c[0] == '-')
					return -2147483648;
				else
					return 2147483647;
			
			// Bounds stuff
			if(Integer.parseInt(num.substring(0,1)) >= 2)	// Biggest term is 2
			{
				if(temp > 147483647)	// subterms 
					if(c[0] == '-')
						return -2147483648;
					else
						return 2147483647;
			}
			
		}
		
		// Negative?
		if(c[0] == '-')
			return -ans;
			
		return ans;
	}
}
