

public class MergeSort 
{
	public int[] sort(int[] a)
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
	
	public int[] merge(int[] a, int[] b)
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
