import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;


public class THEMAIN
{
	public static void main(String[] args) throws FileNotFoundException
	{
	
	}
	
	public static int GCD(int a, int b)
	{
		ArrayList<Integer> factorsA = new ArrayList<Integer>();
		ArrayList<Integer> factorsB = new ArrayList<Integer>();
		
		factorsA = getFactors(a, factorsA);
		factorsB = getFactors(b, factorsB);
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < factorsA.size(); i++)
		{
			// System.out.print(factorsA.get(i) + " ");
			if(!map.containsKey(factorsA.get(i)))
				map.put(factorsA.get(i), 1);
			else
				map.put(factorsA.get(i), map.get(factorsA.get(i)) + 1);
		}
		
//		System.out.println();
		
		int factor = 1;
		
//		for(Integer i : map.keySet())
//			System.out.println(i + " " + map.get(i));
		
		
		for(int i = 0; i < factorsB.size(); i++)
		{
			// System.out.print(factorsB.get(i) + " ");
			if(map.containsKey(factorsB.get(i)) && map.get(factorsB.get(i)) > 0)
			{
				factor *= factorsB.get(i);
				map.put(factorsB.get(i), map.get(factorsB.get(i)) - 1);
			}
		}
		
		System.out.println("GCD of " + a + " & " + b + " is " + factor);
		return factor;
	}
	
	public static ArrayList<Integer> getFactors(int n, ArrayList<Integer> a)
	{
		int prev = n;
		
		// Squares?
		
		while(!isPrime(n))
		{	
			if(n == 1)
				return a;
			
			if(n % 2 == 0) 
			{
				a.add(2);
				n = n / 2;
			}
			
			for(int i = 3; i <= n; i+=2)
			{
				if(n % i == 0 && isPrime(i))
				{
					a.add(i);
					n = n / i;
				}
			}
			
			if(isPrime(n))
				a.add(n);
		}
		
		return a;
	}
	
	public static boolean isPrime(int n)
	{
		if(n == 1) return false;
		if(n / 2 == 1) return true;
		if(n % 2 == 0) return false;
			
		for(int i = 3; i < n; i += 2)
		{
			if(n % i == 0)
				return false;
		}
		return true;
	}
	
	public static int sumOfPrimes(int n)
	{
		if(n == 1) return 0;
		if(n == 2) return 2;
		
		int sum = 2;
		
		for(int i = 3; i <= n; i+=2)
		{
			if(isPrime(i))
				sum+=i;
		}
		
		return sum;
	}
	
	public static void problem5()
	{
		// Find prime factors and multiply it out
		
		// start 2520
		for(int i = 2520; i < Integer.MAX_VALUE; i+=2)
		{
			//if(i % 2 == 0)
				if(i % 3 == 0)
					//if(i % 4 == 0)
						if(i % 5 == 0)
							//if(i % 6 == 0)
								if(i % 7 == 0)
									//if(i % 8 == 0)
										if(i % 9 == 0)
											//if(i % 10 == 0)
												if(i % 11 == 0)
													if(i % 12 == 0)
														if(i % 13 == 0)
															if(i % 14 == 0)
																if(i % 15 == 0)
																	if(i % 16 == 0)
																		if(i % 17 == 0)
																			if(i % 18 == 0)
																				if(i % 19 == 0)
																					if(i % 20 == 0)
																					{
																						System.out.println(i);
																						break;
																					}
		}
	}
	
	public static void problem4()
	{
		 int value = 0;
	        for(int i = 999;i >= 100;i--)
	        {
	            for(int j = 999;j >= 100;j--)
	            {
	                int value1 = i * j;
	                StringBuilder sb1 = new StringBuilder(""+value1);
	                String sb2 = ""+value1;
	                sb1.reverse();
	                if(sb2.equals(sb1.toString()) && value<value1) {
	                    value = value1;
	                    System.out.println(i + " " + j);
	                    
	                }

	            }
	        }
	        System.out.println(value);
	}
	
	public static void problem3(long n)
	{
		for(long i = 2; i <= n; i++)
		{
			if(isPrime(i))
			{
				if(n % i == 0)
				{
					System.out.println(i);
					n = n/i;
				}
			}
		}
	}
	
	public static boolean isPrime(long n)
	{
		for(long i = 2; i < n; i++)
		{
			if(n % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void problem2()
	{
		long[] fib = new long[4000000];
		long sum = 0;
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i < 4000000; i++)
		{
			fib[i] = fib[i - 1] + fib[i - 2];
			
			if(fib[i] >= 4000000)
				break;
			
			if(fib[i] % 2 == 0)
				sum += fib[i];
		}
		
		System.out.println("SUM " + sum);
	}
	
	public static void problem1()
	{
		int sum = 0;
		for(int i = 0; i < 1000; i++)
		{
			if(i % 3 == 0)
				sum += i;
			else if(i % 5 == 0)
				sum += i;
		}
		
		System.out.println(sum);
	}
	
	public static void isSq(int x)
	{
		double y  = x/2;
		System.out.println((int) y);
		
		//decimals
		
	}
	
	public static void permute(ArrayList<Integer> x, ArrayList<Integer> p)
	{
		if(x.size() == 2)
		{
			System.out.println(p.toString() + x.get(0) + "," + x.get(1));
			System.out.println(p.toString() + x.get(1) + "," + x.get(0));
			return;
		}

		ArrayList<Integer> o = new ArrayList<Integer>();

		for(int q : x) {
		    o.add(q);
		}
		
		for(int i = 0; i < o.size(); i++)
		{
			p.clear();

			//x=o;
			
			p.add(x.get(i));
			x.remove(i);
			
			permute(x,p);
		}
	}
	
	private static void toBinary(double x)
	{
		int y = (int) x;
		
		double d = x - y;
		
		toBinaryD(y);
		System.out.print(".");
		toBinaryDD(d, 10);
	}
	
	private static void toBinaryDD(double d, int x)
	{
		if(x == 0)
			return;
		
		d = d * 2;
		int z = (int) d;
		System.out.print(z);
		toBinaryDD(d, x-1);
	}
	
	private static void toBinaryD(int num)
	{
		int rem = -1;
		
		if(num > 0)
		{	
			rem = num % 2;
			num = num / 2;
			toBinaryD(num);
			System.out.print(rem);
		}
	}
	
	private static ArrayList<String> list(HashMap<String, String>  m, ArrayList<String> o, String s)
	{
		if(m.containsKey(s))
		{
			o.add(m.get(s));
			list(m, o, m.get(s));
		}
		else
		{
			if(o.size() == m.size() + 1)
				return o;
			else
			{
				o.clear();
				o.add("failed");
				return o;
			}
		}

		return o;	
	}
	
	private static void pow(int i, int j) {
		boolean neg = false;
		
		if(i == 0)
		{
			System.out.println("0");
			return;
		}
		if(j == 1)
		{
			System.out.println(i);
			return;
		}
		if(j < 0){
			neg = true;
			j=-j;
		}
		
		int temp = i;
		
		for(int z = 1; z < j; z++)
			temp *= i;
		
		if(neg)
			System.out.println("1/"+temp);
		else
		
		System.out.println(temp);
	}

	private static void printWellOrdered(int number, int prev, int n) {

		if(n==0){
		System.out.println(number);
		return;
		}

		for(int i=(prev+1); i<(11-n); i++){
		printWellOrdered(number*10 + i, i, n-1) ;
		}

		}
	
	
	private static void wellOrder(int start, int size, int num)
	{
		if(size <= 0)
		{
			System.out.println(num);
			return;
		}
		
		
		
		for(int i = (start + 1); i < 10; i++)
			wellOrder(i, size-1, num*10+i);
	
	}

	private static void binary(int i) {
		if(i >= 1)
		{
			binary(i/2);
			System.out.print(i%2);
			
		}		
	}

	public static void threeWayPartition(char data[], int size)
	{
		
		//
//		char x[] = {'r','r','g','g','b','r','r','r','g','g','b','b','b','g','g','r'};
		
//		threeWayPartition(x, x.length);
//		int isG = 0;
//		int end = x.length - 1;
//		int[] g = {0,0,0,0};
//	
//		for(int i = 0; i < end;)
//		{
//			if(x[i] == 'r')
//			{
//				x[i] = x[isG];
//				x[isG] = 'r';
//				
//				isG++;
//				i++;
//			}
//			else if(x[i] == 'b')
//			{
//				x[i] = x[end];
//				x[end] = 'b';
//				end--;
//			}
//			else
//			{
//				i++;
//			}
//			for(int j = 0; j < x.length; j++)
//				System.out.print(x[j] + " ");
//			System.out.println();
//		}
//		
//		wellOrder(0,3,0);
//		printWellOrdered(0,0,2); // 4 digit numbers 
		//
	  	int p = 0;
	  	int q = size-1;
	  	int i ;

	 	char t;
	        for ( i = 0; i <= q;)
	        {
	                if (data[i] == 'r')
	                {
	                	System.out.print("Swapping "+ data[i] + ":" + i + " " + data[p] + ":" + p);
	                      t = data[i];
	                        data[i] = data[p];
	                        data[p] = t;
	                        ++p;
	                        ++i;
	                }

	                else if (data[i] == 'b')
	                {
	                	System.out.print("Swapping "+  data[i] + ":" + i + " " + data[q] + ":" + q);
	                        t = data[i];
	                        data[i] = data[q];
	                        data[q] =t;
	                        --q;
	                }
	                else
	                {
	                	System.out.print("Moving forward");
	                        ++i;
	                }
	                
	            	for(int j = 0; j < data.length; j++)
	    				System.out.print(" " + data[j]);
	            	System.out.println();
	        }
	        
			
		
	}
	
	public static void specPrint(int x)
	{
		int height = 1;
		int lh = x;
		
		for(int i = 1; i < x + 1; i++)
		{
			for(int j = 0; j < lh-1; j++)
				System.out.print("*");
			
			for(int j = 0; j < height * 2 - 1; j++)
				if(j%2==0)
					System.out.print(i);
				else
					System.out.print("*");
				
			for(int j = 0; j < lh-1; j++)
				System.out.print("*");
			
			lh--;
			height++;
			System.out.println();
		}
	}
}
