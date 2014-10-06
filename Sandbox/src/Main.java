import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class Main{
	Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
	public static void main(String[] args)
	{
		Statistician s = new Statistician(0,Integer.MAX_VALUE,0,0);
		s.nextNumber(2.4);
		s.nextNumber(1.7);
		s.nextNumber(0.2);
		System.out.println("High " + s.getHighest());
		System.out.println("Low " + s.getLowest());
		System.out.println("Last " + s.getLast());
		System.out.println("Count " +s.getCount());
		System.out.println("Mean " + s.getTotal()/s.getCount());
		System.out.println("Sum " + s.getTotal());
		
//		LinkedList<Integer> ll = new LinkedList<Integer>();
//		ll.add(0);
//		ll.add(1);
//		ll.add(2);
//		
//		//System.out.println(ll.remove(0));
//		//System.out.println(ll.remove(1));
//		System.out.println(ll.remove(2));
//		
//		System.out.println("Size: " + ll.getSize());
//		ll.print();
		
		
//		SumOfPrimes m = new SumOfPrimes();
//		System.out.println(m.SumOfPrimes(5));
		
//		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
//		
//		int[] x = {2,4,7,4,0,2,7};
//		
//		for(int i = 0; i < x.length; i++)
//		{
//			if(m.containsKey(x[i]))
//				m.put(x[i], 2);
//			else
//				m.put(x[i], 1);
//		}
//		
//		for(Integer s : m.keySet())
//		{
//			if(m.get(s) == 1)
//				System.out.println(s);
//		}
		
		

     
        
//		double c1[] = {0, -0.26, -2};
//		double u1[] = {-0.312558911,
//				-0.16296112,
//				-0.935815474
//
//};
//		double lhs[] = {-1,
//				0.07,
//				0
//};
//		double temp2[] = {0,0,0};
//		double rhs[] = {0.559522031,
//				-0.095761209,
//				0.001967534
//
//
//};
//	
//		double min = 10000;
//		double minT = 0;
//		double lA = 0;
//		for(double i = 0; i < 20; i+=0.01)
//		{
//			temp2 = rhs.clone();
//			
//			temp2[0] *= i;
//			temp2[1] *= i;
//			temp2[2] *= i;
//			
//			/*double result = Math.pow(lhs[0] - temp2[0], 2) + Math.pow(lhs[1] - temp2[1], 2) + Math.pow(lhs[2] - temp2[2],  2);
//			result = Math.sqrt(result);
//			*/
//			temp2[0] = lhs[0] + temp2[0];
//			temp2[1] = lhs[1] + temp2[1];
//			temp2[2] = lhs[2] + temp2[2];
//			
//			double leastApproach = Math.sqrt(Math.pow(temp2[0], 2) + Math.pow(temp2[1], 2) + Math.pow(temp2[2], 2));
//			
//			/*if(result < min)
//			{
//				min = result;
//				minT = i;
//				System.out.println(result + " : " +minT);
//			}*/
//			
//			if(leastApproach < min)
//			{
//				min = leastApproach;
//				lA = i;
//			}
//		}
//		
//		System.out.println(minT + " vs " + lA);
//		double x = c1[0] - u1[0] * lA;
//		double y = c1[1] - u1[1] * lA;
//		double z = c1[2] - u1[2] * lA;
//		
//		System.out.println(x + ", " + y + ", " + z);
//		
//		System.out.println("Z distance away " + (u1[2] * lA));
//		
		/*
		 * double c1[] = {0.08, -0.25, -1.7};
		double c2[] = {-0.29, -0.25,-1.53};
		
		double r1[] = {-0.09553, -0.14168,-0.98529};
		double r2[] = {-0.3327, -0.15341, -0.93047};
		
		double rs[] = new double[3];
		double ls[] = new double[3];
		
		double r[] = new double[3];
		double min = 1000000;
		double maxI;
		
		
		 * 	for(double i = 0; i < 20; i += 0.01)
		{
			rs[0] = c1[0] + r1[0] * i;
			rs[1] = c1[1] + r1[1] * i;
			rs[2] = c1[2] + r1[2] * i;
			
			ls[0] = c2[0] + r2[0] * i;
			ls[1] = c2[1] + r2[1] * i;
			ls[2] = c2[2] + r2[2] * i;
			
			
			r[0] = Math.pow(rs[0] - ls[0], 2);
			r[1] = Math.pow(rs[1] - ls[1], 2);
			r[2] = Math.pow(rs[2] - ls[2], 2);
			
			double sul = Math.sqrt(r[0] + r[1] + r[2]);
			System.out.println(sul + " " + i);
			
			if(sul < min)
			{
				min = sul;
				maxI = i;
				System.out.println(maxI);
			}
		}
		 */
		/*
		  BufferedReader br = new BufferedReader(new FileReader("D:\\temp\\comps.csv"));
		  
		  try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();

		        while (line != null) {
		            sb.append(line);
		            sb.append(System.lineSeparator());
		            line = br.readLine();
		            
		            System.out.println(line);
		        }
		        String everything = sb.toString();
		    } finally {
		        br.close();
		    }
		/*EscanDataAnalyser s = new EscanDataAnalyser("Hi");
		s.dumpData();
		
	
		Map<String, Map<String,Integer>> myMap = new HashMap<String,Map<String,Integer>>();
		Map<String,Integer> innerMap = new HashMap<String,Integer>();
		myMap.put("entry1", innerMap);
		/*
		int[] x = {1,2,3,4,5};
		int sum = 6;
		int j = x.length - 1;
		
		for(int i = 0; i < x.length / 2;)
		{
			if(x[i] + x[j] == sum)
			{
				System.out.println(x[i] + " " + x[j]);
				i++;
			}
			else
				j--;
		}
		/*
		int row = 3;
		int col = 3;
		
		for(int i = 0; i < row; i++)
		{
			for(int j = col - 1; j >= 0; j--)
			{
				System.out.print(x[j][i] + " ");
			}
			System.out.println();
		}
		
		/*
		int threshold = 7;
		
		int upperbound = threshold - x[0];
		
		// find upperbound
		for(int i = 0; i < x.length; i++)
		{
			if(x[i] >= upperbound)
			{
				upperbound = i;
				break;
			}
		}
		
		// O(n^2)
		/*
		for(int i = 0; i < upperbound; i++)
		{
			for(int j = upperbound; j > 0; j--)
				
			if(x[i] + x[j] == threshold)
				System.out.println(x[i] + " " + x[j]);
		}
		*/
		/*
		int i = 0;
		int j = x.length - 1;
		
		while(i < j)
		{
			if(x[i] + x[j] == threshold)
			{
				System.out.println(x[i] + " " + x[j]);
				i++;
			}
			else
				j--;	
		}
		*/
		/*
		ArrayList<Integer> x = new ArrayList<Integer>();
		x.add(8);
		x.add(5);
		x.add(7);
		x.add(2);
		x.add(4);
		x.add(7);
		x.add(1);
		x.add(0);
		x.add(9);
		
		QuickSort q = new QuickSort();
		
		x = q.sortQuickly(x);
		
		for(int i = 0; i < x.size(); i++)
			System.out.print(x.get(i) + " ");
		
		/*
		int[] x = {1,2,3,4,5};
		int[] y = {4,5,6,7,8};
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < x.length; i++)
			if(!map.containsKey(x[i]))
				map.put(x[i], 1);
		
		for(int i = 0; i < y.length; i++)
			if(map.containsKey(y[i]))
				map.put(y[i], map.get(y[i]) + 1);
			
		for(int i = 0; i < 8; i++)
			if(map.get(i)!=null)
				if(map.get(i) >=2)
					System.out.print(i + " ");
		
		*/
		
		
		//throw new SadnessError();
		/*
		String filename = "x";
		BufferedReader x = new BufferedReader(new FileReader(filename));
		*/
	}
	
	public <K> void mvoe(K k, int i)
	{
		
	}
}
