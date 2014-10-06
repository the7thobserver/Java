
public class Primes {
	public void find(int n)
	{
	// 3, 5, 7, 9
		if(n <= 4)
		{
			System.out.print(3);
		}
		else if(n <= 6)
		{
			System.out.print(3);
			System.out.print(5);
		}
		else if(n <= 8)
		{
			System.out.print(3);
			System.out.print(5);
			System.out.print(7);
		}
		else
		{
			System.out.print(3);
			System.out.print(5);
			System.out.print(7);
			System.out.print(9);
		}
		
			// ignore 0, 1, 2 because not prime
			for(int i = 3; i < n; i=i+2)
			{
				//3,5,7,9,11,13,15,17,19,21
				
				//3,5,7,9
				if(i%3 == 0)
				{
					continue;
				}
				if(i%5 == 0)
				{
				continue;
				}
				if(i%7 == 0)
				{
				continue;
				}
				if(i%9 == 0)
				{
				continue;
				}
				
				System.out.print(i + " ");
			}
	}
}
