import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ModSum 
{
	public static void main(String[] args)
	{
		 Scanner scn=new Scanner(System.in);
	     int tests = scn.nextInt();
	
	     for(int i=0;i<tests;i++)
	     {
	         int max = scn.nextInt();
	         int mod = scn.nextInt();
	         sum(max, mod);
	     }
	}

	private static void sum(int max, int mod) {
		int sum = 0;
		
		for(int i = 1; i <= max; i++)
		{
			sum += i % mod;
		}

		System.out.println(sum);
	}
}
