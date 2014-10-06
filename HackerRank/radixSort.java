import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class radixSort 
{
	static class Data
	{
		int value;
		String s_;
		int isValid;
		
		public Data(int i, String s, int valid)
		{
			value = i;
			s_ = s;
			isValid = valid;
		}
	}
	
	public static void main(String[] args)
	{
		 Scanner in = new Scanner(System.in);
	     int size = in.nextInt();
	     
	     Data ar[] = new Data[size];
	     int max = 0;
	     
	     // loop over t
	     for(int run = 0; run < size; run++)
	     { 
	    	 Data d;
	    	 
	    	 if(run < size/2)
	    	 {
	    		 d = new Data(in.nextInt(), in.next(), 0);
	    	 }
	    	 else
	    	 {
	    		 d = new Data(in.nextInt(), in.next(), 1);	 
	    	 } 
	    	 
	    	 
	    	 if(d.value > max)
	    			 max = d.value;
	    	 
	    	 ar[run] = d;
	     }
	     
//	    ArrayList<Data> m = sort(ar, max);
//
//	    for(int i = 0; i < m.size(); i++)
//		{
//			if(m.get(i).isValid == 0)
//			{
//				System.out.print("- ");
//			}
//			else
//				System.out.print(ar[i].s_ + " ");
//
//		}
	    
	   // print(ar);
//	     printAns(ar);
	}
	
//	private static ArrayList<Data> sort(Data[] ar, int max)
//	{
//		int pivot = ar[0].value;
//		int repeat = 0;
//		Data d = null;
//		
//		ArrayList<Data> l = new ArrayList<Data>();
//		ArrayList<Data> r = new ArrayList<Data>();
//		
//		for(int i = 0; i < ar.length; i++)
//		{
//			if(ar[i].value < pivot)
//				l.add(ar[i]);
//			else if(ar[i].value > pivot)
//				r.add(ar[i]);
//			else
//			{
//				repeat++;
//				d = ar[i];
//			}
//		}
//		
//		l = sort(l);
//		r = sort(r);
//		
//		ArrayList<Data> m = new ArrayList<Data>();
//		for(int i = 0; i < l.size(); i++)
//			m.add(l.get(i));
//		for(int i = 0; i < repeat; i++)
//		{
//			if(d== null)
//				break;
//			m.add(d);
//		}
//	
//		for(int j = 0; j < r.size(); j++)
//			m.add(r.get(j));
//		
//		return m;
//	}
//	
//	
//	
//	private static ArrayList<Data> sort(ArrayList<Data> ar) {
//		if(ar.size() <= 1)
//			return ar;
//		
//		int pivot = ar.get(0).value;
//		Data rep = null;
//		int repeat = 0;
//		ArrayList<Data> l = new ArrayList<Data>();
//		ArrayList<Data> r = new ArrayList<Data>();
//		
//		for(int i = 0; i < ar.size(); i++)
//		{
//			if(ar.get(i).value < pivot)
//				l.add(ar.get(i));
//			else if(ar.get(i).value > pivot)
//				r.add(ar.get(i));
//			else
//			{
//				repeat++;
//				rep = ar.get(i);
//			}
//		}
//		
//		l = sort(l);
//		r = sort(r);
//		
//		ArrayList<Data> m = new ArrayList<Data>();
//		for(int i = 0; i < l.size(); i++)
//			m.add(l.get(i));
//		
//		for(int i = 0; i < repeat; i++)
//		{
//			if(rep== null)
//				break;
//			
//			m.add(rep);
//		}
//		
//		for(int j = 0; j < r.size(); j++)
//			m.add(r.get(j));
//		
//		printArrayList(m);
//		return m;
//	}
//
//private static void printArrayList(ArrayList<Data> m) {
//		for(int i = 0; i < m.size(); i++)
//		{
//			System.out.print(m.get(i).value + " " + m.get(i).s_ + " | ");
//		}
//		System.out.println();
//	}

//	// faster if quicksort or lexicographic sort
//	private static Data[] sort(Data[] ar, int max) {
//		
//		for(int i = 0; i < ar.length; i++)
//		{
//			int j = i;
//			while(j > 0 && ar[j - 1].value > ar[j].value)
//			{
//				Data d = ar[j-1];
//				ar[j-1] = ar[j];
//				ar[j] = d;
//				j--;
//			}
//		}
//		return ar;
//	}



	private static void printAns(Data[] ar) {
		for(int i = 0; i < ar.length; i++)
		{
			if(ar[i].isValid == 0)
			{
				System.out.print("- ");
			}
			else
				System.out.print(ar[i].s_ + " ");

		}
		
	}

	// Radix sort
//	private static Data[] sort(Data[] ar, int max) {
//
//		// array of lists
//		ArrayList<Data>[] x = new ArrayList[max+1];
//		
//		// init
//		for(int i = 0; i < x.length; i++)
//			x[i] = new ArrayList<Data>();
//		
//		// sort into buckets
//		for(int i = 0; i < ar.length; i++)
//		{
////			if(ar[i].isValid == 1)
////			{	
//				x[ar[i].value].add(ar[i]);
//			//}
//			
//		}
//		
//
//		// go into array
//		for(int i = 0; i < x.length; i++)
//		{
//			// go into each bucket
//			if(x[i].size() == 1)
//				continue;
//			
//			
//			
//			// sort arraylist
//			System.out.println(x[i].size());
//			for(int j = 0; j < x[i].size(); j++)
//			{
//				
//				// insert sort
//				int k = j;
//				while(k>0 && x[i].get(k - 1).s_.compareTo(x[i].get(k).s_) > 0)
//				{
//					Data d = x[i].get(k-1);
//					x[i].set(k-1, x[i].get(k));
//					x[i].set(k, d);
//					k--;
//				}
//			}
//			
//		}
//		
//		// dump buckets
//		int index = 0;
//		for(int i = 0; i < x.length; i++)
//			for(int j = 0; j < x[i].size(); j++)
//			{
//				ar[index] = x[i].get(j);
//				index++;
//			}
//		
//		return ar;
//	}

	static void print(Data[] ar)
	{
		for(int i = 0; i < ar.length; i++)
		{
			System.out.println(ar[i].value + " " + ar[i].s_);
		}
		
	}
}
