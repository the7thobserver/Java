import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution 
{
	// Nested class
	
	public static void main(String[] args)
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution x = new Solution();
        Solution.Temp t = x.new Temp();
        t.go();
        
        
	}
	
	class Temp
	{
		public Temp()
		{
			System.out.println("hi");
		}
		
		public void go()
		{
			System.out.println("GO");
		}
	}
}
