package Interview;

public class CoinChange
{
	// C(P) = min over i [C(P-Vi)} + 1
	// V = coins
	
	static int[] coins = {1,5,10,25};
	static int amount = 30;
	
	public static void main(String[] args)
	{
		change();
	}
	
	public static void change()
	{
		int[] C = new int[amount + 1];
		int[][] Cu = new int[amount + 1][coins.length];
		int min;
		
		int[] CoinsUsed = new int[coins.length];
		
		// 1 -> amount
		for(int p = 1; p < amount + 1; p++)
		{
			min = Integer.MAX_VALUE;
			
			// Go over all coins
			for(int i = 0; i < coins.length; i++)
			{
				// Look at coins < amount
				if(coins[i] <= p)
					if(1 + C[p-coins[i]] < min)
					{
						min = 1 + C[p-coins[i]];
						// CoinsUsed =coins[i] + Cu[p-coins[i]
						CoinsUsed = Cu[p-coins[i]].clone();
						CoinsUsed[i] += 1;	// Add the used coin
					}
				
				C[p] = min;
				// Cu[p] = CoinsUsed
				Cu[p] = CoinsUsed.clone();
			}
		}
		
		// Output
		System.out.println("Amount | # Coins | 1 5 10 25");
		
		for(int i = 0; i < C.length; i++)
		{
			System.out.printf("%d\t%d\t   ",i, C[i]);
			
			for(int k = 0; k < coins.length; k++)
					System.out.print(Cu[i][k] + " " );
			
			System.out.println();
		}
	}
}
