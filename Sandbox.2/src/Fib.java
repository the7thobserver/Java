import java.util.Arrays;


public class Fib 
{
	public static void main(String[] args)
	{
		int target = 38;
//		for(int i = 1; i <= target; i++)
//			System.out.print(fib(i) + " ");
		
		getFib(38);
	}

	private static void getFib(int s)
	{
		int[] x = new int[s];
		x[0] = 1;
		x[1] = 1;
		
		for(int i = 2; i < x.length; i++)
		{
			x[i] = x[i-1] + x[i-2];
		}
		
		System.out.println(Arrays.toString(x));
	}

	private static int fib(int i) {
		if(i <= 0)
		{
			System.out.println("ERROR");
			return 0;
		}
		if(i == 1 || i == 2)
		{
			//System.out.print("1 ");
			return 1;
		}
		
		int ans = fib(i -1) + fib(i - 2);
		
		return ans;
	}

}
