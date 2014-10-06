import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class FindMissing 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	     int size = in.nextInt();
	     
	     int[] x = new int[size];
	     
	     for(int i = 0 ; i < size; i++)
	     {
	    	 x[i]= in.nextInt();
	     }
	     
	     // sort
	     x = sort(x);
	     
	     size = in.nextInt();
	     int[] x2 = new int[size];
	     
	     for(int i = 0 ; i < size; i++)
	     {
	    	 x2[i]= in.nextInt();
	     }
	     
	     // sort
	     x2 = sort(x2);
	     
	     check(x,x2);
	}

	private static void check(int[] x, int[] x2) {
		HashMap<Integer, Integer> m = new LinkedHashMap<Integer, Integer>();
		
		for(int i = 0; i < x.length; i++)
			if(!m.containsKey(x[i]))
				m.put(x[i], 1);
			else
				m.put(x[i], m.get(x[i]) + 1);
		
		for(int i = 0; i < x2.length; i++)
		{
			if(m.containsKey(x2[i]))
			{
				m.put(x2[i], m.get(x2[i]) - 1);
			}
			else
				m.put(x2[i], 1);
			
		}
		
		for(Integer i : m.keySet())
			if(m.get(i) != 0)
			System.out.print(i + " ");
		
	}
	
	public static int[] sort(int[] a)
	{
		if(a.length == 1)
			return a;
		
		int[] l = new int[(a.length/2)];
		int[] r = new int[(int) Math.ceil(((double)a.length)/2)];
		
		
		for(int i = 0; i < a.length/2; i++)
			l[i] = a[i];
		
		for(int i = a.length/2; i < a.length; i++)
			r[i - a.length/2] = a[i];
		
		l = sort(l);
		r = sort(r);
		
		return merge(l,r);
	}
	
	public static int[] merge(int[] a, int[] b)
	{
		int[] c = new int[a.length + b.length];
		
		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		
		while((aIndex < a.length) && (bIndex < b.length))
		{
			if(a[aIndex] < b[bIndex])
			{
				c[cIndex] = a[aIndex];
				aIndex++;
				cIndex++;
			}
			else
			{
				c[cIndex] = b[bIndex];
				bIndex++;
				cIndex++;
			}
			
		}
		
		while(bIndex < b.length)
		{
			c[cIndex] = b[bIndex];
			bIndex++;
			cIndex++;
		}
		
		while(aIndex < a.length)
		{
			c[cIndex] = a[aIndex];
			aIndex++;
			cIndex++;
		}
		
		return c;
	}
}
