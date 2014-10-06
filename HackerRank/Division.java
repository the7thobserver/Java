
public class Division 
{

	public static void main(String[] args)
	{
	    System.out.println(divide(10, 2));
        System.out.println(divide(100, 11));
        System.out.println(divide(1, 4));
        System.out.println(divide(5, 2));
        System.out.println(divide(5, 3));
        System.out.println(divide(1, 12));
        System.out.println(divide(1, 13));
        System.out.println(divide(1, 14));
        
	}
	
		// a / b
	public static String divide(int a, int b)
	{
		if(a < 0 && b < 0)
		{
			a = 0 - a;
			b = 0 - b;
		}
		if(b == 0)
			return "Invalid";
		
		if(a == 0)
			return "0";		
		
		
		int div = 0;
		int dec = 0;
		
		while(a-b < 0)
		{
			a = a * 10;
			dec++;
		}
		int precision = 1000;
		
		a *= precision;
		
		while(a-b >= 0)
		{
			a = a - b;
			div++;
		}
		
		//round based off last digit
		int last = div - ((int)(div / 10) * 10);
		
		double answer = (((double)div)/(Math.pow(10, dec)*precision));
		
		if(last >= 5)
		{
			// get 2nd to last digit add that place
			answer += (1/((Math.pow(10, dec-1)*precision)));
		}
		
		return answer + "";
	}
}
