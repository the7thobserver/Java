package Interview;

public class SubsetSum 
{
	static int[] s = {-2,3,1,0,-1,2,-3,0};
	
	// O(ulogu + n)
	
	public static void main(String[] args)
	{
		subsetSum(s);
//		s = mergesort(s);
//		
//		for(int i = 0; i < s.length; i++)
//			System.out.println(s[i]);
	}
	
	public static void subsetSum(int[] s)
	{
		s = mergesort(s);
		
		int h = s.length - 1;
		int l = 0;
		int l2 = 1;
		
		while(true)
		{

			if(h < 0)
				break;
			
			if(s[l] + s[l2] + s[h] == 0)
			{
				System.out.println(s[l] + " " + s[l2] + " " + s[h]);
				h--;
				continue;
			}
			
			if(s[l] + s[l2] < s[h])
			{
				l2++;
				continue;
			}
			
			l2++;
			
			
			if(l > s.length)
				break;
			
			if(l2 == s.length)
			{
				l++;
				l2 = l;
			}
		}
		
		// other way
		h = 0;
		l =  s.length - 1;
		l2 =  s.length - 2;
		
		while(true)
		{
			if(h >= s.length)
				break;
			
			if(s[l] + s[l2] + s[h] == 0)
			{
				System.out.println(s[l] + " " + s[l2] + " " + s[h]);
				h++;
				continue;
			}
			
			if(s[l] + s[l2] > s[h])
			{
				l2--;
				continue;
			}
			
			l2--;
			
			if(l < 0)
				break;
			
			if(l2 < 0)
			{
				l--;
				l2 = l;
			}
			if(h > l)
				break;
		}
		
//		// palantir programming, 3 numbers add up to 0
//		int[] x = {5,-1,3,2,-4,7,-2};
//		
//		MergeSort m = new MergeSort();
//		int[] y = m.sort(x);
//		
//		int h = x.length - 1;
//		int l = 0;
//		int l2 = 0;
//		
//		// 2 negative pointers
//		while(true)
//		{
//			if(y[h] + y[l] + y[l2] ==  0)
//			{
//				System.out.println("NEG " + y[h] + " " + y[l] + " " + y[l2]);
//				h--;
//				continue;
//			}
//			
//			
////			// big number too big
//			if(y[l] + y[l2] + y[h] > 0)
//			{
//				if(y[l2] > 0)
//				{
//					l++;
//					l2 = l;
//					continue;
//				}
//				if(y[l] + y[l2 + 1] + y[h] > 0)
//				{
//					h--;
//					continue;
//				}
//			}
//
//			l2++;
//
//			if(l2 > x.length - 1)
//			{
//				l++;
//				l2 = l;
//			}
//			if(l > (x.length - 1) / 2 || h < (x.length - 1)/2)
//				break;
//		}
//		
//		h = 0;
//		l = x.length - 1;
//		l2 = x.length - 1;
//		
//		// 2 positive pointers
//		while(true)
//		{
//			if(y[h] + y[l] + y[l2] ==  0)
//			{
//				System.out.println("POS " + y[h] + " " + y[l] + " " + y[l2]);
//				h++;
//				continue;
//			}
//			
//			
////			// big number too big
//			if(y[l] + y[l2] + y[h] > 0)
//			{
//				if(y[l2] > 0)
//				{
//					l--;
//					l2 = l;
//					continue;
//				}
//				if(y[l] + y[l2 + 1] + y[h] > 0)
//				{
//					h++;
//					continue;
//				}
//			}
//
//			l2--;
//
//			if(l2 > x.length - 1)
//			{
//				l--;
//				l2 = l;
//			}
//			if(l > (x.length - 1) / 2 || h < (x.length - 1)/2)
//				break;
//		}
//		
//		for(int i = 0; i < x.length; i++)
//			for(int j = 0; j < x.length; j++)
//				for(int k = 0; k < x.length; k++)
//					if(x[i] + x[j] + x[k] == 0)
//						System.out.println(x[i] + " " + x[j] + " " +x[k]);
	}

	public static int[] mergesort(int[] a)
	{
		if(a.length == 1)
			return a;
		
		int[] left = new int[a.length/2];
		int[] right = new int[(int)Math.floor(a.length/2)];
		
		for(int i = 0; i < a.length/2; i++)
			left[i] = a[i];
		
		for(int i = (int) Math.ceil((double)a.length/2); i < a.length; i++)
			right[a.length - 1 - i] = a[i];
		
		left = mergesort(left);
		right = mergesort(right);
		
		return merge(left, right);
	}
	
	public static int[] merge(int[] a, int[] b)
	{
		int[] sum = new int[a.length + b.length];
		
		int aI = 0;
		int bI = 0;
		int sI = 0;
		
		while(aI < a.length && bI < b.length)
		{
			if(a[aI] < b[bI])
			{
				sum[sI] = a[aI];
				sI++;
				aI++;
			}
			else
			{
				sum[sI] = b[bI];
				sI++;
				bI++;
			}
		}
		
		while(aI < a.length)
		{
			sum[sI] = a[aI];
			sI++;
			aI++;
		}
		
		while(bI < b.length)
		{
			sum[sI] = b[bI];
			sI++;
			bI++;
		}
		
		return sum;
	}
}
