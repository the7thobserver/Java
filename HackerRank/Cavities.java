import java.util.Scanner;
//mira - uci outreach 11am 26th

public class Cavities {
	static int[][] ar;
	static int[][] copy;
	
	public static void main(String[] args)
	{
	     Scanner in = new Scanner(System.in);
	     int s = in.nextInt();
	     
	     if(s < 1)
	    	 return;
	     
	     ar = new int[s][s];
	     copy = new int[s-2][s-2];
	     
	     for(int j = 0; j < s; j++)
	     {
		    	 char[] ch = in.next().toCharArray();
		    	 
		    	 for(int i = 0; i < s; i++)
		    	 {
		    		 ar[j][i]=Character.getNumericValue(ch[i]); 
		    		 
		    		 if(i != 0 && i != s-1 && j != 0 && j != s-1)
		    		 {
		    			 copy[j-1][i-1]=Character.getNumericValue(ch[i]);
			    		 
		    		 }
		    	}
	     }   
	     
	     findCavity();
	}
	
	static void printC()
	{
		for(int i = 0; i < copy.length; i++)
		{
			for(int j = 0; j < copy.length; j++)
			{
				System.out.print(copy[i][j]);
			}
			System.out.println();
		}
	}
	
	static void findCavity()
	{
		for(int i = 0; i < copy.length; i++)
			for(int j = 0; j < copy.length; j++)
			{
				if(checksurround(i,j) == -1)
				{
					ar[i+1][j+1] = -1;
					//System.out.println("FJEL");
				}
			}
		
		printA();
	}
	
	/*
	 * 
	 * 1 1 1 1
	 * 1 X X 1
	 * 1 X X 1
	 * 1 1 1 1
	 * 
	 * 1 1 1 1 1 1
	 * 1 X X X X 1
	 * 1 X X X X 1
	 * 1 X X X X 1
	 * 1 1 1 1 1 1
	 */
	private static void printA() {
		for(int i = 0; i < ar.length; i++)
		{
			for(int j = 0; j < ar.length; j++)
			{
				if(ar[i][j] == -1)
				{
					System.out.print("X");
					continue;
				}
				
				System.out.print(ar[i][j]);
			}
			System.out.println();
		}
	}

	static int checksurround(int i, int j)
	{
		// top
		if(i == 0)
		{
			if(j == 0)
			{
				//System.out.println("First " + i + " " + j);
				if(copy[i+1][j] <= copy[i][j] || copy[i][j+1] <= copy[i][j])
					return -1;
			}
			else if(j == copy.length - 1)
			{
				//System.out.println("S" + i + " " + j + " " + copy[i+1][j] + " " + copy[i][j-1]);
				if(copy[i+1][j] <= copy[i][j] || copy[i][j-1] <= copy[i][j])
					return -1;
			}
			else
			{
				//System.out.println("T" + i + " " + j);
				if(copy[i+1][j] <= copy[i][j] || copy[i][j+1] <= copy[i][j] || copy[i][j-1] <= copy[i][j])
					return -1;
			}
		}
		else if(i == copy.length - 1)	// edge
		{
			if(j == 0)
			{
				//System.out.println("First " + i + " " + j);
				if(copy[i-1][j] <= copy[i][j] || copy[i][j+1] <= copy[i][j])
					return -1;
			}
			else if(j == copy.length - 1)
			{
				//System.out.println("S" + i + " " + j + " " + copy[i-1][j] + " " + copy[i][j-1]);
				if(copy[i-1][j] <= copy[i][j] || copy[i][j-1] <= copy[i][j])
					return -1;
			}
			else
			{
				//System.out.println("T" + i + " " + j);
				if(copy[i-1][j] <= copy[i][j] || copy[i][j+1] <= copy[i][j] || copy[i][j-1] <= copy[i][j])
					return -1;
			}
		}

		
		return 0;
	}
	
}
