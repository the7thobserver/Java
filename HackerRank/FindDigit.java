import java.util.Scanner;


public class FindDigit 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
        int numTests;
        numTests = in.nextInt();
        
        String input[] = new String[numTests];
        
        for(int i = 0; i < numTests; i++)
        {
        	int value = in.nextInt();
        	
        	input[i] = value + "";
        }
        
        int ans = 0;
        
        for(int i = 0; i < numTests; i++)
        {
        	char[] te = input[i].toCharArray();
    		ans = 0;
    		
        	for(int j = 0; j < input[i].length(); j++)
        	{
        		if(Integer.parseInt(input[i]) % te[j] == Integer.parseInt(input[i]))
        			ans++;
        		
        		
        	}
        	System.out.println(ans);
        }
	}
}
