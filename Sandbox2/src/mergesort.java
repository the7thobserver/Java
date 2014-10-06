
public class mergesort {
	public static int[] mergeSort(int[] array)
	{
		if(array.length == 0)
			return null;
		
		if(array.length == 1)
			return array;
		
		int[] first = new int[(int) (Math.ceil(array.length/2.0))];
		int[] second = new int[array.length/2];
		
		for(int i = 0; i < first.length; i++)
			first[i] = array[i];
		
		for(int i = first.length; i < array.length; i++)
			second[i- first.length] = array[i];
	
		first = mergeSort(first);
		second = mergeSort(second);
		
		return merge(first, second);
	}
	
	public static int[] merge(int[] a, int[] b)
	{
		int[] mergedList = new int[a.length + b.length];
		
		int aIndex = 0;
		int bIndex = 0;
		int index = 0;
		
		while(index < b.length)
		{
			if(a[aIndex] < b[bIndex])
			{
				mergedList[index] = a[aIndex];
				index++;
				aIndex++;
			}
			else
			{
				mergedList[index] = b[bIndex];
				index++;
				bIndex++;
			}
		}
		
		if(a.length - aIndex > 0)
		{
			for(int i = aIndex; i < a.length; i++)
			{
				mergedList[index] = a[aIndex];
				index++;
				aIndex++;
			}
		}
		
		if(b.length - bIndex > 0)
		{
			for(int i = bIndex; i < b.length; i++)
			{
				mergedList[index] = b[bIndex];
				index++;
				bIndex++;
			}
		}
		
		return mergedList;
	}
}
