import java.util.Arrays;

public class Median {
	public static void main(String[] args) {
		Median m = new Median();
		int[] A = {1,4};
		int[] B = {2,3};
//	 	[2], [1,3,4,5,6]
	
//		int[] A = {1};
//		int[] B = {2, 3, 4,5};
		//	 	[2,4,6,7], [1,3,5]
		
		System.out.println(m.findMedianSortedArrays(A, B));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
		// if one or the other is null/0
		if(B == null || B.length == 0)
		{
			if(A.length % 2 != 0)
				return A[A.length/2];
			else
				return (A[A.length / 2] + A[(A.length - 1) / 2]) / 2.0;
		}
		else if(A == null || A.length == 0)
		{
			if(B.length % 2 != 0)
				return B[B.length/2];
			else
				return (B[B.length / 2] + B[(B.length - 1) / 2]) / 2.0;
		}
		
		int size = A.length + B.length;
		
		int a_front = A[0];
		int a_end = A[A.length - 1];
		
		int b_front = B[0];
		int b_end = B[B.length - 1];
		
		// all of a comes before b
		if(a_front >= b_end)
		{
			return mismatchCompare(A,B, size);
		}
		else if(b_front >= a_end)	// all of b comes before a
		{
			return mismatchCompare(B,A, size);
		}
		else	// mismatched
		{		// idea - remove lowest, highest - until 1/2 left
			return compareMisMatch(A, B, size);
		}
	}

	private double compareMisMatch(int[] a, int[] b, int size) {
		int a_pt = 0, a_end_pt = a.length - 1, b_pt = 0, b_end_pt = b.length - 1;
		boolean isEven = false;
		if(size % 2 == 0)
			isEven = true;
		
		int a_removed = 0, b_removed = 0;
		
		if(isEven)
		{
			while(size - (a_removed + b_removed) > 2)
			{
				// Smallest
				if(a[a_pt] < b[b_pt])
				{
					System.out.println("Removing a " + a[a_pt]);
					a_pt++;
				}
				else
				{
					System.out.println("Removing b " + b[b_pt]);
					b_pt++;
				}
				
				// Largest
				if(a[a_end_pt] > b[b_end_pt])
				{
					System.out.println("Removing a " + a[a_end_pt]);
					a_end_pt--;
				}
				else
				{
					System.out.println("Removing b " + b[b_end_pt]);
					b_end_pt--;
				}
				
				if(a_pt >= a.length)
					a_pt = a.length -1;
				if(b_pt >= b.length)
					b_pt = b.length - 1;
				if(a_end_pt < 0)
					a_end_pt = 0;
				if(b_end_pt < 0)
					b_end_pt = 0;
				
				a_removed++;
				b_removed++;
			}
			System.out.println(a_end_pt + " " +  a_pt + " " +  b_end_pt + " " + b_pt);
			
			// what if one of them is completely eliminated?
			
			return (a[a_pt] + b[b_pt]) / 2.0;
		}
		else
		{
			while(size - (a_removed + b_removed) > 1)
			{
				// Smallest
				if(a[a_pt] < b[b_pt])
				{
//					System.out.println("Removing a " + a[a_pt]);
					a_pt++;
				}
				else
				{
//					System.out.println("Removing b " + b[b_pt]);
					b_pt++;
				}
				
				// Largest
				if(a[a_end_pt] > b[b_end_pt])
				{
//					System.out.println("Removing a " + a[a_end_pt]);
					a_end_pt--;
				}
				else
				{
//					System.out.println("Removing b " + b[b_end_pt]);
					b_end_pt--;
				}
				a_removed++;
				b_removed++;
			}
			
//			System.out.println(a_end_pt + " " +  a_pt + " " +  b_end_pt + " " + b_pt);

			if(b_end_pt == b_pt)
			{
				return b[b_pt];
			}
			if(a_end_pt == a_pt)
			{
				return a[a_pt];
			}
			
			return 0;
		}
	}

	private double mismatchCompare(int[] A, int[] B, int size) {
		boolean isEven = false;
		
		int median = size / 2;
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
		System.out.println(median);
		
		if(size % 2 == 0)
			isEven = true;
		
		if(median > B.length - 1)
		{	
			median = median - B.length;
			
			if(!isEven)
				return A[median];
			else
			{
				if(median == 0)
					return ((A[median] + B[B.length - 1]) / 2.0);
	 
				return (A[median] + A[median - 1]) / 2.0;
			}
		}
		else
		{
			median = median - (B.length - 1);
			
			if(!isEven)
				return B[median];
			else
			{
				if(median == 0)
					return ((B[median] + A[A.length - 1]) / 2.0);
				
				return (B[median] + B[median - 1]) / 2.0;
			}
		}
	}

}
