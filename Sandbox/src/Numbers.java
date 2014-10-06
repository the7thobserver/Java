import BoxAlgos.MergeSort;


public class Numbers {
	
	public void removeDuplicates()
	{
		int[] x = {7,4,3,10,-1,3,7,3,10,-1};
		//int[] x = {9,7,0,6,2,3};
		MergeSort m = new MergeSort();
		
		x = m.sort(x);
		
		for(int i = 0; i < x.length; i++)
				System.out.print(x[i] + " ");

		System.out.println();
		
		int temp;
		int j = 1;
		
		int[] a = new int[x.length];
		int save = 0;
		for(int i = 0; i < x.length; i++)
		{
			temp = x[i];
			
			// look forward
			if(x[i] == x[i + 1])
				i++;
			else
				a[save] = x[i];
		}
		
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	
		System.out.println("done");
	}
	/*
	public class main
	{
		public static void main(String args[])
		{
			Parser parser = new Parser();
			Numbers num = new Numbers(args[0]);
			
			int input = parser.readLine();
			
			System.out.println("First occurence: " + num.findIndex(input));
			System.out.println("Number of occurences: " + num.findOccurences(input));
		}
	}

	import java.io.*;

	public class Parser
	{
		private BufferedReader;
		
		public Parser()
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public int getLine()
		{
			try{
				return reader.readLine();
			}
			catch(Exception e)
			{
				System.out.println("Invalid input");
			}
		}
		
	}

	import java.util.HashMap;

	public class Numbers
	{
		private int[] array;
		private HashMap<Integer> indexMap;
		private HashMap<Integer> occurenceMap;
		
		public Numbers(int[] array)
		{
			this.array = array;
			indexMap = new HashMap<Integer>();
			occurenceMap = new Hashmap<Integer>();
			
			indexMap();
			indexOccrences();
		}
		
		private void indexMap()
		{
			for(int i = 0; i < array.length; i++)
			{
				if(!indexMap.containsKey(array[i]))
				{
					indexMap.put(array[i], i);
				}
			}
		}
		
		private void indexOccreneces()
		{
			for(int i = 0; i < array.length; i++)
			{
				if(!occurencesMap.containsKey(array[i]))
				{
					occurencesMap.put(array[i], 1);
				}
				else
				{
					occurencesMap.put(array[i], occurencesMap.get(array[i]) + 1);
				}
			}
		}
		
		public int findIndex(int input)
		{
			return indexMap.get(input);
		}
		
		public int findOccurences(int input)
		{
			return occurencesMap.get(input);
		}
	}







	*/
}




