
public class Partition 
{
	public static void main(String[] args)
	{
		// a needs to be sorted
		int[] a = {1,2,3,4,5,6,7,8,9};
	
		int pt1 = 0;
		int pt2 = a.length - 1;
		
		int sum1 = a[pt1];
		int sum2= a[pt2];
		
		while(pt1 < pt2 - 1)
		{
			if(sum1 < sum2)
			{
				pt1++;
				sum1 += a[pt1];
			}
			else if(sum2 <= sum1)
			{
				pt2--;
				sum2 += a[pt2];
			}
			
		}
		
		
		System.out.println(sum1 + " " + sum2 + " | bound " + pt1 + " " + pt2);
		if(sum1 != sum2)
			System.out.println("No match");
		
	}

}
