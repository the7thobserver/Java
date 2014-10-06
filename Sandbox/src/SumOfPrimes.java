
public class SumOfPrimes {
	// Write a function that calculates the sum of all prime numbers between 1 and n.
	public int SumOfPrimes(int n)
	{
		int sum = 0;
		boolean isPrime = true;
		
		for(int i = 2; i <= n; i=i+2)
		{
			// i = 5
			// j  = 2 3 4
			
			for(int j = 2; j < i; j++)
			{
				//i / j = X remainder 0
				if(i%j == 0)
				{
					// boolean
					isPrime = false;
					break;
				}
			}
			
			// check boolean
			if(isPrime)
			{
				sum += i;
				isPrime = true;
			}
		}
		
		
		return sum;
	}
}
