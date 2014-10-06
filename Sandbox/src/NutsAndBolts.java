
public class NutsAndBolts {

	

/*
	N Nuts and N Bolts
	
	int partition(int *Nuts, int *Bolts, int start, int end, int pivot)
*/
	/*
	 * nut 
	 * 	4 3 2 8 1 7 
	 * 
	 * bolts 
	 * 	8 3 4 2 1 7
	 * 
	 * 
	 * pivot -> quicksort
	 * 
	 * 
	 */
	
	public int partition(int[] nuts, int[] bolts)
	{
		// compare nuts to bolts only
		
		for(int i = 0; i < nuts.length; i++)
		{
			bolts = quicksort(bolts, nuts[i]);		
		}
		
		return 0;
	}

	private int[] quicksort(int[] array, int pivot)
	{
		/*
		 * 4 3 2 8 1 7 
		 * pivot 3
		 * 
		 * 1 3 2 8 4 7
		 *
		 *  array.length - i
		 */
		
		boolean working = true;
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		
		while(working)
		{
			if(array[leftIndex] > pivot)
			{
				if(array[rightIndex] < pivot)
				{
					int temp = array[rightIndex];
					array[rightIndex] = array[leftIndex]; 
					array[leftIndex] = temp;
					
					rightIndex--;
					
					leftIndex++;
					
				}
				else
				{
					rightIndex--;
					
					working = stillSorting(rightIndex, leftIndex);
				}
			}
			else
			{
				leftIndex++;
				
			}
		}
		
		
		return array;
	}
	
	private boolean stillSorting(int rightIndex, int leftIndex)
	{
		return rightIndex == leftIndex;
	}
	
}

