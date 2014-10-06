import java.util.Scanner;


public class UtopianTree 
{

	 public static void main(String[] args)
	 {
	        Scanner in = new Scanner(System.in);
	        int numTests;
	        numTests = in.nextInt();
	        
	        if(numTests < 1 || numTests > 10)
	        	throw new RuntimeException("Invalid num tests");
	        	
	        int input[] = new int[numTests];
	        
	        for(int i = 0; i < numTests; i++)
	        {
	        	int value = in.nextInt();
	        	
	        	if(value > 60 || value < 0)
	        		throw new RuntimeException("Invalid test number");
	        	
	        	input[i] = value;
	        }
	        
	        int start = 1;
	        
	        for(int i = 0; i < numTests; i++)
	        {
	        	for(int j = 0; j < input[i]; j++)
	        	{
	        		if(j % 2 == 0)
	        		{
	        			start *=2;
	        		}
	        		else
	        			start++;
	        	}
	        	
	        	System.out.println(start);
	        	start = 1;
	        }
	        
	        
	 }
}
