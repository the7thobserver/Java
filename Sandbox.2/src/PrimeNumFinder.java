import java.util.Arrays;


public class PrimeNumFinder {
	public static void main(String[] args)
	{
		findPrime2(10);
	}
	
	// o(nlogn) run
	// o(n) space
	static void findPrime2(int n)
	{
		boolean[] primes = new boolean[n + 2];
		for(int i = 0; i < primes.length;i++)
			primes[i] = true;
		
		// ignore 0, 1
		int index = 2;
		
		for(int j = 2; j < n;j++) // 2 3 4 5 6
		{
			// 4 6 8
			for(int i = 2*j; i < primes.length; i=i+j)
			{
				primes[i] = false;
			}
			index++;
		}
			
		for(int i = 2; i < primes.length;i++)
			if(primes[i])
			System.out.println(i + " ");
	}
	
	// o(n^2) run
	// o(1) space
	private static void findPrime(int n) 
	{
		boolean isPrime = true;
		
		for(int i = 1; i <= n; i++)
		{
			for(int j = 2; j < i; j++)
			{
				if(i % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			
			if(isPrime)
				System.out.println(i + " ");
		     
			isPrime = true;
		}
		System.out.println("end.");
	}
	
}
