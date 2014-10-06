
public class StackUp 
{
	public void stack(int n)
	{
		int maxLength = 2 * n - 1;
		int stars = 0;
		int num = n;
		
		// Height
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < stars; j++)
				System.out.print("*");
			
			for(int j = 0; j < num; j++)
			{
				System.out.print(num);
				
				if(j != num - 1)
					System.out.print("*");
			}
			
			for(int j = 0; j < stars; j++)
				System.out.print("*");
			
			num--;
			stars++;
			System.out.println();
		}
	}

}
