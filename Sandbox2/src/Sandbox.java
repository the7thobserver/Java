import java.util.ArrayList;
import java.util.HashMap;

public class Sandbox 
{
	static int[][] A = {{1,2,3,4},
						{12,13,14,5},
						{11,16,15,6},
						{10,9,8,7}};
		
	static int[] B = {5,3,7,2,1,-6,9};
	
	transient int x = 5;
	
	public static void main(String[] args)
	{
		StackUp s = new StackUp();
		s.stack(8);
		
		/*
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		PrimeChecker p = new PrimeChecker();
		
		for(int i = 0; i < 100; i++)
		{
			if(p.isPrime(i) == true)
				a.add(i);
		
			if(p.isPrime2(i) == true)
				b.add(i);
		}
		
		for(int i = 0; i < a.size(); i++)
			System.out.print(a.get(i) + " ");
		
		System.out.println();
		
		for(int i = 0; i < b.size(); i++)
			System.out.print(b.get(i) + " ");
		*/
	}
}
