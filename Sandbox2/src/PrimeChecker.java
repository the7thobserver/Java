
public class PrimeChecker 
{
	public boolean isPrime(int num){
		int i;
		
		if(num <= 1) return false;
		
		for(i = 2; i*i <= num; i++){
			if( num%i == 0) return false;
		}
		return true;
	}

	
	// Me
	public boolean isPrime2(int n)
	{
		if(n <= 1)
			return false;
		
		for(int i = 2; i < n; i++)
			if(n % i == 0)
				return false;
		
		return true;
	}
}
